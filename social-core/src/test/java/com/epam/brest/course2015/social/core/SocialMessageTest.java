package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;


/**
 * Created by alexander on 12.4.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class SocialMessageTest {
    private final Integer user1Id = 1;
    private final Integer user2Id = 2;
    private final String message = "Test message!";

    @Autowired
    private SocialMessage testSocialMessage;

    @Test
    public void testGetUser1Id() throws Exception {
        testSocialMessage.setUser1Id(user1Id);
        assertEquals(user1Id, testSocialMessage.getUser1Id());
    }

    @Test
    public void testGetUser2Id() throws Exception {
        testSocialMessage.setUser2Id(user2Id);
        assertEquals(user2Id, testSocialMessage.getUser2Id());
    }

    @Test
    public void testGetMessage() throws Exception {
        testSocialMessage.setMessage(message);
        assertEquals(message, testSocialMessage.getMessage());
    }

    @Test
    public void testGetCreatedDate() throws Exception {
        assertEquals(Date.class, testSocialMessage.getCreatedDate().getClass());
    }
}