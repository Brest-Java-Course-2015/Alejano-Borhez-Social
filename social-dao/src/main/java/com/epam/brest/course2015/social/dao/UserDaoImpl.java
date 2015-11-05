package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * Created by alexander on 25.10.15.
 */
public class UserDaoImpl implements UserDao {
    public static final Logger LOGGER = LogManager.getLogger();
    @Value("${user.selectAllUsers}")
    String selectAllUsers;
    @Value("${user.selectById}")
    String selectUserById;
    @Value("${user.selectByLogin}")
    String selectUserByLogin;
    @Value("${user.deleteUser}")
    String deleteUser;
    @Value("${user.addUser}")
    String addUser;
    @Value("${user.updateUser}")
    String updateUser;
    @Value("${friend.findFriends}")
    String selectFriendship;

    private RowMapper<User> userMapper = new BeanPropertyRowMapper<>(User.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer addUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(addUser, parameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void updateUser(Integer id, String password) {
        User user = new User();
        user.setUserId(id);
        user.setPassword(password);
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(updateUser, parameterSource);
    }

    @Override
    public void deleteUser(Integer id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("userId", id);
        namedParameterJdbcTemplate.update(deleteUser, parameterSource);
    }

    @Override
    public List<User> getFriends(Integer id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("userId", id);
        return namedParameterJdbcTemplate.query(selectFriendship, parameterSource, userMapper);
    }

    @Override
    public List<User> getAllUsers() {
        return namedParameterJdbcTemplate.query(selectAllUsers, userMapper);
    }

    @Override
    public User getUserById(Integer id) {
        SqlParameterSource paramSource = new MapSqlParameterSource("userId", id);
        return namedParameterJdbcTemplate.queryForObject(selectUserById, paramSource, userMapper);
    }

    @Override
    public User getUserByLogin(String login) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("login", login);
        return namedParameterJdbcTemplate.queryForObject(selectUserByLogin, parameterSource, userMapper);
    }
}
