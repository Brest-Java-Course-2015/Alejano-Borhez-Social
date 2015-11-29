package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alexander on 28.11.15.
 */

@Controller
public class SocialWebController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Value("${rest.prefix}")
    private String restPrefix;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String init() {
        return "redirect:users";
    }

    @RequestMapping("/users")
    public ModelAndView getAllUsers() {
        String url = restPrefix + "userdto";
        SocialDto dto = restTemplate
                        .getForEntity(
                        url
                        , SocialDto.class
                        )
                        .getBody();
        LOGGER.debug("app: users.size: {}", dto.getTotalUsers());
        return new ModelAndView("users", "dto", dto);
    }

    @RequestMapping("/usersbydate")
    public ModelAndView getAllUsersByDate(@RequestParam("datemin")
                                          String dateMin,
                                          @RequestParam("datemax")
                                          String dateMax) {
        String url = restPrefix + "/userdtobydate"
                    + "?datemin="
                    + dateMin
                    + "&datemax="
                    + dateMax;
        SocialDto dto = restTemplate.getForEntity(
                    url
                  , SocialDto.class)
                   .getBody();
        LOGGER.debug("app: userlist by date {} - {}", dateMin, dateMax);
        return new ModelAndView("usersbydate", "dto", dto);
    }

    @RequestMapping("/friends")
    public ModelAndView getAllFriends(@RequestParam("id")
                                      Integer id) {

        String url = restPrefix
                + "/friendsdto"
                + "?id="
                + id;
        SocialDto dto = restTemplate
                .getForEntity(
                 url
                , SocialDto.class)
                .getBody();
        return new ModelAndView("friends", "dto", dto);
    }

    @RequestMapping("/user/friendship/del")
    public String deleteFriend(@RequestParam("id1")
                               Integer id1,
                               @RequestParam("id2")
                               Integer id2) {

        String url = restPrefix
                + "/user/friendship"
                + "?id1="
                + id1
                + "&id2="
                + id2;

        restTemplate.delete(url);
        LOGGER.debug("app: deleted friendship: {}, {}", id1, id2);
        return "forward:/friends?id=" + id1;
    }

    @RequestMapping("user/friendship/add")
    public String addFriendship(@RequestParam("id1")
                                       Integer id1,
                                @RequestParam("id2")
                                       Integer id2) {
        String url = restPrefix
                + "user/friendship"
                + "?id1="
                + id1
                + "&id2="
                + id2;

        restTemplate.postForObject(url, null, String.class);
        LOGGER.debug("app: added friendship: {}, {}", id1, id2);

        return "forward:/nofriends?id=" + id1;

    }

    @RequestMapping("/user")
    public ModelAndView getUser(@RequestParam("id")
                                       Integer id) {
        String url = restPrefix
                + "friendsdto"
                + "?id="
                + id;

        SocialDto dto =
                restTemplate
                .getForEntity(
                        url
                        , SocialDto.class)
                .getBody();
        LOGGER.debug("app: get user by id {}", id);
        return new ModelAndView("user", "dto", dto);

    }

    @RequestMapping("/addusersubmit")
    public String addUserSubmit(@RequestBody User user) {
        LOGGER.debug("app: adding new user");
        String url = restPrefix
                + "user";

        Integer userId = restTemplate
                .postForObject(
                        url
                        , user
                        , Integer.class
                );
        LOGGER.debug("app: added new user, id: {}", userId);

        return "forward:/users";
    }

    @RequestMapping("/adduser")
    public ModelAndView addUser() {
        LOGGER.debug("app: preparing to add new user");
        return new ModelAndView("adduser");
    }

    @RequestMapping("/user/delete")
    public String deleteUser(@RequestParam("id")
                                    Integer id) {
        LOGGER.debug("app: deleting user {}", id);

        String url = restPrefix
                + "user"
                + "?id="
                + id;

        restTemplate.delete(url);

        return "forward:/users";
    }

    @RequestMapping("/user/password")
    public String changePassword(@RequestParam("id")
                                 Integer id,
                                 @RequestParam("password")
                                 String password) {
        LOGGER.debug("app: setting new password of user: {}", id);

        String url = restPrefix
                + "user/password"
                + "?id="
                + id
                + "&password="
                + password;

        restTemplate.put(url, null);

        return "forward:/user?id=" + id;
    }

    @RequestMapping("/user/login")
    public String changeLogin(@RequestParam("id")
                              Integer id,
                              @RequestParam("login")
                              String login) {
        LOGGER.debug("app: setting new login of user: {}", id);
        String url = restPrefix
                + "user/login"
                + "?id="
                + id
                + "&login="
                + login;

        restTemplate.put(url, null);

        return "forward:/user?id=" + id;
    }

    @RequestMapping(value = "/user/firstname")
    public String changeFirstName(@RequestParam("id")
                                         Integer id,
                                  @RequestParam("firstname")
                                          String firstname) {
        LOGGER.debug("app: setting new firstname of user: {}", id);

        String url = restPrefix
                + "user/firstname"
                + "?id="
                + id
                + "&firstname="
                + firstname;

        restTemplate.put(url, null);

        return "forward:/user?id=" + id;
    }

    @RequestMapping("/user/lastname")
    public String changeLastName(@RequestParam("id")
                                        Integer id,
                                 @RequestParam("lastname")
                                         String lastname) {
        LOGGER.debug("app: setting new lastname of user: {}", id);

        String url = restPrefix
                + "user/lastname"
                + "?id="
                + id
                + "&lastname="
                + lastname;

        restTemplate.put(url, null);

        return "forward:/user?id=" + id;
    }

    @RequestMapping("/nofriends")
    public ModelAndView getAllNoFriendsOfAUser(@RequestParam("id")
                                                      Integer id) {
        LOGGER.debug("app: getting all no-friends of a user {}", id);

        String url = restPrefix
                + "/nofriendsdto"
                + "?id="
                + id;

        SocialDto dto = restTemplate
                .getForObject(url, SocialDto.class);
        return new ModelAndView("nofriends", "dto", dto);
    }

}
