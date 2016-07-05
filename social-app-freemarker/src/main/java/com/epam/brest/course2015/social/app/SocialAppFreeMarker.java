package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alexander_borohov on 27.6.16.
 */
@Controller
public class SocialAppFreeMarker {

    @Value("${rest.prefix}")
    private String restPrefix;

    @Autowired
    private SocialConsumer socialConsumer;

    @RequestMapping("/restAPI")
    @ResponseBody
    public String restPrefix() {
        return restPrefix + "websocket/endpoint";
    }

    @RequestMapping("/hello")
    @Logged
    public ModelAndView sayHello() {
        return new ModelAndView("hello", "hello", socialConsumer.hello());
    }

    @RequestMapping("/")
    public String init() {
        return "redirect:users";
    }

    @RequestMapping("/users")
    @Logged
    public ModelAndView getAllUsers() {
        SocialDto dto = socialConsumer.getAllUsers();
        return new ModelAndView("users", "dto", dto);
    }

    @RequestMapping("/usersbydate")
    @Logged
    public ModelAndView getAllUsersByDate(@RequestParam("datemin")
                                                  String dateMin,
                                          @RequestParam("datemax")
                                                  String dateMax) {
        SocialDto dto = socialConsumer
                .getAllUsersByDate(
                        dateMin
                        , dateMax
                );
        return new ModelAndView("usersbydate", "dto", dto);
    }

    @RequestMapping("/friends")
    @Logged
    public ModelAndView getAllFriends(@RequestParam("id")
                                              Integer id) {
        SocialDto dto = socialConsumer.getAllFriends(id);
        ModelAndView model = new ModelAndView("friends", "dto", dto);
        model.addObject("mapping", "friends");
        return model;
    }

    @RequestMapping("/user/friendship/del")
    @Logged
    public String deleteFriend(@RequestParam("id1")
                                       Integer id1,
                               @RequestParam("id2")
                                       Integer id2) {
        socialConsumer.deleteFriend(id1, id2);
        return "forward:/friends?id=" + id1;
    }

    @RequestMapping("user/friendship/add")
    @Logged
    public String addFriendship(@RequestParam("id1")
                                        Integer id1,
                                @RequestParam("id2")
                                        Integer id2) {
        socialConsumer.addFriendship(id1, id2);
        return "forward:/nofriends?id=" + id1;
    }

    @RequestMapping("/user")
    @Logged
    public ModelAndView getUser(@RequestParam("id")
                                        Integer id) {
        SocialDto dto = socialConsumer.getUser(id);

        ModelAndView model = new ModelAndView("user", "dto", dto);
        model.addObject("mapping", "usertab");
        return model;
    }

    @RequestMapping("/addusersubmit")
    @Logged
    public String addUserSubmit(@RequestBody User user) {
        socialConsumer.addUserSubmit(user);
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
        socialConsumer.deleteUser(id);
        return "forward:/users";
    }

    @RequestMapping("/user/password")
    @Logged
    public String changePassword(@RequestParam("id")
                                         Integer id,
                                 @RequestParam("password")
                                         String password) {
        socialConsumer.changePassword(id, password);
        return "forward:/user?id=" + id;
    }

    @RequestMapping("/user/login")
    @Logged
    public String changeLogin(@RequestParam("id")
                                      Integer id,
                              @RequestParam("login")
                                      String login) {
        socialConsumer.changeLogin(id, login);
        return "forward:/user?id=" + id;
    }

    @RequestMapping(value = "/user/firstname")
    @Logged
    public String changeFirstName(@RequestParam("id")
                                          Integer id,
                                  @RequestParam("firstname")
                                          String firstname) {
        socialConsumer.changeFirstName(id, firstname);
        return "forward:/user?id=" + id;
    }

    @RequestMapping("/user/lastname")
    @Logged
    public String changeLastName(@RequestParam("id")
                                         Integer id,
                                 @RequestParam("lastname")
                                         String lastname) {
        socialConsumer.changeLastName(id, lastname);
        return "forward:/user?id=" + id;
    }

    @RequestMapping("/nofriends")
    @Logged
    public ModelAndView getAllNoFriendsOfAUser(@RequestParam("id")
                                                       Integer id) {

        SocialDto dto = socialConsumer.getAllNoFriendsOfAUser(id);
        return new ModelAndView("nofriends", "dto", dto);
    }

}
