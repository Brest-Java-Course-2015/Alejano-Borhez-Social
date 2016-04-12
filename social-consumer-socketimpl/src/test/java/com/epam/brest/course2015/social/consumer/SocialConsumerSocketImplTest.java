package com.epam.brest.course2015.social.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Created by alexander on 17.3.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-spring-consumer-socket.xml"})
public class SocialConsumerSocketImplTest {
    @Autowired
    SocialConsumer socialConsumer;

    @Test
    public void testHello() throws Exception {
        String hello = socialConsumer.hello();
        assertNotNull(hello);
        assertEquals(hello, "Hello");
    }

}