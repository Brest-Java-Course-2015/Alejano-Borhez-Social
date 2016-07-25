package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.ImageDao;
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

    private static final Integer TEST_ID = 1;
    private static final String TEST_LOGIN = "julia_borohova";
    private static final String TEST_PASSWORD = "newPassword";
    private static final String TEST_FIRST_NAME = "FirstName";
    private static final String TEST_LAST_NAME = "LastName";
    private static final User TEST_USER = new User("login", "password", "Petr", "Petrov", 30);

    @Autowired
    private UserDao userDao;
    @Autowired
    private ImageDao imageDao;

    @Test
    public void testGetUserById() throws Exception {
        User user = userDao.getUserById(TEST_ID);
        assertNotNull(user);
        assertEquals(user.getFirstName(), "Alexander");
    }


    @Test
    public void testDeleteUser() throws Exception {
        User user1 = userDao.getUserById(TEST_ID);
        assertNotNull(user1);
        userDao.deleteUser(TEST_ID);
        User user2 = userDao.getUserById(TEST_ID);
        assertNull(user2);
    }

    @Test
    public void testChangePassword() throws Exception {
        User user = userDao.getUserById(TEST_ID);
        String passwordBefore = user.getPassword();
        userDao.changePassword(TEST_ID, TEST_PASSWORD);
        User user2 = userDao.getUserById(TEST_ID);
        String passwordAfter = user2.getPassword();
        assertNotEquals(passwordBefore, passwordAfter);
        assertEquals(passwordAfter, TEST_PASSWORD);
    }

    @Test
    public void testAddUser() throws Exception {
        Integer i = userDao.addUser(TEST_USER);
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
        userDao.changeLogin(TEST_ID, TEST_LOGIN);
        assertEquals(TEST_LOGIN, userDao.getUserById(TEST_ID).getLogin());
    }

    @Test
    public void testChangeFirstName() throws Exception {
        userDao.changeFirstName(TEST_ID, TEST_FIRST_NAME);
        assertEquals(TEST_FIRST_NAME, userDao.getUserById(TEST_ID).getFirstName());
    }

    @Test
    public void testChangeLastName() throws Exception {
        userDao.changeLastName(TEST_ID, TEST_LAST_NAME);
        assertEquals(TEST_LAST_NAME, userDao.getUserById(TEST_ID).getLastName());
    }

    @Test
    public void testGetFriends() throws Exception {
        List<User> friends = userDao.getFriends(TEST_ID);
        assertNotNull(friends);
        assertTrue(friends.size() == 3);
        assertEquals(User.class, friends.get(0).getClass());
    }

    @Test
    public void testGetNoFriends() throws Exception {
        List<User> noFriends = userDao.getNoFriends(TEST_ID + 1);
        assertNotNull(noFriends);
        assertTrue(noFriends.size() == 1);
        assertEquals(User.class, noFriends.get(0).getClass());
    }

    @Test
    public void testGetCountOfUserFriends() throws Exception {
        Integer count = userDao.getCountOfUserFriends(TEST_ID);
        assertNotNull(count);
        assertTrue(count > 0);
    }

    @Test
    public void testAddImage() throws Exception {
        Integer imageCountBefore = userDao.getUserById(TEST_ID).getImages().size();
        Image image = new Image();
        image.setCreatedDate(new Date());
        image.setUrl("url");
        image.setUrl50("url50");
        image.setUrl81("url81");
        Integer imageId = imageDao.addImage(image);
        Image imageNew = imageDao.getImage(imageId);
        userDao.addImage(TEST_ID, image);
        Integer imageCountAfter = userDao.getUserById(TEST_ID).getImages().size();
        assertTrue(imageCountBefore < imageCountAfter);
        assertEquals(userDao.getUserById(TEST_ID).getImages().get(2), imageNew);
        assertEquals(userDao.getUserById(TEST_ID).getImages().get(2).getUrl(), "url");

    }
}