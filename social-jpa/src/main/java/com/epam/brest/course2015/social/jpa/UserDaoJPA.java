package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;
import com.epam.brest.course2015.social.test.Logged;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 25.12.15.
 */
public class UserDaoJPA implements UserDao {

    @PersistenceContext(unitName = "social-user")
    private EntityManager entityManager;

    @Override
    @Logged
    public Integer addUser(User user) {

        return 1;
    }

    @Override
    @Logged
    public void changePassword(Integer id, String password) {
        User user = entityManager.find(User.class, id);
        user.setPassword(password);
        entityManager.merge(user);
    }

    @Override
    public void changeLogin(Integer id, String login) {

    }

    @Override
    public void changeFirstName(Integer id, String firstName) {

    }

    @Override
    public void changeLastName(Integer id, String lastName) {

    }

    @Override
    @Logged
    public void deleteUser(Integer id) {
        entityManager.remove(getUserById(id));

    }

    @Override
    public List<User> getFriends(Integer id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> getAllUsers(Date dateMin, Date dateMax) {
        return null;
    }

    @Override
    @Logged
    public User getUserById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public Integer getCountOfUsers() {
        return null;
    }

    @Override
    public Integer getCountOfUserFriends(Integer id) {
        return null;
    }
}
