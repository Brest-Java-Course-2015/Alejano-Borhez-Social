package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.dao.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by alexander on 6.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service-test.xml"})
@Transactional
public class SocialServiceImplTest  {
    //Универсальный Логгер, который показывает имя тестового класса и имя тестового метода
    private static final Logger LOGGER = LogManager.getLogger();
    private static void LOGGERDO() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        LOGGER.debug("Test Class: " + elements[2].getClassName() + ", started test: " + elements[2].getMethodName());
    }
    private static final User testUser1 = new User("testLogin1", "testPassword1", "testFirstName1", "testLastName1", 25);
    private static final User testUser2 = new User("testLogin2", "testPassword2", "testFirstName2", "testLastName2", 26);
    private static final Friendship testFriendship = new Friendship(2, 4);

    @Autowired
    private SocialService socialService;

    @Test
    public void testAddUser() throws Exception {
        LOGGERDO();
        Integer sizeBefore = socialService.getAllUsers().size();
        Integer newUserId = socialService.addUser(testUser1);
        Integer sizeAfter = socialService.getAllUsers().size();
        assertTrue(sizeAfter - sizeBefore == 1);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNotNullId() throws Exception {
        LOGGERDO();
        socialService.addUser(new User(5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullUser() throws Exception {
        LOGGERDO();
        socialService.addUser(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullLogin() throws Exception {
        LOGGERDO();
        User testUser = new User();
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullPassword() throws Exception {
        LOGGERDO();
        User testUser = new User();
        testUser.setLogin(testUser1.getLogin());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullFirstName() throws Exception {
        LOGGERDO();
        User testUser = new User();
        testUser.setLogin(testUser1.getLogin());
        testUser.setPassword(testUser1.getPassword());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullLastName() throws Exception {
        LOGGERDO();
        User testUser = new User();
        testUser.setLogin(testUser1.getLogin());
        testUser.setPassword(testUser1.getPassword());
        testUser.setFirstName(testUser1.getFirstName());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddExistingUser() throws Exception {
        LOGGERDO();
        User testUser = socialService.getUserById(1);
        testUser.setUserId(null);
        socialService.addUser(testUser);
    }

    public void testDeleteUser() throws Exception {

    }

    public void testUpdateUser() throws Exception {

    }

    public void testGetUserById() throws Exception {

    }

    public void testGetUserByLogin() throws Exception {

    }

    public void testGetAllUsers() throws Exception {

    }

    public void testGetFriends() throws Exception {

    }

    public void testAddFriendship() throws Exception {

    }
}