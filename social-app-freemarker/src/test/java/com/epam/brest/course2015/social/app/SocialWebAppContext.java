package com.epam.brest.course2015.social.app;

import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.File;
import java.io.IOException;

/**
 * Created by alexander_borohov on 1.8.16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {SocialUserAdministrator.class})
public class SocialWebAppContext extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/bootstrap_metro/janux/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/bootstrap_metro/janux/js/");
        registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/font/**").addResourceLocations("/resources/bootstrap_metro/janux/font/");
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/bootstrap_metro/janux/img/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setSuffix(".ftl");
        viewResolver.setPrefix("");
        viewResolver.setCache(true);
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }

    @Bean
    FreeMarkerConfigurer freeMarkerConfigurer() throws IOException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_24);
            cfg.setDirectoryForTemplateLoading(new File("src/main/webapp/views/clear_design/"));
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setLogTemplateExceptions(false);
        configurer.setConfiguration(cfg);
        return configurer;
    }

    @Bean
    MessageSource messageSource() {
       ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;

    }
}
