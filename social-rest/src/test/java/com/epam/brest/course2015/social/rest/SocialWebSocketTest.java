package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


/**
 * Created by alexander on 10.4.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-rest-spring-messaging-test.xml"})
public class SocialWebSocketTest {
    @Resource
    SocialRestController restController;

   /* @Autowired
    SocialService service;*/

    private SocialTestMessageChannel outMessageChannel;

    private SocialTestAnnotationMethodMessageHandler messageHandler;

    @Before
    public void setUp() {
        this.outMessageChannel = new SocialTestMessageChannel();

        this.messageHandler = new SocialTestAnnotationMethodMessageHandler(
          new SocialTestMessageChannel(), outMessageChannel, new SimpMessagingTemplate(new SocialTestMessageChannel())
        );

        this.messageHandler.setDestinationPrefixes(Arrays.asList("/app"));
        this.messageHandler.registerHandler(restController);
        this.messageHandler.setMessageConverter(new MappingJackson2MessageConverter());
        this.messageHandler.setApplicationContext(new StaticApplicationContext());
        this.messageHandler.afterPropertiesSet();
    }

    @Test
    public void testGetSocialMessage() throws Exception {
//        Setting headers
        StompHeaderAccessor headers = StompHeaderAccessor.create(StompCommand.SUBSCRIBE);
        headers.setSubscriptionId("0");
        headers.setDestination("/app/addeduser");
        headers.setSessionId("0");
        headers.setLogin("guest");
        headers.setSessionAttributes(new HashMap<String, Object>());
//        Setting new User
        User user = new User();
        user.setFirstName("Alexander");
        user.setLastName("Borohov");
        user.setAge(30);
        user.setLogin("alejano_borhez1");
        user.setPassword("123");
//        Setting payload using new User object
        byte[] payload = new ObjectMapper().writeValueAsBytes(user);
//        Building new SocialMessage
        Message<?> message = MessageBuilder.withPayload(payload).setHeaders(headers).build();
//        Handling SocialMessage
        this.messageHandler.handleMessage(message);
//        Testing
        assertEquals(1, this.outMessageChannel.getMessages().size());


    }

    @Test
    public void helloTest() throws Exception {
        StompHeaderAccessor headers = StompHeaderAccessor.create(StompCommand.SUBSCRIBE);
        headers.setSubscriptionId("0");
        headers.setDestination("/app/hello");
        headers.setSessionId("0");
        headers.setSessionAttributes(new HashMap<String, Object>());
//        Setting test payload
        String hello = "Alex";
//        Setting payload using new User object
        byte[] payload = new ObjectMapper().writeValueAsBytes(hello);
//        Building new SocialMessage
        Message<?> message = MessageBuilder.withPayload(payload).setHeaders(headers).build();
//        Handling SocialMessage
        this.messageHandler.handleMessage(message);

//        Testing
        assertEquals(1, outMessageChannel.getMessages().size());
        Message<?> reply = this.outMessageChannel.getMessages().get(0);
        User testUser = new ObjectMapper().readValue((byte[]) reply.getPayload(), User.class);
        assertEquals(testUser.getClass(), User.class);
        assertEquals(testUser.getFirstName(), "Alex");

        System.out.println(reply);
        System.out.println("Out:" + this.outMessageChannel.getMessages());
    }

}
