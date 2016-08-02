package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

/**
 * Created by alexander on 12.4.16.
 */
@Component
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialMessage that = (SocialMessage) o;
        return Objects.equals(getUser1Id(), that.getUser1Id()) &&
                Objects.equals(getUser2Id(), that.getUser2Id()) &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser1Id(), getUser2Id(), getMessage());
    }

    @Override
    public String toString() {
        return "SocialMessage{" +
                "user1Id=" + user1Id +
                ", user2Id=" + user2Id +
                ", message='" + message + '\'' +
                '}';
    }
}
