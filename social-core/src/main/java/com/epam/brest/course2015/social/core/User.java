package com.epam.brest.course2015.social.core;

import com.fasterxml.jackson.annotation.JsonFormat;

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
 *
 */
public class User {
//  Class variables declaration
    private Integer userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String login;
    private String password;
    private Integer totalFriends;
//  Dates are formatted to be transferred via JSON
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy")
    private Date createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy")
    private Date updatedDate;

//  Getters and setters for class variables
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getTotalFriends() {
        return totalFriends;
    }
    public void setTotalFriends(Integer totalFriends) {
        this.totalFriends = totalFriends;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getUpdatedDate() {
        return updatedDate;
    }
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
     * @param firstName must have a first capital letter. Spaces are not allowed.
     * @param lastName  must have a first capital letter. Spaces are not allowed.
     * @param age       a positive Integer.
     */
    public User(String login, String password,
                String firstName, String lastName,
                Integer age) {
        this.password = password;
        this.login = login;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

    /**
     * Empty constructor for {@link User} object.
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

}
