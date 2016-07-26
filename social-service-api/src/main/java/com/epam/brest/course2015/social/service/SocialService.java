package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 5.11.15.
 */
public interface SocialService {
    Integer addUser(User user);
    Integer addImage(Integer userId, String url, String url50, String url81);
    void deleteUser(Integer id);
    void deleteImage(Integer userId, Integer imageId);
    void changePassword(Integer id, String password);
    void changeLogin(Integer id, String login);
    void changeFirstName(Integer id, String firstName);
    void changeLastName(Integer id, String lastName);
    void renameImage(Integer id, String name);
    User getUserById(Integer id);
    User getUserByLogin(String login);
    List<User> getAllUsers();
    List<User> getAllUsersByDate(Date dateMin, Date dateMax);
    List<User> getFriends(Integer id);
    List<User> getNoFriends(Integer id);
    void addFriendship(Integer id1, Integer id2);
    boolean isAFriend(Integer id1, Integer id2);
    void discardFriendship(Integer id1, Integer id2);
    List<Friendship> getAllFriendships();
    void discardAllFriendshipsOfAUser(Integer id);
    SocialDto getSocialUsersDto();
    SocialDto getSocialFriendsDto(Integer id);
    SocialDto getSocialNoFriendsDto(Integer id);
    SocialDto getSocialUsersDtoByDate(Date dateMin, Date dateMax);
    List<Image> getAllImagesOfAUser(Integer id);

}
