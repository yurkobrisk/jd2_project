package it.academy.mapper;

import it.academy.dto.UserDto;
import it.academy.model.User;
import org.modelmapper.*;
import org.springframework.stereotype.Component;

@Component
public class UserMap extends PropertyMap<UserDto, User> {

    Converter<String, Integer> enableConverter =
            context -> context.getSource() == null ? 0 : 1;

    @Override
    protected void configure() {
        map().setUserName(source.getUserName());
        map().setPassword(source.getPassword());
        using(enableConverter).map(source.getEnabled()).setEnabled(null);

        map().getAuthority().setUsername(source.getUserName());
        map().getAuthority().setId(source.getAuthorityId());
        map(source.getAuthority()).getAuthority().setUserType(null);
    }
}
