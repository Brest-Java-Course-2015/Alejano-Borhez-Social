package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;

/**
 * Created by alexander on 19.1.16.
 */
public interface SocialConsumer {
    SocialDto getUser(Integer id);
    SocialDto getAllUsers();
    SocialDto getAllUsersByDate(String dateMin, String dateMax);
    SocialDto getAllFriends(Integer id);
    SocialDto getAllNoFriendsOfAUser(Integer id);
    Integer addUserSubmit(User user);
    void deleteUser(Integer id);
    void addFriendship(Integer id1, Integer id2);
    void deleteFriend(Integer id1, Integer id2);
    void changePassword(Integer id, String password);
    void changeLogin(Integer id, String login);
    void changeFirstName(Integer id, String firstName);
    void changeLastName(Integer id, String lastName);
}