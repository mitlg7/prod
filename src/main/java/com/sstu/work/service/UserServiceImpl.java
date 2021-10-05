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
        return null;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User createUser(RegistrationRequest request) {
        return null;
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
    public boolean downToUserByProducerId(String id) {
        return false;
    }
}
