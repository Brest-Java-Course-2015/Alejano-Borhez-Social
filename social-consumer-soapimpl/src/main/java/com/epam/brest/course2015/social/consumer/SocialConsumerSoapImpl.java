package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 * Created by alexander on 26.1.16.
 */

@Endpoint
public class SocialConsumerSoapImpl implements SocialConsumer {
    @Override
    public String hello() {
        return "Hello!";
    }

    @Override
    public SocialDto getUser(Integer id) {
        return null;
    }

    @Override
    public SocialDto getAllUsers() {
        return null;
    }

    @Override
    public SocialDto getAllUsersByDate(String dateMin, String dateMax) {
        return null;
    }

    @Override
    public SocialDto getAllFriends(Integer id) {
        return null;
    }

    @Override
    public SocialDto getAllNoFriendsOfAUser(Integer id) {
        return null;
    }

    @Override
    public Integer addUserSubmit(User user) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public void addFriendship(Integer id1, Integer id2) {

    }

    @Override
    public void deleteFriend(Integer id1, Integer id2) {

    }

    @Override
    public void changePassword(Integer id, String password) {

    }

    @Override
    public void changeLogin(Integer id, String login) {

    }

    @Override
    public void changeFirstName(Integer id, String firstName) {

    }

    @Override
    public void changeLastName(Integer id, String lastName) {

    }
}
