package com.shpakovskiy.trippy.app.service.user;

import com.shpakovskiy.trippy.app.entity.User;
import com.shpakovskiy.trippy.dao.user.DefaultUserDao;

import java.util.List;

public class DefaultUserService implements UserService {

    @Override
    public List<User> getAllUsers() {
        return new DefaultUserDao().getAllUsers();
    }

    @Override
    public List<User> getAllUsers(String email) {
        return new DefaultUserDao().getAllUsers(email);
    }

    @Override
    public boolean addUser(User user) {
        return new DefaultUserDao().addUser(user);
    }

    @Override
    public boolean isUserExists(String email, String password) {
        return new DefaultUserDao().isUserExists(email, password);
    }

    @Override
    public User getUser(String email, String password) {
        return new DefaultUserDao().getUser(email, password);
    }
}
