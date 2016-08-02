package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${test.token}")
    private String testToken;
    @Value("${test.userId1}")
    private Integer testUserId;
    @Value("${test.role}")
    private String role;

    private static final Date TEST_DATE = new Date();

    @Autowired
    private SocialToken token;

    @Test
    public void getToken() throws Exception {
        token.setToken(testToken);
        assertNotNull(token.getToken());
        assertEquals(token.getToken(), testToken);
    }

    @Test
    public void getRole() throws Exception {
        token.setRole(role);
        assertNotNull(token.getRole());
        assertEquals((token.getRole()), SocialToken.Role.ADMIN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getRoleFail() throws Exception {
        token.setRole(role + "abc");

    }

    @Test
    public void getExpires() throws Exception {
        token.setExpires(TEST_DATE);
        assertNotNull(token.getExpires());
        assertEquals(token.getExpires(), TEST_DATE);
    }

    @Test
    public void getUserId() throws Exception {
        token.setUserId(testUserId);
        assertNotNull(token.getUserId());
        assertEquals(token.getUserId(), testUserId);
    }

    @Test
    public void testConstructor() throws Exception {
        SocialToken socialToken = new SocialToken(testUserId, testToken, role);
        assertNotNull(socialToken.getUserId());
        assertNotNull(socialToken.getToken());
        assertNotNull(socialToken.getExpires());
        assertEquals(socialToken.getToken(), testToken);
        assertEquals(socialToken.getUserId(), testUserId);
        assertEquals(socialToken.getRole(), SocialToken.Role.valueOf(role));
        assertTrue(socialToken.getExpires().after(TEST_DATE));

    }

}