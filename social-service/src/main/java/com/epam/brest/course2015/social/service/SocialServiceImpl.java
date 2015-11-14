package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.dao.UserDao;
import com.epam.brest.course2015.social.dto.SocialDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collections;
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

    @Value("${addUser.notNullUser}")
    private String notNullUser;
    @Value("${addUser.nullId}")
    private String nullId;
    @Value("${addUser.notNullLogin}")
    private String notNullLogin;
    @Value("${addUser.notNullPassword}")
    private String notNullPassword;
    @Value("${addUser.notNullFirstName}")
    private String notNullFirstName;
    @Value("${addUser.notNullLastName}")
    private String notNullLastName;
    @Value("${deleteUser.notNullId}")
    private String notNullId;
    @Value("${deleteUser.correctId}")
    private String correctId;

    @Override
    public Integer addUser(User user) {
        Assert.notNull(user, notNullUser);
        Assert.isNull(user.getUserId(), nullId);
        Assert.notNull(user.getLogin(), notNullLogin);
        Assert.notNull(user.getPassword(), notNullPassword);
        Assert.notNull(user.getFirstName(), notNullFirstName);
        Assert.notNull(user.getLastName(), notNullLastName);
        LOGGER.debug("Adding new user: {}", user.getLogin());
        try {
            Assert.isNull(userDao.getUserByLogin(user.getLogin()), "User with login: " + user.getLogin() + " already exists");
            throw new IllegalArgumentException();
        } catch (EmptyResultDataAccessException ex) {
            return userDao.addUser(user);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        Assert.notNull(id, notNullId);
        Assert.isTrue(id > 0, correctId);
        LOGGER.debug("Deleting a user with id: {}", id);
        try {
            userDao.getUserById(id);
            userDao.deleteUser(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            LOGGER.debug("User with Id {} does not exist", id);
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void updateUser(Integer id, String password) {
        Assert.notNull(id, notNullId);
        Assert.isTrue(id > 0, correctId);
        Assert.notNull(password, notNullPassword);
        LOGGER.debug("Updating a user with id: {}", id);
        try {
            userDao.getUserById(id);
            userDao.updateUser(id, password);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            LOGGER.debug("User with Id {} does not exist", id);
            throw new IllegalArgumentException();
        }
    }

    @Override
    public User getUserById(Integer id) {
        Assert.notNull(id, notNullId);
        Assert.isTrue(id > 0, correctId);
        LOGGER.debug("Getting user by Id: {}", id);
        try {
            return userDao.getUserById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            LOGGER.debug("User with Id {} does not exist", id);
            throw new IllegalArgumentException();        }
    }

    @Override
    public User getUserByLogin(String login) {
        Assert.notNull(login, notNullLogin);
        LOGGER.debug("Getting user by login: {}", login);
        try {
            return userDao.getUserByLogin(login);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            LOGGER.debug("User with login {} does not exist", login);
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.debug("Getting list of all users");
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getFriends(Integer id) {
        Assert.notNull(id, notNullId);
        Assert.isTrue(id > 0, correctId);
        LOGGER.debug("Getting list of all friends of user with id: {}", id);
        try {
            userDao.getUserById(id);
            return userDao.getFriends(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            LOGGER.debug("User with Id {} does not exist", id);
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addFriendship(User user1, User user2) {
        Assert.notNull(user1, notNullUser + " user1");
        Assert.notNull(user2, notNullUser + " user2");
        Assert.notNull(user1.getUserId(), notNullId + " user1");
        Assert.notNull(user2.getUserId(), notNullId + " user2");
        Assert.isTrue(!friendshipDao.isAFriend(user1, user2), "Friendship already exists");
        LOGGER.debug("Adding new friendship of users: {}, {}", user1.getUserId(), user2.getUserId());
        friendshipDao.addFriendship(user1, user2);
        userDao.increaseFriends(user1.getUserId());
        userDao.increaseFriends(user2.getUserId());

    }

    @Override
    public boolean isAFriend(User user1, User user2) {
        Assert.notNull(user1, notNullUser + " user1");
        Assert.notNull(user2, notNullUser + " user2");
        Assert.notNull(user1.getUserId(), notNullId + " user1");
        Assert.notNull(user2.getUserId(), notNullId + " user2");
        LOGGER.debug("Checking for friendship of users: {}, {}", user1.getUserId(), user2.getUserId());
        return friendshipDao.isAFriend(user1, user2);
    }

    @Override
    public void discardFriendship(User enemy1, User enemy2) {
        Assert.notNull(enemy1, notNullUser + " user1");
        Assert.notNull(enemy2, notNullUser + " user2");
        Assert.notNull(enemy1.getUserId(), notNullId + " user1");
        Assert.notNull(enemy2.getUserId(), notNullId + " user2");
        Assert.isTrue(friendshipDao.isAFriend(enemy1, enemy2), "Friendship does not exist");
        LOGGER.debug("Discarding a friendship of users: {}, {}", enemy1.getUserId(), enemy2.getUserId());
        friendshipDao.discardFriendship(enemy1, enemy2);
        userDao.decreaseFriends(enemy1.getUserId());
        userDao.decreaseFriends(enemy2.getUserId());

    }

    @Override
    public List<Friendship> getAllFriendships() {
        LOGGER.debug("Getting list of all friendships");
        return friendshipDao.getAllFriendships();
    }

    @Override
    public void discardAllFriendshipsOfAUser(Integer id) {
        LOGGER.debug("service: Deleting all friendships of a user {}", id);
        friendshipDao.discardAllFriendshipsOfAUser(id);
    }

    @Override
    public SocialDto getSocialDto() {
        LOGGER.debug("service: Getting dto");
        SocialDto dto = new SocialDto();
        dto.setTotalUsers(userDao.getCountOfUsers());
        if (dto.getTotalUsers() > 0) {
            dto.setUsers(userDao.getAllUsers());
        } else  {
            dto.setUsers(Collections.<User>emptyList());
        }
        return dto;
    }



}
