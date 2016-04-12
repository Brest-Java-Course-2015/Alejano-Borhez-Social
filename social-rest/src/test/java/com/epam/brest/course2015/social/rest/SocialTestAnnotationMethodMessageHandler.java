package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.test.Logged;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.support.SimpAnnotationMethodMessageHandler;

/**
 * Created by alexander on 10.4.16.
 */

public class SocialTestAnnotationMethodMessageHandler extends SimpAnnotationMethodMessageHandler {

    public SocialTestAnnotationMethodMessageHandler (SubscribableChannel inChannel,
                                                     MessageChannel outChannel,
                                                     SimpMessageSendingOperations brokerTemplate) {
        super(inChannel, outChannel, brokerTemplate);
    }

    public void registerHandler(Object handler) {
        super.detectHandlerMethods(handler);
    }

    @Override
    @Logged
    public void handleMessage(Message<?> message) throws MessagingException {
        super.handleMessage(message);
    }
}
