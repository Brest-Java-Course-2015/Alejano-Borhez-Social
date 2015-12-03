package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
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

    @Value("${rest.prefix}")
    private String restPrefix;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String init() {
        return "redirect:users";
    }

    @RequestMapping("/users")
    @Logged
    public ModelAndView getAllUsers() {
        String url = restPrefix + "userdto";
        SocialDto dto = restTemplate
                        .getForEntity(
                        url
                        , SocialDto.class
                        )
                        .getBody();
        return new ModelAndView("users", "dto", dto);
    }

    @RequestMapping("/usersbydate")
    @Logged
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
        return new ModelAndView("usersbydate", "dto", dto);
    }

    @RequestMapping("/friends")
    @Logged
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
    @Logged
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
        return "forward:/friends?id=" + id1;
    }

    @RequestMapping("user/friendship/add")
    @Logged
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

        return "forward:/nofriends?id=" + id1;

    }

    @RequestMapping("/user")
    @Logged
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
        return new ModelAndView("user", "dto", dto);

    }

    @RequestMapping("/addusersubmit")
    @Logged
    public String addUserSubmit(@RequestBody User user) {
        String url = restPrefix
                + "user";

        Integer userId = restTemplate
                .postForObject(
                        url
                        , user
                        , Integer.class
                );

        return "forward:/users";
    }

    @RequestMapping("/adduser")
    @Logged
    public ModelAndView addUser() {
        return new ModelAndView("adduser");
    }

    @RequestMapping("/user/delete")
    @Logged
    public String deleteUser(@RequestParam("id")
                                    Integer id) {

        String url = restPrefix
                + "user"
                + "?id="
                + id;

        restTemplate.delete(url);

        return "forward:/users";
    }

    @RequestMapping("/user/password")
    @Logged
    public String changePassword(@RequestParam("id")
                                 Integer id,
                                 @RequestParam("password")
                                 String password) {

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
    @Logged
    public String changeLogin(@RequestParam("id")
                              Integer id,
                              @RequestParam("login")
                              String login) {
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
    @Logged
    public String changeFirstName(@RequestParam("id")
                                         Integer id,
                                  @RequestParam("firstname")
                                          String firstname) {

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
    @Logged
    public String changeLastName(@RequestParam("id")
                                        Integer id,
                                 @RequestParam("lastname")
                                         String lastname) {

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
    @Logged
    public ModelAndView getAllNoFriendsOfAUser(@RequestParam("id")
                                                      Integer id) {

        String url = restPrefix
                + "/nofriendsdto"
                + "?id="
                + id;

        SocialDto dto = restTemplate
                .getForObject(url, SocialDto.class);
        return new ModelAndView("nofriends", "dto", dto);
    }

}
