package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Objects;

import static org.junit.Assert.*;


/**
 * Created by alexander on 26.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class FriendshipTest {
    @Value("${test.userId1}")
    private Integer testFirstFriend;
    @Value("${test.userId2}")
    private Integer testSecondFriend;
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

    @Test
    public void testEquals() throws Exception {
        Friendship testFriendship1 = new Friendship(testFirstFriend, testSecondFriend);
        Friendship testFriendship2 = new Friendship(testFirstFriend, testSecondFriend);
        Friendship testFriendship3 = null;
        Friendship testFriendship4 = testFriendship1;
        assertFalse(testFriendship1.equals(testFriendship3));
        assertFalse(testFriendship1.equals(new Friendship()));
        assertFalse(testFriendship1.equals("testFriendship1"));
        assertTrue(testFriendship1.equals(testFriendship2));
        assertTrue(testFriendship1.equals(testFriendship4));
        assertTrue(testFriendship2.equals(testFriendship1));
    }

    @Test
    public void testToString() throws Exception {
        Friendship testFriendship1 = new Friendship(testFirstFriend, testSecondFriend);
        assertEquals(testFriendship1.toString(), "Friendship{" +
                "friend1Id=" + testFirstFriend +
                ", friend2Id=" + testSecondFriend +
                '}');

    }

    @Test
    public void testHashCode() throws Exception {
        Friendship friendship = new Friendship(testFirstFriend, testSecondFriend);
        assertEquals(friendship.hashCode(), Objects.hash(testFirstFriend, testSecondFriend));

    }
}
