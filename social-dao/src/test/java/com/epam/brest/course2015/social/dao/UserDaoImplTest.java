package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by alexander on 25.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-dao.xml"})
@Transactional
public class UserDaoImplTest {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Integer testId = 1;
    public static final String testLogin = "julia_borohova";
    public static final String testPassword = "newPassword";
    @Autowired
    private UserDao userDao;

    @Test
    public void testGetAllUsers() throws Exception {
        LOGGER.debug("dao-test: getAllUsers");
        List<User> users = userDao.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() == 4);
    }

    @Test
    public void testGetUserById() throws Exception {
        LOGGER.debug("dao-test: getUserById");
        User user = userDao.getUserById(testId);
        assertNotNull(user);
        assertEquals(User.class, user.getClass());
        assertEquals(testId, user.getUserId());
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        LOGGER.debug("dao-test: getUserById");
        User user = userDao.getUserByLogin(testLogin);
        assertNotNull(user);
        assertEquals(User.class, user.getClass());
        assertEquals(testLogin, user.getLogin());
    }

    @Test (expected = EmptyResultDataAccessException.class)
    public void testDeleteUser() throws Exception {
        LOGGER.debug("dao-test: deleteUser");
        Integer sizeBefore = userDao.getAllUsers().size();
        userDao.deleteUser(testId);
        Integer sizeAfter = userDao.getAllUsers().size();
        assertTrue(sizeBefore-sizeAfter == 1);
        userDao.getUserById(testId);
    }

    @Test
    public void testAddUser() throws Exception {
        LOGGER.debug("dao-test: addUser");
        User user = new User("login", "password", "Petr", "Petrov", 30);
        Integer sizeBefore = userDao.getAllUsers().size();
        Integer newUserId = userDao.addUser(user);
        Integer sizeAfter = userDao.getAllUsers().size();
        assertNotNull(newUserId);
        assertTrue(sizeAfter - sizeBefore == 1);
        assertEquals(User.class, userDao.getUserById(newUserId).getClass());
    }

    @Test
    public void testUpdateUser() throws Exception {
        LOGGER.debug("dao-test: updateUser");
        userDao.updateUser(testId, testPassword);
        assertEquals(testPassword, userDao.getUserById(testId).getPassword());
    }

    @Test
    public void testGetFriends() throws Exception {
        LOGGER.debug("dao-test: getFriends");
        List<User> friends = userDao.getFriends(testId);
        assertNotNull(friends);
        assertTrue(friends.size() == 3);
        assertEquals(User.class, friends.get(0).getClass());

    }

}
