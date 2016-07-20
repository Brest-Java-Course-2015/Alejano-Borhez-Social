package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.SocialToken;
import com.epam.brest.course2015.social.dao.SecurityDao;
import org.apache.commons.logging.impl.SLF4JLocationAwareLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.Assert.*;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-persistence-HSQL.xml"})
@Transactional
public class SecurityDaoJPATest {
    private static final String testTokenId = "testToken";
    private static final String testTokenId2 = "testToken2";
    private static final Integer testUserId = 1;
    private static final SocialToken testSocialToken = new SocialToken(testUserId, testTokenId);

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

}