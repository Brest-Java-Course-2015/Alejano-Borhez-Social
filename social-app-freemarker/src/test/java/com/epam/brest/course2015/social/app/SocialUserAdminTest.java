package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.mail.SocialMail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;

import javax.annotation.Resource;

import java.util.Map;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by alexander_borohov on 1.8.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SocialUserAdministratorConfig.class, SocialWebAppContext.class})
@WebAppConfiguration
public class SocialUserAdminTest {
//    Testing WebApp context
    @Autowired
    WebApplicationContext webAppContext;

//    MockMVC infrastructure
    private MockMvc mockMvc;

//    Mocks and test data
    @Autowired
    private SocialConsumer socialConsumer;
    @Autowired
    private SocialMail socialMail;
    @Autowired
    private User user;
    @Autowired
    private MultiValueMap<String, String> userMap;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext)
                .build();
    }

    @After
    public void tearDown() throws Exception {
        verify(socialConsumer);
        reset(socialConsumer);
        verify(socialMail);
        reset(socialMail);
    }

    @Test
    public void addUserSubmit() throws Exception {
        expect(socialConsumer.addUserSubmit(anyObject(User.class))).andReturn(true);
        expect(socialConsumer.getToken(user.getLogin())).andReturn("token");
        socialMail.sendApprovalEmail(anyString(), anyString(), anyObject(User.class));
        replay(socialConsumer);
        replay(socialMail);

        mockMvc.perform(
                post("/admin/addusersubmit")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .params(userMap)
                )
                .andDo(print())
                .andExpect(view().name("addusersubmit"))
                .andExpect(model().attribute("email", user.getEmail()))
                .andExpect(cookie().value("uid", "token"));

    }



}