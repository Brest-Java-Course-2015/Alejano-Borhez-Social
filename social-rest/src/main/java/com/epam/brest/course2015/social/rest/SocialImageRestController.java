package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.service.SocialSecured;
import com.epam.brest.course2015.social.service.SocialSecurity;
import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

/**
 * Created by alexander_borohov on 13.7.16.
 */

@RestController
@CrossOrigin
@RequestMapping("/image")
public class SocialImageRestController {

    @Autowired
    private SocialService socialService;

    @Autowired
    private SocialSecurity socialSecurity;

    @RequestMapping(value = "/upload",
            method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @Logged
    @SocialSecured
    public Integer uploadImage(@RequestBody String token,
                               @RequestParam Map<String, String> params) {


        Integer id = socialSecurity.getUserId(token);
        return socialService.addImage(id, params.get("url"), params.get("url50"), params.get("url81"));
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    @Logged
    @SocialSecured
    public void deleteImage(@RequestBody String token,
                            @RequestParam("imageId") Integer imageId) {
        Integer userId = socialSecurity.getUserId(token);
        socialService.deleteImage(userId, imageId);
    }

    @RequestMapping(value = "/rename",
            method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    @Logged
    @SocialSecured
    public void renameImage(@RequestBody String token,
                            @RequestParam("name") String name) {
        Integer id = socialSecurity.getUserId(token);
        socialService.renameImage(id, name);
    }



}
