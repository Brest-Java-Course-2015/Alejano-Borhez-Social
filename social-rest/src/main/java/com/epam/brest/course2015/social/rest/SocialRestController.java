package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alexander on 9.11.15.
 */

@RestController
public class SocialRestController {
    @Autowired
    private SocialService socialService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {return socialService.getAllUsers();}

}
