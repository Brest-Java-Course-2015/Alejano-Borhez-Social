package com.epam.brest.course2015.social.service;

import java.io.UnsupportedEncodingException;

/**
 * Created by alexander_borohov on 20.7.16.
 */
public interface SocialSecurity {

    String generateSecurityToken(String login, Integer userId);
    Integer getUserId(String token);

}
