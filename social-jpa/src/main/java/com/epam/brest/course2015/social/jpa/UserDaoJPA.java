package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.UserDao;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 25.12.15.
 */
public class UserDaoJPA implements UserDao {
    @Value("${user.selectAllUsers}")
    private String selectAllUsers;
    @Value("${user.selectAllUsersByDate}")
    private String getSelectAllUsersByDate;
    @Value("${user.selectById}")
    private String selectUserById;
    @Value("${user.selectByLogin}")
    private String selectUserByLogin;
    @Value("${user.deleteUser}")
    private String deleteUser;
    @Value("${user.addUser}")
    private String addUser;
    @Value("${user.changePassword}")
    private String changePassword;
    @Value("${user.changeLogin}")
    private String changeLogin;
    @Value("${user.changeFirstName}")
    private String changeFirstName;
    @Value("${user.changeLastName}")
    private String changeLastName;
    @Value("${friend.findFriends}")
    private String selectFriendship;
    @Value("${user.getCountOfUsers}")
    private String getCountOfUsers;
    @Value("${user.getCountOfUserFriends}")
    private String getCountOfUserFriends;

    @PersistenceContext(unitName = "social-user")
    private EntityManager entityManager;

    @Override
    @Logged
    public Integer addUser(User user) {
        entityManager.persist(user);
        user = entityManager.merge(user);
        return user.getUserId();
    }

    @Override
    @Logged
    public void changePassword(Integer id, String password) {
        User user = entityManager.find(User.class, id);
        user.setPassword(password);
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void changeLogin(Integer id, String login) {
        User user = entityManager.find(User.class, id);
        user.setLogin(login);
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void changeFirstName(Integer id, String firstName) {
        User user = entityManager.find(User.class, id);
        user.setFirstName(firstName);
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void changeLastName(Integer id, String lastName) {
        User user = entityManager.find(User.class, id);
        user.setLastName(lastName);
        entityManager.merge(user);
    }

    @Override
    @Logged
    public void deleteUser(Integer id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    @Logged
    public List<User> getFriends(Integer id) {
        List<User> list = entityManager
                .createNativeQuery(selectFriendship, User.class)
                .setParameter("userId", id)
                .getResultList();
        return list;
    }

    @Override
    @Logged
    public List<User> getAllUsers() {
        List<User> list = entityManager
                .createNativeQuery(selectAllUsers, User.class)
                .getResultList();
        return list;
    }

    @Override
    @Logged
    public List<User> getAllUsers(Date dateMin, Date dateMax) {
        List<User> list = entityManager
                .createNativeQuery(getSelectAllUsersByDate, User.class)
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

//    Временные костыли
    @Override
    @Logged
    public User getUserByLogin(String login) {
        List<User> user = entityManager
                .createNativeQuery(selectUserByLogin, User.class)
                .setParameter("login", login)
                .getResultList();
        return user.get(0);
    }

    @Override
    @Logged
    public Integer getCountOfUsers() {
        BigInteger big = (BigInteger) entityManager
                .createNativeQuery(getCountOfUsers)
                .getSingleResult();
        return big.intValue();
    }

    @Override
    @Logged
    public Integer getCountOfUserFriends(Integer id) {
        BigInteger big = (BigInteger) entityManager
                .createNativeQuery(getCountOfUserFriends)
                .setParameter("userId", id)
                .getSingleResult();
        return big.intValue();
    }
}
