package com.epam.brest.course2015.social.core;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by alexander on 26.10.15.
 */
public class Friendship {
//    Объявление переменных
    private Integer firstFriend;
    private Integer secondFriend;
    private Date createdDate;
//    Конструкторы
//    Пустой конструктор
    public Friendship(){}
//    Базовый конструктор
    public Friendship(Integer firstFriend, Integer secondFriend) {
        this.firstFriend = firstFriend;
        this.secondFriend = secondFriend;
        this.createdDate = new Date();
    }
//    Геттеры и сеттеры
    public Integer getFirstFriend() {
        return firstFriend;
    }

    public void setFirstFriend(Integer firstFriend) {
        this.firstFriend = firstFriend;
    }

    public Integer getSecondFriend() {
        return secondFriend;
    }

    public void setSecondFriend(Integer secondFriend) {
        this.secondFriend = secondFriend;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
