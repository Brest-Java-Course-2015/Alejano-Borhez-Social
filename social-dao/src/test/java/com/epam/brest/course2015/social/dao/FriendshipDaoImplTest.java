package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.epam.brest.course2015.social.test.SocialTestLogger.LOGGER;


/**
 * Created by alexander on 26.10.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-dao.xml"})
@Transactional
public class FriendshipDaoImplTest extends TestCase {
    private static final Integer testFirstFriend = 5;
    private static final Integer testSecondFriend = 6;
    private static final User testFriend1 = new User(testFirstFriend);
    private static final User testFriend2 = new User(testSecondFriend);

    @Autowired
    private FriendshipDao friendshipDao;

    @Test
    public void testAddFriendship() throws Exception {
        LOGGER();
        assertFalse(friendshipDao.isAFriend(testFriend1, testFriend2));
        assertFalse(friendshipDao.isAFriend(testFriend2, testFriend1));
        friendshipDao.addFriendship(testFriend1, testFriend2);
        assertTrue(friendshipDao.isAFriend(testFriend1, testFriend2));
        assertTrue(friendshipDao.isAFriend(testFriend2, testFriend1));
    }

    @Test
    public void testIsAFriendFalse() throws Exception {
        LOGGER();
        assertFalse(friendshipDao.isAFriend(testFriend1, testFriend2));
        assertFalse(friendshipDao.isAFriend(testFriend2, testFriend1));

    }

    @Test
    public void testIsAFriendTrue() throws Exception {
        LOGGER();
        assertTrue(friendshipDao.isAFriend(new User(1), new User(2)));
        assertTrue(friendshipDao.isAFriend(new User(2), new User(1)));
    }

    @Test
    public void testDiscardFriendship() throws Exception {
        LOGGER();
        assertTrue(friendshipDao.isAFriend(new User(1), new User(2)));
        assertTrue(friendshipDao.isAFriend(new User(2), new User(1)));
        friendshipDao.discardFriendship(new User(1), new User(2));
        assertFalse(friendshipDao.isAFriend(new User(1), new User(2)));
        assertFalse(friendshipDao.isAFriend(new User(2), new User(1)));
    }

    @Test
    public void testGetAllFriendships () throws Exception {
        LOGGER();
        List<Friendship> friendshipsList = friendshipDao.getAllFriendships();
        assertNotNull(friendshipsList);
        assertTrue(friendshipsList.size() > 0);
        assertEquals(friendshipsList.get(0).getClass(), Friendship.class);
        assertEquals(friendshipsList.get(0).getFriend1Id().getClass(), Integer.class);
        assertEquals(friendshipsList.get(0).getFriend2Id().getClass(), Integer.class);
    }

    @Test
    public void testDiscardAllFriendshipsOfAUser() throws Exception {
        LOGGER();
        assertTrue(friendshipDao.isAFriend(new User(1), new User(2)));
        assertTrue(friendshipDao.isAFriend(new User(1), new User(3)));
        assertTrue(friendshipDao.isAFriend(new User(1), new User(4)));
        friendshipDao.discardAllFriendshipsOfAUser(1);
        assertFalse(friendshipDao.isAFriend(new User(1), new User(2)));
        assertFalse(friendshipDao.isAFriend(new User(1), new User(3)));
        assertFalse(friendshipDao.isAFriend(new User(1), new User(4)));
    }
}