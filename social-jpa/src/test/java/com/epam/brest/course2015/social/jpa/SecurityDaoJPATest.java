package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.SocialToken;
import com.epam.brest.course2015.social.dao.SecurityDao;
import org.junit.Before;
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
@ContextConfiguration(locations = {"classpath:test-spring-persistence-HSQL.xml"})
@Transactional
public class SecurityDaoJPATest {
    @Value("${test.token}")
    private String testTokenId;
    @Value("${test.token1}")
    private String testTokenId2;
    @Value("${test.userId1}")
    private Integer testUserId;
    @Value("${test.role}")
    private String testRole;
    private SocialToken testSocialToken = new SocialToken();

    @Before
    public void setUp() throws Exception {
        testSocialToken.setRole(testRole);
        testSocialToken.setToken(testTokenId);
        testSocialToken.setUserId(testUserId);

    }

    @Autowired
    private SecurityDao securityDao;

    @Test
    public void addToken() throws Exception {
        securityDao.addToken(testSocialToken);
        SocialToken token = securityDao.getToken(testTokenId);
        assertEquals(token, testSocialToken);
    }

    @Test
    public void deleteToken() throws Exception {
        SocialToken token = securityDao.getToken(testTokenId2);
        assertNotNull(token);
        securityDao.deleteToken(token);
        token = securityDao.getToken(testTokenId2);
        assertNull(token);
    }

    @Test
    public void getUserId() throws Exception {
        securityDao.addToken(testSocialToken);
        Integer userId = securityDao.getUserId(testSocialToken);
        assertNotNull(userId);
        assertEquals(userId, testUserId);
    }

    @Test
    public void getTokenByUserId() throws Exception {
        SocialToken token = securityDao.getTokenByUserId(testUserId +1);
        assertNotNull(token);
    }

}