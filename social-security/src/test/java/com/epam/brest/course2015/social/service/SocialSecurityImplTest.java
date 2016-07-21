package com.epam.brest.course2015.social.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-security-test.xml"})
@Transactional
public class SocialSecurityImplTest {
    @Autowired
    private SocialSecurity socialSecurity;

    private static final Integer TEST_USER_ID = 1;
    private static final String TEST_TOKEN = "testToken2";

    @Test
    public void generateSecurityToken() throws Exception {
        String token = socialSecurity.generateSecurityToken(TEST_USER_ID);
        Integer userId = socialSecurity.getUserId(token);
        assertNotNull(userId);
    }

    @Test
    public void getUserId() throws Exception {
        Integer userId = socialSecurity.getUserId(TEST_TOKEN);
        assertNotNull(userId);
        assertTrue(userId == 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getUserIdIncorrectToken() throws Exception {

        Integer userId = socialSecurity.getUserId("token");

    }

}