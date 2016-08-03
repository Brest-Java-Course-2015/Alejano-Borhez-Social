package com.epam.brest.course2015.social.dto;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Created by alexander on 14.11.15.
 *
 * @author alexander.borohov
 * @version 1.0
 *
 * {@link SocialDto} class is a DataTransferObject used to retrieve data
 * from a DB and to transfer universal data to GUI.
 * It includes a list of {@link User}s, number of {@link User} objects in
 * a list in a totalUsers variable, and a single {@link User} object
 * related to this list (e.g.
 *  -user - is a {@link User},
 *  -users list of {@link User}s - is a list of friends,
 *  -totalFriends - is a number of {@link User} objects in a users list
 *
 *
 */
@Component
public class SocialDto {
//  Class variables declaration
    private List<User> users;



    private List<Image> images;
    private Integer totalUsers;
    private User user;
//  Getters and setters for class variables
    @Logged
    public List<User> getUsers() {
        return users;
    }

    /*@Logged
    public List<SocialMessage> getMessages() {
        return messages;
    }

    @Logged
    public void setMessages(List<SocialMessage> messages) {
        this.messages = messages;
    }
*/
    @Logged
    public void setUsers(List<User> users) {
        this.users = users;
    }
    @Logged
    public Integer getTotalUsers() {
        return totalUsers;
    }
    @Logged
    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }
    @Logged
    public User getUser() {
        return user;
    }
    @Logged
    public void setUser(User user) {
        this.user = user;
    }

    public SocialDto () { }
    @Logged
    public void setImages(List<Image> images) {
        this.images = images;
    }
    @Logged
    public List<Image> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "SocialDto{" +
                "users=" +
                ((users != null)? users.size(): "empty") +
                ", images=" +
                ((images != null)? images.size(): "empty") +
                ", totalUsers=" + totalUsers +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialDto dto = (SocialDto) o;
        return Objects.equals(getUsers(), dto.getUsers()) &&
                Objects.equals(getUser(), dto.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsers(), getUser());
    }
}
