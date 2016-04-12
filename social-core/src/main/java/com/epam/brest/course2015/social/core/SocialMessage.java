package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by alexander on 12.4.16.
 */
//@Entity
//@Table(name = "MESSAGES")
public class SocialMessage {
    private Integer user1Id;
    private Integer user2Id;
    private String message;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy")
    private Date createdDate;

    public SocialMessage() {
        this.createdDate = new Date();
    }

    @Logged
    public Integer getUser1Id() {
        return user1Id;
    }

    @Logged
    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    @Logged
    public Integer getUser2Id() {
        return user2Id;
    }

    @Logged
    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    @Logged
    public String getMessage() {
        return message;
    }

    @Logged
    public void setMessage(String message) {
        this.message = message;
    }

    @Logged
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        String message = "Message is sent from: User#"
                + user1Id
                + " to User#"
                + user2Id
                + " with text: "
                + this.message;
        return message;
    }
}
