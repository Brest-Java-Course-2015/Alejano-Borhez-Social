package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alexander on 26.10.15.
 */
public class FriendshipDaoImpl implements FriendshipDao {
    @Value("${friend.addFriendship}")
    String addFriendship;
    @Value("${friend.findFriendship}")
    String findFriendship;
    @Value("${friend.discardFriendship}")
    String deleteFriendship;
    @Value("${friend.selectAllFriendship}")
    String getAllFriendships;

    private RowMapper<Friendship> friendshipRowMapper = new BeanPropertyRowMapper<>(Friendship.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void addFriendship(User friend1, User friend2) {
        Friendship friendship12 = new Friendship(friend1.getUserId(), friend2.getUserId());
        BeanPropertySqlParameterSource parameterSource12 = new BeanPropertySqlParameterSource(friendship12);
        namedParameterJdbcTemplate.update(addFriendship, parameterSource12);
        Friendship friendship21 = new Friendship(friend2.getUserId(), friend1.getUserId());
        BeanPropertySqlParameterSource parameterSource21 = new BeanPropertySqlParameterSource(friendship21);
        namedParameterJdbcTemplate.update(addFriendship, parameterSource21);
    }

    @Override
    public boolean isAFriend(User user1, User user2) {
        Friendship friendship = new Friendship (user1.getUserId(), user2.getUserId());
        BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(friendship);
        try {
            Friendship testFriendship = namedParameterJdbcTemplate.queryForObject(findFriendship, source, friendshipRowMapper);
            return true;
        } catch (EmptyResultDataAccessException ex) {

            return false;
        }
    }

    @Override
    public void discardFriendship(User enemy1, User enemy2) {
        Friendship friendship12 = new Friendship(enemy1.getUserId(), enemy2.getUserId());
        Friendship friendship21 = new Friendship(enemy2.getUserId(), enemy1.getUserId());
        BeanPropertySqlParameterSource source12 = new BeanPropertySqlParameterSource(friendship12);
        BeanPropertySqlParameterSource source21 = new BeanPropertySqlParameterSource(friendship21);
        namedParameterJdbcTemplate.update(deleteFriendship, source12);
        namedParameterJdbcTemplate.update(deleteFriendship, source21);
    }


    @Override
    public List<Friendship> getAllFriendships () {
        return namedParameterJdbcTemplate.query(getAllFriendships, friendshipRowMapper);
    }
}
