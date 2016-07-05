package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.dao.UserDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * Created by alexander on 6.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service-mock-test.xml"})
public class SocialServiceImplMockTest {
    private static final User testMockUser1 = new User("testLogin1", "testPassword1", "testFirstName1", "testLastName1", 25);
    private static final User testMockUser2 = new User("testLogin2", "testPassword2", "testFirstName2", "testLastName2", 26);

    @Autowired
    private SocialService socialService;

    @Autowired
    private UserDao userMockDao;

    @Autowired
    private FriendshipDao friendshipMockDao;

    @After
    public void clean() {
        reset(userMockDao);
        reset(friendshipMockDao);
    }

    @Test
    public void testAddUser() throws Exception {
        testMockUser1.setUserId(null);
        testMockUser2.setUserId(null);
        expect(userMockDao.getUserByLogin(testMockUser1.getLogin()))
                .andThrow(new EmptyResultDataAccessException(1));
        expect(userMockDao.addUser(testMockUser1)).andReturn(1);
        replay(userMockDao);
        Integer result = socialService.addUser(testMockUser1);
        assertTrue(result == 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNull() throws Exception {
        expect(userMockDao.getUserByLogin(testMockUser1.getLogin()))
                .andReturn(null);
        replay(userMockDao);
        socialService.addUser(testMockUser1);
    }


    @Test
    public void testDeleteUser() throws Exception {
        testMockUser1.setUserId(5);
        expect(userMockDao.getUserById(testMockUser1.getUserId()))
                .andReturn(testMockUser1);
        userMockDao.deleteUser(testMockUser1.getUserId());
        expectLastCall();
        replay(userMockDao);
        socialService.deleteUser(testMockUser1.getUserId());

    }

    @Test
    public void testUpdateUser() throws Exception {
        testMockUser1.setUserId(5);
        expect(userMockDao.getUserById(testMockUser1.getUserId()))
                          .andReturn(testMockUser1);
        userMockDao.changePassword(testMockUser1.getUserId(),
                                   testMockUser2.getPassword());
        expectLastCall();
        replay(userMockDao);
        socialService.changePassword(testMockUser1.getUserId(),
                testMockUser2.getPassword());
    }

    @Test
    public void testGetUserById() throws Exception {
        expect(userMockDao.getUserById(1)).andReturn(testMockUser1);
        replay(userMockDao);
        User result = socialService.getUserById(1);
        assertEquals(result, testMockUser1);
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        expect(userMockDao.getUserByLogin("testLogin"))
                .andReturn(testMockUser1);
        replay(userMockDao);
        User result = socialService.getUserByLogin("testLogin");
        assertEquals(result, testMockUser1);

    }

    @Test
    public void testGetAllUsers() throws Exception {
        expect(userMockDao.getAllUsers())
                .andReturn(Arrays.<User>asList(testMockUser1));
        replay(userMockDao);
        List<User> result = socialService.getAllUsers();
        assertNotNull(result);
        assertEquals(result.get(0), testMockUser1);
    }

    @Test
    public void testGetFriends() throws Exception {
        expect(userMockDao.getUserById(1))
                .andReturn(new User());
        expect(userMockDao.getFriends(1))
                .andReturn(Arrays.<User>asList(testMockUser1));
        replay(userMockDao);
        List<User> result = socialService.getFriends(1);
        assertNotNull(result);
        assertEquals(result.get(0), testMockUser1);
    }

    @Test
    public void testAddFriendship() throws Exception {
        testMockUser1.setUserId(5);
        testMockUser2.setUserId(6);
        expect(friendshipMockDao.isAFriend(testMockUser1, testMockUser2))
                .andReturn(false);
        friendshipMockDao.addFriendship(testMockUser1, testMockUser2);
        expectLastCall();
        replay(friendshipMockDao);
        socialService.addFriendship(testMockUser1, testMockUser2);

    }

    @Test
    public void testIsAFriend() throws Exception {
        testMockUser1.setUserId(5);
        testMockUser2.setUserId(6);
        expect(friendshipMockDao.isAFriend(testMockUser1, testMockUser2))
                .andReturn(true);
        replay(friendshipMockDao);
        boolean result = socialService.isAFriend(testMockUser1, testMockUser2);
        assertTrue(result);
    }

    @Test
    public void testDiscardFriendship() throws Exception {
        testMockUser1.setUserId(5);
        testMockUser2.setUserId(6);
        expect(friendshipMockDao.isAFriend(testMockUser1, testMockUser2))
                .andReturn(true);
        friendshipMockDao.discardFriendship(testMockUser1, testMockUser2);
        expectLastCall();
        replay(friendshipMockDao);
        socialService.discardFriendship(testMockUser1, testMockUser2);
    }

    @Test
    public void testGetAllFriendships() throws Exception {
        expect(friendshipMockDao.getAllFriendships())
                .andReturn(Arrays.<Friendship>asList(new Friendship(testMockUser1.getUserId(),
                        testMockUser2.getUserId())));
        replay(friendshipMockDao);
        List<Friendship> result = socialService.getAllFriendships();
        assertNotNull(result);
        assertEquals(result.get(0).getClass(), Friendship.class);
        assertEquals(result.get(0).getFriend1Id(), testMockUser1.getUserId());
        assertEquals(result.get(0).getFriend2Id(), testMockUser2.getUserId());
    }

    @Test
    public void testDiscardAllFriendshipsOfAUser() throws Exception {
        friendshipMockDao.discardAllFriendshipsOfAUser(1);
        expectLastCall();
        replay(friendshipMockDao);
        socialService.discardAllFriendshipsOfAUser(1);
    }



}