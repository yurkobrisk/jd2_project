package it.academy.service;

import it.academy.ServiceTestConfig;
import it.academy.model.Document;
import it.academy.model.User;
import it.academy.repository.UsersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchNullPointerException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {ServiceTestConfig.class, UserServiceImpl.class, DocumentServiceImpl.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Autowired
    UsersRepository usersRepository;

    @Test
    @DisplayName("it should return list of users with size 2")
    void readAllUsers() {
        //Given
        //When
        final List<User> allUsers = userService.readAllUsers();
        //Then
        assertThat(allUsers).isNotNull();
        assertThat(allUsers.size()).isEqualTo(2);
        assertThat(allUsers.get(0).getUserName()).isEqualTo("Noname");
        assertThat(catchNullPointerException(
                () -> allUsers.get(1).getAuthority())).isNull();
        assertThat(allUsers.get(1).getPassword()).isNull();
    }

    @Test
    @DisplayName("it should return user when read method runs")
    void readUser() {
        //Given
        //When
        User user = userService.readUser("7");
        //Then
        assertThat(user.getUserName()).isNotNull();
        assertThat(user.getEnabled()).isEqualTo(1);
    }

    @Test
    @DisplayName("it should return user when save method runs")
    void saveUser() {
        //Given
        User newUser = new User();
        newUser.setUserName("Noname");
        //When
        User user = userService.saveUser(newUser);
        //Then
        assertThat(user).isNotNull();
        assertThat(user.getUserName()).isEqualTo("Noname");
    }

    @Test
    @DisplayName("it should return user when update method runs")
    void updateUser() {
        //Given
        User newUser = new User();
        newUser.setUserName("Noname");
        //When
        User user = userService.updateUser(newUser);
        //Then
        assertThat(user).isNotNull();
        assertThat(user.getUserName()).isEqualTo("Noname");
    }

    @Test
    @DisplayName("it should runs delete method two times")
    void deleteUser() {
        //Given
        //When
        usersRepository.deleteById("7");
        usersRepository.deleteById("7");
        //Then
        verify(usersRepository, times(2))
                .deleteById("7");
    }
}
