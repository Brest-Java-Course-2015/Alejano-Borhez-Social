package com.epam.brest.course2015.social.mail;

import com.epam.brest.course2015.social.core.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

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
    private MimeMessage mimeMessage;
    @Autowired
    private MimeMessageHelper helper;

    @Test
    public void sendApprovalEmail() throws Exception {
        User user = new User();
        user.setEmail(TO);
        user.setFirstName("Alex");
        socialMail.sendApprovalEmail(PATH, TOKEN, user);
        assertNotNull(helper);
        assertEquals(TO, helper.getMimeMessage().getRecipients(Message.RecipientType.TO)[0].toString());
        assertTrue(helper.getMimeMessage().getContent().toString().contains(PATH));
        assertEquals("Simple Social Network - registration", helper.getMimeMessage().getSubject());
    }


    @Test
    public void sendRecoveryEmail() throws Exception {
        User user = new User();
        user.setEmail(TO);
        user.setFirstName("Alex");
        socialMail.sendPasswordRecoveryEmail(PATH, TOKEN, user);

        assertNotNull(helper);
//        assertEquals(TO, message.getTo()[0]);
//        assertEquals(PATH + "/admin/recovery?token=" + TOKEN, message.getText());
        assertEquals("Simple Social Network - password recovery", helper.getMimeMessage().getSubject());
    }



}