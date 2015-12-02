package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.test.TestLogged;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexander on 25.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-dao.xml"})
@Transactional
public class UserDaoImplTest {
    public static Date getTestDate(String date) {
    try {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static final Integer testId = 1;
    public static final String testLogin = "julia_borohova";
    public static final String testPassword = "newPassword";
    public static final String testFirstName = "FirstName";
    public static final String testLastName = "LastName";
    @Autowired
    private UserDao userDao;

    @Test
    @TestLogged
    public void testGetAllUsers() throws Exception {
        List<User> users = userDao.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() == 4);
    }

    @Test
    @TestLogged
    public void testGetUserById() throws Exception {
        User user = userDao.getUserById(testId);
        assertNotNull(user);
        assertEquals(User.class, user.getClass());
        assertEquals(testId, user.getUserId());
    }

    @Test
    @TestLogged
    public void testGetUserByLogin() throws Exception {
        User user = userDao.getUserByLogin(testLogin);
        assertNotNull(user);
        assertEquals(User.class, user.getClass());
        assertEquals(testLogin, user.getLogin());
    }

    @Test (expected = EmptyResultDataAccessException.class)
    @TestLogged
    public void testDeleteUser() throws Exception {
        Integer sizeBefore = userDao.getAllUsers().size();
        userDao.deleteUser(testId);
        Integer sizeAfter = userDao.getAllUsers().size();
        assertTrue(sizeBefore-sizeAfter == 1);
        userDao.getUserById(testId);
    }

    @Test
    @TestLogged
    public void testAddUser() throws Exception {
        User user = new User("login", "password", "Petr", "Petrov", 30);
        Integer sizeBefore = userDao.getAllUsers().size();
        Integer newUserId = userDao.addUser(user);
        Integer sizeAfter = userDao.getAllUsers().size();
        assertNotNull(newUserId);
        assertTrue(sizeAfter - sizeBefore == 1);
        assertEquals(User.class, userDao.getUserById(newUserId).getClass());
    }

    @Test
    @TestLogged
    public void testChangePassword() throws Exception {
        userDao.changePassword(testId, testPassword);
        assertEquals(testPassword, userDao.getUserById(testId).getPassword());
    }

    @Test
    @TestLogged
    public void testGetFriends() throws Exception {
        List<User> friends = userDao.getFriends(testId);
        assertNotNull(friends);
        assertTrue(friends.size() == 3);
        assertEquals(User.class, friends.get(0).getClass());

    }

    @Test
    @TestLogged
    public void testGetCountOfUserFriends() throws Exception {
        Integer count = userDao.getCountOfUserFriends(1);
        assertNotNull(count);
        assertTrue(count > 0);
    }

    @Test
    @TestLogged
    public void testGetCountOfUsers() throws Exception {
        Integer count = userDao.getCountOfUsers();
        assertNotNull(count);
        assertTrue(count > 0);
    }

    @Test
    @TestLogged
    public void testChangeLogin() throws Exception {
        userDao.changeLogin(testId, testLogin);
        assertEquals(testLogin, userDao.getUserById(testId).getLogin());
    }

    @Test
    @TestLogged
    public void testChangeFirstName() throws Exception {
        userDao.changeFirstName(testId, testFirstName);
        assertEquals(testFirstName, userDao.getUserById(testId).getFirstName());
    }

    @Test
    @TestLogged
    public void testChangeLastName() throws Exception {
        userDao.changeLastName(testId, testLastName);
        assertEquals(testLastName, userDao.getUserById(testId).getLastName());
    }

    @Test
    @TestLogged
    public void testGetAllUsers1() throws Exception {
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = getTestDate("2015-10-20");
        List<User> list = userDao.getAllUsers(dateMin, dateMax);
        assertNotNull(list);
        assertEquals(list.get(0).getClass(), User.class);
    }
}