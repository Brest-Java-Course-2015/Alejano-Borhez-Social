package com.epam.brest.course2015.social.soap;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;

/**
 * Created by alexander on 30.1.16.
 */
@Endpoint
    @WebService
public class SocialWebService {

    private static final String NAMESPACE = "http://epam.com/brest/course2015/social/soap";

    @Autowired
    SocialService service;

    @Logged
    @PayloadRoot(namespace = NAMESPACE, localPart = "sayHello")
    public @ResponsePayload String sayHello() {
        return "HellO!";
    }

    @Logged
    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllUsers")
    public @ResponsePayload SocialDto getAllUsers() {
        SocialDto dto = new SocialDto();
        User user1 = new User();
        user1.setLogin("alejano");
        user1.setPassword("123");
        user1.setFirstName("Alex");
        user1.setLastName("Borohov");
        user1.setAge(30);
        dto.setUser(user1);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user1);
        dto.setTotalUsers(list.size());
        return dto;
    }
}
