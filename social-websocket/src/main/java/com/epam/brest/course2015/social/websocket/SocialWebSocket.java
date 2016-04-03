package com.epam.brest.course2015.social.websocket;

import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;


/**
 * Created by alexander on 12.3.16.
 */
@Controller
public class SocialWebSocket {

    @Autowired
    private SocialService service;

    @Logged
    @MessageMapping("/hello")
    public String sayHello(String hello) {
        System.out.println("You are using websockets " + hello + "!");
        return "Hello!";

    }

    @Logged
    @SubscribeMapping("/userdto")
    public SocialDto getUserDto() {
        return service.getSocialUsersDto();
    }

}
