package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

/**
 * Created by alexander on 26.10.15.
 */
public class FriendshipDaoImpl implements FriendshipDao {
    private static final Logger LOGGER = LogManager.getLogger();
    @Value("${friend.addFriendship}")
    private String addFriendship;
    @Value("${friend.findFriendship}")
    private String findFriendship;
    @Value("${friend.discardFriendship}")
    private String deleteFriendship;
    @Value("${friend.selectAllFriendship}")
    private String getAllFriendships;
    @Value("${friend.deleteAllFriendships}")
    private String deleteAllFriendshipsOfAUser;

    private RowMapper<Friendship> friendshipRowMapper =
            new BeanPropertyRowMapper<>(Friendship.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void addFriendship(User friend1, User friend2) {
        LOGGER.debug("friendshipDao: Adding friendship of users: {}, {}",
                      friend1.getUserId(), friend2.getUserId());
        Friendship friendship12 = new Friendship(friend1.getUserId(),
                                                 friend2.getUserId());
        BeanPropertySqlParameterSource parameterSource12 =
                new BeanPropertySqlParameterSource(friendship12);
        namedParameterJdbcTemplate.update(addFriendship, parameterSource12);
        Friendship friendship21 = new Friendship(friend2.getUserId(),
                                                 friend1.getUserId());
        BeanPropertySqlParameterSource parameterSource21 =
                new BeanPropertySqlParameterSource(friendship21);
        namedParameterJdbcTemplate.update(addFriendship, parameterSource21);
    }

    @Override
    public boolean isAFriend(User user1, User user2) {
        LOGGER.debug("friendshipDao: Checking friendship of users: {}, {}",
                      user1.getUserId(), user2.getUserId());
        Friendship friendship = new Friendship (user1.getUserId(),
                                                user2.getUserId());
        BeanPropertySqlParameterSource source =
                new BeanPropertySqlParameterSource(friendship);
        try {
            Friendship testFriendship = namedParameterJdbcTemplate
                    .queryForObject(findFriendship,
                                    source,
                                    friendshipRowMapper);
            if (testFriendship.getClass().equals(Friendship.class)) {
                return true;
            }
            return false;
        } catch (EmptyResultDataAccessException ex) {

            return false;
        }
    }

    @Override
    public void discardFriendship(User enemy1, User enemy2) {
        LOGGER.debug("friendshipDao: Deleting friendship of users: {}, {}",
                enemy1.getUserId(), enemy2.getUserId());
        Friendship friendship12 = new Friendship(enemy1.getUserId(),
                                                enemy2.getUserId());
        Friendship friendship21 = new Friendship(enemy2.getUserId(),
                                                enemy1.getUserId());
        BeanPropertySqlParameterSource source12 =
                new BeanPropertySqlParameterSource(friendship12);
        BeanPropertySqlParameterSource source21 =
                new BeanPropertySqlParameterSource(friendship21);
        namedParameterJdbcTemplate.update(deleteFriendship, source12);
        namedParameterJdbcTemplate.update(deleteFriendship, source21);
    }

    @Override
    public List<Friendship> getAllFriendships () {
        LOGGER.debug("friendshipDao: Getting all friendships");
        return namedParameterJdbcTemplate.query(getAllFriendships,
                                                friendshipRowMapper);
    }

    @Override
    public void discardAllFriendshipsOfAUser(Integer userId) {
        LOGGER.debug("friendshipDao: Deleting all friendships of a user {}",
                userId);
        SqlParameterSource source = new MapSqlParameterSource("id", userId);
        namedParameterJdbcTemplate.update(deleteAllFriendshipsOfAUser,
                                          source);
    }
}
