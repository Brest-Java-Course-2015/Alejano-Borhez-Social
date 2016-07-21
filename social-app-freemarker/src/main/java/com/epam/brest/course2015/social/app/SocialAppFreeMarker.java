package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by alexander_borohov on 27.6.16.
 */
@Controller
public class SocialAppFreeMarker {

    @Value("${rest.prefix}")
    private String restPrefix;
    @Value("${security.uid}")
    private String uid;


    @Autowired
    private SocialConsumer socialConsumer;

    @RequestMapping("/restAPI")
    @ResponseBody
    @Logged
    public String restPrefix() {
        return restPrefix + "websocket/endpoint";
    }

    @RequestMapping("/hello2")
    @Logged
    public ModelAndView sayHelloAgain(HttpServletRequest req,
                                      HttpServletResponse resp) {

        ModelAndView model = new ModelAndView("hello", "hello", socialConsumer.hello());


        return model;

    }

    @RequestMapping("/hello")
    @Logged
    public ModelAndView sayHello(HttpServletRequest req,
                                 HttpServletResponse resp) throws IOException {

        ModelAndView model = new ModelAndView("hello", "hello", socialConsumer.hello());

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            String userId = "";

            for (Cookie cookie : cookies) {
                if (uid.equals(cookie.getName())) {
                    model.addObject(uid, cookie.getValue());
                    userId = cookie.getValue();
                }
            }

            if (!uid.isEmpty()) {
                model.addObject("dto", socialConsumer.getAllUsers());
            } else {
                resp.sendRedirect("login");
                return model;
            }

        } else {
            resp.sendRedirect("login");
            return model;
        }
        return model;
    }

    @RequestMapping("/user")
    @Logged
    public ModelAndView getUser(HttpServletRequest req,
                                HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        ModelAndView mav = new ModelAndView("user");

        if (cookies != null) {
            for (Cookie cookie: cookies) {
                mav.addObject("cookie", uid);
                if ((uid.toString()).equals(cookie.getName().toString())) {
                    String token = cookie.getValue().toString();
                    SocialDto dto = socialConsumer.getUserDto(token);
                    mav.addObject("dto", dto);
                    mav.addObject("header", cookie.getValue());
                    mav.addObject("mapping", "usertab");
                    return mav;
                }
            }
        }

        resp.sendRedirect("login");
        return mav;
    }


    @RequestMapping("/")
    @Logged
    public String init(HttpServletRequest req,
                       HttpServletResponse resp) {

            return "redirect:/login";


    }

    @RequestMapping("/login")
    @Logged
    public ModelAndView login() {



        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginapprove", method = RequestMethod.POST)
    @Logged
    public ModelAndView loginApprove(HttpServletResponse resp,
                                     HttpServletRequest req,
                                     @ModelAttribute("user") User user) throws IOException {

// Checking for a user from DataBase

        User userFromDB = socialConsumer.getUser(user.getLogin());

        if (userFromDB != null && user.getLogin().equals(userFromDB.getLogin()) &&
            user.getPassword().equals(userFromDB.getPassword())) {

// Creating a token
            String token = socialConsumer.getToken(user.getLogin());
// Setting a Cookie

            Cookie cookie = new Cookie("uid", token);
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);

// Proceed to Hello page

            SocialDto dto = socialConsumer.getAllUsers();
            ModelAndView model = new ModelAndView("hello", "dto", dto);
            resp.sendRedirect("user");
            return model;
        }
        else {
            resp.sendRedirect("login");
            return new ModelAndView("login");
        }
    }

    @RequestMapping("/users")
    @Logged
    public ModelAndView getAllUsers() {
        SocialDto dto = socialConsumer.getAllUsers();
        ModelAndView model = new ModelAndView("users", "dto", dto);
        model.addObject("mapping", "users");
        return model;
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

    @RequestMapping("/messages")
    @Logged
    public ModelAndView getMessages(@RequestParam("id") Integer id) {
        return new ModelAndView("messages");
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



    @RequestMapping("/photo")
    @Logged
    public ModelAndView getPhoto(@RequestParam("id")
                                 Integer id) {
//        SocialDto dto = socialConsumer.getUser(id);
//
//        ModelAndView model = new ModelAndView("photo", "dto", dto);
//        model.addObject("mapping", "phototab");
//        return model;
        return null;
    }

    @RequestMapping("/addusersubmit")
    @Logged
    public String addUserSubmit(@ModelAttribute("user") User user) {
        socialConsumer.addUserSubmit(user);
        return "redirect:/users";
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
        ModelAndView model = new ModelAndView("nofriends", "dto", dto);
        model.addObject("mapping", "nofriends");
        return model;
    }

   /* @RequestMapping("/vk")
    @Logged
    public ModelAndView getVKStyle(@RequestParam("id") Integer id) {
        SocialDto dto = socialConsumer.getUser(id);
        ModelAndView model = new ModelAndView("vk", "dto", dto);
        model.addObject("mapping", "vk");
        return model;

    }*/
}
