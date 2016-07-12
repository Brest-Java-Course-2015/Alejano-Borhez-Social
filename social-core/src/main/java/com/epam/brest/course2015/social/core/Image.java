package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexander_borohov on 7.7.16.
 */
@Component
@Entity
@Table(name = "image")
public class Image {

    /*@ManyToOne
    @JoinColumn(name = "userId")
    private User user;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String url;


    /*@Logged
    public User getUser() {
        return user;
    }

    @Logged
    public void setUser(User user) {
        this.user = user;
    }
*/
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
    public String getUrl() {
        return url;
    }

    @Logged
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        String s = "User(" +
//                    this.user.getUserId() +
                    "), Image(" +
                    this.imageId +
                    "), Url:" +
                    this.url;
        return s;
    }

    public Image() {
    }

}
