package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 9.11.15.
 */

@RestController
public class SocialRestController {
    @Autowired
    private SocialService socialService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<User> getAllUsers(/*@RequestParam(value = "crdatemin") Date createdDateMin,
                                                @RequestParam(value = "crdatemax") Date createdDateMa*/) {return socialService.getAllUsers();}

    @RequestMapping(value = "/friendships", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Friendship> getAllFriendships() {return socialService.getAllFriendships();}

    @RequestMapping(value = "/user/friends", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<User> getFriends(@RequestParam(value ="id") Integer id) {
        return socialService.getFriends(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserById (@RequestParam(value = "id") Integer id) {
        return socialService.getUserById(id);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUserByLogin (@RequestParam(value = "login") String login) {
        return socialService.getUserByLogin(login);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody Integer addUser (@RequestBody User user) {
        return socialService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateUser(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "password") String password) {
        socialService.updateUser(id, password);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@RequestParam(value = "id") Integer id) {
        socialService.deleteUser(id);
    }


}
