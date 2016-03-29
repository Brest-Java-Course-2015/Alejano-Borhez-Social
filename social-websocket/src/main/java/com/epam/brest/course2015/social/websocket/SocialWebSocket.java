package com.epam.brest.course2015.social.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by alexander on 12.3.16.
 */
@Controller
public class SocialWebSocket {


    @MessageMapping("/hello")
    public String sayHello(String hello) {
        System.out.println("You are using websockets " + hello + "!");
        return "Hello!";

    }

}
