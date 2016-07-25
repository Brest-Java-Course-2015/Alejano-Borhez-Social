package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class SocialTokenTest {
    private static final String TEST_TOKEN = "TEST_TOKEN";
    private static final Date TEST_DATE = new Date();
    private static final Integer TEST_USER_ID = 1;

    @Autowired
    private SocialToken token;

    @Test
    public void getToken() throws Exception {
        token.setToken(TEST_TOKEN);
        assertNotNull(token.getToken());
        assertEquals(token.getToken(), TEST_TOKEN);
    }

    @Test
    public void getExpires() throws Exception {
        token.setExpires(TEST_DATE);
        assertNotNull(token.getExpires());
        assertEquals(token.getExpires(), TEST_DATE);
    }

    @Test
    public void getUserId() throws Exception {
        token.setUserId(TEST_USER_ID);
        assertNotNull(token.getUserId());
        assertEquals(token.getUserId(), TEST_USER_ID);
    }

    @Test
    public void testConstructor() throws Exception {
        SocialToken socialToken = new SocialToken(TEST_USER_ID, TEST_TOKEN);
        assertNotNull(socialToken.getUserId());
        assertNotNull(socialToken.getToken());
        assertNotNull(socialToken.getExpires());
        assertEquals(socialToken.getToken(), TEST_TOKEN);
        assertEquals(socialToken.getUserId(), TEST_USER_ID);
        assertTrue(socialToken.getExpires().after(TEST_DATE));

    }

}