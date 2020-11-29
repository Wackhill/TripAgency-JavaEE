package com.shpakovskiy.trippy.dao.user;

import com.shpakovskiy.trippy.app.entity.User;
import com.shpakovskiy.trippy.utils.dbConnection.DbConnectionFactory;
import com.shpakovskiy.trippy.utils.hash.PasswordHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultUserDao implements UserDao {

    public List<User> getAllUsers() {
        return getAllUsers(null);
    }

    public List<User> getAllUsers(String email) {
        Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement getAllUsersQuery;
            if (email == null) {
                 getAllUsersQuery = connection.prepareStatement("SELECT * FROM users");
            } else {
                getAllUsersQuery = connection.prepareStatement("SELECT * FROM users WHERE email LIKE " + email); //FIXME: Injection vulnerable
            }

            List<User> allUsers = new ArrayList<>();
            ResultSet allUsersQueried = getAllUsersQuery.executeQuery();

            while (allUsersQueried.next()) {
                User newUser = new User
                        .Builder()
                        .email(allUsersQueried.getString(2))
                        .name(allUsersQueried.getString(3))
                        .password(allUsersQueried.getString(4))
                        .roleId(allUsersQueried.getInt(5))
                        .build();

                allUsers.add(newUser);
            }

            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addUser(User user) {
        Connection connection = DbConnectionFactory.getConnection();

        System.out.println("Adding user: " + user.toString());

        try {
            PreparedStatement addUserQuery = connection.prepareStatement("INSERT INTO users (email, user_name, user_password, user_role_id) VALUES (?, ?, ?, ?)");
            addUserQuery.setString(1, user.getEmail());
            addUserQuery.setString(2, user.getName());
            addUserQuery.setString(3, user.getPassword());
            addUserQuery.setInt(4, user.getRoleId());
            return addUserQuery.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public User getUser(String email, String password) {
        System.out.println("Looking for user: (" + email + ", " + password + ")");

        Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement getAllUsersQuery = connection.prepareStatement("SELECT * FROM users WHERE email LIKE '" + email + "' AND user_password LIKE '" + password + "'"); //FIXME: Injection vulnerable

            User user = null;
            ResultSet userQueried = getAllUsersQuery.executeQuery();

            if (userQueried.next()) {
                user = new User
                        .Builder()
                        .email(userQueried.getString(2))
                        .name(userQueried.getString(3))
                        .password(userQueried.getString(4))
                        .roleId(userQueried.getInt(5))
                        .build();
            }

            System.out.println("Got user: " + user);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean isUserExists(String email, String password) {
        return getUser(email, password) != null;
    }
}
