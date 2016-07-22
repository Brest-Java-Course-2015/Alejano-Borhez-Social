package com.epam.brest.course2015.social.jpa;

import com.epam.brest.course2015.social.core.SocialToken;
import com.epam.brest.course2015.social.dao.SecurityDao;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@Repository
public class SecurityDaoJPA implements SecurityDao {
    @Value("${token.selectTokenById}")
    private String getTokenById;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Logged
    public void addToken(SocialToken token) {
        entityManager.persist(token);
    }

    @Override
    @Logged
    public void deleteToken(SocialToken token) {
        entityManager.remove(token);
    }

    @Override
    @Logged
    public Integer getUserId(SocialToken token) {
        SocialToken gotToken = entityManager.find(SocialToken.class, token.getToken());
        if (gotToken != null) {
            return gotToken.getUserId();
        } else {
            return null;
        }
    }

    @Override
    @Logged
    public SocialToken getToken(String token) {
        return entityManager.find(SocialToken.class, token);
    }

    @Override
    @Logged
    public SocialToken getTokenByUserId(Integer userId) {
        List<SocialToken> tokenList = entityManager
                .createQuery(getTokenById, SocialToken.class)
                .setParameter("userId", userId)
                .getResultList();
        if (!tokenList.isEmpty()) {
        SocialToken token = tokenList.get(tokenList.size()-1);
            if (token != null) {
                return token;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
