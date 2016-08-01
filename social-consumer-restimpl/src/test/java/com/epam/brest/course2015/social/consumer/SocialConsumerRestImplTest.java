package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * Created by alexander_borohov on 1.8.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SocialConsumerTestContext.class})
public class SocialConsumerRestImplTest {
    private static final Integer TEST_ID = 1;
    private static final String TEST_TOKEN = "token";
    private static final String TEST_NAME = "name";
    private static final String TEST_DATE_MIN = "2015-10-01";
    private static final String TEST_DATE_MAX = "2015-10-02";

    @Autowired
    private SocialConsumer socialConsumer;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Image image;
    @Value("${rest.prefix}")
    private String restPrefix;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        verify(restTemplate);
        reset(restTemplate);
    }

    @Test
    public void addImage() throws Exception {
        expect(restTemplate.postForObject(
                restPrefix
                + "image/upload"
                + "?url="
                + image.getUrl()
                + "&url50="
                + image.getUrl50()
                + "&url81="
                + image.getUrl81(),
                "token", Integer.class))
                .andReturn(TEST_ID);
        replay(restTemplate);
        Integer userId = socialConsumer.addImage(TEST_TOKEN, image.getUrl(), image.getUrl50(), image.getUrl81());
        assertTrue(userId == TEST_ID);
    }

    @Test
    public void deleteUser() throws Exception {
        restTemplate.delete(restPrefix + "user?id=" + TEST_ID);
        expectLastCall();
        replay(restTemplate);
        socialConsumer.deleteUser(TEST_ID);
    }

    @Test
    public void deleteImage() throws Exception {
        expect(restTemplate.postForLocation(restPrefix + "image/delete?userId=" + TEST_ID, TEST_TOKEN))
                .andReturn(new URI(restPrefix));
        replay(restTemplate);
        socialConsumer.deleteImage(TEST_TOKEN, TEST_ID);
    }

    @Test
    public void renameImage() throws Exception {
        expect(restTemplate.postForLocation(restPrefix + "image/rename?name=" + TEST_NAME, TEST_TOKEN))
                .andReturn(new URI(restPrefix));
        replay(restTemplate);
        socialConsumer.renameImage(TEST_TOKEN, TEST_NAME);
    }

    @Test
    public void deleteFriend() throws Exception {
        expect(restTemplate.postForLocation(restPrefix + "friendship/delete?id2=" + TEST_ID, TEST_TOKEN))
                .andReturn(new URI(restPrefix));
        replay(restTemplate);
        socialConsumer.deleteFriend(TEST_TOKEN, TEST_ID);
    }

    @Test
    public void addFriendship() throws Exception {
        expect(restTemplate.postForLocation(restPrefix + "friendship/add?id2=" + TEST_ID, TEST_TOKEN))
                .andReturn(new URI(restPrefix));
        replay(restTemplate);
        socialConsumer.addFriendship(TEST_TOKEN, TEST_ID);
    }

    @Test
    public void getAllUsersByDate() throws Exception {
        String url = restPrefix + "userdtobydate?datemin=" + TEST_DATE_MIN + "&datemax=" + TEST_DATE_MAX;
        expect(restTemplate.postForObject(url, TEST_TOKEN, SocialDto.class))
                .andReturn(new SocialDto());
        replay(restTemplate);
        Object test = socialConsumer.getAllUsersByDate(TEST_TOKEN, TEST_DATE_MIN, TEST_DATE_MAX);
        assertEquals(test.getClass(), SocialDto.class);
    }

    @Test
    public void addUserSubmit() throws Exception {
        User user = new User();
        expect(restTemplate.postForObject(restPrefix + "user", user, Boolean.class))
                .andReturn(true);
        replay(restTemplate);
        Boolean test = socialConsumer.addUserSubmit(user);
        assertTrue(test);
    }

//    @Test
    public void changePassword() throws Exception {

    }

//    @Test
    public void changeLastName() throws Exception {

    }

//    @Test
    public void getAllNoFriendsOfAUser() throws Exception {

    }

//    @Test
    public void isUserInDB() throws Exception {

    }

//    @Test
    public void isTokenValid() throws Exception {

    }

//    @Test
    public void getToken() throws Exception {

    }

//    @Test
    public void getUserDto() throws Exception {

    }

//    @Test
    public void getAllFriends() throws Exception {

    }

//    @Test
    public void getAllUsers() throws Exception {

    }

}