package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.test.SocialLogger;
import org.easymock.EasyMock;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;


/**
 * Created by alexander_borohov on 1.8.16.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.epam.brest.course2015.social.consumer"})
public class SocialConsumerTestContext {
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = EasyMock.createMock(RestTemplate.class);
        return restTemplate;
    }

    @Bean
    Image image() {
        Image image = new Image();
        image.setUrl("http://localhost:8082/test-rest/url");
        image.setUrl50("http://localhost:8082/test-rest/url50");
        image.setUrl81("http://localhost:8082/test-rest/url81");
        return image;
    }

    @Bean
    PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer conf = new PropertyPlaceholderConfigurer();
        conf.setIgnoreResourceNotFound(true);
        conf.setLocations(new ClassPathResource("social-app.properties"));
        return conf;
    }

    @Bean
    SocialLogger socialLogger() {
        return new SocialLogger();
    }
}
