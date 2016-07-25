package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;

/**
 * Created by alexander on 19.1.16.
 */
public interface SocialConsumer {
    String getToken(String login);
    SocialDto getUserDto(String token);
    SocialDto getAllFriends(String token);
    SocialDto getAllUsers(String token);
    SocialDto getAllUsersByDate(String token, String dateMin, String dateMax);
    SocialDto getAllNoFriendsOfAUser(String token);
    void changePassword(String token, String password);
    void changeLogin(String token, String login);
    void changeFirstName(String token, String firstName);
    void changeLastName(String token, String lastName);

//    Not implemented
    Integer addUserSubmit(User user);
    Integer addImage(Integer userId, String url, String url50, String url81);
    void deleteUser(Integer id);
    void deleteImage(Integer userId, Integer imageId);
    void addFriendship(Integer id1, Integer id2);
    void deleteFriend(Integer id1, Integer id2);

    void renameImage(Integer id, String name);
    boolean isUserInDB(User user);
}