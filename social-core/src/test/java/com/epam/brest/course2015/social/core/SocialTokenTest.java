package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class SocialTokenTest {
    private static final String testToken = "testToken";
    private static final Date testDate = new Date();
    private static final Integer testUserId = 1;

    @Autowired
    private SocialToken token;

    @Test
    public void getToken() throws Exception {
        token.setToken(testToken);
        assertNotNull(token.getToken());
        assertEquals(token.getToken(), testToken);
    }

    @Test
    public void getExpires() throws Exception {
        token.setExpires(testDate);
        assertNotNull(token.getExpires());
        assertEquals(token.getExpires(), testDate);
    }

    @Test
    public void getUserId() throws Exception {
        token.setUserId(testUserId);
        assertNotNull(token.getUserId());
        assertEquals(token.getUserId(), testUserId);
    }

    @Test
    public void testConstructor() throws Exception {
        SocialToken socialToken = new SocialToken(testUserId, testToken);
        assertNotNull(socialToken.getUserId());
        assertNotNull(socialToken.getToken());
        assertNotNull(socialToken.getExpires());
        assertEquals(socialToken.getToken(), testToken);
        assertEquals(socialToken.getUserId(), testUserId);
        assertTrue(socialToken.getExpires().after(testDate));

    }

}