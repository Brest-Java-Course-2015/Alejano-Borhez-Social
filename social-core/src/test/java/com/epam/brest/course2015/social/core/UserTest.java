package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${test.firstName}")
    private String firstName;
    @Value("${test.lastName}")
    private String lastName;
    @Value("${test.age}")
    private Integer age;
    @Value("${test.login}")
    private String login;
    @Value("${test.password}")
    private String password;
    @Value("${test.email}")
    private String email;
    @Value("${test.userId1}")
    private Integer userId;

    private static final List<Image> IMAGE_LIST = Arrays.asList(new Image(), new Image());
    private static final List<User> USER_LIST = Arrays.asList(new User(), new User());

    @Autowired
    private User user;

    @Test
    public void testGetFirstName() throws Exception {
        user.setFirstName(firstName);
        assertNotNull(user.getFirstName());
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        user.setLastName(lastName);
        assertNotNull(user.getLastName());
        assertEquals(lastName, user.getLastName());
    }

    @Test
    public void testGetAge() throws Exception {
        user.setAge(age);
        assertNotNull(user.getAge());
        assertEquals(age, user.getAge());
    }

    @Test
    public void testGetLogin() throws Exception {
        user.setLogin(login);
        assertNotNull(user.getLogin());
        assertEquals(login, user.getLogin());
    }

    @Test
    public void testGetPassword() throws Exception {
        user.setPassword(password);
        assertNotNull(user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetEmail() throws Exception {
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testInvalidEmail() throws Exception {
        user.setEmail("email");
        assertEquals(user.getEmail(), "email");
    }

    @Test
    public void testGetUserId() throws Exception {
        user.setUserId(userId);
        assertNotNull(user.getUserId());
        assertEquals(userId, user.getUserId());
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
        User testUser = new User(login, password, firstName, lastName, age, email);
        assertEquals(login, testUser.getLogin());
        assertEquals(password, testUser.getPassword());
        assertEquals(firstName, testUser.getFirstName());
        assertEquals(lastName, testUser.getLastName());
        assertEquals(age, testUser.getAge());
        assertEquals(email, testUser.getEmail());
        assertNull(testUser.getUserId());
        assertEquals(Date.class, testUser.getCreatedDate().getClass());
        assertEquals(Date.class, testUser.getUpdatedDate().getClass());
    }

    @Test
    public void testLPConstructor() throws Exception {
        User testUser = new User(login, password);
        assertNotNull(testUser);
        assertEquals(login, testUser.getLogin());
        assertEquals(String.class, testUser.getLogin().getClass());
        assertEquals(password, testUser.getPassword());
        assertEquals(String.class, testUser.getPassword().getClass());
    }

    @Test
    public void testTestConstructor() throws Exception {
        User testUser = new User(userId);
        assertNotNull(testUser);
        assertNotNull(testUser.getUserId());
        assertEquals(testUser.getUserId(), userId);
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
