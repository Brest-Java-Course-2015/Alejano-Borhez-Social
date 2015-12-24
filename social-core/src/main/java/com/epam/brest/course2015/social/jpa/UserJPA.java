package com.epam.brest.course2015.social.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexander on 25.12.15.
 */
@Entity
@Table(name = "USER")
public class UserJPA {
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

    @Id
    @GeneratedValue
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

    public UserJPA(String login,
                   String password,
                   String firstName,
                   String lastName,
                   Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.login = login;
        this.password = password;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }
}
