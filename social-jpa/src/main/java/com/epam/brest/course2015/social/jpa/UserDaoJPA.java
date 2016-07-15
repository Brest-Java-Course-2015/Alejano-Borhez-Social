package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Value("${user.getCountOfUsers}")
    private String getCountOfUsers;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Logged
    public Integer addUser(User user) {
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        entityManager.persist(user);
        user = entityManager.merge(user);
        return user.getUserId();
    }

    @Override
    @Logged
    public void changePassword(Integer id, String password) {
        User user = entityManager.find(User.class, id);
        user.setPassword(password);
        user.setUpdatedDate(new Date());
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void changeLogin(Integer id, String login) {
        User user = entityManager.find(User.class, id);
        user.setLogin(login);
        user.setUpdatedDate(new Date());
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void changeFirstName(Integer id, String firstName) {
        User user = entityManager.find(User.class, id);
        user.setFirstName(firstName);
        user.setUpdatedDate(new Date());
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void changeLastName(Integer id, String lastName) {
        User user = entityManager.find(User.class, id);
        user.setLastName(lastName);
        user.setUpdatedDate(new Date());
        entityManager.merge(user);
    }

    @Override
    public void addImage(Integer id, Image image) {
        User user = entityManager.find(User.class, id);
        user.getImages().add(image);
        user.setUpdatedDate(new Date());
        entityManager.merge(user);
    }

    @Override
    public void deleteImage(Integer id, Image image) {
        User user = entityManager.find(User.class, id);
        user.getImages().remove(image);
        user.setUpdatedDate(new Date());
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void deleteUser(Integer id) {
        try {
            User deletedUser = entityManager.find(User.class, id);
            List<User> list = deletedUser.getFriends();
            for (User user: list) {
                user.getFriends().remove(deletedUser);
            }
            for (User user: list) {
                entityManager.merge(user);
            }
            entityManager.remove(deletedUser);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new EmptyResultDataAccessException(id);
        }
    }

    @Override
    @Logged
    public List<User> getFriends(Integer id) {

        List<User> list = entityManager.find(User.class, id).getFriends();

        return list;
    }

    @Override
    @Logged
    public List<User> getNoFriends(Integer id) {
        List<User> list = entityManager.find(User.class, id).getFriends();
        List<User> list1 = entityManager
                .createQuery(selectAllUsers, User.class)
                .getResultList();
        list1.removeAll(list);
        list1.remove(getUserById(id));
        return list1;
    }

    @Override
    @Logged
    public List<User> getAllUsers() {
        List<User> list = entityManager
                .createQuery(selectAllUsers, User.class)
                .getResultList();
        return list;
    }

    @Override
    @Logged
    public List<User> getAllUsers(Date dateMin, Date dateMax) {
        List<User> list = entityManager
                .createQuery(SelectAllUsersByDate, User.class)
                .setParameter("dateMin", dateMin)
                .setParameter("dateMax", dateMax)
                .getResultList();
        return list;
    }

    @Override
    @Logged
    public User getUserById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Logged
    public User getUserByLogin(String login) {
        try {
            User user = entityManager
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
        Long count = (Long) entityManager
                .createQuery(getCountOfUsers)
                .getSingleResult();
        return count.intValue();
    }

    @Override
    @Logged
    public Integer getCountOfUserFriends(Integer id) {
        try {
            User user = entityManager.find(User.class, id);
            return user.getFriends().size();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
