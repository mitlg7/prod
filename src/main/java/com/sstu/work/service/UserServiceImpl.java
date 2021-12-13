package com.sstu.work.service;

import com.sstu.work.model.User;
import com.sstu.work.model.UserInfo;
import com.sstu.work.model.utils.RegistrationRequest;
import com.sstu.work.model.utils.UserInfoRequest;
import com.sstu.work.model.utils.UserUpdateRequest;
import com.sstu.work.repository.UserInfoRepository;
import com.sstu.work.repository.UserRepository;
import com.sstu.work.service.utils.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ImageService imageService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public User getUserByUsername(String username) {
        return  userRepository.getUserByLogin(username);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void createUser(RegistrationRequest request) {

        User userCreate = new User()
                .setEmail(request.getEmail())
                .setLogin(request.getLogin())
                .setPassword(request.getPassword());
        userRepository.create(userCreate);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAllUsers();
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

    @Override
    public void addUserInfo(UserInfoRequest userInfoRequest, String login) {
        UserInfo userInfo = new UserInfo()
                .setBirthday(Date.valueOf(userInfoRequest.getBirthday()))
                .setLastName(userInfoRequest.getLastname())
                .setName(userInfoRequest.getName())
                .setPhone(userInfoRequest.getPhone())
                .setImage(imageService.saveImage(userInfoRequest.getImage()));

        userInfoRepository.create(userInfo);
        userRepository.addUserInfoIdToUser(login);
    }

}
