package com.epam.brest.course2015.social.appmarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alexander_borohov on 27.6.16.
 */
@Controller
public class SocialAppFreeMarker {

    @RequestMapping ("/users")
    public ModelAndView hello () {
        String hello = "Hello!";
        return new ModelAndView("users", "hello", hello);
    }
}
