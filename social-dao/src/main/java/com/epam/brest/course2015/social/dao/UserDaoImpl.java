package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;

import java.util.List;

/**
 * Created by alexander on 25.10.15.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public Integer addUser(User user) {
        return null;
    }

    @Override
    public void updateUser(Integer id, String password) {

    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public List<User> getFriends(Integer id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }
}
