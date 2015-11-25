package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
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

    @RequestMapping(value = "/users",
                    method = RequestMethod.GET)
    public List<User> getAllUsers() {
        LOGGER.debug("rest: Getting all users");
        return socialService.getAllUsers();
    }

    @RequestMapping(value = "/friendships",
                    method = RequestMethod.GET)
    public List<Friendship> getAllFriendships() {
        LOGGER.debug("rest: Getting all friendships");
        return socialService.getAllFriendships();
    }

    @RequestMapping(value = "/user/friends",
                    method = RequestMethod.GET)
    public List<User> getFriends(@RequestParam(value = "id")
                                               Integer id) {
        LOGGER.debug("rest: Getting all friends of user {}", id);
        return socialService.getFriends(id);
    }

    @RequestMapping(value = "/user/nofriends",
                    method = RequestMethod.GET)
    public List<User> getNoFriends(@RequestParam(value = "id")
                                                 Integer id) {
        LOGGER.debug("rest: Getting all no-friends of user {}", id);
        return socialService.getNoFriends(id);
    }

    @RequestMapping(value = "/user",
                    method = RequestMethod.GET)
    public User getUserById(@RequestParam(value = "id")
                                           Integer id) {
        LOGGER.debug("rest: Getting user by id {}", id);
        return socialService.getUserById(id);
    }

    @RequestMapping(value = "/user/login",
                    method = RequestMethod.GET)
    public User getUserByLogin(@RequestParam(value = "login")
                                              String login) {
        LOGGER.debug("rest: Getting user by login {}", login);
        return socialService.getUserByLogin(login);
    }

    @RequestMapping(value = "/user",
                    method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer addUser(@RequestBody User user) {
        LOGGER.debug("rest: Adding new user {}", user.getLogin());
        return socialService.addUser(user);
    }

    @RequestMapping(value = "/user/password",
                    method = RequestMethod.PUT)
    public void changePassword(@RequestParam(value = "id")
                                             Integer id,
                               @RequestParam(value = "password")
                                             String password) {
        LOGGER.debug("rest: Changing password of a user {}", id);
        socialService.changePassword(id, password);
    }

    @RequestMapping(value = "/user/login",
                    method = RequestMethod.PUT)
    public void changeLogin(@RequestParam(value = "id")
                                          Integer id,
                            @RequestParam(value = "login")
                                          String login) {
        LOGGER.debug("rest: Changing login of a user {}", id);
        socialService.changeLogin(id, login);
    }

    @RequestMapping(value = "/user/firstname",
                    method = RequestMethod.PUT)
    public void changeFirstName(@RequestParam(value = "id")
                                              Integer id,
                                @RequestParam(value = "firstname")
                                              String firstname) {
        LOGGER.debug("rest: Changing firstName of a user {}", id);
        socialService.changeFirstName(id, firstname);
    }

    @RequestMapping(value = "/user/lastname",
                    method = RequestMethod.PUT)
    public void changeLastName(@RequestParam(value = "id")
                                             Integer id,
                               @RequestParam(value = "lastname")
                                             String lastname) {
        LOGGER.debug("rest: Changing lastName of a user {}", id);
        socialService.changeLastName(id, lastname);
    }

    @RequestMapping(value = "/user",
                    method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(value = "id")
                                         Integer id) {
        LOGGER.debug("rest: Deleting a user {}", id);
        socialService.deleteUser(id);
        socialService.discardAllFriendshipsOfAUser(id);

    }

    @RequestMapping(value = "/user/friendship",
                    method = RequestMethod.GET)
    public boolean isAFriend(@RequestParam(value = "id1")
                                           Integer id1,
                             @RequestParam(value = "id2")
                                           Integer id2) {
        LOGGER.debug("rest: Checking friendship of users {}, {}",
                                                        id1, id2);
        return socialService.isAFriend(new User(id1), new User(id2));
    }

        @RequestMapping(value = "/user/friendship",
                        method = RequestMethod.DELETE)
    public void discardFriendship(@RequestParam(value = "id1")
                                                 Integer id1,
                                   @RequestParam(value = "id2")
                                                 Integer id2) {
        LOGGER.debug("rest: Discarding friendship of users {}, {}",
                                                          id1, id2);
        socialService.discardFriendship(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/user/friendship",
                    method = RequestMethod.POST)
    public void addFriendship(@RequestParam(value = "id1")
                                            Integer id1,
                              @RequestParam(value = "id2")
                                            Integer id2) {
        LOGGER.debug("rest: Adding friendship of users {}, {}", id1, id2);
        socialService.addFriendship(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/userdto",
                    method = RequestMethod.GET)
    public SocialDto getUsersDto() {
        LOGGER.debug("rest: Getting UserDto");
        return socialService.getSocialUsersDto();
    }

    @RequestMapping(value = "/friendsdto",
                    method = RequestMethod.GET)
    public SocialDto getFriendsDto(@RequestParam(value = "id")
                                                 Integer id) {
        LOGGER.debug("rest: Getting friendsDto");
        return socialService.getSocialFriendsDto(id);
    }

    @RequestMapping(value = "/nofriendsdto",
                    method = RequestMethod.GET)
    public SocialDto getNoFriendsDto(@RequestParam(value = "id")
                                                   Integer id) {
        LOGGER.debug("rest: Getting no-friendsDto");
        return socialService.getSocialNoFriendsDto(id);
    }
}
