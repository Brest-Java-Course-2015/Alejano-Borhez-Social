package com.epam.brest.course2015.social.rest;

import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.service.SocialSecurity;
import com.epam.brest.course2015.social.service.SocialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by alexander_borohov on 13.7.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-image-rest-spring-mock-test.xml"})
public class SocialImageRestControllerTest {
    @Resource
    private SocialImageRestController socialRestController;

    @Autowired
    private SocialService socialService;
    @Autowired
    private SocialSecurity socialSecurity;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(socialRestController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @After
    public void tearDown() throws Exception {
        verify(socialService);
        reset(socialService);
        verify(socialSecurity);
        reset(socialSecurity);
    }

    @Test
    public void testAddImage() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(true);
        expect(socialSecurity.getUserId(anyString())).andReturn(2);
        expect(socialService.addImage(anyInt(), anyString(), anyString(), anyString())).andReturn(3);
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString("token");
        mockMvc.perform(
                post("/image/upload?url=url&url50=url50&url81=url81")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string("3"));
    }

    @Test
    public void testDeleteImage() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(true);
        expect(socialSecurity.getUserId(anyString())).andReturn(2);
        socialService.deleteImage(anyInt(), anyInt());
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString("token");
        mockMvc.perform(
                post("/image/delete?imageId=1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testRenameImage() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(true);
        expect(socialSecurity.getUserId(anyString())).andReturn(2);
        socialService.renameImage(2, "rename");
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString("token");
        mockMvc.perform(
                post("/image/rename?name=rename")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

}