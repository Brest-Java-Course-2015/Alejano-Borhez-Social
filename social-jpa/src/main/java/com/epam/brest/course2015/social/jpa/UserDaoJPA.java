package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;

import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 25.12.15.
 */
public class UserDaoJPA implements UserDao {


    @Override
    public Integer addUser(User user) {

        return null;
    }

    @Override
    public void changePassword(Integer id, String password) {

    }

    @Override
    public void changeLogin(Integer id, String login) {

    }

    @Override
    public void changeFirstName(Integer id, String firstName) {

    }

    @Override
    public void changeLastName(Integer id, String lastName) {

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
    public List<User> getAllUsers(Date dateMin, Date dateMax) {
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

    @Override
    public Integer getCountOfUsers() {
        return null;
    }

    @Override
    public Integer getCountOfUserFriends(Integer id) {
        return null;
    }
}
