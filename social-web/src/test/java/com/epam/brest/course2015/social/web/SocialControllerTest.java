package com.epam.brest.course2015.social.web;


import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by alexander on 21.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-web-spring-mock-test.xml"})
public class SocialControllerTest {
    private static final Logger LOGGER = LogManager.getLogger();
    private static void LOGGERDO() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        LOGGER.debug("Started test: " + elements[2].getMethodName());
    }

    @Resource
    private SocialController socialController;

    @Autowired
    private SocialService socialService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = standaloneSetup(socialController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .setViewResolvers(viewResolver)
                .build();
    }

    @After
    public void tearDown() {
//        verify(socialService);
        reset(socialService);
    }

    @Test
    public void testInit() throws Exception {
        mockMvc.perform(
                get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        expect(socialService.getSocialUsersDto())
                .andReturn(new SocialDto());
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }



}