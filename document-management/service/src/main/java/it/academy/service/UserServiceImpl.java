package it.academy.service;

import it.academy.model.User;
import it.academy.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log =
            LoggerFactory.getLogger(User.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User readUser(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
