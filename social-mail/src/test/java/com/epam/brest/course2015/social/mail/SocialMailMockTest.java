package com.epam.brest.course2015.social.mail;

import com.epam.brest.course2015.social.core.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


/**
 * Created by alexander_borohov on 27.7.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mail-spring-mock-test.xml"})
public class SocialMailMockTest {
    private static final String TO = "alexander.borohov17@gmail.com";
    private static final String TOKEN = "token";
    private static final String PATH = "http://localhost:8082/social-app-freemarker";


    @Autowired
    private SocialMail socialMail;
    @Autowired
    private SimpleMailMessage message;
    @Autowired
    private MailSender mailSender;

    @Test
    public void sendApprovalEmail() throws Exception {
        User user = new User();
        user.setEmail(TO);
        user.setFirstName("Alex");
        socialMail.sendApprovalEmail(PATH, TOKEN, user);
        assertNotNull(message);
        assertEquals(TO, message.getTo());
//        assertEquals(PATH+"/admin/approve?token="+TOKEN, message.getText());
        assertEquals("Simple Social Network - registration", message.getSubject());
    }

    @Test
    public void sendRecoveryEmail() throws Exception {
        socialMail.sendPasswordRecoveryEmail(PATH, TOKEN, TO);
        assertNotNull(message);
        assertEquals(TO, message.getTo()[0]);
        assertEquals(PATH + "/admin/recovery?token=" + TOKEN, message.getText());
        assertEquals("Simple Social Network - password recovery", message.getSubject());
    }



}