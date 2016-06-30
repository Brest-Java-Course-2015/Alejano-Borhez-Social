package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.core.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alexander_borohov on 30.6.16.
 */
public interface SocialWebAppController {
    public String restPrefix ();

    public ModelAndView sayHello();
    public String init();
    public ModelAndView getAllUsers();
    public ModelAndView getAllUsersByDate(String dateMin, String dateMax);
    public ModelAndView getAllFriends(Integer id);
    public String deleteFriend(Integer id1, Integer id2);
    public String addFriendship(Integer id1, Integer id2);
    public ModelAndView getUser(Integer id);
    public String addUserSubmit(User user);
    public ModelAndView addUser();
    public String deleteUser(Integer id);
    public String changePassword(Integer id, String password);
    public String changeLogin(Integer id, String password);
    public String changeFirstName(Integer id, String password);
    public String changeLastName(Integer id, String password);
    public ModelAndView getAllNoFriendsOfAUser(Integer id);

}
