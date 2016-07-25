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

    private static final User USER = new User(1);
    private static final Integer IMAGE_ID = 1;
    private static final Date CREATED_DATE = new Date();
    private static final String URL = "File Name";
    private static final String URL_50 = "File Name 50";
    private static final String URL_81 = "File Name 81";

    @Test
    public void getImageId() throws Exception {
        image.setImageId(IMAGE_ID);
        assertNotNull(image.getImageId());
        assertEquals(image.getImageId(), IMAGE_ID);
    }

    @Test
    public void getCreatedDate() throws Exception {
        image.setCreatedDate(CREATED_DATE);
        assertNotNull(image.getCreatedDate());
        assertEquals(image.getCreatedDate(), CREATED_DATE);
    }

    @Test
    public void getUrl() throws Exception {
        image.setUrl(URL);
        assertNotNull(image.getUrl());
        assertEquals(image.getUrl(), URL);
    }

    @Test
    public void getUrl50() throws Exception {
        image.setUrl50(URL_50);
        assertNotNull(image.getUrl50());
        assertEquals(image.getUrl50(), URL_50);
    }

    @Test
    public void getUrl81() throws Exception {
        image.setUrl81(URL_81);
        assertNotNull(image.getUrl81());
        assertEquals(image.getUrl81(), URL_81);
    }
}