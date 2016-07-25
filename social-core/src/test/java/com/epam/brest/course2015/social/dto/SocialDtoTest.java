package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.SocialMessage;
import com.epam.brest.course2015.social.core.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 14.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class SocialDtoTest extends TestCase {
    private static final Integer TOTAL_USERS = 5;
    @Autowired
    private SocialDto dto;
    @Autowired
    private User user;
    @Autowired
    private SocialMessage message;

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
        dto.setTotalUsers(TOTAL_USERS);
        assertNotNull(dto.getTotalUsers());
        assertTrue(dto.getTotalUsers() == TOTAL_USERS);
    }

    @Test
    public void testGetUser() throws Exception {
        dto.setUser(user);
        assertNotNull(dto.getUser());
        assertEquals(dto.getUser().getClass(), user.getClass());
    }

  /*  @Test
    public void testGetMessages() throws Exception {
        List<SocialMessage> list = new ArrayList<>();
        message.setUser1Id(1);
        message.setUser2Id(2);
        message.setMessage("Hello!");
        list.add(message);
        dto.setMessages(list);
        assertNotNull(dto.getMessages());
        assertEquals(dto.getMessages().get(0).getClass(), message.getClass());
        assertEquals(dto.getMessages().size(), 1);
    }*/

    @Test
    public void testGetImages() throws Exception {
        Image image1 = new Image();
        image1.setUrl("url1");
        image1.setCreatedDate(new Date());
        image1.setImageId(1);
        Image image2 = new Image();
        image2.setUrl("url2");
        image2.setCreatedDate(new Date());
        image2.setImageId(2);

        List<Image> imageList = new ArrayList<>();
        imageList.add(image1);
        imageList.add(image2);

        dto.setImages(imageList);
        assertNotNull(dto.getImages());
        assertNotNull(dto.getImages().get(0));
        assertEquals(dto.getImages().get(0).getClass(), Image.class);
    }
}