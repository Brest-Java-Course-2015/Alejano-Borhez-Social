package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 25.12.15.
 */
@Repository
public class UserDaoJPA implements UserDao {
    @Value("${user.selectAllUsers}")
    private String selectAllUsers;
    @Value("${user.selectAllUsersByDate}")
    private String SelectAllUsersByDate;
    @Value("${user.selectByLogin}")
    private String selectUserByLogin;
    @Value("${friend.findFriends}")
    private String selectFriendship;
    @Value("${friend.findNoFriends}")
    private String selectNoFriendship;
    @Value("${user.getCountOfUsers}")
    private String getCountOfUsers;
    @Value("${user.getCountOfUserFriends}")
    private String getCountOfUserFriends;

    @PersistenceContext
    private EntityManager entityManagerUser;

    @Override
    @Logged
    public Integer addUser(User user) {
        entityManagerUser.persist(user);
        user = entityManagerUser.merge(user);
        return user.getUserId();
    }

    @Override
    @Logged
    public void changePassword(Integer id, String password) {
        User user = entityManagerUser.find(User.class, id);
        user.setPassword(password);
        entityManagerUser.merge(user);
    }

    @Override
    @Logged
    public void changeLogin(Integer id, String login) {
        User user = entityManagerUser.find(User.class, id);
        user.setLogin(login);
        entityManagerUser.merge(user);
    }

    @Override
    @Logged
    public void changeFirstName(Integer id, String firstName) {
        User user = entityManagerUser.find(User.class, id);
        user.setFirstName(firstName);
        entityManagerUser.merge(user);
    }

    @Override
    @Logged
    public void changeLastName(Integer id, String lastName) {
        User user = entityManagerUser.find(User.class, id);
        user.setLastName(lastName);
        entityManagerUser.merge(user);
    }

    @Override
    @Logged
    public void deleteUser(Integer id) {
        try {
            entityManagerUser.remove(getUserById(id));
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new EmptyResultDataAccessException(id);
        }
    }

    @Override
    @Logged
    public List<User> getFriends(Integer id) {

        List<User> list = entityManagerUser.find(User.class, id).getFriends();

        return list;
    }

    @Override
    @Logged
    public List<User> getNoFriends(Integer id) {
        List<User> list = entityManagerUser
                .createQuery(selectNoFriendship, User.class)
                .setParameter("userId", id)
                .getResultList();
        return list;
    }

    @Override
    @Logged
    public List<User> getAllUsers() {
        List<User> list = entityManagerUser
                .createQuery(selectAllUsers, User.class)
                .getResultList();
        return list;
    }

    @Override
    @Logged
    public List<User> getAllUsers(Date dateMin, Date dateMax) {
        List<User> list = entityManagerUser
                .createQuery(SelectAllUsersByDate, User.class)
                .setParameter("dateMin", dateMin)
                .setParameter("dateMax", dateMax)
                .getResultList();
        return list;
    }

    @Override
    @Logged
    public User getUserById(Integer id) {
        return entityManagerUser.find(User.class, id);
    }

    @Override
    @Logged
    public User getUserByLogin(String login) {
        try {
            User user = entityManagerUser
                    .createQuery(selectUserByLogin, User.class)
                    .setParameter("login", login)
                    .getSingleResult();
            return user;
        } catch (NoResultException e) {
            e.printStackTrace();
            throw new EmptyResultDataAccessException(login, 1);
        }
    }

    @Override
    @Logged
    public Integer getCountOfUsers() {
        Long count = (Long) entityManagerUser
                .createQuery(getCountOfUsers)
                .getSingleResult();
        return count.intValue();
    }

    @Override
    @Logged
    public Integer getCountOfUserFriends(Integer id) {
        Long count = (Long) entityManagerUser
                .createQuery(getCountOfUserFriends)
                .setParameter("userId", id)
                .getSingleResult();
        return count.intValue();
    }
}
