package com.epam.brest.course2015.social.core;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import static org.junit.Assert.*;
import static com.epam.brest.course2015.social.test.LOGGER.LOGGERDO;

/**
 * Created by alexander on 25.10.15.
 */
public class UserTest {
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
        LOGGERDO();
        user.setFirstName(firstName);
        assertNotNull(user.getFirstName());
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        LOGGERDO();
        user.setLastName(lastName);
        assertNotNull(user.getLastName());
        assertEquals(lastName, user.getLastName());
    }

    @Test
    public void testGetAge() throws Exception {
        LOGGERDO();
        user.setAge(age);
        assertNotNull(user.getAge());
        assertEquals(age, user.getAge());
    }

    @Test
    public void testGetLogin() throws Exception {
        LOGGERDO();
        user.setLogin(login);
        assertNotNull(user.getLogin());
        assertEquals(login, user.getLogin());
    }

    @Test
    public void testGetPassword() throws Exception {
        LOGGERDO();
        user.setPassword(password);
        assertNotNull(user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetUserId() throws Exception {
        LOGGERDO();
        user.setUserId(userId);
        assertNotNull(user.getUserId());
        assertEquals(userId, user.getUserId());
    }

    @Test
    public void testGetCreatedDate() throws Exception {
        LOGGERDO();
        user.setCreatedDate(new Date());
        assertNotNull(user.getCreatedDate());
        assertEquals(Date.class, user.getCreatedDate().getClass());
    }

    @Test
    public void testGetUpdatedDate() throws Exception {
        LOGGERDO();
        user.setUpdatedDate(new Date());
        assertNotNull(user.getUpdatedDate());
        assertEquals(Date.class, user.getUpdatedDate().getClass());
    }

    @Test
    public void testBaseConstructor() throws Exception {
        LOGGERDO();
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

    @Test
    public void testTestConstructor() throws Exception {
        LOGGERDO();
        User testUser = new User(userId);
        assertNotNull(testUser);
        assertNotNull(testUser.getUserId());
        assertEquals(testUser.getUserId(), userId);
        assertEquals(testUser.getUserId().getClass(), Integer.class);
    }

    @Test
    public void testSetTotalFriends() throws Exception {
        LOGGERDO();
        Integer totalFriends = 5;
        user.setTotalFriends(totalFriends);
        Integer testTotalFriends = user.getTotalFriends();
        assertNotNull(testTotalFriends);
        assertTrue(testTotalFriends == totalFriends);
    }

}
