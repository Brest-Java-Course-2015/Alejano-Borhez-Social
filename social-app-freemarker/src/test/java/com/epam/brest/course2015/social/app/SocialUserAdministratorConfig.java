package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.mail.SocialMail;
import com.epam.brest.course2015.social.test.Logged;
import org.easymock.EasyMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by alexander_borohov on 28.7.16.
 */
@Configuration
@ComponentScan(basePackageClasses = {SocialUserAdministrator.class})
class SocialUserAdministratorConfig {
    @Bean
    PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("test-data.properties", User.class.getClassLoader()),
                                new ClassPathResource("social-app.properties"),
                                new ClassPathResource("cdn.properties"));
        return configurer;
    }



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




}
