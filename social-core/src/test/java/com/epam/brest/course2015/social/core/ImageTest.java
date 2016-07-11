package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by alexander_borohov on 8.7.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-core.xml"})
public class ImageTest {

    @Autowired
    private Image image;

    private static final User user = new User(1);
    private static final Integer imageId = 1;
    private static final Date createdDate = new Date();
    private static final String url = "File Name";

    @Test
    public void getUser() throws Exception {
        image.setUser(user);
        assertNotNull(image.getUser());
        assertEquals(image.getUser(), user);
    }

    @Test
    public void getImageId() throws Exception {
        image.setImageId(imageId);
        assertNotNull(image.getImageId());
        assertEquals(image.getImageId(), imageId);
    }

    @Test
    public void getCreatedDate() throws Exception {
        image.setCreatedDate(createdDate);
        assertNotNull(image.getCreatedDate());
        assertEquals(image.getCreatedDate(), createdDate);
    }

    @Test
    public void getUrl() throws Exception {
        image.setUrl(url);
        assertNotNull(image.getUrl());
        assertEquals(image.getUrl(), url);
    }

}