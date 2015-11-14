package com.epam.brest.course2015.social.core;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 25.10.15.
 */
public class User {
    //Объявление переменных
    private Integer userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String login;
    private String password;
    private List<User> friends;
    private Integer totalFriends;



    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdDate;
    @JsonFormat (shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date updatedDate;
    //Геттеры и сеттеры
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
    public List<User> getFriends() {
        return friends;
    }
    public Integer getTotalFriends() {
        return totalFriends;
    }
    public void setTotalFriends(Integer totalFriends) {
        this.totalFriends = totalFriends;
    }
    public void setFriends(List<User> friends) {
        this.friends = friends;
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
    //Конструкторы
    //Базовый конструктор - используется для добавления
    //в базу данных нового пользователя
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
    //Пустой конструктор - используется в основном для тестов
    public User() { }
//    Конструкторы для тестов
    public User(Integer userId) {
        this.userId = userId;
    }

}
