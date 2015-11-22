package com.epam.brest.course2015.social.web;


import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Date;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static com.epam.brest.course2015.social.test.LOGGER.LOGGERDO;


/**
 * Created by alexander on 21.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-web-spring-mock-test.xml"})
public class SocialControllerTest {

    @Resource
    private SocialController socialController;

    @Autowired
    private SocialService socialService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = standaloneSetup(socialController)
                .setMessageConverters(
                new MappingJackson2HttpMessageConverter())
                .setViewResolvers(viewResolver)
                .build();
    }

    @After
    public void tearDown() {
        verify(socialService);
        reset(socialService);
    }

    @Test
    public void testInit() throws Exception {
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("users"));
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
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(forwardedUrl("/WEB-INF/view/users.jsp"));
    }


    @Test
    public void testGetAllUsersByDate() throws Exception {
        expect(socialService.getSocialUsersDtoByDate(
                            anyObject(Date.class),
                            anyObject(Date.class)))
                            .andReturn(new SocialDto());
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/usersbydate?datemin=2015-10-11&datemax=2015-11-11")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(forwardedUrl("/WEB-INF/view/usersbydate.jsp"));
    }

    @Test
    public void testGetAllFriendsOfAUser() throws Exception {
        expect(socialService.getSocialFriendsDto(1))
                .andReturn(new SocialDto());
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/friends?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(forwardedUrl("/WEB-INF/view/friends.jsp"));
    }

    @Test
    public void testGetUser() throws Exception {
        expect(socialService.getSocialFriendsDto(1))
                .andReturn(new SocialDto());
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/user?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(forwardedUrl("/WEB-INF/view/user.jsp"));
    }

    @Test
    public void testAddUserSubmit() throws Exception {
        expect(socialService.addUser(anyObject(User.class)))
                .andReturn(1);
        replay(socialService);
        LOGGERDO();
        String user = new ObjectMapper().writeValueAsString(new User());
        mockMvc.perform(
                post("/addusersubmit")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"));
    }

    @Test
    public void testAddUser() throws Exception {
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/adduser"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/adduser.jsp"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        socialService.deleteUser(1);
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                delete("/user/delete?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users"));
    }

    @Test
    public void testChangePassword() throws Exception {
        socialService.changePassword(1, "password");
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                put("/user/password?id=1&password=password")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user?id=1"));
    }

    @Test
    public void testChangeLogin() throws Exception {
        socialService.changeLogin(1, "login");
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                put("/user/login?id=1&login=login")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user?id=1"));
    }

    @Test
    public void testChangeFirstName() throws Exception {
        socialService.changeFirstName(1, "firstname");
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                put("/user/firstname?id=1&firstname=firstname")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user?id=1"));
    }

    @Test
    public void testChangeLastName() throws Exception {
        socialService.changeLastName(1, "lastname");
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                put("/user/lastname?id=1&lastname=lastname")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user?id=1"));
    }

    @Test
    public void testDiscardFriendship() throws Exception {
        socialService.discardFriendship(anyObject(User.class),
                                        anyObject(User.class));
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                delete("/user/friendship/del?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user?id=1"));
    }

    @Test
    public void testAddFriendship() throws Exception {
        socialService.addFriendship(anyObject(User.class),
                                    anyObject(User.class));
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                post("/user/friendship/add?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/nofriends?id=1"));
    }

    @Test
    public void testGetAllNoFriendsOfAUser() throws Exception {
        expect(socialService.getSocialNoFriendsDto(1))
                .andReturn(new SocialDto());
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/nofriends?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/nofriends.jsp"));
    }

    @Test
    public void testGetDate() throws Exception {
        expect(socialService.getSocialUsersDtoByDate(
                anyObject(Date.class),
                anyObject(Date.class)))
                .andReturn(new SocialDto());
        replay(socialService);
        socialService.getSocialUsersDtoByDate(
                new Date(),
                new Date());
    }
}