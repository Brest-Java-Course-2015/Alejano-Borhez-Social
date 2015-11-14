package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        LOGGER.debug("Started test: " + elements[2].getMethodName());
    }
    private static User testUser1 = new User("testLogin1", "testPassword1", "testFirstName1", "testLastName1", 25);
    private static User testUser2 = new User("testLogin2", "testPassword2", "testFirstName2", "testLastName2", 26);
    private static final String testPassword = "testPassword";
    private static final String testLogin = "alejano_borhez";

    @Autowired
    private SocialService socialService;

    @Test
    public void testAddUser() throws Exception {
        LOGGERDO();
        testUser1.setUserId(null);
        Integer sizeBefore = socialService.getAllUsers().size();
        Integer newUserId = socialService.addUser(testUser1);
        Integer sizeAfter = socialService.getAllUsers().size();
        assertTrue(sizeAfter - sizeBefore == 1);
        assertNotNull(newUserId);
        assertEquals(newUserId.getClass(), Integer.class);

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

    @Test
    public void testDeleteUser() throws Exception {
        LOGGERDO();
        Integer sizeBefore = socialService.getAllUsers().size();
        socialService.deleteUser(1);
        Integer sizeAfter = socialService.getAllUsers().size();
        assertTrue(sizeBefore - sizeAfter == 1);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteUserWithNullId() throws Exception {
        LOGGERDO();
        socialService.deleteUser(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteUserWithIncorrectId() throws Exception {
        LOGGERDO();
        socialService.deleteUser(-2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteOfNonExistingUser() throws Exception {
        LOGGERDO();
        socialService.deleteUser(7);
    }

    @Test
    public void testUpdateUser() throws Exception {
        LOGGERDO();
        assertNotEquals(socialService.getUserById(1).getPassword(), testPassword);
        socialService.updateUser(1, testPassword);
        assertEquals(socialService.getUserById(1).getPassword(), testPassword);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateNullUser() throws Exception {
        LOGGERDO();
        socialService.updateUser(null, testPassword);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateUserWithNullPassword() throws Exception {
        LOGGERDO();
        socialService.updateUser(1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUdateUserWithIncorrectId() throws Exception {
        LOGGERDO();
        socialService.updateUser(-1, testPassword);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateNonExistingUser() throws Exception {
        LOGGERDO();
        socialService.updateUser(7, testPassword);
    }

    @Test
    public void testGetUserById() throws Exception {
        LOGGERDO();
        User testUser = socialService.getUserById(1);
        assertNotNull(testUser);
        assertEquals(testUser.getClass(), User.class);
        assertTrue(testUser.getUserId() == 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByIncorrectId() throws Exception {
        LOGGERDO();
        socialService.getUserById(-2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNonExistingId() throws Exception {
        LOGGERDO();
        socialService.getUserById(7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNullId() throws Exception {
        LOGGERDO();
        socialService.getUserById(null);
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        LOGGERDO();
        User testUser = socialService.getUserByLogin(testLogin);
        assertNotNull(testUser);
        assertEquals(testUser.getClass(), User.class);
        assertEquals(testUser.getLogin(), testLogin);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByIncorrectLogin() throws Exception {
        LOGGERDO();
        socialService.getUserByLogin(testUser1.getLogin());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNullLogin() throws Exception {
        LOGGERDO();
        socialService.getUserByLogin(null);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        LOGGERDO();
        List<User> testList = socialService.getAllUsers();
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test
    public void testGetFriends() throws Exception {
        LOGGERDO();
        List<User> testList = socialService.getFriends(1);
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), User.class);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFriendsOfNullId() throws Exception {
        LOGGERDO();
        socialService.getFriends(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFriendsOfNonExistingUser() throws Exception {
        LOGGERDO();
        socialService.getFriends(7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFriendsOfIncorrectId() throws Exception {
        LOGGERDO();
        socialService.getFriends(-2);
    }

    @Test
    public void testGetAllFriendships() throws Exception {
        LOGGERDO();
        List<Friendship> testList = socialService.getAllFriendships();
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), Friendship.class);
        assertEquals(testList.get(0).getFriend1Id().getClass(), Integer.class);
        assertEquals(testList.get(0).getFriend2Id().getClass(), Integer.class);
    }

    public void testAddFriendship() throws Exception {
        LOGGERDO();
        testUser1.setUserId(null);
        testUser2.setUserId(null);
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        Integer sizeBefore = socialService.getAllFriendships().size();
        socialService.addFriendship(testUser1, testUser2);
        Integer sizeAfter = socialService.getAllFriendships().size();
        assertTrue(sizeAfter - sizeBefore == 2);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddExistingFriendship() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.addFriendship(testUser1, testUser2);
        socialService.addFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfNullUser1() throws Exception {
        LOGGERDO();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.addFriendship(null, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfNullUser2() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.addFriendship(testUser1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfUserNullId1() throws Exception {
        LOGGERDO();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.addFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfUserNullId2() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.addFriendship(testUser1, testUser2);
    }

    public void testIsAFriend() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        assertFalse(socialService.isAFriend(testUser1, testUser2));
        socialService.addFriendship(testUser1, testUser2);
        assertTrue(socialService.isAFriend(testUser1, testUser2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullUser1() throws Exception {
        LOGGERDO();
        testUser2.setUserId(socialService.addUser(testUser2));
        assertTrue(socialService.isAFriend(null, testUser2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullUser2() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        assertTrue(socialService.isAFriend(testUser1, null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullIdUser1() throws Exception {
        LOGGERDO();
        testUser2.setUserId(socialService.addUser(testUser2));
        assertTrue(socialService.isAFriend(testUser1, testUser2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullIdUser2() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        assertTrue(socialService.isAFriend(testUser1, testUser2));
    }

    public void testDiscardFriendship() throws Exception {
        LOGGERDO();
        testUser1.setUserId(null);
        testUser2.setUserId(null);
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        assertFalse(socialService.isAFriend(testUser1, testUser2));
        socialService.addFriendship(testUser1, testUser2);
        assertTrue(socialService.isAFriend(testUser1, testUser2));
        socialService.discardFriendship(testUser1, testUser2);
        assertFalse(socialService.isAFriend(testUser1, testUser2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullUser1() throws Exception {
        LOGGERDO();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.discardFriendship(null, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullUser2() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.discardFriendship(testUser1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullIdUser1() throws Exception {
        LOGGERDO();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.discardFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullIdUser2() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.discardFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardNonExistingFriendship() throws Exception {
        LOGGERDO();
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.discardFriendship(testUser1, testUser2);
    }
}