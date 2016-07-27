package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexander on 6.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service-test.xml"})
@Transactional
public class SocialServiceImplTest {
    private static final User TEST_USER_1 = new User("testLogin1", "testPassword1", "testFirstName1", "testLastName1", 25, "test1@mail.com");
    private static final User TEST_USER_2 = new User("testLogin2", "testPassword2", "testFirstName2", "testLastName2", 26, "test2@mail.com");
    private static final Integer TEST_ID_1 = 1;
    private static final Integer TEST_ID_2 = 2;
    private static final String TEST_PASSWORD = "testPassword";
    private static final String TEST_LOGIN = "testLogin";
    private static final String TEST_FIRST_NAME = "testFirstName";
    private static final String TEST_LAST_NAME = "testLastName";
    private static final String TEST_EMAIL = "test@email.com";

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
        TEST_USER_1.setUserId(null);
        Integer sizeBefore = socialService.getAllUsers().size();
        Integer newUserId = socialService.addUser(TEST_USER_1);
        Integer sizeAfter = socialService.getAllUsers().size();
        assertTrue(sizeAfter - sizeBefore == 1);
        assertNotNull(newUserId);
        assertEquals(newUserId.getClass(), Integer.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNotNullId() throws Exception {
        socialService.addUser(new User(5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullUser() throws Exception {
        socialService.addUser(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullLogin() throws Exception {
        User testUser = new User();
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullPassword() throws Exception {
        User testUser = new User();
        testUser.setLogin(TEST_USER_1.getLogin());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullFirstName() throws Exception {
        User testUser = new User();
        testUser.setLogin(TEST_USER_1.getLogin());
        testUser.setPassword(TEST_USER_1.getPassword());
        socialService.addUser(testUser);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserNullLastName() throws Exception {
        User testUser = new User();
        testUser.setLogin(TEST_USER_1.getLogin());
        testUser.setPassword(TEST_USER_1.getPassword());
        testUser.setFirstName(TEST_USER_1.getFirstName());
        socialService.addUser(testUser);
    }

    @Test
    public void testAddExistingUser() throws Exception {
        User testUser = socialService.getUserById(1);
        User testUser1 = new User(testUser.getLogin(),
                                  testUser.getPassword(),
                                  testUser.getFirstName(),
                                  testUser.getLastName(),
                                  testUser.getAge(),
                                  testUser.getEmail());
        assertNull(socialService.addUser(testUser1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddUserIncorrectAge() {
        TEST_USER_1.setAge(-2);
        socialService.addUser(TEST_USER_1);
    }

    @Test
    public void testDeleteUser() throws Exception {
        Integer sizeBefore = socialService.getAllUsers().size();
        socialService.deleteUser(1);
        Integer sizeAfter = socialService.getAllUsers().size();
        assertTrue(sizeBefore - sizeAfter == 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteUserWithNullId() throws Exception {
        socialService.deleteUser(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDeleteUserWithIncorrectId() throws Exception {
        socialService.deleteUser(-2);
    }

    @Test (expected = InvalidDataAccessApiUsageException.class)
    public void testDeleteOfNonExistingUser() throws Exception {
        socialService.deleteUser(7);
    }

    @Test
    public void testUpdateUser() throws Exception {
        assertNotEquals(socialService.getUserById(1).getPassword(), TEST_PASSWORD);
        socialService.changePassword(1, TEST_PASSWORD);
        assertEquals(socialService.getUserById(1).getPassword(), TEST_PASSWORD);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateNullUser() throws Exception {
        socialService.changePassword(null, TEST_PASSWORD);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateUserWithNullPassword() throws Exception {
        socialService.changePassword(1, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUdateUserWithIncorrectId() throws Exception {
        socialService.changePassword(-1, TEST_PASSWORD);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateNonExistingUser() throws Exception {
        socialService.changePassword(7, TEST_PASSWORD);
    }

    @Test
    public void testGetUserById() throws Exception {
        User testUser = socialService.getUserById(1);
        assertNotNull(testUser);
        assertEquals(testUser.getClass(), User.class);
        assertTrue(testUser.getUserId() == 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByIncorrectId() throws Exception {
        socialService.getUserById(-2);
    }

    @Test
    public void testGetUserByNonExistingId() throws Exception {
        User user = socialService.getUserById(7);
        assertNull(user);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNullId() throws Exception {
        socialService.getUserById(null);
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        socialService.addUser(new User(TEST_LOGIN, TEST_PASSWORD, TEST_FIRST_NAME, TEST_LAST_NAME, 29, TEST_EMAIL));
        User testUser = socialService.getUserByLogin(TEST_LOGIN);
        assertNotNull(testUser);
        assertEquals(testUser.getClass(), User.class);
        assertEquals(testUser.getLogin(), TEST_LOGIN);
    }

    @Test
    public void testGetUserByIncorrectLogin() throws Exception {
        User user = socialService.getUserByLogin(TEST_USER_1.getLogin());
        assertNull(user);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetUserByNullLogin() throws Exception {
        socialService.getUserByLogin(null);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> testList = socialService.getAllUsers();
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test
    public void testGetFriends() throws Exception {
        List<User> testList = socialService.getFriends(1);
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), User.class);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFriendsOfNullId() throws Exception {
        socialService.getFriends(null);
    }

    @Test (expected = NullPointerException.class)
    public void testGetFriendsOfNonExistingUser() throws Exception {
        assertEquals(socialService.getFriends(7).size(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetFriendsOfIncorrectId() throws Exception {
        socialService.getFriends(-2);
    }

    @Test
    public void testGetNoFriends() throws Exception {
        List<User> list = socialService.getNoFriends(2);
        assertNotNull(list);
        assertEquals(list.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetNoFriendsNullId() throws Exception {
        socialService.getNoFriends(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetNoFriendsIncorrectId() throws Exception {
        socialService.getNoFriends(-2);
    }

/*    @Test
    public void testGetAllFriendships() throws Exception {
        List<Friendship> testList = socialService.getAllFriendships();
        assertNotNull(testList);
        assertTrue(testList.size() > 0);
        assertEquals(testList.get(0).getClass(), Friendship.class);
        assertEquals(testList.get(0).getFriend1Id().getClass(), Integer.class);
        assertEquals(testList.get(0).getFriend2Id().getClass(), Integer.class);
    }

    public void testAddFriendship() throws Exception {
        TEST_USER_1.setUserId(null);
        TEST_USER_2.setUserId(null);
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        Integer sizeBefore = socialService.getAllFriendships().size();
        socialService.addFriendship(TEST_USER_1, TEST_USER_2);
        Integer sizeAfter = socialService.getAllFriendships().size();
        assertTrue(sizeAfter - sizeBefore == 2);

    }*/

    @Test (expected = IllegalArgumentException.class)
    public void testAddExistingFriendship() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        socialService.addFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
        socialService.addFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfNullUser1() throws Exception {
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        socialService.addFriendship(null, TEST_USER_2.getUserId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfNullUser2() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        socialService.addFriendship(TEST_USER_1.getUserId(), null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfUserNullId1() throws Exception {
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        socialService.addFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFriendshipOfUserNullId2() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        socialService.addFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
    }

    public void testIsAFriend() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        assertFalse(socialService.isAFriend(TEST_USER_1.getUserId(), TEST_USER_2.getUserId()));
        socialService.addFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
        assertTrue(socialService.isAFriend(TEST_USER_1.getUserId(), TEST_USER_2.getUserId()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullUser1() throws Exception {
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        assertTrue(socialService.isAFriend(null, TEST_USER_2.getUserId()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullUser2() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        assertTrue(socialService.isAFriend(TEST_USER_1.getUserId(), null));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullIdUser1() throws Exception {
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        assertTrue(socialService.isAFriend(TEST_USER_1.getUserId(), TEST_USER_2.getUserId()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIsAFriendNullIdUser2() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        assertTrue(socialService.isAFriend(TEST_USER_1.getUserId(), TEST_USER_2.getUserId()));
    }

    public void testDiscardFriendship() throws Exception {
        TEST_USER_1.setUserId(null);
        TEST_USER_2.setUserId(null);
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        assertFalse(socialService.isAFriend(TEST_USER_1.getUserId(), TEST_USER_2.getUserId()));
        socialService.addFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
        assertTrue(socialService.isAFriend(TEST_USER_1.getUserId(), TEST_USER_2.getUserId()));
        socialService.discardFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
        assertFalse(socialService.isAFriend(TEST_USER_1.getUserId(), TEST_USER_2.getUserId()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullUser1() throws Exception {
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        socialService.discardFriendship(null, TEST_USER_2.getUserId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullUser2() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        socialService.discardFriendship(TEST_USER_1.getUserId(), null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullIdUser1() throws Exception {
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        socialService.discardFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardFriendshipNullIdUser2() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        socialService.discardFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDiscardNonExistingFriendship() throws Exception {
        TEST_USER_1.setUserId(socialService.addUser(TEST_USER_1));
        TEST_USER_2.setUserId(socialService.addUser(TEST_USER_2));
        socialService.discardFriendship(TEST_USER_1.getUserId(), TEST_USER_2.getUserId());
    }

    @Test
    public void testGetSocialUsersDto() throws Exception {
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
        assertNotEquals(socialService.getUserById(1).getLogin(), TEST_LOGIN);
        socialService.changeLogin(1, TEST_LOGIN);
        assertEquals(socialService.getUserById(1).getLogin(), TEST_LOGIN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLoginWithNullId() throws Exception {
        socialService.changeLogin(null, TEST_LOGIN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLoginWithIncorrectId() throws Exception {
        socialService.changeLogin(-2, TEST_LOGIN);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLoginOfNonExistingUser() throws Exception {
        socialService.changeLogin(10, TEST_LOGIN);
    }

    @Test
    public void testChangeFirstName() throws Exception {
        assertNotEquals(socialService.getUserById(1).getFirstName(), TEST_FIRST_NAME);
        socialService.changeFirstName(1, TEST_FIRST_NAME);
        assertEquals(socialService.getUserById(1).getFirstName(), TEST_FIRST_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeFirstNameWithNullId() throws Exception {
        socialService.changeFirstName(null, TEST_FIRST_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeFirstNameWithIncorrectId() throws Exception {
        socialService.changeFirstName(-2, TEST_FIRST_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeFirstNameOfNonExistingUser() throws Exception {
        socialService.changeFirstName(10, TEST_FIRST_NAME);
    }

    @Test
    public void testChangeLastName() throws Exception {
        assertNotEquals(socialService.getUserById(1).getLastName(), TEST_LAST_NAME);
        socialService.changeLastName(1, TEST_LAST_NAME);
        assertEquals(socialService.getUserById(1).getLastName(), TEST_LAST_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLastNameWithNullId() throws Exception {
        socialService.changeLastName(null, TEST_LAST_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLastNameWithIncorrectId() throws Exception {
        socialService.changeLastName(-2, TEST_LAST_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeLastNameOfNonExistingUser() throws Exception {
        socialService.changeLastName(10, TEST_LAST_NAME);
    }

    @Test
    public void testGetAllUsersByDate() throws Exception {
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = getTestDate("2015-10-20");
        List<User> testList = socialService.getAllUsersByDate(
                                            dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAllUsersByNullMinDate() throws Exception {
        Date dateMin = null;
        Date dateMax = getTestDate("2015-10-20");
        List<User> testList = socialService.getAllUsersByDate(
                dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAllUsersByNullMaxDate() throws Exception {
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = null;
        List<User> testList = socialService.getAllUsersByDate(
                dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAllUsersByDateCompare() throws Exception {
        Date dateMin = getTestDate("2015-10-05");
        Date dateMax = getTestDate("2015-10-01");
        List<User> testList = socialService.getAllUsersByDate(
                dateMin, dateMax);
        assertNotNull(testList);
        assertEquals(testList.get(0).getClass(), User.class);
    }

    @Test
    public void testGetSocialUsersDtoByDate() throws Exception {
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

    @Test
    public void testAddImage() throws Exception {
        Integer before = socialService.getAllImagesOfAUser(1).size();
        socialService.addImage(1, TEST_LOGIN, TEST_FIRST_NAME, TEST_LAST_NAME);
        Integer after = socialService.getAllImagesOfAUser(1).size();
        assertTrue(after - before == 1);

    }

    @Test
    public void testDeleteImage() throws Exception {
        Integer before = socialService.getAllImagesOfAUser(1).size();
        socialService.deleteImage(1, 1);
        Integer after = socialService.getAllImagesOfAUser(1).size();
        assertTrue(after - before == -1);

    }

    @Test
    public void testGetAllImagesOfAUser() throws Exception {

    }



}