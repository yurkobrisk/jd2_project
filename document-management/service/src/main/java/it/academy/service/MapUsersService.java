package it.academy.service;

import it.academy.dto.UserDto;
import it.academy.mapper.Mapper;
import it.academy.mapper.UserMap;
import it.academy.model.User;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MapUsersService {

    private static final Logger log =
            LoggerFactory.getLogger(MapUsersService.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserMap userMap;

    public List<UserDto> getAllUsers(){
        return userService
                .readAllUsers()
                .stream()
                .map(this::convertUserToDto)
                .collect(Collectors.toList());
    }

    public User saveUser(UserDto userDto){
        if (isUserPresent(userDto)) {
            System.out.println("такой пользователь уже есть в базе данных");
            userDto.setAuthorityId(
                    getUser(userDto.getUserName())
                            .getAuthorityId());
            return userService.saveUser(convertDtoToUsers(userDto));
        }
        System.out.println("добавление нового пользователя в базу данных");
        return userService.saveUser(convertDtoToUsers(userDto));
    }

    public UserDto getUser(String id) {
        return convertUserToDto(userService.readUser(id));
    }

    public void deleteUser(String id) {
        userService.deleteUser(id);
    }

    private UserDto convertUserToDto(User user) {
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
         UserDto userDto = mapper
                .map(user, UserDto.class);
        return userDto;
    }

    private User convertDtoToUsers(UserDto userDto){
        TypeMap<UserDto, User> typeMap =
                mapper.getTypeMap(UserDto.class, User.class);
        if (typeMap == null) {
            mapper.addMappings(userMap);
        }
        return mapper.map(userDto, User.class);
    }

    private boolean isUserPresent(UserDto userDto) {
        long count = getAllUsers()
                .stream()
                .filter(user -> user.getUserName().equals(userDto.getUserName()))
                .count();
        return count > 0;
    }
}
