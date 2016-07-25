package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.SocialToken;
import com.epam.brest.course2015.social.dao.SecurityDao;
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
@ContextConfiguration(locations = {"classpath:test-spring-persistence-HSQL.xml"})
@Transactional
public class SecurityDaoJPATest {
    private static final String TEST_TOKEN_ID = "testToken";
    private static final String TEST_TOKEN_ID_2 = "testToken2";
    private static final Integer TEST_USER_ID = 1;
    private static final SocialToken TEST_SOCIAL_TOKEN = new SocialToken(TEST_USER_ID, TEST_TOKEN_ID);

    @Autowired
    private SecurityDao securityDao;

    @Test
    public void addToken() throws Exception {
        securityDao.addToken(TEST_SOCIAL_TOKEN);
        SocialToken token = securityDao.getToken(TEST_TOKEN_ID);
        assertEquals(token, TEST_SOCIAL_TOKEN);
    }

    @Test
    public void deleteToken() throws Exception {
        SocialToken token = securityDao.getToken(TEST_TOKEN_ID_2);
        assertNotNull(token);
        securityDao.deleteToken(token);
        token = securityDao.getToken(TEST_TOKEN_ID_2);
        assertNull(token);
    }

    @Test
    public void getUserId() throws Exception {
        securityDao.addToken(TEST_SOCIAL_TOKEN);
        Integer userId = securityDao.getUserId(TEST_SOCIAL_TOKEN);
        assertNotNull(userId);
        assertEquals(userId, TEST_USER_ID);
    }

    @Test
    public void getTokenByUserId() throws Exception {
        SocialToken token = securityDao.getTokenByUserId(TEST_USER_ID +1);
        assertNotNull(token);
    }

}