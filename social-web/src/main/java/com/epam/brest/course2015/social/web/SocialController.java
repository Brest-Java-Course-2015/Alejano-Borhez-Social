package com.epam.brest.course2015.social.web;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by alexander on 21.11.15.
 */

@Controller
public class SocialController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private SocialService socialService;

    @RequestMapping("/")
    public String init() {
        return "redirect:users";
    }

    @RequestMapping("/users")
    public ModelAndView getAllUsers() {
        SocialDto dto = socialService.getSocialUsersDto();
        LOGGER.debug("web: users.size: {}", dto.getTotalUsers());
        return new ModelAndView("users", "dto", dto);
    }

    @RequestMapping("/friends")
    public ModelAndView getAllFriendsOfAUser(@RequestParam("id") Integer id) {
        LOGGER.debug("web: friends of a user: {}", id);
        SocialDto dto = socialService.getSocialFriendsDto(id);
        return new ModelAndView("friends", "dto", dto);
    }

    @RequestMapping("/user")
    public ModelAndView getUser(@RequestParam("id") Integer id)
    {
        LOGGER.debug("web: getting user: {}", id);
        SocialDto dto = socialService.getSocialFriendsDto(id);
        return new ModelAndView("user", "dto", dto);
    }

    @RequestMapping("/user/password")
    public String changePassword(@RequestParam("id") Integer id,
                                 @RequestParam("password") String password) {
        LOGGER.debug("web: setting new password of user: {}", id);
        socialService.changePassword(id, password);
        return "redirect:/user?id=" + id;
    }

    @RequestMapping("/user/login")
    public String changeLogin(@RequestParam("id") Integer id,
                                 @RequestParam("login") String login) {
        LOGGER.debug("web: setting new login of user: {}", id);
        socialService.changeLogin(id, login);
        return "redirect:/user?id=" + id;
    }

    @RequestMapping("/user/firstname")
    public String changeFirstName(@RequestParam("id") Integer id,
                              @RequestParam("firstname") String firstname) {
        LOGGER.debug("web: setting new firstname of user: {}", id);
        socialService.changeFirstName(id, firstname);
        return "redirect:/user?id=" + id;
    }

    @RequestMapping("/user/lastname")
    public String changeLastName(@RequestParam("id") Integer id,
                                  @RequestParam("lastname") String lastname) {
        LOGGER.debug("web: setting new lastname of user: {}", id);
        socialService.changeLastName(id, lastname);
        return "redirect:/user?id=" + id;
    }

    @RequestMapping("/user/friendship/del")
    public String discardFriendship(@RequestParam("id1") Integer id1,
                                    @RequestParam("id2") Integer id2) {
        LOGGER.debug("web: discarding friendship of users: {}, {}", id1, id2);
        socialService.discardFriendship(new User(id1), new User(id2));
        return "redirect:/user?id=" + id1;
    }

    @RequestMapping("/user/friendship/add")
    public String addFriendship(@RequestParam("id1") Integer id1,
                                    @RequestParam("id2") Integer id2) {
        LOGGER.debug("web: adding friendship of users: {}, {}", id1, id2);
        socialService.addFriendship(new User(id1), new User(id2));
        return "redirect:/nofriends?id=" + id1;
    }


    @RequestMapping("nofriends")
    public ModelAndView getAllNoFriendsOfAUser(@RequestParam("id") Integer id) {
        LOGGER.debug("web: getting all no-friends of a user {}", id);
        SocialDto dto = socialService.getSocialNoFriendsDto(id);
        return new ModelAndView("nofriends", "dto", dto);
    }

}
