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
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by alexander_borohov on 27.6.16.
 */
@Controller
public class SocialAppFreeMarker {

    private static void setReferer(HttpServletResponse resp, HttpServletRequest req) {
        Cookie referer = new Cookie("Referer", req.getRequestURL().toString());
        referer.setMaxAge(60*60*4);
        resp.addCookie(referer);
    }

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
                       HttpServletResponse resp, HttpServletRequest req) {
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                return "redirect:/user";
            }
        }

        setReferer(resp, req);
        return "redirect:/login";
    }

    @RequestMapping("/user/friendship/del")
    @Logged
    public String deleteFriend(@CookieValue(name = "uid", required = false) Cookie cookie,
                               @RequestParam("id2") Integer id2) {
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                socialConsumer.deleteFriend(token, id2);
                return "forward:/user";
            }
        }
        return "forward:/friends";
    }

    @RequestMapping("/user/friendship/add")
    @Logged
    public String addFriendship(@CookieValue(name = "uid", required = false) Cookie cookie,
                                @RequestParam("id2") Integer id2) {
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                socialConsumer.addFriendship(token, id2);
                return "forward:/user";
            }
        }
        return "forward:/nofriends";
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
    public String changePassword(@CookieValue(name = "uid", required = false) Cookie cookie,
                                 @RequestParam("password") String password) {
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                socialConsumer.changePassword(token, password);
                return "forward:/user";
            }
        }
        return "forward:/user";
    }

    @RequestMapping("/user/login")
    @Logged
    public String changeLogin(@CookieValue(name = "uid", required = false) Cookie cookie,
                              @RequestParam("login")
                                      String login) {
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                socialConsumer.changeLogin(token, login);
                return "forward:/user";

            }
        }
        return "forward:/user";
    }

    @RequestMapping(value = "/user/firstname")
    @ResponseBody
    @Logged
    public void changeFirstName(@CookieValue(name = "uid", required = false) Cookie cookie,
                                @RequestParam("firstname") String firstname) {
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                socialConsumer.changeFirstName(token, firstname);
            }
        }
    }

    @RequestMapping("/user/lastname")
    @Logged
    public String changeLastName(@CookieValue(name = "uid", required = false) Cookie cookie,
                                 @RequestParam("lastname")
                                         String lastname) {
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                socialConsumer.changeLastName(token, lastname);
                return "forward:/user";

            }
        }
        return "forward:/user";
    }


    @RequestMapping("/login")
    @Logged
    public ModelAndView login(HttpServletRequest req,
                              HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        Cookie cookie1 = WebUtils.getCookie(req, "uid");

        Cookie cookie = new Cookie(uid, "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginapprove", method = RequestMethod.POST)
    @Logged
    public String loginApprove(HttpServletResponse resp,
                               HttpServletRequest req,
                               @ModelAttribute("user") User user,
                               @CookieValue(name = "Referer", required = false) String referer) throws IOException {
// Checking for a user from DataBase
        if (socialConsumer.isUserInDB(user)) {

// Generating or receiving existing token
            String token = socialConsumer.getToken(user.getLogin(), "USER");
// Setting a Cookie
            Cookie cookie = new Cookie("uid", token);
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);
// Proceed to User page

            return (referer != null)? "redirect:" + referer: "redirect:user";
        }
        else {
// Proceed to Login Page
            return "redirect:/login";
        }
    }

    @RequestMapping("/usersbydate")
    @Logged
    public ModelAndView getAllUsersByDate(
            @CookieValue(name = "uid", required = false) Cookie cookie,
            HttpServletRequest req,
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
        setReferer(resp, req);
        resp.sendRedirect("login");
        return mav;
    }

    @RequestMapping("users")
    @Logged
    public ModelAndView getAllUsersDto(@CookieValue(name = "uid", required = false) Cookie cookie,
                                       HttpServletRequest req,
                                       HttpServletResponse resp
                                       ) throws IOException {
        ModelAndView mav = new ModelAndView("users");
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                SocialDto dto = socialConsumer.getAllUsers(token);
                mav.addObject("dto", dto);
                mav.addObject("mapping", "userstab");
                return mav;
            }

        }
        setReferer(resp, req);
        resp.sendRedirect("login");
        return mav;
    }

    @RequestMapping("user")
    @Logged
    public ModelAndView getUserDto(@CookieValue(name = "uid", required = false) Cookie cookie,
                                   HttpServletRequest req,
                                   HttpServletResponse resp) throws IOException {
        ModelAndView mav = new ModelAndView("user");
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                SocialDto dto = socialConsumer.getUserDto(token);
                mav.addObject("dto", dto);
                mav.addObject("mapping", "usertab");
                return mav;
            }

        }
        setReferer(resp, req);
        resp.sendRedirect("login");
        return mav;
    }

    @RequestMapping("photo")
    @Logged
    public ModelAndView getPhoto(@CookieValue(name = "uid", required = false) Cookie cookie,
                                   HttpServletRequest req,
                                   HttpServletResponse resp) throws IOException {
        ModelAndView mav = new ModelAndView("photo");
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                SocialDto dto = socialConsumer.getUserDto(token);
                mav.addObject("dto", dto);
                mav.addObject("mapping", "phototab");
                return mav;
            }

        }
        setReferer(resp, req);
        resp.sendRedirect("login");
        return mav;
    }

    @RequestMapping("messages")
    @Logged
    public ModelAndView getMessages(@CookieValue(name = "uid", required = false) Cookie cookie,
                                    HttpServletRequest req,
                                   HttpServletResponse resp) throws IOException {
        ModelAndView mav = new ModelAndView("messages");
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                SocialDto dto = socialConsumer.getUserDto(token);
                mav.addObject("dto", dto);
                mav.addObject("mapping", "messagestab");
                return mav;
            }

        }
        setReferer(resp, req);
        resp.sendRedirect("login");
        return mav;
    }

    @RequestMapping("friends")
    @Logged
    public ModelAndView getFriendsDto(@CookieValue(name = "uid", required = false) Cookie cookie,
                                      HttpServletRequest req,
                                      HttpServletResponse resp) throws IOException {
        ModelAndView mav = new ModelAndView("friends");
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                SocialDto dto = socialConsumer.getAllFriends(token);
                mav.addObject("dto", dto);
                mav.addObject("mapping", "friendstab");
                return mav;
            }

        }
        setReferer(resp, req);
        resp.sendRedirect("login");
        return mav;
    }

    @RequestMapping("nofriends")
    @Logged
    public ModelAndView getNoFriendsDto(@CookieValue(name = "uid", required = false) Cookie cookie,
                                      HttpServletRequest req,
                                      HttpServletResponse resp) throws IOException {
        ModelAndView mav = new ModelAndView("nofriends");
        if (cookie != null) {
            String token = cookie.getValue();
            if (token != null) {
                SocialDto dto = socialConsumer.getAllNoFriendsOfAUser(token);
                mav.addObject("dto", dto);
                mav.addObject("mapping", "nofriendstab");
                return mav;
            }

        }
        setReferer(resp, req);
        resp.sendRedirect("login");
        return mav;
    }

}
