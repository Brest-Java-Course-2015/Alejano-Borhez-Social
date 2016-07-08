package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexander on 26.10.15.
 *
 * @author alexander.borohov
 * @version 1.0
 *
 * {@link Friendship} class is one of entities of my Simple-Social-Network
 * study project.
 *
 * Instance of a {@link Friendship} class is used to transfer data to a DB.
 * Every record in a DB determines a friendship between two {@link User}s.
 *
 *  Class is ready to use as Entity in JPA to persist data in database
 */

@Entity
@Table(name = "friends")
public class Friendship {
//  Class variables declaration

    @Id
    private Integer friend1Id;
    private Integer friend2Id;
//  Dates are formatted to be transferred via JSON
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    /**
     * Empty constructor for {@link Friendship} object.
     * Used for JPA purposes
     */
    public Friendship() { }
    /**
     * Basic constructor for {@link Friendship} object.
     * It is usually used for basic operations within Dao processes.
     * <p>
     * Variable createdDate is evaluated by default.
     *
     * @param firstFriend a positive Integer, determining a {@link User} id.
     * @param secondFriend a positive Integer, determining a {@link User} id.
     */
    public Friendship(Integer firstFriend, Integer secondFriend) {
        this.friend1Id = firstFriend;
        this.friend2Id = secondFriend;
        this.createdDate = new Date();
    }
//  Getters and setters for class variables
    @Logged
    public Integer getFriend1Id() {
        return friend1Id;
    }
    @Logged
    public void setFriend1Id(Integer friend1Id) {
        this.friend1Id = friend1Id;
    }
    @Logged
    public Integer getFriend2Id() {
        return friend2Id;
    }
    @Logged
    public void setFriend2Id(Integer friend2Id) {
        this.friend2Id = friend2Id;
    }
    @Logged
    public Date getCreatedDate() {
        return createdDate;
    }
    @Logged
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        String friendship = "friends: id1: "
                + friend1Id
                + ", id2: "
                + friend2Id
                + ", createdDate: "
                + createdDate;
        return friendship;
    }
}
