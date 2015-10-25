package com.epam.brest.course2015.social.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.*;
/**
 * Created by alexander on 25.10.15.
 */
public class UserTest {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String firstName = "FirstName";
    private static final String lastName = "LastName";
    private static final Integer age = 38;
    private static final String login = "Login";
    private static final String password = "Password";
    private static final Integer userId = 1;
    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGetFirstName() throws Exception {
        LOGGER.debug("core-test: getFirstName");
        user.setFirstName(firstName);
        assertNotNull(user.getFirstName());
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        LOGGER.debug("core-test: getLastName");
        user.setLastName(lastName);
        assertNotNull(user.getLastName());
        assertEquals(lastName, user.getLastName());
    }

    @Test
    public void testGetAge() throws Exception {
        LOGGER.debug("core-test: getAge");
        user.setAge(age);
        assertNotNull(user.getAge());
        assertEquals(age, user.getAge());
    }

    @Test
    public void testGetLogin() throws Exception {
        LOGGER.debug("core-test: getLogin");
        user.setLogin(login);
        assertNotNull(user.getLogin());
        assertEquals(login, user.getLogin());
    }

    @Test
    public void testGetPassword() throws Exception {
        LOGGER.debug("core-test: getPassword");
        user.setPassword(password);
        assertNotNull(user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetUserId() throws Exception {
        LOGGER.debug("core-test: getUserId");
        user.setUserId(userId);
        assertNotNull(user.getUserId());
        assertEquals(userId, user.getUserId());
    }

    @Test
    public void testGetFriends() throws Exception {
        LOGGER.debug("core-test: getFriends");
        List<User> friends = new ArrayList<User>() {};
        friends.add(user);
        user.setFriends(friends);
        assertNotNull(user.getFriends());
        assertTrue(user.getFriends().size() > 0);
        assertEquals(User.class, user.getFriends().get(0).getClass());
    }

    @Test
    public void testGetCreatedDate() throws Exception {
        LOGGER.debug("core-test: getCreatedDate");
        user.setCreatedDate(new Date());
        assertNotNull(user.getCreatedDate());
        assertEquals(Date.class, user.getCreatedDate().getClass());
    }

    @Test
    public void testGetUpdatedDate() throws Exception {
        LOGGER.debug("core-test: getUpdatedDate");
        user.setUpdatedDate(new Date());
        assertNotNull(user.getUpdatedDate());
        assertEquals(Date.class, user.getUpdatedDate().getClass());
    }

    @Test
    public void testBaseConstructor() throws Exception {
        LOGGER.debug("core-test: baseConstructor user");
        User testUser = new User(login, password, firstName, lastName, age);
        assertNotNull(testUser);
        assertEquals(login, testUser.getLogin());
        assertEquals(String.class, testUser.getLogin().getClass());
        assertEquals(password, testUser.getPassword());
        assertEquals(String.class, testUser.getPassword().getClass());
        assertEquals(firstName, testUser.getFirstName());
        assertEquals(String.class, testUser.getFirstName().getClass());
        assertEquals(lastName, testUser.getLastName());
        assertEquals(String.class, testUser.getLastName().getClass());
        assertEquals(age, testUser.getAge());
        assertEquals(Integer.class, testUser.getAge().getClass());
        assertNull(testUser.getUserId());
        assertEquals(Date.class, testUser.getCreatedDate().getClass());
        assertEquals(Date.class, testUser.getUpdatedDate().getClass());
    }



}
