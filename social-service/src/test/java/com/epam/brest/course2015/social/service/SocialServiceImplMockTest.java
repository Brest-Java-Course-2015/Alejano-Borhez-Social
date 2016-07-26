package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.dao.ImageDao;
import com.epam.brest.course2015.social.dao.UserDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    private static final User TEST_MOCK_USER_1 = new User("testLogin1", "testPassword1", "testFirstName1", "testLastName1", 25);
    private static final User TEST_MOCK_USER_2 = new User("testLogin2", "testPassword2", "testFirstName2", "testLastName2", 26);

    @Autowired
    private SocialService socialService;

    @Autowired
    private UserDao userMockDao;
    @Autowired
    private FriendshipDao friendshipMockDao;
    @Autowired
    private ImageDao imageMockDao;

    @After
    public void clean() {
        reset(userMockDao);
        reset(friendshipMockDao);
        reset(imageMockDao);
    }

    @Test
    public void testAddUser() throws Exception {
        TEST_MOCK_USER_1.setUserId(null);
        expect(userMockDao.getUserByLogin(TEST_MOCK_USER_1.getLogin()))
                .andReturn(null);
        expect(userMockDao.addUser(TEST_MOCK_USER_1)).andReturn(1);
        replay(userMockDao);
        Integer result = socialService.addUser(TEST_MOCK_USER_1);
        assertTrue(result == 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNull() throws Exception {
        expect(userMockDao.getUserByLogin(TEST_MOCK_USER_1.getLogin()))
                .andReturn(null);
        replay(userMockDao);
        socialService.addUser(TEST_MOCK_USER_1);
    }


    @Test
    public void testDeleteUser() throws Exception {
        userMockDao.deleteUser(anyInt());
        replay(userMockDao);
        socialService.deleteUser(TEST_MOCK_USER_1.getUserId());

    }

    @Test
    public void testUpdateUser() throws Exception {
        TEST_MOCK_USER_1.setUserId(5);
        expect(userMockDao.getUserById(TEST_MOCK_USER_1.getUserId()))
                          .andReturn(TEST_MOCK_USER_1);
        userMockDao.changePassword(TEST_MOCK_USER_1.getUserId(),
                                   TEST_MOCK_USER_2.getPassword());
        expectLastCall();
        replay(userMockDao);
        socialService.changePassword(TEST_MOCK_USER_1.getUserId(),
                TEST_MOCK_USER_2.getPassword());
    }

    @Test
    public void testGetUserById() throws Exception {
        expect(userMockDao.getUserById(1)).andReturn(TEST_MOCK_USER_1);
        replay(userMockDao);
        User result = socialService.getUserById(1);
        assertEquals(result, TEST_MOCK_USER_1);
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        expect(userMockDao.getUserByLogin("testLogin"))
                .andReturn(TEST_MOCK_USER_1);
        replay(userMockDao);
        User result = socialService.getUserByLogin("testLogin");
        assertEquals(result, TEST_MOCK_USER_1);

    }

    @Test
    public void testGetAllUsers() throws Exception {
        expect(userMockDao.getAllUsers())
                .andReturn(Arrays.<User>asList(TEST_MOCK_USER_1));
        replay(userMockDao);
        List<User> result = socialService.getAllUsers();
        assertNotNull(result);
        assertEquals(result.get(0), TEST_MOCK_USER_1);
    }

    @Test
    public void testGetFriends() throws Exception {
        expect(userMockDao.getUserById(1))
                .andReturn(new User());
        expect(userMockDao.getFriends(1))
                .andReturn(Arrays.<User>asList(TEST_MOCK_USER_1));
        replay(userMockDao);
        List<User> result = socialService.getFriends(1);
        assertNotNull(result);
        assertEquals(result.get(0), TEST_MOCK_USER_1);
    }

    @Test
    public void testAddFriendship() throws Exception {
        TEST_MOCK_USER_1.setUserId(5);
        TEST_MOCK_USER_2.setUserId(6);
        expect(friendshipMockDao.isAFriend(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId()))
                .andReturn(false);
        friendshipMockDao.addFriendship(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId());
        expectLastCall();
        replay(friendshipMockDao);
        socialService.addFriendship(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId());

    }

    @Test
    public void testIsAFriend() throws Exception {
        TEST_MOCK_USER_1.setUserId(5);
        TEST_MOCK_USER_2.setUserId(6);
        expect(friendshipMockDao.isAFriend(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId()))
                .andReturn(true);
        replay(friendshipMockDao);
        boolean result = socialService.isAFriend(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId());
        assertTrue(result);
    }

    @Test
    public void testDiscardFriendship() throws Exception {
        TEST_MOCK_USER_1.setUserId(5);
        TEST_MOCK_USER_2.setUserId(6);
        expect(friendshipMockDao.isAFriend(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId()))
                .andReturn(true);
        friendshipMockDao.discardFriendship(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId());
        expectLastCall();
        replay(friendshipMockDao);
        socialService.discardFriendship(TEST_MOCK_USER_1.getUserId(), TEST_MOCK_USER_2.getUserId());
    }

    @Test
    public void testGetAllFriendships() throws Exception {
        expect(friendshipMockDao.getAllFriendships())
                .andReturn(Arrays.<Friendship>asList(new Friendship(TEST_MOCK_USER_1.getUserId(),
                        TEST_MOCK_USER_2.getUserId())));
        replay(friendshipMockDao);
        List<Friendship> result = socialService.getAllFriendships();
        assertNotNull(result);
        assertEquals(result.get(0).getClass(), Friendship.class);
        assertEquals(result.get(0).getFriend1Id(), TEST_MOCK_USER_1.getUserId());
        assertEquals(result.get(0).getFriend2Id(), TEST_MOCK_USER_2.getUserId());
    }

    @Test
    public void testDiscardAllFriendshipsOfAUser() throws Exception {
        friendshipMockDao.discardAllFriendshipsOfAUser(1);
        expectLastCall();
        replay(friendshipMockDao);
        socialService.discardAllFriendshipsOfAUser(1);
    }

    @Test
    public void testDeleteImage() throws Exception {
        expect(imageMockDao.getImage(anyInt())).andReturn(new Image());
        userMockDao.deleteImage(anyInt(), anyObject(Image.class));
        expectLastCall();
        imageMockDao.deleteImage(anyInt());
        expectLastCall();
        replay(imageMockDao);
        replay(userMockDao);

        socialService.deleteImage(1, 1);

    }


}