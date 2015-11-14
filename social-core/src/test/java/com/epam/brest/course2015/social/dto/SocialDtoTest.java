package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.User;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 14.11.15.
 */
public class SocialDtoTest extends TestCase {
    //Универсальный Логгер, который показывает имя тестового класса и имя тестового метода
    public static final Logger LOGGER = LogManager.getLogger();
    private static void LOGGERDO() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        LOGGER.debug("Started test: " + elements[2].getMethodName());
    }
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
        LOGGERDO();
        List<User> list = new ArrayList<User>() {};
        list.add(user);
        dto.setUsers(list);
        assertNotNull(dto.getUsers());
        assertTrue(dto.getUsers().size() > 0);
        assertEquals(User.class, dto.getUsers().get(0).getClass());
    }

    public void testGetTotalUsers() throws Exception {
        LOGGERDO();
        dto.setTotalUsers(totalUsers);
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() == totalUsers);
    }

}