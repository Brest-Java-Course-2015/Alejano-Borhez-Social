package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
    public Integer addImage(String token, String url, String url50, String url81) {
        String restUrl = restPrefix + "/image/upload" +
                "?url="
                + url
                + "&url50="
                + url50
                + "&url81="
                + url81;

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "application/json");
//        HttpEntity entity = new HttpEntity(headers);
//        Map<String, String> params = new HashMap<>();
//        params.put("url", url);
//        params.put("url50", url50);
//        params.put("url81", url81);

//        Integer imageId = restTemplate.exchange(restUrl, HttpMethod.POST, entity, Integer.class, params).getBody();

        Integer imageId = restTemplate
                .postForObject(
                        restUrl
                        , token
                        , Integer.class
//                        , params
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
    public void deleteImage(String token, Integer imageId) {
        String url = restPrefix
                + "/image"
                + "/delete"
                + "?imageId="
                + imageId;

        restTemplate.postForObject(url, token, Object.class);
    }

    @Override
    public void renameImage(String token, String name) {
        String url = restPrefix
                + "image/rename"
                + "?name="
                + name;
        restTemplate.postForObject(url, token, Object.class);
    }



//    All newly implemented methods
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
    public void deleteFriend(String token, Integer id2) {
        String url = restPrefix
                + "friendship/delete"
                + "?id2="
                + id2;

        restTemplate.postForObject(url, token, Boolean.class);
    }

    @Override
    @Logged
    public void addFriendship(String token, Integer id2) {
        String url = restPrefix
                + "friendship/add"
                + "?id2="
                + id2;

        restTemplate.postForObject(url, token, String.class);
    }

    @Override
    @Logged
    public boolean addUserSubmit(User user) {
        String url = restPrefix
                + "user";

        return restTemplate
                .postForObject(
                        url
                        , user
                        , boolean.class
                );
    }

    @Override
    @Logged
    public void changePassword(String token, String password) {
        String url = restPrefix
                + "user/password"
                + "?param="
                + password;

        restTemplate.postForObject(url, token, Object.class);
    }

    @Override
    @Logged
    public void changeLogin(String token, String login) {
        String url = restPrefix
                + "user/login"
                + "?param="
                + login;

        restTemplate.postForObject(url, token, Object.class);
    }

    @Override
    @Logged
    public void changeFirstName(String token, String firstName) {
        String url = restPrefix
                + "user/firstname"
                + "?param="
                + firstName;


        restTemplate.postForObject(url, token, Object.class);
    }

    @Override
    @Logged
    public void changeLastName(String token, String lastName) {
        String url = restPrefix
                + "user/lastname"
                + "?param="
                + lastName;

        restTemplate.postForObject(url, token, Object.class);
    }

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
