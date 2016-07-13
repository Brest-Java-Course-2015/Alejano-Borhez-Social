package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by alexander_borohov on 13.7.16.
 */

@RestController
@CrossOrigin
@Component
@RequestMapping("/image")
public class SocialImageRestController {

    @Autowired
    private SocialService socialService;

    @RequestMapping(value = "/upload",
            method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @Logged
    public Integer uploadImage(@RequestParam("id") Integer id,
                               @RequestParam("url") String url) {

        return socialService.addImage(id, url);
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.OK)
    @Logged
    public void deleteImage(@RequestParam("userId") Integer userId,
                            @RequestParam("imageId") Integer imageId) {
        socialService.deleteImage(userId, imageId);

    }

    @RequestMapping(value = "/rename",
            method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    @Logged
    public void renameImage(@RequestParam("id") Integer id,
                            @RequestParam("name") String name) {
        socialService.renameImage(id, name);
    }



}
