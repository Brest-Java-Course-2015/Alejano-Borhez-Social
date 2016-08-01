package com.epam.brest.course2015.social.mail;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.test.Logged;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexander_borohov on 27.7.16.
 */
@Component
public class SocialMailImpl implements SocialMail {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Configuration freemarkerMailConfig;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Logged
    public void sendApprovalEmail(String path, String token, User user) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setTo(user.getEmail());
            helper.setSubject("Simple Social Network - registration");
            String text = prepareText("approve", path, token, user);
            helper.setText(text, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Logged
    public void sendPasswordRecoveryEmail(String path, String token, User user) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);


            helper.setTo(user.getEmail());
            helper.setSubject("Simple Social Network - password recovery");
            String text = prepareText("recover", path, token, user);
            helper.setText(text, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public void sendEmailWithAttachment(String path, File attach, User user) {

    }

    private String prepareText(String action, String path, String token, User user)  {
        try {
            Template template = freemarkerMailConfig.getTemplate(action + ".ftl");
            Map<String, Object> model = new HashMap<>();
            model.put("path", path);
            model.put("token", token);
            model.put("user", user);
            model.put("action", action);
            StringWriter output = new StringWriter();
            template.process(model, output);
            return output.toString();

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        return null;
    }
}
