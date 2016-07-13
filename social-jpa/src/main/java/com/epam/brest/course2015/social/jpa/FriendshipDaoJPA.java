package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alexander on 13.1.16.
 */
@Repository
@Component
@Transactional
public class FriendshipDaoJPA implements FriendshipDao {

    @PersistenceContext
    EntityManager entityManager;

    @Value("${friends.getAllFriendships}")
    private String getAllFriendship;

    @Override
    @Logged
    public void addFriendship(User friend1, User friend2) {
            User user1 = entityManager.find(User.class, friend1.getUserId());
            User user2 = entityManager.find(User.class, friend2.getUserId());

            user1.getFriends().add(user2);
            user2.getFriends().add(user1);
            entityManager.merge(user1);
            entityManager.merge(user2);
    }

    @Override
    @Logged
    public boolean isAFriend(User user1, User user2) {
        User user11 = entityManager.find(User.class, user1.getUserId());
        User user21 = entityManager.find(User.class, user2.getUserId());
        return user11.getFriends().contains(user21) && user21.getFriends().contains(user11);
    }


    @Override
    @Logged
    public void discardFriendship(User enemy1, User enemy2) {
        User user1 = entityManager.find(User.class, enemy1.getUserId());
        User user2 = entityManager.find(User.class, enemy2.getUserId());

        user1.getFriends().remove(user2);
        user2.getFriends().remove(user1);

        entityManager.merge(user1);
        entityManager.merge(user2);
    }

    @Override
    @Logged
    public List<Friendship> getAllFriendships() {
        return entityManager.createQuery(getAllFriendship, Friendship.class).getResultList();
    }

    @Override
    @Logged
    public void discardAllFriendshipsOfAUser(Integer userId) {

    }
}
