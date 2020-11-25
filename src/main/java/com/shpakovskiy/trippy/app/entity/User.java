package com.shpakovskiy.trippy.app.entity;

import java.util.Objects;

public class User {

    private int id;
    private String email;
    private String name;
    private String password;
    private UserRole role = null;
    private int roleId;

    private User() { }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() { return name; }

    public String getPassword() {
        return password;
    }

    public int getRoleId() {
        if (role != null) {
            return role.ordinal();
        }
        return roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                roleId == user.roleId &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, password, role, roleId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", roleId=" + roleId +
                '}';
    }

    public static class Builder {
        private final User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder id(int id) {
            newUser.id = id;
            return this;
        }

        public Builder email(String email) {
            newUser.email = email;
            return this;
        }

        public Builder name(String name) {
            newUser.name = name;
            return this;
        }


        public Builder password(String password) {
            newUser.password = password;
            return this;
        }

        public Builder role(UserRole userRole) {
            newUser.role = userRole;
            newUser.roleId = userRole.ordinal() + 1;
            return this;
        }

        public Builder roleId(int roleId) {
            newUser.roleId = roleId;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
