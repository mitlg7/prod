package com.sstu.work.service;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.RegistrationRequest;
import com.sstu.work.model.utils.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);

    User getUserById(String id);

    User createUser(RegistrationRequest request);

    List<User> getAll();

    User updateUser(UserUpdateRequest request);

    boolean removeUserByUserId(String id);

    boolean upToProducerByUserId(String id);

    boolean downToUserByUserId(String id);

    List<User> getAllProoducers();


}
