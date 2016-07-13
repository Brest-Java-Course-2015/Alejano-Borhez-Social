package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.ImageDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexander_borohov on 8.7.16.
 */
@Repository
public class ImageDaoJPA implements ImageDao {
    @Value("${image.selectAllImagesOfAUser}")
    private String selectImages;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer addImage(Image image) {
        entityManager.persist(image);
        Image addedImage = entityManager.merge(image);
        return addedImage.getImageId();
    }

    @Override
    public void deleteImage(Integer id) {
        try {
            entityManager.remove(getImage(id));

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new EmptyResultDataAccessException(id);
        }
    }

    @Override
    public void renameImage(Integer id, String filename) {
        Image newImage = entityManager.find(Image.class, id);
        newImage.setUrl(filename);
        entityManager.merge(newImage);
    }

    @Override
    public Image getImage(Integer imageId) {
        return entityManager.find(Image.class, imageId);
    }

    @Override
    public List<Image> getAllImagesOfAUser(Integer userId) {
        /*List<Image> list = entityManager
                .createQuery(selectImages, Image.class)
                .setParameter("userId", userId)
                .getResultList();*/
        List<Image> list = entityManager
                .find(
                      User.class,
                      userId
                     )
                .getImages();
        return list;
    }
}
