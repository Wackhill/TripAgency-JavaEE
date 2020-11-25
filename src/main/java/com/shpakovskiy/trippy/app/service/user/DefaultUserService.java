package com.shpakovskiy.trippy.app.service.user;

import com.shpakovskiy.trippy.app.entity.User;
import com.shpakovskiy.trippy.dao.user.DefaultUserDao;
import com.shpakovskiy.trippy.dao.user.UserDao;

import java.util.List;

public class DefaultUserService implements UserService {

    @Override
    public List<User> getAllUsers() {
        UserDao userDao = new DefaultUserDao();
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getAllUsers(String email) {
        UserDao userDao = new DefaultUserDao();
        return userDao.getAllUsers(email);
    }

    @Override
    public boolean addUser(User user) {
        UserDao userDao = new DefaultUserDao();
        return userDao.addUser(user);
    }

    @Override
    public boolean isUserExists(String email) {
        UserDao userDao = new DefaultUserDao();
        return userDao.isUserExists(email);
    }
}
