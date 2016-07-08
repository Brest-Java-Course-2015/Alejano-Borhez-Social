package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexander_borohov on 7.7.16.
 */
@Entity
@Table(name = "image")
public class Image {

    private Integer userId;
    @Id
    private Integer imageId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    private String filename;

    @Logged
    public Integer getUserId() {
        return userId;
    }

    @Logged
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Logged
    public Integer getImageId() {
        return imageId;
    }

    @Logged
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    @Logged
    public Date getCreatedDate() {
        return createdDate;
    }

    @Logged
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Logged
    public String getFilename() {
        return filename;
    }

    @Logged
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        String s = "/" +
                    userId +
                    "/" +
                    imageId;
        return s;
    }

    public Image() {
    }

    public Image(Integer userId, Integer imageId) {
        this.userId = userId;
        this.imageId = imageId;
        this.createdDate = new Date();

    }
}
