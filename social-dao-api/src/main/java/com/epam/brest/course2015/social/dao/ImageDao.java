package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.Image;


/**
 * Created by alexander_borohov on 8.7.16.
 */
public interface ImageDao {
    Integer addImage(Image image);
    void deleteImage(Image image);
    void renameImage(Image image, String filename);
}
