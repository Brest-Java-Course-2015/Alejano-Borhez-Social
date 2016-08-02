package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.SocialMessage;
import com.epam.brest.course2015.social.core.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${test.totalUsers}")
    private Integer totalUsers;
    @Value("${test.url}")
    private String url;
    @Value("${test.url50}")
    private String url50;
    @Value("${test.url81}")
    private String url81;
    @Value("${test.imageId1}")
    private Integer imageId;
    @Value("${test.url1}")
    private String url1;
    @Value("${test.url501}")
    private String url501;
    @Value("${test.url811}")
    private String url811;
    @Value("${test.imageId2}")
    private Integer imageId1;

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

    @Test
    public void testGetImages() throws Exception {
        Image image1 = new Image();
        image1.setUrl(url);
        image1.setUrl50(url50);
        image1.setUrl81(url81);
        image1.setCreatedDate(new Date());
        image1.setImageId(imageId);
        Image image2 = new Image();
        image2.setUrl(url1);
        image2.setUrl50(url501);
        image2.setUrl81(url811);
        image2.setCreatedDate(new Date());
        image2.setImageId(imageId1);

        List<Image> imageList = new ArrayList<>();
        imageList.add(image1);
        imageList.add(image2);

        dto.setImages(imageList);
        assertNotNull(dto.getImages());
        assertNotNull(dto.getImages().get(0));
        assertEquals(dto.getImages().get(0).getClass(), Image.class);
        assertEquals(dto.getImages().get(0).getUrl(), image1.getUrl());
        assertEquals(dto.getImages().get(0).getUrl50(), image1.getUrl50());
        assertEquals(dto.getImages().get(0).getUrl81(), image1.getUrl81());
        assertEquals(dto.getImages().get(1).getUrl(), image2.getUrl());
        assertEquals(dto.getImages().get(1).getUrl50(), image2.getUrl50());
        assertEquals(dto.getImages().get(1).getUrl81(), image2.getUrl81());

    }
}