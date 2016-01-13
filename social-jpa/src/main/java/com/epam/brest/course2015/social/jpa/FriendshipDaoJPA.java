package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dao.FriendshipDao;
import com.epam.brest.course2015.social.test.Logged;
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
    @PersistenceContext(unitName = "social-friendship")
    EntityManager entityManagerFriendship;

    @Override
    @Logged
    public void addFriendship(User friend1, User friend2) {
        Friendship friendship1 = new Friendship(friend1.getUserId(),
                                               friend2.getUserId());
        entityManagerFriendship.persist(friendship1);
        Friendship friendship2 = new Friendship(friend2.getUserId(),
                                                friend1.getUserId());
        entityManagerFriendship.persist(friendship2);
    }

    @Override
    @Logged
    public boolean isAFriend(User user1, User user2) {
        List<Friendship> friendships = null;
        friendships = entityManagerFriendship.createQuery(
            "select f from Friendship f where f.friend1Id = :friend1Id and f.friend2Id = :friend2Id",
            Friendship.class)
            .setParameter("friend1Id", user1.getUserId())
            .setParameter("friend2Id", user2.getUserId())
            .getResultList();
        if (friendships.size() == 0) return false;
        else return true;
    }


    @Override
    @Logged
    public void discardFriendship(User enemy1, User enemy2) {
        entityManagerFriendship.createQuery(
                "delete Friendship f where f.friend1Id = :friend1Id and f.friend2Id = :friend2Id"
        ).setParameter("friend1Id", enemy1.getUserId())
         .setParameter("friend2Id", enemy2.getUserId())
         .executeUpdate();

        entityManagerFriendship.createQuery(
                "delete Friendship f where f.friend1Id = :friend2Id and f.friend2Id = :friend1Id"
        ).setParameter("friend1Id", enemy1.getUserId())
         .setParameter("friend2Id", enemy2.getUserId())
         .executeUpdate();
    }

    @Override
    @Logged
    public List<Friendship> getAllFriendships() {
        return entityManagerFriendship.createQuery("select f from Friendship f", Friendship.class)
                .getResultList();
    }

    @Override
    @Logged
    public void discardAllFriendshipsOfAUser(Integer userId) {
        entityManagerFriendship.createQuery("delete from Friendship f where f.friend1Id = :userId or f.friend2Id = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }
}
