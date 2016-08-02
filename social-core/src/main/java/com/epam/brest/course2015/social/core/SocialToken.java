package com.epam.brest.course2015.social.core;

import com.epam.brest.course2015.social.test.Logged;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by alexander_borohov on 20.7.16.
 */
@Component
@Entity
@Table(name = "token")
public class SocialToken {

    private Integer userId;
    @Id
    private String token;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Logged
    public Role getRole() {
        return role;
    }
    @Logged
    public void setRole(String role) {
        this.role = Role.valueOf(Role.class, role);
    }

    @Logged
    public String getToken() {
        return token;
    }
    @Logged
    public void setToken(String token) {
        this.token = token;
    }
    @Logged
    public Date getExpires() {
        return expires;
    }
    @Logged
    public void setExpires(Date expires) {
        this.expires = expires;
    }
    @Logged
    public Integer getUserId() {
        return userId;
    }
    @Logged
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public SocialToken() {
    }

    public SocialToken(Integer userId, String token, String role) {
        this.userId = userId;
        this.token = token;
        this.role = Role.valueOf(Role.class, role);
        this.expires = DateUtils.addMonths(new Date(), 1);
    }

    public enum Role {
        ADMIN ("ADMIN"),
        USER ("USER"),
        TEMP ("TEMP");

        private final String code;

        Role(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "'" + code + '\'';
        }

        public String getCode() {
            return code;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialToken that = (SocialToken) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getToken(), that.getToken()) &&
                getRole() == that.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getToken(), getRole());
    }

    @Override
    public String toString() {
        return "SocialToken{" +
                "userId=" + userId +
                ", token='" + token.substring(0,10) + '\'' +
                ", expires=" + expires +
                ", role=" + role +
                '}';
    }
}
