package com.epam.brest.course2015.social.mail;

import com.epam.brest.course2015.social.test.Logged;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;


/**
 * Created by alexander_borohov on 27.7.16.
 */
public class MockMailSender implements JavaMailSender {

    @Override
    @Logged
    public void send(SimpleMailMessage simpleMailMessage) throws MailException {

    }

    @Logged
    @Override
    public void send(SimpleMailMessage... simpleMailMessages) throws MailException {

    }

    @Override
    @Logged
    public MimeMessage createMimeMessage() {
        return null;
    }

    @Override
    @Logged
    public MimeMessage createMimeMessage(InputStream inputStream) throws MailException {
        return null;
    }

    @Override
    @Logged
    public void send(MimeMessage mimeMessage) throws MailException {

    }

    @Override
    @Logged
    public void send(MimeMessage... mimeMessages) throws MailException {

    }

    @Override
    @Logged
    public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

    }

    @Override
    @Logged
    public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

    }
}
