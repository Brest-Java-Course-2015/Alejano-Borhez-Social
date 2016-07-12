package com.epam.brest.course2015.social.rest;


import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.Image;
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
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by alexander on 10.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-rest-spring-mock-test.xml"})
public class SocialRestControllerMockTest {
    @Resource
    SocialRestController socialRestController;

    private static Date getDate(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private MockMvc mockMvc;

    @Autowired
    SocialService socialService;

    @Autowired
    SimpMessagingTemplate socialMessaging;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(socialRestController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @After
    public void tearDown() {
        verify(socialService);
        reset(socialService);
    }

//    @Test
    public void testGetAllUsers() throws Exception {
        expect(socialService
                .getAllUsers())
                .andReturn(Arrays.<User>asList(new User(3)));
        replay(socialService);
        mockMvc.perform(
                get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
    public void testGetAllFriendships() throws Exception {
        expect(socialService
                .getAllFriendships())
                .andReturn(Arrays.<Friendship>asList(new Friendship(1, 2)));
        replay(socialService);
        mockMvc.perform(
                get("/friendships")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

//    @Test
    public void testGetUserById() throws Exception {
        expect(socialService.getUserById(1)).andReturn(new User(1));
        replay(socialService);
        mockMvc.perform(
                get("/user?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
    public void testGetUserByLogin() throws Exception {
        expect(socialService.getUserByLogin("login")).andReturn(new User(1));
        replay(socialService);
        mockMvc.perform(
                get("/user/login?login=login")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
    public void testGetUserFriends() throws Exception {
        expect(socialService.getFriends(1)).andReturn(Arrays.<User>asList(new User(2), new User(3)));
        replay(socialService);
        mockMvc.perform(
                get("/user/friends?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
    public void testGetUserNoFriends() throws Exception {
        expect(socialService.getNoFriends(1)).andReturn(Arrays.<User>asList(new User(2), new User(3)));
        replay(socialService);
        mockMvc.perform(
                get("/user/nofriends?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddUser() throws Exception {
        expect(socialService.addUser(anyObject(User.class)))
        .andReturn(5);
        expect(socialService.getSocialUsersDto())
        .andReturn(new SocialDto());
        replay(socialService);
        String user = new ObjectMapper().writeValueAsString(new User());
        mockMvc.perform(
                post("/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string("5"));
    }

    @Test
    public void testChangePassword() throws Exception {
        socialService.changePassword(1, "password");
        expectLastCall();
        replay(socialService);
        mockMvc.perform(
                put("/user/password?id=1&password=password")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testChangeLogin() throws Exception {
        socialService.changeLogin(1, "login");
        expectLastCall();
        replay(socialService);
        mockMvc.perform(
                put("/user/login/?id=1&login=login")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testChangeFirstName() throws Exception {
        socialService.changeFirstName(1, "firstname");
        expectLastCall();
        replay(socialService);
        mockMvc.perform(
                put("/user/firstname/?id=1&firstname=firstname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testChangeLastName() throws Exception {
        socialService.changeLastName(1, "lastname");
        expectLastCall();
        replay(socialService);
        mockMvc.perform(
                put("/user/lastname/?id=1&lastname=lastname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testDeleteUser() throws Exception {
        socialService.deleteUser(1);
        socialService.discardAllFriendshipsOfAUser(1);
        expectLastCall();
        replay(socialService);
        mockMvc.perform(
                delete("/user?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testDiscardFriendship() throws Exception {
        socialService.discardFriendship(anyObject(User.class), anyObject(User.class));
        expectLastCall();
        replay(socialService);
        mockMvc.perform(
                delete("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testAddFriendship() throws Exception {
        socialService.addFriendship(anyObject(User.class),
                anyObject(User.class));
        expectLastCall();
        replay(socialService);
        mockMvc.perform(
                post("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

//    @Test
    public void testIsAFriend() throws Exception {
        expect(socialService.isAFriend(anyObject(User.class),
                anyObject(User.class)))
                .andReturn(true);
        replay(socialService);
        mockMvc.perform(
                get("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testGetUserDto() throws Exception {
        expect(socialService.getSocialUsersDto())
                .andReturn(new SocialDto());
        replay(socialService);
        mockMvc.perform(
                get("/userdto")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                  .string("{\"users\":null,\"images\":null,\"totalUsers\":null,\"user\":null}"));
    }

    @Test
    public void testGetFriendsDto() throws Exception {
        expect(socialService.getSocialFriendsDto(1))
                .andReturn(new SocialDto());
        replay(socialService);
        mockMvc.perform(
                get("/friendsdto?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                    .string("{\"users\":null,\"images\":null,\"totalUsers\":null,\"user\":null}"));
    }

    @Test
    public void testGetNoFriendsDto() throws Exception {
        expect(socialService.getSocialNoFriendsDto(1))
                .andReturn(new SocialDto());
        replay(socialService);
        mockMvc.perform(
                get("/nofriendsdto?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string("{\"users\":null,\"images\":null,\"totalUsers\":null,\"user\":null}"));
    }

    @Test
    public void testGetUsersDtoByDate() throws Exception {
        Date date1 = getDate("2015-10-01");
        Date date2 = getDate("2015-11-01");
        expect(socialService.getSocialUsersDtoByDate(date1,
                date2))
                .andReturn(new SocialDto());
        replay(socialService);
        mockMvc.perform(
                get("/userdtobydate?datemin=2015-10-01&datemax=2015-11-01")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string("{\"users\":null,\"images\":null,\"totalUsers\":null,\"user\":null}"));
    }

    @Test
    public void testAddImage() throws Exception {
        expect(socialService.addImage(anyInt(), anyString())).andReturn(3);
        replay(socialService);
        String image = new ObjectMapper().writeValueAsString(new Image());
        mockMvc.perform(
                post("/upload?id=1&url=url")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(image))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string("3"));
    }
}
