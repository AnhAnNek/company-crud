package com.vanannek.companycrud.service;

import com.vanannek.companycrud.dto.UserDTO;
import com.vanannek.companycrud.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}