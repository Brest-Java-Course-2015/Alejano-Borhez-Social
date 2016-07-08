package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;
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
 * Created by alexander on 25.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-persistence-HSQL.xml"})
@Transactional
public class UserDaoJPATest {
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
    private static User testUser = new User("login", "password", "Petr", "Petrov", 30);

    @Autowired
    UserDao userDao;

    @Test
    public void testGetUserById() throws Exception {
        User user = userDao.getUserById(testId);
        assertNotNull(user);
        assertEquals(user.getFirstName(), "Alexander");
    }


    @Test
    public void testDeleteUser() throws Exception {
        User user1 = userDao.getUserById(testId);
        userDao.deleteUser(testId);
        User user2 = userDao.getUserById(testId);
        assertNull(user2);

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

    @Test
    public void testAddUser() throws Exception {
        Integer i = userDao.addUser(testUser);
        assertNotNull(i);
        assertTrue(i > 0);
        assertNotNull(userDao.getUserById(i).getCreatedDate());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> list = userDao.getAllUsers();
        assertNotNull(list);
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getFriends());
        System.out.println(list.get(0).getFriends());
    }

    @Test
    public void testGetAllUsers1() throws Exception {
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = getTestDate("2015-10-20");
        List<User> list = userDao.getAllUsers(dateMin, dateMax);
        assertNotNull(list);
        assertTrue(list.size() > 0);
        assertEquals(list.get(0).getClass(), User.class);
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        User user = userDao.getUserByLogin("alejano_borhez");
        assertEquals(user.getLogin(), "alejano_borhez");
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testGetUserByWrongLogin() throws Exception {
        User user = userDao.getUserByLogin("alejano");
    }

    @Test
    public void testGetCountOfUsers() throws Exception {
        Integer i = userDao.getCountOfUsers();
        assertTrue(i == 4);
    }

    @Test
    public void testChangeLogin() throws Exception {
        userDao.changeLogin(testId, testLogin);
        assertEquals(testLogin, userDao.getUserById(testId).getLogin());
    }

    @Test
    public void testChangeFirstName() throws Exception {
        userDao.changeFirstName(testId, testFirstName);
        assertEquals(testFirstName, userDao.getUserById(testId).getFirstName());
    }

    @Test
    public void testChangeLastName() throws Exception {
        userDao.changeLastName(testId, testLastName);
        assertEquals(testLastName, userDao.getUserById(testId).getLastName());
    }

    @Test
    public void testGetFriends() throws Exception {
        List<User> friends = userDao.getFriends(testId);
        assertNotNull(friends);
        assertTrue(friends.size() == 3);
        assertEquals(User.class, friends.get(0).getClass());
    }

    @Test
    public void testGetNoFriends() throws Exception {
        List<User> noFriends = userDao.getNoFriends(testId + 1);
        assertNotNull(noFriends);
        assertTrue(noFriends.size() == 1);
        assertEquals(User.class, noFriends.get(0).getClass());
    }

    @Test
    public void testGetCountOfUserFriends() throws Exception {
        Integer count = userDao.getCountOfUserFriends(1);
        assertNotNull(count);
        assertTrue(count > 0);
    }
}