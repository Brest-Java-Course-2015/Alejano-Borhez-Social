package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.dao.ImageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexander_borohov on 11.7.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-persistence-HSQL.xml"})
@Transactional
public class ImageDaoJPATest {

    @Autowired
    private ImageDao imageDao;

    private static final Integer TEST_USER_ID = 1;
    private static final Integer TEST_IMAGE_ID = 2;
    private static final Image TEST_IMAGE = new Image();
    private static final String TEST_URL = "http://localhost:8080/images/test.jpg";


    @Test
    public void addImage() throws Exception {
        TEST_IMAGE.setUrl(TEST_URL);
        TEST_IMAGE.setUrl50(TEST_URL);
        TEST_IMAGE.setUrl81(TEST_URL);
        TEST_IMAGE.setCreatedDate(new Date());
        Integer imageId = imageDao.addImage(TEST_IMAGE);
        assertNotNull(imageId);
        System.out.println(imageId);
    }

    @Test
    public void testGetImage() throws Exception {
        Image image = imageDao.getImage(1);
        assertNotNull(image);
        assertEquals(image.getClass(), Image.class);
    }

    @Test
    public void testDeleteImage() throws Exception {
        Image image = imageDao.getImage(TEST_IMAGE_ID);
        assertNotNull(image);
        imageDao.deleteImage(TEST_IMAGE_ID);
        Image image1 = imageDao.getImage(TEST_IMAGE_ID);
        assertNull(image1);
    }

    @Test
    public void testRenameImage() throws Exception {
        String url = "new";
        imageDao.renameImage(TEST_IMAGE_ID, url);

        Image image = imageDao.getImage(TEST_IMAGE_ID);
        String newUrl = image.getUrl();
        assertEquals(newUrl, url);
    }

    @Test
    public void testGetAllImagesOfAUser() throws Exception {
        List<Image> list = imageDao.getAllImagesOfAUser(TEST_USER_ID);
        assertNotNull(list);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getClass(), Image.class);
//        imageDao.deleteAllImages(TEST_USER_ID);
//        List<Image> list1 = imageDao.getAllImagesOfAUser(TEST_USER_ID);
//        assertTrue(list1.isEmpty());
    }

}