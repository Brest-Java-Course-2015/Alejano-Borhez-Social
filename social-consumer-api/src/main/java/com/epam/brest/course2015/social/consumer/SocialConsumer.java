package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;

/**
 * Created by alexander on 19.1.16.
 */
public interface SocialConsumer {
    String hello();
    String getToken(String login);
    SocialDto getUserDto(String token);
    User getUser(String login);
    SocialDto getAllUsers();
    SocialDto getAllUsersByDate(String dateMin, String dateMax);
    SocialDto getAllFriends(Integer id);
    SocialDto getAllNoFriendsOfAUser(Integer id);
    Integer addUserSubmit(User user);
    Integer addImage(Integer userId, String url, String url50, String url81);
    void deleteUser(Integer id);
    void deleteImage(Integer userId, Integer imageId);
    void addFriendship(Integer id1, Integer id2);
    void deleteFriend(Integer id1, Integer id2);
    void changePassword(Integer id, String password);
    void changeLogin(Integer id, String login);
    void changeFirstName(Integer id, String firstName);
    void changeLastName(Integer id, String lastName);
    void renameImage(Integer id, String name);

}