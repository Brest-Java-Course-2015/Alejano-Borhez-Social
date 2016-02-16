package com.epam.brest.course2015.social.soap;

//import com.epam.brest.course2015.social.dto.SocialDto;
//import com.epam.brest.course2015.social.service.SocialService;
//import org.springframework.beans.factory.annotation.Autowired;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.service.SocialServiceImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by alexander on 30.1.16.
 */
@WebService
public class SocialWebService {

    SocialService service = new SocialServiceImpl();

    @WebMethod
    public String sayHello() {
        return "HellO!";
    }

    @WebMethod
    public SocialDto getAllUsers() {
        return service.getSocialUsersDto();
    }
}
