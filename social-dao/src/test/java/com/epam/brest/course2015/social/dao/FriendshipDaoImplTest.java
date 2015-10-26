package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;
import junit.framework.TestCase;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by alexander on 26.10.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-spring-dao.xml"})
@Transactional
public class FriendshipDaoImplTest extends TestCase {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Integer testFirstFriend = 5;
    private static final Integer testSecondFriend = 6;
    private static final User testFriend1 = new User(testFirstFriend);
    private static final User testFriend2 = new User(testSecondFriend);


    @Autowired
    private FriendshipDao friendshipDao;

    @Test
    public void testAddFriendship() throws Exception {
        friendshipDao.addFriendship(testFriend1, testFriend2);
        assertTrue(testFirstFriend != testSecondFriend);
    }

    public void testIsAFriend() throws Exception {

    }

    public void testDiscardFriendship() throws Exception {

    }

    public void testListOfFriendsId() throws Exception {

    }

    public void testGetFriends() throws Exception {

    }
}