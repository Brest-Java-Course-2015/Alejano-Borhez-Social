package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;

import java.util.List;

/**
 * Created by alexander on 26.10.15.
 */
public interface FriendshipDao {
    void addFriendship(Integer id1, Integer id2);
    boolean isAFriend(Integer id1, Integer id2);
    void discardFriendship(Integer id1, Integer id2);
    List<Friendship> getAllFriendships();
    void discardAllFriendshipsOfAUser(Integer userId);
}
