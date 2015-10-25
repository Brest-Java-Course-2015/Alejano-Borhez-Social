package com.epam.brest.course2015.social.core;

import org.junit.Before;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Date;
import java.util.InputMismatchException;

import static org.junit.Assert.*;

/**
 * Created by alexander on 26.10.15.
 */
public class FriendshipTest {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Integer testFirstFriend = 1;
    private static final Integer testSecondFriend = 2;
    private Friendship friendship;
    @Before
    public void setUp() {
        friendship = new Friendship();
    }

    @Test
    public void testGetFirstFriend() throws Exception {
        LOGGER.debug("core-test: getFirstFriend");
        friendship.setFirstFriend(testFirstFriend);
        assertNotNull(friendship.getFirstFriend());
        assertEquals(testFirstFriend, friendship.getFirstFriend());
    }

    @Test
    public void testGetSecondFriend() throws Exception {
        LOGGER.debug("core-test: getSecondFriend");
        friendship.setSecondFriend(testSecondFriend);
        assertNotNull(friendship.getSecondFriend());
        assertEquals(testSecondFriend, friendship.getSecondFriend());
    }

    @Test
    public void testGetCreatedDate() throws Exception {
        LOGGER.debug("core-test: getCreatedDate");
        friendship.setCreatedDate(new Date());
        assertNotNull(friendship.getCreatedDate());
        assertEquals(Date.class, friendship.getCreatedDate().getClass());
    }

    @Test
    public void testBaseConstructor() throws Exception {
        LOGGER.debug("core-test: baseConstructor friendship");
        Friendship testFriendship = new Friendship(testFirstFriend, testSecondFriend);
        assertNotNull(testFriendship);
        assertEquals(testFirstFriend, testFriendship.getFirstFriend());
        assertEquals(Integer.class, testFriendship.getFirstFriend().getClass());
        assertEquals(testSecondFriend, testFriendship.getSecondFriend());
        assertEquals(Integer.class, testFriendship.getSecondFriend().getClass());
        assertNotNull(testFriendship.getCreatedDate());
        assertEquals(Date.class, testFriendship.getCreatedDate().getClass());

    }
}
