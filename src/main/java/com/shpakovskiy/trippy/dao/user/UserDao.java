package com.shpakovskiy.trippy.dao.user;

import com.shpakovskiy.trippy.app.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    List<User> getAllUsers(String email);
    boolean addUser(User user);
    boolean isUserExists(String email);
}
