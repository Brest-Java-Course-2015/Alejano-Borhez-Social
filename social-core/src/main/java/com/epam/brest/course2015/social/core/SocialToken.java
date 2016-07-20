package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@Component
@Entity
@Table(name = "token")
public class SocialToken {

    private Integer userId;
    @Id
    private String token;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;

    @Logged
    public String getToken() {
        return token;
    }
    @Logged
    public void setToken(String token) {
        this.token = token;
    }
    @Logged
    public Date getExpires() {
        return expires;
    }
    @Logged
    public void setExpires(Date expires) {
        this.expires = expires;
    }
    @Logged
    public Integer getUserId() {
        return userId;
    }
    @Logged
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public SocialToken() {
    }

    public SocialToken(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
        this.expires = DateUtils.addMonths(new Date(), 1);
    }
}
