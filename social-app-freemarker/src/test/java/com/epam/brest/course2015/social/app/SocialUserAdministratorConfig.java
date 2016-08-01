package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.mail.SocialMail;
import com.epam.brest.course2015.social.test.Logged;
import org.easymock.EasyMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by alexander_borohov on 28.7.16.
 */
@ComponentScan(basePackageClasses = {SocialUserAdministrator.class})
public class SocialUserAdministratorConfig {
    @Bean
    @Logged
    SocialConsumer socialConsumer() {
        return EasyMock.createMock(SocialConsumer.class);
    }

    @Bean
    @Logged
    SocialMail socialMail() {
        return EasyMock.createMock(SocialMail.class);
    }

    @Bean
    @Logged
    User user() {
        return new User("testLogin", "testPassword", "Alex", "Borohov", 30, "test@mail.com");
    }

    @Bean
    @Logged
    MultiValueMap<String, String> userMap(@Autowired User user) {
        Map map = new HashMap();
            map.put("login", user.getLogin());
            map.put("password", user.getPassword());
            map.put("firstName", user.getFirstName());
            map.put("lastName", user.getLastName());
            map.put("age", user.getAge().toString());
            map.put("email", user.getEmail());

        MultiValueMap<String, String> returnedMap = new LinkedMultiValueMap<>();
        returnedMap.setAll(map);
        return returnedMap;
    }

}
