package com.epam.brest.course2015.social.service;

import com.epam.brest.course2015.social.core.SocialToken;
import com.epam.brest.course2015.social.dao.SecurityDao;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.UUID;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@Service
@Transactional
public class SocialSecurityImpl implements SocialSecurity {

    @Autowired
    private SecurityDao securityDao;

    @Override
    @Logged
    public String generateSecurityToken(Integer userId, String role) {
        Assert.notNull(userId, "UserId must NOT be NULL");
        String addedToken = UUID.randomUUID().toString();
        securityDao.addToken(new SocialToken(userId, addedToken, role));
        return addedToken;
    }

    @Override
    @Logged
    public String getToken(Integer userId) {
        Assert.notNull(userId, "UserId must NOT be NULL");
        SocialToken socialToken = securityDao.getTokenByUserId(userId);
        return (socialToken != null)? socialToken.getToken(): null;
    }


    @Override
    @Logged
    public Integer getUserId(String token) {
        Assert.notNull(token, "You are trying to use incorrect token");

        SocialToken socialToken = securityDao.getToken(token);

        Assert.notNull(socialToken, "Your token is not valid");
        Assert.isTrue(socialToken.getExpires().after(new Date()), "Your token has expired. Please, re-login");

        return securityDao.getUserId(socialToken);

    }

    @Override
    @Logged
    public Boolean isTokenValid(String token, String... role) {
        if (token == null || role == null) return false;
        SocialToken socialToken = securityDao.getToken(token);
        if (socialToken == null) return false;
        if (socialToken.getExpires().before(new Date())) return false;
        boolean result = false;
        for (String roleIt: role) {
            if (socialToken.getRole().equals(SocialToken.Role.valueOf(roleIt))) {
                result = true;
            }
        }
        return result;
    }

}
