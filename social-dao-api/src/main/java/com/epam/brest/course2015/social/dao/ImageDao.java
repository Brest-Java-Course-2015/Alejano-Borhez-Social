package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.Image;

import java.util.List;


/**
 * Created by alexander_borohov on 8.7.16.
 */
public interface ImageDao {
    Integer addImage(Image image);
    void deleteImage(Integer id);
    void renameImage(Integer id, String filename);
    void deleteAllImages(Integer id);
    Image getImage(Integer imageId);
    List<Image> getAllImagesOfAUser(Integer userId);

}
