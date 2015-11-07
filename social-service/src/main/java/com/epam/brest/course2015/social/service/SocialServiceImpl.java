package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.dao.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by alexander on 6.11.15.
 */

@Transactional
public class SocialServiceImpl implements SocialService {
    private static final Logger LOGGER = LogManager.getLogger();
    private UserDao userDao;
    private FriendshipDao friendshipDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void setFriendshipDao(FriendshipDao friendshipDao) {
        this.friendshipDao = friendshipDao;
    }

    @Override
    public Integer addUser(User user) {
        Assert.notNull(user, "User should not be null");
        Assert.isNull(user.getUserId(), "User id should be null");
        Assert.notNull(user.getLogin(), "User login should not be null");
        Assert.notNull(user.getPassword(), "User password should not be null");
        Assert.notNull(user.getFirstName(), "User FirstName should not be null");
        Assert.notNull(user.getLastName(), "User LastName should not be null");

        try {
            Assert.isNull(userDao.getUserByLogin(user.getLogin()), "User with login: " + user.getLogin() + " already exists");
            throw new IllegalArgumentException();
        } catch (EmptyResultDataAccessException ex) {
            return userDao.addUser(user);
        }



    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(Integer id, String password) {
        userDao.updateUser(id, password);

    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getFriends(Integer id) {
        return userDao.getFriends(id);
    }

    @Override
    public void addFriendship(User user1, User user2) {
        friendshipDao.addFriendship(user1, user2);

    }

    @Override
    public boolean isAFriend(User user1, User user2) {
        return friendshipDao.isAFriend(user1, user2);
    }

    @Override
    public void discardFriendship(User enemy1, User enemy2) {
        friendshipDao.discardFriendship(enemy1, enemy2);

    }

    @Override
    public List<Friendship> getAllFriendships() {
        return friendshipDao.getAllFriendships();
    }
}
