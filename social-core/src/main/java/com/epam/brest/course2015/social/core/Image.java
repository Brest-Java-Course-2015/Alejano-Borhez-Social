package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by alexander_borohov on 7.7.16.
 */
@Component
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String url;
    private String url50;
    private String url81;

    @Logged
    public String getUrl50() {
        return url50;
    }

    @Logged
    public void setUrl50(String url50) {
        this.url50 = url50;
    }

    @Logged
    public String getUrl81() {
        return url81;
    }

    @Logged
    public void setUrl81(String url81) {
        this.url81 = url81;
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
    public String getUrl() {
        return url;
    }

    @Logged
    public void setUrl(String url) {
        this.url = url;
    }

    public Image() {
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", url='" + url.substring(0,10) + '\'' +
                ", url50='" + url50.substring(0,10) + '\'' +
                ", url81='" + url81.substring(0,10) + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(getUrl(), image.getUrl()) &&
                Objects.equals(getUrl50(), image.getUrl50()) &&
                Objects.equals(getUrl81(), image.getUrl81());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getUrl50(), getUrl81());
    }
}
