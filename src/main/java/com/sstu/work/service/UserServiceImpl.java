package com.sstu.work.service;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.RegistrationRequest;
import com.sstu.work.model.utils.UserUpdateRequest;
import com.sstu.work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByLogin(username);
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User createUser(RegistrationRequest request) {
        User userCreate = new User().setEmail(request.getEmail())
                .setLogin(request.getLogin())
                .setPassword(request.getPassword());
        userRepository.create(userCreate);

        return userRepository.getUserByLogin(userCreate.getLogin());
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User updateUser(UserUpdateRequest request) {
        return null;
    }

    @Override
    public boolean removeUserByUserId(String id) {
        return false;
    }

    @Override
    public boolean upToProducerByUserId(String id) {
        return false;
    }

    @Override
    public boolean downToUserByUserId(String id) {
        return false;
    }

    @Override
    public List<User> getAllProducers() {
        return null;
    }
}
