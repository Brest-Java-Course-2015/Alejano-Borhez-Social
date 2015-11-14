package com.epam.brest.course2015.social.core;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by alexander on 26.10.15.
 */
public class Friendship {
//    Объявление переменных
    private Integer friend1Id;
    private Integer friend2Id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date createdDate;
//    Конструкторы
//    Пустой конструктор
    public Friendship() { }
    //    Базовый конструктор
    public Friendship(final Integer firstFriend, final Integer secondFriend) {
        this.friend1Id = firstFriend;
        this.friend2Id = secondFriend;
        this.createdDate = new Date();
    }
//    Геттеры и сеттеры
    public Integer getFriend1Id() {
        return friend1Id;
    }

    public void setFriend1Id(Integer friend1Id) {
        this.friend1Id = friend1Id;
    }

    public Integer getFriend2Id() {
        return friend2Id;
    }

    public void setFriend2Id(Integer friend2Id) {
        this.friend2Id = friend2Id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
