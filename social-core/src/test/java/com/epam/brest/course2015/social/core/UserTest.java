package com.epam.brest.course2015.social.core;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexander on 25.10.15.
 */
public class UserTest {
    private static final String firstName = "FirstName";
    private static final String lastName = "LastName";
    private User user;
    private List<User> friends;



    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGetFirstName() throws Exception {
        user.setFirstName(firstName);
        assertNotNull(user.getFirstName());
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        user.setLastName(lastName);
        assertNotNull(user.getLastName());
        assertEquals(lastName, user.getLastName());
    }



/*
    @Test
    public void testGetFriends() throws Exception {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        friends.add(user);
        user.setFriends(friends);
        assertNotNull(user.getFriends());
        assertTrue(user.getFriends().size() > 0);
        assertEquals(User.class, user.getFriends().get(0));
    }*/

}
