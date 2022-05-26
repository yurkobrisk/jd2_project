package it.academy.service;

import it.academy.model.User;
import it.academy.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger log =
            LoggerFactory.getLogger(DocumentServiceImpl.class.getName());

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> readAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User readUser(String id) {
        return usersRepository.getOne(id);
    }

    @Override
    public User saveUser(User user) {
        return usersRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(User user) {
        return usersRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(String id) {
        usersRepository.deleteById(id);
    }
}
