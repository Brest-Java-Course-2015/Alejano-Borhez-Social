package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Created by alexander on 19.1.16.
 */
public class SocialConsumerRestImpl implements SocialConsumer {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.prefix}")
    private String restPrefix;

    @Override
    @Logged
    public SocialDto getAllUsers() {
        String url = restPrefix + "userdto";
        SocialDto dto = restTemplate
                .getForEntity(
                        url
                        , SocialDto.class
                )
                .getBody();
        return dto;
    }

    @Override
    @Logged
    public SocialDto getAllUsersByDate(String dateMin, String dateMax) {
        String url = restPrefix + "/userdtobydate"
                + "?datemin="
                + dateMin
                + "&datemax="
                + dateMax;
        SocialDto dto = restTemplate.getForEntity(
                url
                , SocialDto.class)
                .getBody();

        return dto;
    }

    @Override
    @Logged
    public SocialDto getAllFriends(Integer id) {
        String url = restPrefix
                + "/friendsdto"
                + "?id="
                + id;
        SocialDto dto = restTemplate
                .getForEntity(
                        url
                        , SocialDto.class)
                .getBody();
        return dto;
    }

    @Override
    @Logged
    public void deleteFriend(Integer id1, Integer id2) {
        String url = restPrefix
                + "/user/friendship"
                + "?id1="
                + id1
                + "&id2="
                + id2;

        restTemplate.delete(url);
    }

    @Override
    @Logged
    public void addFriendship(Integer id1, Integer id2) {
        String url = restPrefix
                + "user/friendship"
                + "?id1="
                + id1
                + "&id2="
                + id2;

        restTemplate.postForObject(url, null, String.class);
    }

    @Override
    @Logged
    public SocialDto getUser(Integer id) {
        String url = restPrefix
                + "friendsdto"
                + "?id="
                + id;

        SocialDto dto =
                restTemplate
                        .getForEntity(
                                url
                                , SocialDto.class)
                        .getBody();
        return dto;
    }

    @Override
    @Logged
    public Integer addUserSubmit(User user) {
        String url = restPrefix
                + "user";

        Integer userId = restTemplate
                .postForObject(
                        url
                        , user
                        , Integer.class
                );
        return userId;
    }

    @Override
    @Logged
    public void deleteUser(Integer id) {
        String url = restPrefix
                + "user"
                + "?id="
                + id;

        restTemplate.delete(url);
    }

    @Override
    @Logged
    public void changePassword(Integer id, String password) {
        String url = restPrefix
                + "user/password"
                + "?id="
                + id
                + "&password="
                + password;

        restTemplate.put(url, null);
    }

    @Override
    @Logged
    public void changeLogin(Integer id, String login) {
        String url = restPrefix
                + "user/login"
                + "?id="
                + id
                + "&login="
                + login;

        restTemplate.put(url, null);
    }

    @Override
    @Logged
    public void changeFirstName(Integer id, String firstName) {
        String url = restPrefix
                + "user/firstname"
                + "?id="
                + id
                + "&firstname="
                + firstName;

        restTemplate.put(url, null);
    }

    @Override
    @Logged
    public void changeLastName(Integer id, String lastName) {
        String url = restPrefix
                + "user/lastname"
                + "?id="
                + id
                + "&lastname="
                + lastName;

        restTemplate.put(url, null);
    }

    @Override
    @Logged
    public SocialDto getAllNoFriendsOfAUser(Integer id) {
        String url = restPrefix
                + "/nofriendsdto"
                + "?id="
                + id;

        SocialDto dto = restTemplate
                .getForObject(url, SocialDto.class);
        return dto;
    }


}
