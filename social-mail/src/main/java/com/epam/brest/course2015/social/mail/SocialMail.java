package com.epam.brest.course2015.social.mail;

import com.epam.brest.course2015.social.core.User;

import java.io.File;

/**
 * Created by alexander_borohov on 27.7.16.
 */
public interface SocialMail {

    void sendApprovalEmail(String path, String token, User user);
    void sendPasswordRecoveryEmail(String path, String token, String to);
    void sendEmailWithAttachment(String path, File attach, String to);
}
