package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexander on 25.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-persistence-user.xml"})
@Transactional
public class UserDaoJPATest {

    private static final Integer testId = 1;
    private static final String testPassword = "newPassword";

    @Autowired
    UserDao userDao;

    @Test
    public void testGetAllUsers() throws Exception {
        User user = userDao.getUserById(testId);
        assertNotNull(user);
        assertEquals(user.getFirstName(), "Alexander");
    }


    @Test
    public void testDeleteUser() throws Exception {
        userDao.deleteUser(testId);
    }

    @Test
    public void testChangePassword() throws Exception {
        User user = userDao.getUserById(testId);
        String passwordBefore = user.getPassword();
        userDao.changePassword(testId, testPassword);
        User user2 = userDao.getUserById(testId);
        String passwordAfter = user2.getPassword();
        assertNotEquals(passwordBefore, passwordAfter);
        assertEquals(passwordAfter, testPassword);
    }
}