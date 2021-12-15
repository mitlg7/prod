package com.sstu.work.service;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.RegistrationRequest;
import com.sstu.work.model.utils.UserInfoRequest;
import com.sstu.work.model.utils.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);

    User getUserById(Long id);

    void createUser(RegistrationRequest request);

    List<User> getAll();

    User updateUser(UserUpdateRequest request);

    boolean removeUserByUserId(String id);

    boolean upToProducerByUserId(String id);

    boolean downToUserByUserId(String id);

    List<User> getAllProducers();

    void addUserInfo(UserInfoRequest userInfoRequest, String login);

    boolean checkToken(String token);
}
