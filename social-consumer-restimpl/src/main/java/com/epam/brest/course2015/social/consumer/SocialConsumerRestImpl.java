package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexander on 19.1.16.
 */
@Component
public class SocialConsumerRestImpl implements SocialConsumer {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${rest.scheme}")
    private String restScheme;
    @Value("${rest.host}")
    private String restHost;
    @Value("${rest.port}")
    private Integer restPort;
    @Value("${rest.prefix}")
    private String restPrefix1;
    @Value("${rest.prefix1}")
    private String restPrefix;


    @Override
    @Logged
    public Integer addImage(String token, String url, String url50, String url81) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("url", url);
        params.set("url50", url50);
        params.set("url81", url81);

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(restScheme)
                .port(restPort)
                .host(restHost)
                .path(restPrefix1)
                .path("/image/upload")
                .queryParams(params)
                .build();

        String restUrl = uriComponents.toUriString();

        return restTemplate
                .postForObject(restUrl, token, Integer.class);
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

        return restTemplate.postForObject(url, token, SocialDto.class);
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
                .postForObject(url, user, Boolean.class);
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

        return restTemplate
                .postForObject(url, token, SocialDto.class);
    }

    @Override
    @Logged
    public boolean isUserInDB(User user) {
        String url = restPrefix
                    + "user/db";
        return restTemplate.postForObject(url, user, Boolean.class);
    }

    @Override
    public boolean isTokenValid(String token) {
        String url = restPrefix
                + "token/validate";

        return restTemplate.postForObject(url, token, Boolean.class);
    }

    @Override
    public String getToken(String login) {
        String url = restPrefix
                + "token"
                + "?login="
                + login;
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    @Logged
    public SocialDto getUserDto(String token) {
        String url = restPrefix
                + "/friendsdto";

        return restTemplate.postForObject(url, token, SocialDto.class);
    }

    @Override
    @Logged
    public SocialDto getAllFriends(String token) {
        String url = restPrefix
                + "/friendsdto";
        return restTemplate.postForObject(url, token, SocialDto.class);
    }

    @Override
    @Logged
    public SocialDto getAllUsers(String token) {
        String url = restPrefix + "userdto";
        return restTemplate.postForObject(url, token, SocialDto.class);
    }


}
