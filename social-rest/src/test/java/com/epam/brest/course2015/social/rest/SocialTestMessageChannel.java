package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.test.Logged;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.AbstractSubscribableChannel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 10.4.16.
 */
public class SocialTestMessageChannel extends AbstractSubscribableChannel {
    private final List<Message<?>> messages = new ArrayList<>();


    public List<Message<?>> getMessages() {
        return this.messages;
    }

    @Override
    @Logged
    protected boolean sendInternal(Message<?> message, long timeout) {
        this.messages.add(message);
        return true;
    }

    public SocialTestMessageChannel(){}
}
