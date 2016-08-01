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
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("url", url);
        params.set("url50", url50);
        params.set("url81", url81);

        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
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
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("user")
                .queryParam("id", id)
                .build();

        String url = uriComponents.toUriString();

        restTemplate.delete(url);
    }

    @Override
    @Logged
    public void deleteImage(String token, Integer imageId) {
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("image/delete")
                .queryParam("userId", imageId)
                .build();

        String url = uriComponents.toUriString();

        restTemplate.postForLocation(url, token);
    }

    @Override
    @Logged
    public void renameImage(String token, String name) {
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("image/rename")
                .queryParam("name", name)
                .build();

        String url = uriComponents.toUriString();

        restTemplate.postForLocation(url, token);
    }

//    All newly implemented methods
    @Override
    @Logged
    public SocialDto getAllUsersByDate(String token, String dateMin, String dateMax) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("datemin", dateMin);
        params.set("datemax", dateMax);

        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("userdtobydate")
                .queryParams(params)
                .build();

        String url = uriComponents.toUriString();

        return restTemplate.postForObject(url, token, SocialDto.class);
    }

    @Override
    @Logged
    public void deleteFriend(String token, Integer id2) {
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("friendship/{action}")
                .queryParam("id2", id2)
                .buildAndExpand("delete");

        String url = uriComponents.toUriString();

        restTemplate.postForLocation(url, token);
    }

    @Override
    @Logged
    public void addFriendship(String token, Integer id2) {
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("friendship/{action}")
                .queryParam("id2", id2)
                .buildAndExpand("add");

        String url = uriComponents.toUriString();

        restTemplate.postForLocation(url, token);
    }

    @Override
    @Logged
    public boolean addUserSubmit(User user) {
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("user")
                .build();

        String url = uriComponents.toUriString();

        return restTemplate
                .postForObject(url, user, Boolean.class);
    }

    @Override
    @Logged
    public void changePassword(String token, String password) {
        UriComponents uriComponents = UriComponentsBuilder
                .fromHttpUrl(restPrefix)
                .path("user")
                .path("{action}")
                .queryParam("param", password)
                .buildAndExpand("password");

        String url = uriComponents.toUriString();

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
