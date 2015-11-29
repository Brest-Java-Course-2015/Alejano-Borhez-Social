package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static com.epam.brest.course2015.social.test.SocialTestLogger.LOGGER;

/**
 * Created by alexander on 6.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service-test.xml"})
@Transactional
public class SocialServiceImplTest  {
    private static User testUser1 = new User("testLogin1", "testPassword1", "testFirstName1", "testLastName1", 25);
    private static User testUser2 = new User("testLogin2", "testPassword2", "testFirstName2", "testLastName2", 26);
    private static String testPassword = "testPassword";
    private static String testLogin = "testLogin";
    private static String testFirstName = "testFirstName";
    private static String testLastName = "testLastName";
    public static Date getTestDate(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    private SocialService socialService;

    @Test
    public void testAddUser() throws Exception {
        LOGGER();
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
        LOGGER();
        socialService.addUser(new User(5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullUser() throws Exception {
        LOGGER();
        socialService.addUser(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullLogin() throws Exception {
        LOGGER();
        User testUser = new User();
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullPassword() throws Exception {
        LOGGER();
        User testUser = new User();
        testUser.setLogin(testUser1.getLogin());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullFirstName() throws Exception {
        LOGGER();
        User testUser = new User();
        testUser.setLogin(testUser1.getLogin());
        testUser.setPassword(testUser1.getPassword());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullLastName() throws Exception {
        LOGGER();
        User testUser = new User();
        testUser.setLogin(testUser1.getLogin());
        testUser.setPassword(testUser1.getPassword());
        testUser.setFirstName(testUser1.getFirstName());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddExistingUser() throws Exception {
        LOGGER();
        User testUser = socialService.getUserById(1);
        testUser.setUserId(null);
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserIncorrectAge() {
        LOGGER();
        testUser1.setAge(-2);
        socialService.addUser(testUser1);
    }

    @Test
    public void testDeleteUser() throws Exception {
        LOGGER();
        Integer sizeBefore = socialService.getAllUsers().size();
        socialService.deleteUser(1);
        Integer sizeAfter = socialService.getAllUsers().size();
        assertTrue(sizeBefore - sizeAfter == 1);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteUserWithNullId() throws Exception {
        LOGGER();
        socialService.deleteUser(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteUserWithIncorrectId() throws Exception {
        LOGGER();
        socialService.deleteUser(-2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteOfNonExistingUser() throws Exception {
        LOGGER();
        socialService.deleteUser(7);
    }

    @Test
    public void testUpdateUser() throws Exception {
        LOGGER();
        assertNotEquals(socialService.getUserById(1).getPassword(), testPassword);
        socialService.changePassword(1, testPassword);
        assertEquals(socialService.getUserById(1).getPassword(), testPassword);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateNullUser() throws Exception {
        LOGGER();
        socialService.changePassword(null, testPassword);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateUserWithNullPassword() throws Exception {
        LOGGER();
        socialService.changePassword(1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUdateUserWithIncorrectId() throws Exception {
        LOGGER();
        socialService.changePassword(-1, testPassword);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateNonExistingUser() throws Exception {
        LOGGER();
        socialService.changePassword(7, testPassword);
    }

    @Test
    public void testGetUserById() throws Exception {
        LOGGER();
        User testUser = socialService.getUserById(1);
        assertNotNull(testUser);
        assertEquals(testUser.getClass(), User.class);
        assertTrue(testUser.getUserId() == 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByIncorrectId() throws Exception {
        LOGGER();
        socialService.getUserById(-2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNonExistingId() throws Exception {
        LOGGER();
        socialService.getUserById(7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNullId() throws Exception {
        LOGGER();
        socialService.getUserById(null);
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        LOGGER();
        socialService.addUser(new User(testLogin, testPassword, testFirstName, testLastName, 29));
        User testUser = socialService.getUserByLogin(testLogin);
        assertNotNull(testUser);
        assertEquals(testUser.getClass(), User.class);
        assertEquals(testUser.getLogin(), testLogin);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByIncorrectLogin() throws Exception {
        LOGGER();
        socialService.getUserByLogin(testUser1.getLogin());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNullLogin() throws Exception {
        LOGGER();
        socialService.getUserByLogin(null);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        LOGGER();
        List<User> testList = socialService.getAllUsers();
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test
    public void testGetFriends() throws Exception {
        LOGGER();
        List<User> testList = socialService.getFriends(1);
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), User.class);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFriendsOfNullId() throws Exception {
        LOGGER();
        socialService.getFriends(null);
    }

    @Test
    public void testGetFriendsOfNonExistingUser() throws Exception {
        LOGGER();
        assertEquals(socialService.getFriends(7).size(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFriendsOfIncorrectId() throws Exception {
        LOGGER();
        socialService.getFriends(-2);
    }

    @Test
    public void testGetNoFriends() throws Exception {
        LOGGER();
        List<User> list = socialService.getNoFriends(2);
        assertNotNull(list);
        assertEquals(list.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetNoFriendsNullId() throws Exception {
        LOGGER();
        socialService.getNoFriends(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetNoFriendsIncorrectId() throws Exception {
        LOGGER();
        socialService.getNoFriends(-2);
    }

    @Test
    public void testGetAllFriendships() throws Exception {
        LOGGER();
        List<Friendship> testList = socialService.getAllFriendships();
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), Friendship.class);
        assertEquals(testList.get(0).getFriend1Id().getClass(), Integer.class);
        assertEquals(testList.get(0).getFriend2Id().getClass(), Integer.class);
    }

    public void testAddFriendship() throws Exception {
        LOGGER();
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
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.addFriendship(testUser1, testUser2);
        socialService.addFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfNullUser1() throws Exception {
        LOGGER();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.addFriendship(null, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfNullUser2() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.addFriendship(testUser1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfUserNullId1() throws Exception {
        LOGGER();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.addFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfUserNullId2() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.addFriendship(testUser1, testUser2);
    }

    public void testIsAFriend() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        assertFalse(socialService.isAFriend(testUser1, testUser2));
        socialService.addFriendship(testUser1, testUser2);
        assertTrue(socialService.isAFriend(testUser1, testUser2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullUser1() throws Exception {
        LOGGER();
        testUser2.setUserId(socialService.addUser(testUser2));
        assertTrue(socialService.isAFriend(null, testUser2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullUser2() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        assertTrue(socialService.isAFriend(testUser1, null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullIdUser1() throws Exception {
        LOGGER();
        testUser2.setUserId(socialService.addUser(testUser2));
        assertTrue(socialService.isAFriend(testUser1, testUser2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullIdUser2() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        assertTrue(socialService.isAFriend(testUser1, testUser2));
    }

    public void testDiscardFriendship() throws Exception {
        LOGGER();
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
        LOGGER();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.discardFriendship(null, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullUser2() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.discardFriendship(testUser1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullIdUser1() throws Exception {
        LOGGER();
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.discardFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullIdUser2() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        socialService.discardFriendship(testUser1, testUser2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardNonExistingFriendship() throws Exception {
        LOGGER();
        testUser1.setUserId(socialService.addUser(testUser1));
        testUser2.setUserId(socialService.addUser(testUser2));
        socialService.discardFriendship(testUser1, testUser2);
    }

    @Test
    public void testGetSocialUsersDto() throws Exception {
        LOGGER();
        SocialDto dto = socialService.getSocialUsersDto();
        assertNotNull(dto);
        assertEquals(SocialDto.class, dto.getClass());
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() > 0);
        assertNotNull(dto.getUsers());
        assertEquals(dto.getUsers().get(0).getClass(), User.class);
        assertTrue(dto.getUsers().size() > 0);
        assertNull(dto.getUser());
    }

    @Test
    public void testGetSocialFriendsDto() throws Exception {
        LOGGER();
        SocialDto dto = socialService.getSocialFriendsDto(1);
        assertNotNull(dto);
        assertEquals(SocialDto.class, dto.getClass());
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() > 0);
        assertNotNull(dto.getUsers());
        assertEquals(dto.getUsers().get(0).getClass(), User.class);
        assertTrue(dto.getUsers().size() > 0);
        assertNotNull(dto.getUser());
        assertEquals(dto.getUser().getClass(), User.class);
    }

    @Test
    public void testGetSocialNoFriendsDto() throws Exception {
        LOGGER();
        SocialDto dto = socialService.getSocialNoFriendsDto(2);
        assertNotNull(dto);
        assertEquals(SocialDto.class, dto.getClass());
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() > 0);
        assertNotNull(dto.getUsers());
        assertEquals(dto.getUsers().get(0).getClass(), User.class);
        assertTrue(dto.getUsers().size() > 0);
        assertNotNull(dto.getUser());
        assertEquals(dto.getUser().getClass(), User.class);
    }

    @Test
    public void testGetSocialNoFriendsDtoEmpty() throws Exception {
        LOGGER();
        SocialDto dto = socialService.getSocialNoFriendsDto(1);
        assertNotNull(dto);
        assertEquals(SocialDto.class, dto.getClass());
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() == 0);
        assertNotNull(dto.getUsers());
        assertTrue(dto.getUsers().size() == 0);
        assertNotNull(dto.getUser());
        assertEquals(dto.getUser().getClass(), User.class);
    }

    @Test
    public void testChangeLogin() throws Exception {
        LOGGER();
        assertNotEquals(socialService.getUserById(1).getLogin(), testLogin);
        socialService.changeLogin(1, testLogin);
        assertEquals(socialService.getUserById(1).getLogin(), testLogin);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLoginWithNullId() throws Exception {
        LOGGER();
        socialService.changeLogin(null, testLogin);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLoginWithIncorrectId() throws Exception {
        LOGGER();
        socialService.changeLogin(-2, testLogin);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLoginOfNonExistingUser() throws Exception {
        LOGGER();
        socialService.changeLogin(10, testLogin);
    }

    @Test
    public void testChangeFirstName() throws Exception {
        LOGGER();
        assertNotEquals(socialService.getUserById(1).getFirstName(), testFirstName);
        socialService.changeFirstName(1, testFirstName);
        assertEquals(socialService.getUserById(1).getFirstName(), testFirstName);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeFirstNameWithNullId() throws Exception {
        LOGGER();
        socialService.changeFirstName(null, testFirstName);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeFirstNameWithIncorrectId() throws Exception {
        LOGGER();
        socialService.changeFirstName(-2, testFirstName);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeFirstNameOfNonExistingUser() throws Exception {
        LOGGER();
        socialService.changeFirstName(10, testFirstName);
    }

    @Test
    public void testChangeLastName() throws Exception {
        LOGGER();
        assertNotEquals(socialService.getUserById(1).getLastName(), testLastName);
        socialService.changeLastName(1, testLastName);
        assertEquals(socialService.getUserById(1).getLastName(), testLastName);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLastNameWithNullId() throws Exception {
        LOGGER();
        socialService.changeLastName(null, testLastName);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLastNameWithIncorrectId() throws Exception {
        LOGGER();
        socialService.changeLastName(-2, testLastName);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLastNameOfNonExistingUser() throws Exception {
        LOGGER();
        socialService.changeLastName(10, testLastName);
    }

    @Test
    public void testGetAllUsersByDate() throws Exception {
        LOGGER();
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = getTestDate("2015-10-20");
        List<User> testList = socialService.getAllUsersByDate(
                                            dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAllUsersByNullMinDate() throws Exception {
        LOGGER();
        Date dateMin = null;
        Date dateMax = getTestDate("2015-10-20");
        List<User> testList = socialService.getAllUsersByDate(
                dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAllUsersByNullMaxDate() throws Exception {
        LOGGER();
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = null;
        List<User> testList = socialService.getAllUsersByDate(
                dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAllUsersByDateCompare() throws Exception {
        LOGGER();
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = getTestDate("2015-10-01");
        List<User> testList = socialService.getAllUsersByDate(
                dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test
    public void testGetSocialUsersDtoByDate() throws Exception {
        LOGGER();
        Date dateMin = getTestDate("2015-10-01");
        Date dateMax = getTestDate("2015-11-30");
        SocialDto dto = socialService.getSocialUsersDtoByDate(
                                      dateMin, dateMax);
        assertNotNull(dto);
        assertNotNull(dto.getUsers());
        assertNotNull(dto.getTotalUsers());
        assertEquals(dto.getClass(), SocialDto.class);
        assertEquals(dto.getUsers().get(0).getClass(), User.class);

    }
}