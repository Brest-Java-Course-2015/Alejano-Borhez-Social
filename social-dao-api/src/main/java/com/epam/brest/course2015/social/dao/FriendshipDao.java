package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;

import java.util.List;

/**
 * Created by alexander on 26.10.15.
 */
public interface FriendshipDao {
    void addFriendship(User friend1, User friend2);
    boolean isAFriend(User user1, User user2);
    void discardFriendship(User enemy1, User enemy2);
    Integer[] listOfFriendsId (User user);
    List<User> getFriends (User user);

}
