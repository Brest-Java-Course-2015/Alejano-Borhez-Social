package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.SocialMessage;

import java.util.List;

/**
 * Created by alexander on 13.4.16.
 */
public interface SocialMessageDao {
    void addMessage(Integer id1, Integer id2, String message);
    void deleteMessage(Integer id1, Integer id2);
    List<SocialMessage> getMessagesFromUserToUser(Integer id1, Integer id2);
}
