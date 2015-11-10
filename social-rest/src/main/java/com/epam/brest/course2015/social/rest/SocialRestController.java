package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.service.SocialService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexander on 9.11.15.
 */

@RestController
public class SocialRestController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private SocialService socialService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<User> getAllUsers(/*@RequestParam(value = "crdatemin") Date createdDateMin,
                                                @RequestParam(value = "crdatemax") Date createdDateMa*/) {
        LOGGER.debug("rest: Getting all users");
        return socialService.getAllUsers();}

    @RequestMapping(value = "/friendships", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Friendship> getAllFriendships() {
        LOGGER.debug("rest: Getting all friendships");
        return socialService.getAllFriendships();}

    @RequestMapping(value = "/user/friends", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<User> getFriends(@RequestParam(value ="id") Integer id) {
        LOGGER.debug("rest: Getting all friends of user {}", id);
        return socialService.getFriends(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserById (@RequestParam(value = "id") Integer id) {
        LOGGER.debug("rest: Getting user by id {}", id);
        return socialService.getUserById(id);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserByLogin (@RequestParam(value = "login") String login) {
        LOGGER.debug("rest: Getting user by login {}", login);
        return socialService.getUserByLogin(login);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Integer addUser (@RequestBody User user) {
        LOGGER.debug("rest: Adding new user {}", user.getLogin());
        return socialService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateUser(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "password") String password) {
        LOGGER.debug("rest: Updating a user {}", id);
        socialService.updateUser(id, password);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@RequestParam(value = "id") Integer id) {
        LOGGER.debug("rest: Deleting a user {}", id);
        socialService.deleteUser(id);
        socialService.discardAllFriendshipsOfAUser(id);
    }

    @RequestMapping(value = "/user/friendship", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public boolean isAFriend(@RequestParam(value = "id1") Integer id1,
                             @RequestParam(value = "id2") Integer id2) {
        LOGGER.debug("rest: Checking friendship of users {}, {}", id1, id2);
        return socialService.isAFriend(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/user/friendship", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void discardFriendship (@RequestParam(value = "id1") Integer id1,
                                   @RequestParam(value = "id2") Integer id2) {
        LOGGER.debug("rest: Discarding friendship of users {}, {}", id1, id2);
        socialService.discardFriendship(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/user/friendship", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addFriendship(@RequestParam(value = "id1") Integer id1,
                              @RequestParam(value = "id2") Integer id2) {
        LOGGER.debug("rest: Adding friendship of users {}, {}", id1, id2);
        socialService.addFriendship(new User(id1), new User(id2));
    }


}
