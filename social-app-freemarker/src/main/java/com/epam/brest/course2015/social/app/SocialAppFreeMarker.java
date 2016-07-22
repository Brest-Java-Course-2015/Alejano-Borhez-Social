package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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


    @RequestMapping("/")
    @Logged
    public String init(@CookieValue(name = "uid", required = false) Cookie cookie,
                       HttpServletResponse resp) {
            return "redirect:/login";
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


    @RequestMapping("/login")
    @Logged
    public ModelAndView login(HttpServletRequest req,
                              HttpServletResponse resp) {
        String referrer = req.getHeader("Referer");
        Cookie cookie = new Cookie(uid, "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginapprove", method = RequestMethod.POST)
    @Logged
    public String loginApprove(HttpServletResponse resp,
                               HttpServletRequest req,
                               @ModelAttribute("user") User user) throws IOException {
// Checking for a user from DataBase
        if (socialConsumer.isUserInDB(user)) {

// Generating or receiving existing token
            String token = socialConsumer.getToken(user.getLogin());
// Setting a Cookie
            Cookie cookie = new Cookie("uid", token);
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);
// Proceed to User page
            return "redirect:user";
        }
        else {
// Proceed to Login Page
            return "redirect:login";
        }
    }

    @RequestMapping("/usersbydate")
    @Logged
    public ModelAndView getAllUsersByDate(
            @CookieValue(name = "uid", required = false) Cookie cookie,
            HttpServletResponse resp,
            @RequestParam("datemin") String dateMin,
            @RequestParam("datemax") String dateMax) throws IOException {
        ModelAndView mav = new ModelAndView("usersbydate");
        if (cookie != null) {
            String token = cookie.getValue();
            SocialDto dto = socialConsumer
                    .getAllUsersByDate(token, dateMin, dateMax);
            if (dto != null) {
                mav.addObject("dto", dto);
                mav.addObject("mapping", "usersbydatetab");
                return mav;
            }
        }
        resp.sendRedirect("login");
        return mav;
    }

    @RequestMapping(name = "user/{action}",
                    method = RequestMethod.PUT)
    @Logged
    public void userActions(
            @PathVariable("action") String action,
            @RequestParam("param") String param,
            @CookieValue(name = "uid", required = false) Cookie cookie,
            HttpServletRequest req,
            HttpServletResponse resp
    ) {
        if (cookie !=null) {
            Integer token = 1;
            switch (action) {
                case "login":
                    socialConsumer.changeLogin(token, param);
                break;
                case "password":
                    socialConsumer.changePassword(token, param);
                break;
                case "firstname":
                    socialConsumer.changeFirstName(token, param);
                break;
                case "lastname":
                    socialConsumer.changeLastName(token, param);
                break;
                default: throw new IllegalArgumentException("You have chosen wrong option to do with user");
            }
        }

    }


    @RequestMapping("/{mapping}")
    @Logged
    public ModelAndView genericDto(
            @PathVariable("mapping") String mapping,
            @CookieValue(name = "uid", required = false) Cookie cookie,
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException

    {
        ModelAndView mav = new ModelAndView(mapping);
        if (cookie != null) {
            String token = cookie.getValue();
            SocialDto dto;
            switch (mapping) {
                case "users": dto = socialConsumer.getAllUsers(token);
                    break;
                case "friends": dto = socialConsumer.getAllFriends(token);
                    break;
                case "nofriends": dto = socialConsumer.getAllNoFriendsOfAUser(token);
                    break;
                default: dto = socialConsumer.getUserDto(token);
            }
            if (dto != null) {
                mav.addObject("dto", dto);
                mav.addObject("mapping", mapping + "tab");
                return mav;
            }
        }
        resp.sendRedirect("login");
        return null;
    }


}
