package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;

import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 5.11.15.
 */
public interface SocialService {
    Integer addUser(User user);
    Integer addImage(Integer userId, String imageUrl);
    void deleteUser(Integer id);
    void changePassword(Integer id, String password);
    void changeLogin(Integer id, String login);
    void changeFirstName(Integer id, String firstName);
    void changeLastName(Integer id, String lastName);
    User getUserById(Integer id);
    User getUserByLogin(String login);
    List<User> getAllUsers();
    List<User> getAllUsersByDate(Date dateMin, Date dateMax);
    List<User> getFriends(Integer id);
    List<User> getNoFriends(Integer id);
    void addFriendship(User user1, User user2);
    boolean isAFriend(User user1, User user2);
    void discardFriendship(User enemy1, User enemy2);
    List<Friendship> getAllFriendships();
    void discardAllFriendshipsOfAUser(Integer id);
    SocialDto getSocialUsersDto();
    SocialDto getSocialFriendsDto(Integer id);
    SocialDto getSocialNoFriendsDto(Integer id);
    SocialDto getSocialUsersDtoByDate(Date dateMin, Date dateMax);
    List<Image> getAllImagesOfAUser(Integer id);
}
