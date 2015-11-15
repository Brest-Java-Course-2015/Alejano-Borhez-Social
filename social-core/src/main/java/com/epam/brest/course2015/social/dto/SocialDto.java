package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.User;

import java.util.List;

/**
 * Created by alexander on 14.11.15.
 */
public class SocialDto {
    private List<User> users;
    private Integer totalUsers;
    private User user;

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
