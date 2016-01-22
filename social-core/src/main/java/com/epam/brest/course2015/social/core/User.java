package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexander on 25.10.15.
 *
 * @author alexander.borohov
 * @version 1.0
 *
 * {@link User} class is one of entities of my Simple-Social-Network
 * study project.
 *
 *  Class is ready to use as Entity in JPA to persist data in database
 *
 */
@Entity
@Table(name = "USER")
public class User {
//  Class variables declaration
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;
    private String lastName;
    private Integer age;
    private String login;
    private String password;

    @Transient
    private Integer totalFriends;
//  Dates are formatted to be transferred via JSON
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

//  Getters and setters for class variables
    @Logged
    public String getFirstName() {
        return firstName;
    }
    @Logged
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Logged
    public String getLastName() {
        return lastName;
    }
    @Logged
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Logged
    public Integer getAge() {
        return age;
    }
    @Logged
    public void setAge(Integer age) {
        this.age = age;
    }
    @Logged
    public String getLogin() {
        return login;
    }
    @Logged
    public void setLogin(String login) {
        this.login = login;
    }
    @Logged
    public String getPassword() {
        return password;
    }
    @Logged
    public void setPassword(String password) {
        this.password = password;
    }
    @Logged
    public Integer getUserId() {
        return userId;
    }
    @Logged
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Logged
    public Integer getTotalFriends() {
        return totalFriends;
    }
    @Logged
    public void setTotalFriends(Integer totalFriends) {
        this.totalFriends = totalFriends;
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
    public Date getUpdatedDate() {
        return updatedDate;
    }
    @Logged
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * Basic constructor for {@link User} object.
     * It is usually used for basic operations within Dao processes.
     * <p>
     * Some parameters like createdDate & updatedDate are evaluated by default.
     *
     * @param  login    may contain only lowercase english letters and
     *                  _- signs and numbers.
     * @param password  may contain only english letters and numbers.
     * @param firstName must have a first capital letter.
     *                  Spaces are not allowed.
     * @param lastName  must have a first capital letter.
     *                  Spaces are not allowed.
     * @param age       a positive Integer.
     */
    public User(String login,
                String password,
                String firstName,
                String lastName,
                Integer age) {
        this.password = password;
        this.login = login;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.createdDate = new Date();
        this.updatedDate = new Date();
        this.totalFriends = 0;
    }

    /**
     * Empty constructor for {@link User} object.
     * Used for JPA purposes
     */
    public User() { }

    /**
     * Simple constructor for {@link User} object.
     * Usually used for test purposes.
     * @param userId should be a positive Integer.
     */
    public User(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        String user = "Id: "
            + userId
            + "; login: "
            + login
            + "; firstname: "
            + firstName
            + "; lastname: "
            + lastName
            + "; age: "
            + age
            + "; createdDate: "
            + createdDate
            + "; updatedDate: "
            + updatedDate;

        return user;
    }
}
