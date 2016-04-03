package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by alexander on 9.11.15.
 */

@CrossOrigin
@RestController
public class SocialRestController {

    private SocialService socialService;
    private SimpMessagingTemplate socialMessaging;

    @Autowired
    public SocialRestController(SocialService socialService, SimpMessagingTemplate socialMessaging) {
        this.socialService = socialService;
        this.socialMessaging = socialMessaging;
    }

    @MessageMapping(value = "/hello")
    @Logged
    public String sayHello (String name) {
        return "Hello, " + name + "!";
    }


    @RequestMapping(value = "/users",
                    method = RequestMethod.GET)
    @Logged
    public List<User> getAllUsers() {
        return socialService.getAllUsers();
    }

    @RequestMapping(value = "/friendships",
                    method = RequestMethod.GET)
    @Logged
    public List<Friendship> getAllFriendships() {
        return socialService.getAllFriendships();
    }

    @RequestMapping(value = "/user/friends",
                    method = RequestMethod.GET)
    @Logged
    public List<User> getFriends(@RequestParam(value = "id")
                                               Integer id) {
        return socialService.getFriends(id);
    }

    @RequestMapping(value = "/user/nofriends",
                    method = RequestMethod.GET)
    @Logged
    public List<User> getNoFriends(@RequestParam(value = "id")
                                                 Integer id) {
        return socialService.getNoFriends(id);
    }

    @RequestMapping(value = "/user",
                    method = RequestMethod.GET)
    @Logged
    public User getUserById(@RequestParam(value = "id")
                                           Integer id) {
        return socialService.getUserById(id);
    }

    @RequestMapping(value = "/user/login",
                    method = RequestMethod.GET)
    @Logged
    public User getUserByLogin(@RequestParam(value = "login")
                                              String login) {
        return socialService.getUserByLogin(login);
    }

    @RequestMapping(value = "/user",
                    method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @Logged
    public Integer addUser(@RequestBody User user) {
        User addedUser = new User(user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getAge());
        socialMessaging.convertAndSend("/topic/update", addedUser);
        return socialService.addUser(addedUser);
    }

    @RequestMapping(value = "/user/password",
                    method = RequestMethod.PUT)
    @Logged
    public void changePassword(@RequestParam(value = "id")
                                             Integer id,
                               @RequestParam(value = "password")
                                             String password) {
        socialService.changePassword(id, password);
    }

    @RequestMapping(value = "/user/login",
                    method = RequestMethod.PUT)
    @Logged
    public void changeLogin(@RequestParam(value = "id")
                                          Integer id,
                            @RequestParam(value = "login")
                                          String login) {
        socialService.changeLogin(id, login);
    }

    @RequestMapping(value = "/user/firstname",
                    method = RequestMethod.PUT)
    @Logged
    public void changeFirstName(@RequestParam(value = "id")
                                              Integer id,
                                @RequestParam(value = "firstname")
                                              String firstname) {
        socialService.changeFirstName(id, firstname);
    }

    @RequestMapping(value = "/user/lastname",
                    method = RequestMethod.PUT)
    @Logged
    public void changeLastName(@RequestParam(value = "id")
                                             Integer id,
                               @RequestParam(value = "lastname")
                                             String lastname) {
        socialService.changeLastName(id, lastname);
    }

    @RequestMapping(value = "/user",
                    method = RequestMethod.DELETE)
    @Logged
    public void deleteUser(@RequestParam(value = "id")
                                         Integer id) {

        socialService.deleteUser(id);
        socialService.discardAllFriendshipsOfAUser(id);

    }

    @RequestMapping(value = "/user/friendship",
                    method = RequestMethod.GET)
    @Logged
    public boolean isAFriend(@RequestParam(value = "id1")
                                           Integer id1,
                             @RequestParam(value = "id2")
                                           Integer id2) {
        return socialService.isAFriend(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/user/friendship",
                    method = RequestMethod.DELETE)
    @Logged
    public void discardFriendship(@RequestParam(value = "id1")
                                                 Integer id1,
                                   @RequestParam(value = "id2")
                                                 Integer id2) {
        socialService.discardFriendship(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/user/friendship",
                    method = RequestMethod.POST)
    @Logged
    public void addFriendship(@RequestParam(value = "id1")
                                            Integer id1,
                              @RequestParam(value = "id2")
                                            Integer id2) {
        socialService.addFriendship(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/userdto",
                    method = RequestMethod.GET)
    @Logged
    public SocialDto getUserDto() {
        return socialService.getSocialUsersDto();
    }

    @RequestMapping(value = "/friendsdto",
                    method = RequestMethod.GET)
    @Logged
    public SocialDto getFriendsDto(@RequestParam(value = "id")
                                                 Integer id) {
        return socialService.getSocialFriendsDto(id);
    }

    @RequestMapping(value = "/nofriendsdto",
                    method = RequestMethod.GET)
    @Logged
    public SocialDto getNoFriendsDto(@RequestParam(value = "id")
                                                   Integer id) {
        return socialService.getSocialNoFriendsDto(id);
    }

    @RequestMapping(value = "/userdtobydate",
            method = RequestMethod.GET)
    @Logged
    public SocialDto getUsersDtoByDate(@RequestParam("datemin")
                                           String dateMin,
                                       @RequestParam("datemax")
                                           String dateMax) {
        Date date1 = getDate(dateMin);
        Date date2 = getDate(dateMax);
        return socialService.getSocialUsersDtoByDate(date1
                                                   , date2);
    }

    @Logged
    private static Date getDate(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
