package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
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

    private static final Integer testUserId = 1;
    private static final Integer testImageId = 2;
    private static final Image testImage = new Image();
    private static final User testUser = new User(testUserId);
    private static final String testUrl = "http://localhost:8080/images/test.jpg";


    @Test
    public void addImage() throws Exception {
        testImage.setUser(testUser);
        testImage.setUrl(testUrl);
        testImage.setCreatedDate(new Date());
        Integer imageId = imageDao.addImage(testImage);
        assertNotNull(imageId);
        System.out.println(imageId);
    }

    @Test
    public void testGetImage() throws Exception {
        Image image = imageDao.getImage(1);
        assertNotNull(image);
        assertEquals(image.getClass(), Image.class);
        assertEquals(image.getUser().getClass(), User.class);
        assertEquals(image.getUser().getUserId().intValue(), 1);
    }

    @Test
    public void testDeleteImage() throws Exception {
        Image image = imageDao.getImage(testImageId);
        assertNotNull(image);
        imageDao.deleteImage(testImageId);
        Image image1 = imageDao.getImage(testImageId);
        assertNull(image1);
    }

    @Test
    public void testRenameImage() throws Exception {
        Image image = imageDao.getImage(testImageId);
        String url = "new";
        imageDao.renameImage(image, url);

        image = imageDao.getImage(testImageId);
        String newUrl = image.getUrl();
        assertEquals(newUrl, url);
    }

    @Test
    public void testGetAllImagesOfAUser() throws Exception {
        List<Image> list = imageDao.getAllImagesOfAUser(testUserId);
        assertNotNull(list);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getClass(), Image.class);
    }


}