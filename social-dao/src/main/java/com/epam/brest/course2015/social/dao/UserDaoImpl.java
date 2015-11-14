package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.User;

import java.util.Date;
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
    @Value("${user.selectAllUsersByDate}")
    String getSelectAllUsersByDate;
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
    @Value("${user.getCountOfUsers}")
    String getCountOfUsers;
    @Value("${user.getCountOfUserFriends}")
    String getCountOfUserFriends;
    @Value("${user.setTotalFriends}")
    String setTotalFriends;

    private RowMapper<User> userMapper = new BeanPropertyRowMapper<>(User.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer addUser(User user) {
        LOGGER.debug("userDao: Adding user {}", user.getLogin());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(addUser, parameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void updateUser(Integer id, String password) {
        LOGGER.debug("userDao: Updating user {}", id);
        User user = new User();
        user.setUserId(id);
        user.setPassword(password);
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(updateUser, parameterSource);
    }

    @Override
    public void deleteUser(Integer id) {
        LOGGER.debug("userDao: Deleting user {}", id);
        SqlParameterSource parameterSource = new MapSqlParameterSource("userId", id);
        namedParameterJdbcTemplate.update(deleteUser, parameterSource);
    }

    @Override
    public List<User> getFriends(Integer id) {
        LOGGER.debug("userDao: Getting friends of user {}", id);
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("userId", id);
        return namedParameterJdbcTemplate.query(selectFriendship, parameterSource, userMapper);
    }

    @Override
    public List<User> getAllUsers() {
        LOGGER.debug("userDao: Getting all users");
        return namedParameterJdbcTemplate.query(selectAllUsers, userMapper);
    }

    @Override
    public List<User> getAllUsers(Date dateMin, Date dateMax) {
        LOGGER.debug("userDao: Getting all users by date");
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("dateMin", dateMin);
        parameterSource.addValue("dateMax", dateMax);
        return namedParameterJdbcTemplate.query(getSelectAllUsersByDate, parameterSource, userMapper);
    }

    @Override
    public User getUserById(Integer id) {
        LOGGER.debug("userDao: Getting user by id: {}", id);
        SqlParameterSource paramSource = new MapSqlParameterSource("userId", id);
        return namedParameterJdbcTemplate.queryForObject(selectUserById, paramSource, userMapper);
    }

    @Override
    public User getUserByLogin(String login) {
        LOGGER.debug("userDao: Getting user by login: {}", login);
        SqlParameterSource parameterSource = new MapSqlParameterSource("login", login);
        return namedParameterJdbcTemplate.queryForObject(selectUserByLogin, parameterSource, userMapper);
    }

    @Override
    public Integer getCountOfUsers() {
        LOGGER.debug("userDao: Getting count of all users");
        SqlParameterSource parameterSource = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.queryForObject(getCountOfUsers, parameterSource, Integer.class);
    }

    @Override
    public Integer getCountOfUserFriends(Integer id) {
        LOGGER.debug("userDao: Getting count of all friends of a user: {}", id);
        SqlParameterSource parameterSource = new MapSqlParameterSource("userId", id);
        return namedParameterJdbcTemplate.queryForObject(getCountOfUserFriends, parameterSource, Integer.class);
    }

    @Override
    public void setCountOfUserFriends(Integer id) {
        LOGGER.debug("userDao: Setting count of all friends of a user: {}", id);
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("totalFriends", getCountOfUserFriends(id));
        source.addValue("userId", id);
        namedParameterJdbcTemplate.update(setTotalFriends, source);
    }
}
