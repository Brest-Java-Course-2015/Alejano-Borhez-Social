package com.epam.brest.course2015.social.soap;

import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by alexander on 30.1.16.
 */
@WebService
public class SocialWebService {
    @Autowired
    SocialService socialService;

    @WebMethod
    public SocialDto getAllUsers()
    {
        return socialService.getSocialUsersDto();
    }

    @WebMethod
    public String sayHello() {
        return "HellO!";
    }
}
