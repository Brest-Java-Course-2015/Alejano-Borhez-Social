package com.epam.brest.course2015.social.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by alexander on 25.10.15.
 */
public class UserTest {
    private static final String firstName = "FirstName";
    private static final String lastName = "LastName";
    private static final Integer age = 38;
    private static final String login = "Login";
    private static final String password = "Password";
    private static final Integer id = 1;
    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

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
    public void testGetId() throws Exception {
        user.setId(id);
        assertNotNull(user.getId());
        assertEquals(id, user.getId());
    }

    @Test
    public void testGetFriends() throws Exception {
        List<User> friends = new ArrayList<User>() {
        };
        friends.add(user);
        user.setFriends(friends);
        assertNotNull(user.getFriends());
        assertTrue(user.getFriends().size() > 0);
        assertEquals(User.class, user.getFriends().get(0).getClass());
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
        assertNull(testUser.getId());
        assertEquals(Date.class, testUser.getCreatedDate().getClass());
        assertEquals(Date.class, testUser.getUpdatedDate().getClass());
    }



}
