package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialSecured;
import com.epam.brest.course2015.social.service.SocialSecurity;
import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alexander on 9.11.15.
 */

@CrossOrigin
@RestController
@Component
public class SocialRestController {

    @Autowired
    private SocialService socialService;
    @Autowired
    private SimpMessagingTemplate socialMessaging;
    @Autowired
    private SocialSecurity socialSecurity;

    @SubscribeMapping("/addeduser")
    @RequestMapping(value = "/user",
                    method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @Logged
    public Integer addUser(@RequestBody User user) {
        Integer addedUserId = socialService.addUser(user);
        /*SocialDto dto = socialService.getSocialUsersDto();
        Integer totalUsers = dto.getTotalUsers();
        user.setUserId(addedUserId);
        socialMessaging.convertAndSend("/topic/addeduser", user);
        socialMessaging.convertAndSend("/topic/totalusers", totalUsers);*/
        return addedUserId;

    }

    @RequestMapping(value = "/user/{action}",
                    method = RequestMethod.POST)
    @Logged
    @SocialSecured
    public void userActions(@PathVariable String action,
                            @RequestBody String token,
                            @RequestParam(value = "param")
                                         String param) {
            Integer id = socialSecurity.getUserId(token);
            switch (action) {
                case "password":
                    socialService.changePassword(id, param);
                    break;
                case "firstname":
                    socialService.changeFirstName(id, param);
                    break;
                case "lastname":
                    socialService.changeLastName(id, param);
                    break;
                case "login":
                    socialService.changeLogin(id, param);
                    break;
                default: throw new IllegalArgumentException("You have chosen wrong option");
            }
    }

 /*   // Not implemented
    @RequestMapping(value = "/user/login",
                    method = RequestMethod.PUT)
    @Logged
    public void changeLogin(@RequestParam(value = "id")
                                          Integer id,
                            @RequestParam(value = "login")
                                          String login) {
        socialService.changeLogin(id, login);
    }

    // Not implemented
    @RequestMapping(value = "/user/firstname",
                    method = RequestMethod.PUT)
    @Logged
    public void changeFirstName(@RequestParam(value = "id")
                                              Integer id,
                                @RequestParam(value = "firstname")
                                              String firstname) {
        socialService.changeFirstName(id, firstname);
    }

    // Not implemented
    @RequestMapping(value = "/user/lastname",
                    method = RequestMethod.PUT)
    @Logged
    public void changeLastName(@RequestParam(value = "id")
                                             Integer id,
                               @RequestParam(value = "lastname")
                                             String lastname) {
        socialService.changeLastName(id, lastname);
    }*/

    // Not implemented
    @RequestMapping(value = "/user",
                    method = RequestMethod.DELETE)
    @Logged
    public void deleteUser(@RequestParam(value = "id")
                                         Integer id) {

        socialService.deleteUser(id);

    }

    // Not implemented
    @RequestMapping(value = "/user/friendship",
                    method = RequestMethod.DELETE)
    @Logged
    public void discardFriendship(@RequestParam(value = "id1")
                                                 Integer id1,
                                   @RequestParam(value = "id2")
                                                 Integer id2) {
        socialService.discardFriendship(new User(id1), new User(id2));
    }

    // Not implemented
    @RequestMapping(value = "/user/friendship",
                    method = RequestMethod.POST)
    @Logged
    public void addFriendship(@RequestParam(value = "id1")
                                            Integer id1,
                              @RequestParam(value = "id2")
                                            Integer id2) {
        socialService.addFriendship(new User(id1), new User(id2));
    }

    @RequestMapping(value = "/userdtobydate",
                    method = RequestMethod.POST)
    @Logged
    @SocialSecured
    public SocialDto getUsersDtoByDate(
            @RequestBody String token,
            @RequestParam("datemin") String dateMin,
            @RequestParam("datemax") String dateMax) {
            Date date1 = getDate(dateMin);
            Date date2 = getDate(dateMax);
            return socialService.getSocialUsersDtoByDate(date1
                                                       , date2);
    }

    @RequestMapping(value = "/userdto",
            method = RequestMethod.POST)
    @Logged
    @SocialSecured
    public SocialDto getUserDto(@RequestBody String token) {
            return socialService.getSocialUsersDto();
    }

    @RequestMapping(value = "/friendsdto",
            method = RequestMethod.POST)
    @Logged
    public SocialDto getFriendsDto(@RequestBody String token) {

        if (socialSecurity.isTokenValid(token)) {
            Integer id = socialSecurity.getUserId(token);
            return socialService.getSocialFriendsDto(id);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/nofriendsdto",
            method = RequestMethod.POST)
    @Logged
    public SocialDto getNoFriendsDto(@RequestBody String token) {
        if (socialSecurity.isTokenValid(token)) {
            Integer id = socialSecurity.getUserId(token);
            return socialService.getSocialNoFriendsDto(id);
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/user/db",
                    method = RequestMethod.POST)
    @Logged
    public boolean isUserValid(@RequestBody User user) {
        String login = user.getLogin();
        String password = user.getPassword();

        if (login != null &&
            password != null) {
                User userByLogin = socialService.getUserByLogin(login);
                if (userByLogin != null &&
                    password.equals(userByLogin.getPassword())) {
                    return true;
                } else {
                    return false;
                }
        } else {
            return false;
        }

    }
    @RequestMapping("/token")
    @Logged
    public String getToken(@RequestParam("login") String login) {

        User user = socialService.getUserByLogin(login);
        if (user != null) {
            Integer userId = user.getUserId();
            String socialToken = socialSecurity.getToken(userId);
            if (socialToken == null) {
                return socialSecurity.generateSecurityToken(userId);
            } else if(socialSecurity.isTokenValid(socialToken)) {
                return socialToken;
            }
            else {
                return socialSecurity.generateSecurityToken(userId);
            }
        } else {
            return null;
        }
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
    @SubscribeMapping(value = "/hello")
    @Logged
    public User sayHello (String name) {
        return new User("login", "paswrd", "Alex", "Borohov", 30);
    }
}
