package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by alexander on 19.1.16.
 */
@Component
public class SocialConsumerRestImpl implements SocialConsumer {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.prefix}")
    private String restPrefix;

    @Override
    @Logged
    public SocialDto getAllUsersByDate(String token, String dateMin, String dateMax) {
        String url = restPrefix + "/userdtobydate"
                + "?datemin="
                + dateMin
                + "&datemax="
                + dateMax;
        SocialDto dto = restTemplate.postForEntity(
                url
                , token
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
    public Integer addImage(Integer id, String url, String url50, String url81) {
        String restUrl = restPrefix
                + "/image"
                + "/upload"
                + "?id="
                + id
                + "&url="
                + url
                + "&url50="
                + url50
                + "&url81="
                + url81;

        Integer imageId = restTemplate
                .postForObject(
                        restUrl
                        , null
                        , Integer.class
                );

        return imageId;
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
    public void deleteImage(Integer userId, Integer imageId) {
        String url = restPrefix
                + "/image"
                + "/delete"
                + "?userId="
                + userId
                + "&imageId="
                + imageId;

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
    public void renameImage(Integer id, String name) {
        String url = restPrefix
                + "image/rename"
                + "?id="
                + id
                + "&name="
                + name;
        restTemplate.put(url, null);
    }



//    All newly implemented methods
    @Override
    @Logged
    public SocialDto getAllNoFriendsOfAUser(String token) {
        String url = restPrefix
                + "/nofriendsdto";

        SocialDto dto = restTemplate
                .postForEntity(url, token, SocialDto.class).getBody();
        return dto;
    }

    @Override
    @Logged
    public boolean isUserInDB(User user) {
        String url = restPrefix
                    + "user/db";
        return restTemplate.postForEntity(url, user, Boolean.class).getBody();
    }

    @Override
    public String getToken(String login) {
        String url = restPrefix
                + "token"
                + "?login="
                + login;
        return restTemplate.getForEntity(url, String.class).getBody();
    }

    @Override
    @Logged
    public SocialDto getUserDto(String token) {
        String url = restPrefix
                + "/friendsdto";

        SocialDto dto =
                restTemplate
                        .postForObject(
                                url,
                                token,
                                SocialDto.class
                        );
        return dto;
    }

    @Override
    @Logged
    public SocialDto getAllFriends(String token) {
        String url = restPrefix
                + "/friendsdto";
        SocialDto dto = restTemplate
                .postForEntity(
                        url
                        , token
                        , SocialDto.class)
                .getBody();
        return dto;
    }

    @Override
    @Logged
    public SocialDto getAllUsers(String token) {
        String url = restPrefix + "userdto";
        SocialDto dto = restTemplate
                .postForEntity(
                        url
                        , token
                        , SocialDto.class
                )
                .getBody();
        return dto;
    }


}
