package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.SocialToken;
import com.epam.brest.course2015.social.dao.SecurityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@Service
public class SocialSecurityImpl implements SocialSecurity {
    @Autowired
    SecurityDao securityDao;

    @Override
    public String generateSecurityToken(String login, Integer userId) {
        Assert.notNull(login, "Login must NOT be NULL");
        Assert.notNull(userId, "UserId must NOT be NULL");
        try {
            Date date = new Date();
            String addedToken = Base64.getEncoder().encodeToString((login + userId + date).getBytes("utf-8"));
            securityDao.addToken(new SocialToken(userId, addedToken));
            return addedToken;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;

        }

    }

    public Integer getUserId(String token) {
        Assert.notNull(token);
        try {
            return securityDao.getUserId(securityDao.getToken(token));
        }catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
