package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * Created by alexander on 26.10.15.
 */
public class FriendshipDaoImpl implements FriendshipDao {
    @Value("${friend.addFriendship}")
    String addFriendship;

    RowMapper<Friendship> friendshipRowMapper = new BeanPropertyRowMapper<>(Friendship.class);

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
        return false;
    }

    @Override
    public void discardFriendship(User enemy1, User enemy2) {

    }

    @Override
    public Integer[] listOfFriendsId(User user) {
        return new Integer[0];
    }

    @Override
    public List<User> getFriends(User user) {
        return null;
    }
}
