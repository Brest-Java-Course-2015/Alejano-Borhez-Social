package com.epam.brest.course2015.social.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;

/**
 * Created by alexander on 12.3.16.
 */

@Controller
public class SocialWebSocket {

    @MessageMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

}
