package com.epam.brest.course2015.social.web;

import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alexander on 19.11.15.
 */

@Controller
public class SocialController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private SocialService socialService;

    @RequestMapping("/")
    public String init() {
        return "redirect:/users";
    }

    @RequestMapping("/users")
    public ModelAndView getUserDto() {
        SocialDto dto = socialService.getSocialUsersDto();
        LOGGER.debug("web: getting user dto");
        return new ModelAndView("home", "dto", dto);
    }

}
