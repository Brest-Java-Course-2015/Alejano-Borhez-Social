package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
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
 * {@link FriendshipJPA} class is one of entities of my Simple-Social-Network
 * study project.
 *
 * Instance of a {@link FriendshipJPA} class is used to transfer data to a DB.
 * Every record in a DB determines a friendship between two {@link User}s.
 *
 *
 */
@Entity
@Table(name = "FRIENDS")
public class FriendshipJPA {
//  Class variables declaration
    private Integer friend1Id;
    private Integer friend2Id;
//  Dates are formatted to be transferred via JSON
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdDate;
    /**
     * Empty constructor for {@link FriendshipJPA} object.
     */
    public FriendshipJPA() { }
    /**
     * Basic constructor for {@link FriendshipJPA} object.
     * It is usually used for basic operations within Dao processes.
     * <p>
     * Variable createdDate is evaluated by default.
     *
     * @param firstFriend a positive Integer, determining a {@link User} id.
     * @param secondFriend a positive Integer, determining a {@link User} id.
     */
    public FriendshipJPA(Integer firstFriend, Integer secondFriend) {
        this.friend1Id = firstFriend;
        this.friend2Id = secondFriend;
        this.createdDate = new Date();
    }
//  Getters and setters for class variables
    @ManyToMany
    @JoinColumn
    public Integer getFriend1Id() {
        return friend1Id;
    }
    public void setFriend1Id(Integer friend1Id) {
        this.friend1Id = friend1Id;
    }

    @ManyToMany
    @JoinColumn
    public Integer getFriend2Id() {
        return friend2Id;
    }
    public void setFriend2Id(Integer friend2Id) {
        this.friend2Id = friend2Id;
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
