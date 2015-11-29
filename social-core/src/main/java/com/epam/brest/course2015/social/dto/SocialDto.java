package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.User;

import java.util.List;

/**
 * Created by alexander on 14.11.15.
 *
 * @author alexander.borohov
 * @version 1.0
 *
 * {@link SocialDto} class is a DataTransferObject used to retrieve data
 * from a DB and to transfer universal data to GUI.
 * It includes a list of {@link User}s, number of {@link User} objects in
 * a list in a totalUsers variable, and a single {@link User} object
 * related to this list (e.g.
 *  -user - is a {@link User},
 *  -users list of {@link User}s - is a list of friends,
 *  -totalFriends - is a number of {@link User} objects in a users list
 *
 *
 */
public class SocialDto {
//  Class variables declaration
    private List<User> users;
    private Integer totalUsers;
    private User user;
//  Getters and setters for class variables
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
