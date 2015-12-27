package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by alexander on 25.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-persistence.xml"})
public class UserDaoJPATest {

    @Autowired
    UserDao userDao;

    @Test
    public void testGetAllUsers() throws Exception {

        assertEquals("name", "name");
        Integer i = userDao.addUser(new User());
        assertNotNull(i);
        System.out.println("allright");
    }



}