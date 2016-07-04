package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexander on 13.1.16.
 */
@Repository
@Transactional("transactionManagerFriendship")
public class FriendshipDaoJPA implements FriendshipDao {
    @Value("${friend.findFriendship}")
    private String selectFriendship;
    @Value("${friend.discardFriendship}")
    private String deleteFriendship;
    @Value("${friend.selectAllFriendship}")
    private String selectAllFriendships;
    @Value("${friend.deleteAllFriendships}")
    private String deleteAllFriendships;

    @PersistenceContext(unitName = "social-friendship")
    EntityManager entityManagerFriendship;

    @Override
    @Logged
    public void addFriendship(User friend1, User friend2) {
        entityManagerFriendship.persist(new Friendship(friend1.getUserId(),
                friend2.getUserId()));
        entityManagerFriendship.persist(new Friendship(friend2.getUserId(),
                friend1.getUserId()));
    }

    @Override
    @Logged
    public boolean isAFriend(User user1, User user2) {
        List<Friendship> friendships = null;
        friendships = entityManagerFriendship
                .createQuery(selectFriendship,
                        Friendship.class)
            .setParameter("friend1Id", user1.getUserId())
            .setParameter("friend2Id", user2.getUserId())
            .getResultList();
        if (friendships.size() == 0) return false;
        else if (friendships.size() == 1) return true;
        else return false;
    }


    @Override
    @Logged
    public void discardFriendship(User enemy1, User enemy2) {
        entityManagerFriendship.createQuery(
                deleteFriendship
        ).setParameter("friend1Id", enemy1.getUserId())
         .setParameter("friend2Id", enemy2.getUserId())
         .executeUpdate();

        entityManagerFriendship.createQuery(
                deleteFriendship
        ).setParameter("friend1Id", enemy2.getUserId())
         .setParameter("friend2Id", enemy1.getUserId())
         .executeUpdate();
    }

    @Override
    @Logged
    public List<Friendship> getAllFriendships() {
        return entityManagerFriendship.createQuery(selectAllFriendships, Friendship.class)
                .getResultList();
    }

    @Override
    @Logged
    public void discardAllFriendshipsOfAUser(Integer userId) {
        entityManagerFriendship.createQuery(deleteAllFriendships)
                .setParameter("userId", userId)
                .executeUpdate();
    }
}
