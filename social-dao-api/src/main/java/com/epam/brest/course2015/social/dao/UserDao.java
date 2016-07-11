package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;

import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 25.10.15.
 */
public interface UserDao {
    Integer addUser(User user);
    void changePassword(Integer id, String password);
    void changeLogin(Integer id, String login);
    void changeFirstName(Integer id, String firstName);
    void changeLastName(Integer id, String lastName);
    void deleteUser(Integer id);
    List<User> getFriends(Integer id);
    List<User> getNoFriends(Integer id);
    List<User> getAllUsers();
    List<User> getAllUsers(Date dateMin, Date dateMax);
    User getUserById(Integer id);
    User getUserByLogin(String login);
    Integer getCountOfUsers();
    Integer getCountOfUserFriends(Integer id);

}
