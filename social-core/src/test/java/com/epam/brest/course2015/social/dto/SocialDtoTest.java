package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 14.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class SocialDtoTest extends TestCase {
    //Универсальный Логгер, который показывает имя тестового класса и имя тестового метода
    private static final Integer totalUsers = 5;
    @Autowired
    private SocialDto dto;
    @Autowired
    private User user;

    @Test
    public void testGetUsers() throws Exception {
        List<User> list = new ArrayList<User>() {};
        list.add(user);
        dto.setUsers(list);
        assertNotNull(dto.getUsers());
        assertTrue(dto.getUsers().size() > 0);
        assertEquals(user.getClass(), dto.getUsers().get(0).getClass());
    }

    @Test
    public void testGetTotalUsers() throws Exception {
        dto.setTotalUsers(totalUsers);
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() == totalUsers);
    }

    @Test
    public void testGetUser() throws Exception {
        dto.setUser(user);
        assertNotNull(dto.getUser());
        assertEquals(dto.getUser().getClass(), user.getClass());
    }

}