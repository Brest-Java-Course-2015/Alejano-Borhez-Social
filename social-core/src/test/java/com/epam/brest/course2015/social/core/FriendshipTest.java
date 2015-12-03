package com.epam.brest.course2015.social.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;


/**
 * Created by alexander on 26.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class FriendshipTest {
    private static final Integer testFirstFriend = 1;
    private static final Integer testSecondFriend = 2;
    @Autowired
    private Friendship friendship;

    @Test
    public void testGetFirstFriend() throws Exception {
        friendship.setFriend1Id(testFirstFriend);
        assertNotNull(friendship.getFriend1Id());
        assertEquals(testFirstFriend, friendship.getFriend1Id());
    }

    @Test
    public void testGetSecondFriend() throws Exception {
        friendship.setFriend2Id(testSecondFriend);
        assertNotNull(friendship.getFriend2Id());
        assertEquals(testSecondFriend, friendship.getFriend2Id());
    }

    @Test
    public void testGetCreatedDate() throws Exception {
        friendship.setCreatedDate(new Date());
        assertNotNull(friendship.getCreatedDate());
        assertEquals(Date.class, friendship.getCreatedDate().getClass());
    }

    @Test
    public void testBaseConstructor() throws Exception {
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
