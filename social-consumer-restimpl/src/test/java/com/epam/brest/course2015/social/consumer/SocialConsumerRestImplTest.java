package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.Image;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private SocialConsumer socialConsumer;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Image image;
    @Value("${rest.scheme}")
    private String restScheme;
    @Value("${rest.host}")
    private String restHost;
    @Value("${rest.port}")
    private Integer restPort;
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
                restScheme
                + "://"
                + restHost
                + ":"
                + restPort
                + "/"
                + restPrefix
                + "/image/upload"
                + "?url="
                + image.getUrl()
                + "&url50="
                + image.getUrl50()
                + "&url81="
                + image.getUrl81(),
                "token", Integer.class))
                .andReturn(1);
        replay(restTemplate);
        Integer userId = socialConsumer.addImage("token", image.getUrl(), image.getUrl50(), image.getUrl81());
        assertTrue(userId == 1);
    }

//    @Test
    public void deleteUser() throws Exception {

    }

//    @Test
    public void deleteImage() throws Exception {

    }

//    @Test
    public void renameImage() throws Exception {

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