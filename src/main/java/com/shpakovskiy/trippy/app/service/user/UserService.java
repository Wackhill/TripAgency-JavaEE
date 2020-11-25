package com.shpakovskiy.trippy.app.service.user;

import com.shpakovskiy.trippy.app.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getAllUsers(String email);
    boolean addUser(User user);
    boolean isUserExists(String email);
}
