package com.epam.brest.course2015.social.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${test.userId1}")
    private Integer testUserId;
    @Value("${test.token}")
    private String testToken;
    @Value("${test.token1}")
    private String testToken1;
    @Value("${test.token2}")
    private String testToken2;
    @Value("${test.role}")
    private String testRole;
    @Value("${test.role1}")
    private String testRole1;
    @Value("${test.role2}")
    private String testRole2;


    @Test
    public void generateSecurityToken() throws Exception {
        String token = socialSecurity.generateSecurityToken(testUserId, testRole);
        Integer userId = socialSecurity.getUserId(token);
        assertNotNull(userId);
        assertTrue(socialSecurity.isTokenValid(token, testRole));
    }

    @Test
    public void getUserId() throws Exception {
        Integer userId = socialSecurity.getUserId(testToken1);
        assertNotNull(userId);
        assertTrue(userId == 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getUserIdIncorrectToken() throws Exception {

        Integer userId = socialSecurity.getUserId(testToken);

    }

    @Test
    public void isTokenValidTrue() throws Exception {
        boolean result = socialSecurity.isTokenValid(testToken1, testRole, testRole1);
        assertTrue(result);
    }

    @Test
    public void isTokenValidFalseNullToken() throws Exception {
        boolean result = socialSecurity.isTokenValid(null, testRole, testRole1);
        assertFalse(result);
    }

    @Test
    public void isTokenValidFalseNullRole() throws Exception {
        assertFalse(socialSecurity.isTokenValid(testToken1));
    }

    @Test
    public void isTokenValidFalseIncorrectRole() throws Exception {
        assertFalse(socialSecurity.isTokenValid(testToken1, testRole2));
    }

    @Test
    public void isTokenValidFalseExpired() throws Exception {
        assertFalse(socialSecurity.isTokenValid(testToken2, testRole));
    }

    @Test
    public void isTokenValidFalseIncorrectToken() throws Exception {
        assertFalse(socialSecurity.isTokenValid(testToken, testRole, testRole1));
    }

}