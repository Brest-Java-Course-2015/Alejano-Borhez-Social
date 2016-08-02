package com.epam.brest.course2015.social.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private static final Date CREATED_DATE = new Date();

    @Value("${test.url}")
    private String url;
    @Value("${test.url50}")
    private String url50;
    @Value("${test.url81}")
    private String url81;
    @Value("${test.imageId1}")
    private Integer imageId;

    @Test
    public void getImageId() throws Exception {
        image.setImageId(imageId);
        assertNotNull(image.getImageId());
        assertEquals(image.getImageId(), imageId);
    }

    @Test
    public void getCreatedDate() throws Exception {
        image.setCreatedDate(CREATED_DATE);
        assertNotNull(image.getCreatedDate());
        assertEquals(image.getCreatedDate(), CREATED_DATE);
    }

    @Test
    public void getUrl() throws Exception {
        image.setUrl(url);
        assertNotNull(image.getUrl());
        assertEquals(image.getUrl(), url);
    }

    @Test
    public void getUrl50() throws Exception {
        image.setUrl50(url50);
        assertNotNull(image.getUrl50());
        assertEquals(image.getUrl50(), url50);
    }

    @Test
    public void getUrl81() throws Exception {
        image.setUrl81(url81);
        assertNotNull(image.getUrl81());
        assertEquals(image.getUrl81(), url81);
    }
}