package com.epam.brest.course2015.social.core;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static com.epam.brest.course2015.social.test.SocialTestLogger.LOGGER;


/**
 * Created by alexander on 26.10.15.
 */
public class FriendshipTest {
    private static final Integer testFirstFriend = 1;
    private static final Integer testSecondFriend = 2;
    private Friendship friendship;
    @Before
    public void setUp() {
        friendship = new Friendship();
    }

    @Test
    public void testGetFirstFriend() throws Exception {
        LOGGER();
        friendship.setFriend1Id(testFirstFriend);
        assertNotNull(friendship.getFriend1Id());
        assertEquals(testFirstFriend, friendship.getFriend1Id());
    }

    @Test
    public void testGetSecondFriend() throws Exception {
        LOGGER();
        friendship.setFriend2Id(testSecondFriend);
        assertNotNull(friendship.getFriend2Id());
        assertEquals(testSecondFriend, friendship.getFriend2Id());
    }

    @Test
    public void testGetCreatedDate() throws Exception {
        LOGGER();
        friendship.setCreatedDate(new Date());
        assertNotNull(friendship.getCreatedDate());
        assertEquals(Date.class, friendship.getCreatedDate().getClass());
    }

    @Test
    public void testBaseConstructor() throws Exception {
        LOGGER();
        Friendship testFriendship = new Friendship(testFirstFriend, testSecondFriend);
        assertNotNull(testFriendship);
        assertEquals(testFirstFriend, testFriendship.getFriend1Id());
        assertEquals(Integer.class, testFriendship.getFriend1Id().getClass());
        assertEquals(testSecondFriend, testFriendship.getFriend2Id());
        assertEquals(Integer.class, testFriendship.getFriend2Id().getClass());
        assertNotNull(testFriendship.getCreatedDate());
        assertEquals(Date.class, testFriendship.getCreatedDate().getClass());

    }
}
