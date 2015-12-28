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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexander on 25.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-persistence-user.xml"})
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

    private static final Integer testId = 1;
    private static final String testPassword = "newPassword";
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

    @Test
    public void testAddUser() throws Exception {
        Integer i = userDao.addUser(testUser);
        assertNotNull(i);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> list = userDao.getAllUsers();
        assertNotNull(list);
        assertTrue(list.size() > 0);
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

    @Test
    public void testGetCountOfUsers() throws Exception {
        Integer i = userDao.getCountOfUsers();
        assertTrue(i == 4);
    }
}