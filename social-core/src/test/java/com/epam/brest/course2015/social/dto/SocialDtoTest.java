package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.epam.brest.course2015.social.test.SocialTestLogger.LOGGER;

/**
 * Created by alexander on 14.11.15.
 */
public class SocialDtoTest extends TestCase {
    //Универсальный Логгер, который показывает имя тестового класса и имя тестового метода
    private static final Integer totalUsers = 5;
    private SocialDto dto;
    private User user;

    @Before
    public void setUp() throws Exception {
        dto = new SocialDto();
        user = new User();
    }

    @Test
    public void testGetUsers() throws Exception {
        LOGGER();
        List<User> list = new ArrayList<User>() {};
        list.add(user);
        dto.setUsers(list);
        assertNotNull(dto.getUsers());
        assertTrue(dto.getUsers().size() > 0);
        assertEquals(User.class, dto.getUsers().get(0).getClass());
    }

    @Test
    public void testGetTotalUsers() throws Exception {
        LOGGER();
        dto.setTotalUsers(totalUsers);
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() == totalUsers);
    }

    @Test
    public void testGetUser() throws Exception {
        LOGGER();
        dto.setUser(user);
        assertNotNull(dto.getUser());
        assertEquals(dto.getUser().getClass(), User.class);
    }

}