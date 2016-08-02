package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialSecured;
import com.epam.brest.course2015.social.service.SocialSecurity;
import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alexander on 9.11.15.
 */

@CrossOrigin
@RestController
public class SocialRestController {
    @Value("${role.admin}")
    private String roleAdmin;
    @Value("${role.user}")
    private String roleUser;
    @Value("${role.temp}")
    private String roleTemp;

    @Autowired
    private SocialService socialService;
    @Autowired
    private SimpMessagingTemplate socialMessaging;
    @Autowired
    private SocialSecurity socialSecurity;

    @SubscribeMapping("/addeduser")
    @RequestMapping(value = "/user",
                    method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @Logged
    public boolean addUser(@RequestBody User user) {
        Integer addedUserId = socialService.addUser(user);
        /*SocialDto dto = socialService.getSocialUsersDto();
        Integer totalUsers = dto.getTotalUsers();
        user.setUserId(addedUserId);
        socialMessaging.convertAndSend("/topic/addeduser", user);
        socialMessaging.convertAndSend("/topic/totalusers", totalUsers);*/
        return (addedUserId != null);

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

//  Not implemented
    @RequestMapping(value = "/user",
                    method = RequestMethod.DELETE)
    @Logged
    public void deleteUser(@RequestParam(value = "id")
                                         Integer id) {

        socialService.deleteUser(id);

    }

    @RequestMapping(value = "/friendship/{action}",
                    method = RequestMethod.POST)
    @Logged
    @SocialSecured
    public void discardFriendship(@RequestBody String token,
                                  @RequestParam(value = "id2")
                                                 Integer id2,
                                  @PathVariable("action") String action) {
        Integer id1 = socialSecurity.getUserId(token);
        switch (action) {
            case "delete": socialService.discardFriendship(id1, id2);
                break;
            case "add": socialService.addFriendship(id1, id2);
                break;
            default: throw new IllegalArgumentException("You have chosen wrong option");
        }

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
    @SocialSecured
    public SocialDto getFriendsDto(@RequestBody String token) {
            Integer id = socialSecurity.getUserId(token);
            return socialService.getSocialFriendsDto(id);
    }

    @RequestMapping(value = "/nofriendsdto",
            method = RequestMethod.POST)
    @Logged
    @SocialSecured
    public SocialDto getNoFriendsDto(@RequestBody String token) {
            Integer id = socialSecurity.getUserId(token);
            return socialService.getSocialNoFriendsDto(id);
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
    public String getToken(HttpServletRequest req,
            @RequestParam("login") String login) {
        String role = req.getHeader("Role");

        User user = socialService.getUserByLogin(login);
        if (user != null) {
            Integer userId = user.getUserId();
            String socialToken = socialSecurity.getToken(userId);
            if (socialToken == null || role == null) {
                return socialSecurity.generateSecurityToken(userId, roleTemp);
            } else if(socialSecurity.isTokenValid(socialToken, roleUser, roleAdmin, roleTemp)) {
                return socialToken;
            }
            else {
                return socialSecurity.generateSecurityToken(userId, role);
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

    @RequestMapping("/token/validate")
    @Logged
    public boolean isTokenValid(@RequestBody String token) {
        return socialSecurity.isTokenValid(token, roleUser, roleAdmin);
    }

    @RequestMapping("/token/temp")
    @Logged
    public String tempToken(@RequestBody String token) {
        String newToken = null;
        if (socialSecurity.isTokenValid(token, roleTemp)) {
            newToken = socialSecurity.generateSecurityToken(socialSecurity.getUserId(token), roleUser);
        }
        return newToken;
    }



    @SubscribeMapping(value = "/hello")
    @Logged
    public User sayHello (String name) {
        return new User("login", "paswrd", "Alex", "Borohov", 30, "login@email.com");
    }
}
