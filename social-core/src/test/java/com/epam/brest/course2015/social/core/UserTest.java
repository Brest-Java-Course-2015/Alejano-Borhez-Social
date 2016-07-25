package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by alexander on 25.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class UserTest {
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final Integer AGE = 38;
    private static final String LOGIN = "Login";
    private static final String PASSWORD = "Password";
    private static final Integer USER_ID = 1;
    private static final List<Image> IMAGE_LIST = Arrays.asList(new Image(), new Image());
    private static final List<User> USER_LIST = Arrays.asList(new User(), new User());

    @Autowired
    private User user;

    @Test
    public void testGetFirstName() throws Exception {
        user.setFirstName(FIRST_NAME);
        assertNotNull(user.getFirstName());
        assertEquals(FIRST_NAME, user.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        user.setLastName(LAST_NAME);
        assertNotNull(user.getLastName());
        assertEquals(LAST_NAME, user.getLastName());
    }

    @Test
    public void testGetAge() throws Exception {
        user.setAge(AGE);
        assertNotNull(user.getAge());
        assertEquals(AGE, user.getAge());
    }

    @Test
    public void testGetLogin() throws Exception {
        user.setLogin(LOGIN);
        assertNotNull(user.getLogin());
        assertEquals(LOGIN, user.getLogin());
    }

    @Test
    public void testGetPassword() throws Exception {
        user.setPassword(PASSWORD);
        assertNotNull(user.getPassword());
        assertEquals(PASSWORD, user.getPassword());
    }

    @Test
    public void testGetUserId() throws Exception {
        user.setUserId(USER_ID);
        assertNotNull(user.getUserId());
        assertEquals(USER_ID, user.getUserId());
    }

    @Test
    public void testGetCreatedDate() throws Exception {
        user.setCreatedDate(new Date());
        assertNotNull(user.getCreatedDate());
        assertEquals(Date.class, user.getCreatedDate().getClass());
    }

    @Test
    public void testGetUpdatedDate() throws Exception {
        user.setUpdatedDate(new Date());
        assertNotNull(user.getUpdatedDate());
        assertEquals(Date.class, user.getUpdatedDate().getClass());
    }

    @Test
    public void testBaseConstructor() throws Exception {
        User testUser = new User(LOGIN, PASSWORD, FIRST_NAME, LAST_NAME, AGE);
        assertNotNull(testUser);
        assertEquals(LOGIN, testUser.getLogin());
        assertEquals(String.class, testUser.getLogin().getClass());
        assertEquals(PASSWORD, testUser.getPassword());
        assertEquals(String.class, testUser.getPassword().getClass());
        assertEquals(FIRST_NAME, testUser.getFirstName());
        assertEquals(String.class, testUser.getFirstName().getClass());
        assertEquals(LAST_NAME, testUser.getLastName());
        assertEquals(String.class, testUser.getLastName().getClass());
        assertEquals(AGE, testUser.getAge());
        assertEquals(Integer.class, testUser.getAge().getClass());
        assertNull(testUser.getUserId());
        assertEquals(Date.class, testUser.getCreatedDate().getClass());
        assertEquals(Date.class, testUser.getUpdatedDate().getClass());
    }

    @Test
    public void testLPConstructor() throws Exception {
        User testUser = new User(LOGIN, PASSWORD);
        assertNotNull(testUser);
        assertEquals(LOGIN, testUser.getLogin());
        assertEquals(String.class, testUser.getLogin().getClass());
        assertEquals(PASSWORD, testUser.getPassword());
        assertEquals(String.class, testUser.getPassword().getClass());
    }

    @Test
    public void testTestConstructor() throws Exception {
        User testUser = new User(USER_ID);
        assertNotNull(testUser);
        assertNotNull(testUser.getUserId());
        assertEquals(testUser.getUserId(), USER_ID);
        assertEquals(testUser.getUserId().getClass(), Integer.class);
    }

    @Test
    public void testSetTotalFriends() throws Exception {
        Integer totalFriends = 5;
        user.setTotalFriends(totalFriends);
        Integer testTotalFriends = user.getTotalFriends();
        assertNotNull(testTotalFriends);
        assertTrue(testTotalFriends == totalFriends);
    }

    @Test
    public void testSetImages() throws Exception {
        user.setImages(IMAGE_LIST);
        assertNotNull(user.getImages());
        assertEquals(user.getImages(), IMAGE_LIST);
        assertEquals(user.getImages().size(), IMAGE_LIST.size());
        assertEquals(user.getImages().get(0).getClass(), Image.class);
    }

    @Test
    public void testSetFriends() throws Exception {
        user.setFriends(USER_LIST);
        assertNotNull(user.getFriends());
        assertEquals(user.getFriends().size(), USER_LIST.size());
        assertEquals(user.getFriends().get(0).getClass(), User.class);

    }

}
