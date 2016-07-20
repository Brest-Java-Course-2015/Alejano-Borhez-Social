package com.epam.brest.course2015.social.dao;

import com.epam.brest.course2015.social.core.SocialToken;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by alexander_borohov on 20.7.16.
 */
public interface SecurityDao {
    void addToken(SocialToken token);
    void deleteToken(SocialToken token);
    Integer getUserId(SocialToken token);
    SocialToken getToken(String token);
}
