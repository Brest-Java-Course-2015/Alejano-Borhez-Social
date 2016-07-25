package com.epam.brest.course2015.social.rest;


import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.service.SocialSecurity;
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
import org.springframework.web.util.NestedServletException;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private final Integer testUserID = 1;

    @Resource
    private SocialRestController socialRestController;

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
    private SocialService socialService;

    @Autowired
    private SocialSecurity socialSecurity;

    @Autowired
    private SimpMessagingTemplate socialMessaging;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(socialRestController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @After
    public void tearDown() {
        verify(socialService);
        reset(socialService);
        verify(socialSecurity);
        reset(socialSecurity);
    }

    // Not implemented
    @Test
    public void testAddUser() throws Exception {
        expect(socialService.addUser(anyObject(User.class)))
        .andReturn(5);
        replay(socialService);
        replay(socialSecurity);

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

    // Not implemented
/*    @Test
    public void testChangePassword() throws Exception {
        socialService.changePassword(1, "password");
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                put("/user/password?id=1&password=password")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    // Not implemented
    @Test
    public void testChangeLogin() throws Exception {
        socialService.changeLogin(1, "login");
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                put("/user/login/?id=1&login=login")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    // Not implemented
    @Test
    public void testChangeFirstName() throws Exception {
        socialService.changeFirstName(1, "firstname");
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                put("/user/firstname/?id=1&firstname=firstname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    // Not implemented
    @Test
    public void testChangeLastName() throws Exception {
        socialService.changeLastName(1, "lastname");
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                put("/user/lastname/?id=1&lastname=lastname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }*/

    // Not implemented
    @Test
    public void testDeleteUser() throws Exception {
        socialService.deleteUser(1);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                delete("/user?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    // Not implemented
    @Test
    public void testDiscardFriendship() throws Exception {
        socialService.discardFriendship(anyObject(User.class), anyObject(User.class));
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                delete("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    // Not implemented
    @Test
    public void testAddFriendship() throws Exception {
        socialService.addFriendship(anyObject(User.class),
                anyObject(User.class));
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                post("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testUserActionLogin() throws Exception {
        String token = "token";
        String testLogin = "newlogin";
        expect(socialSecurity.isTokenValid(token)).andReturn(true);
        expect(socialSecurity.getUserId(token)).andReturn(testUserID);
        socialService.changeLogin(testUserID, testLogin);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/login?param=" + testLogin)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(token))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionPassword() throws Exception {
        String token = "token";
        String testPassword = "newpassword";
        expect(socialSecurity.isTokenValid(token)).andReturn(true);
        expect(socialSecurity.getUserId(token)).andReturn(testUserID);
        socialService.changePassword(testUserID, testPassword);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/password?param=" + testPassword)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(token))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionFirstName() throws Exception {
        String token = "token";
        String testFirstName = "newfirstname";
        expect(socialSecurity.isTokenValid(token)).andReturn(true);
        expect(socialSecurity.getUserId(token)).andReturn(testUserID);
        socialService.changeFirstName(testUserID, testFirstName);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/firstname?param=" + testFirstName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(token))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionLastName() throws Exception {
        String token = "token";
        String testLastName = "newlastname";
        expect(socialSecurity.isTokenValid(token)).andReturn(true);
        expect(socialSecurity.getUserId(token)).andReturn(testUserID);
        socialService.changeLastName(testUserID, testLastName);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/lastname?param=" + testLastName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(token))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionInvalidToken() throws Exception {
        String token = "token";
        String testLastName = "newlastname";
        expect(socialSecurity.isTokenValid(token)).andReturn(false);
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/lastname?param=" + testLastName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(token))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test (expected = NestedServletException.class)
    public void testUserActionInvalidAction() throws Exception {
        String token = "token";
        String testLastName = "newlastname";
        expect(socialSecurity.isTokenValid(token)).andReturn(true);
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/action?param=" + testLastName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(token))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserDto() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(true);
        expect(socialService.getSocialUsersDto())
                .andReturn(new SocialDto());
        replay(socialService);
        replay(socialSecurity);
        String dto = new ObjectMapper().writeValueAsString(new SocialDto());
        mockMvc.perform(
                post("/userdto")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"testToken\"")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(dto));
    }

    @Test
    public void testGetUserDtoInvalidToken() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                post("/userdto")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"token\"")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetFriendsDto() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(true);
        expect(socialSecurity.getUserId(anyString())).andReturn(1);
        expect(socialService.getSocialFriendsDto(1))
                .andReturn(new SocialDto());
        replay(socialService);
        replay(socialSecurity);

        String dto = new ObjectMapper().writeValueAsString(new SocialDto());

        mockMvc.perform(
                post("/friendsdto")
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"token\"")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(dto));
    }

    @Test
    public void testGetFriendsDtoInvalidToken() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                post("/friendsdto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"token\"")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetNoFriendsDto() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(true);
        expect(socialSecurity.getUserId(anyString())).andReturn(1);
        expect(socialService.getSocialNoFriendsDto(1))
                .andReturn(new SocialDto());
        replay(socialService);
        replay(socialSecurity);

        String dto = new ObjectMapper().writeValueAsString(new SocialDto());

        mockMvc.perform(
                post("/nofriendsdto")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"token\"")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(dto));
    }

    @Test
    public void testGetNoFriendsDtoInvalidToken() throws Exception {
        expect(socialSecurity.isTokenValid(anyString())).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                post("/nofriendsdto")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"token\"")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testAddTokenNew() throws Exception {
        expect(socialService.getUserByLogin("login")).andReturn(new User());
        expect(socialSecurity.getToken(anyInt())).andReturn(null);
        expect(socialSecurity.generateSecurityToken(anyInt()))
                .andReturn("token");
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                get("/token?login=login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("\"token\""));

    }

    @Test
    public void testAddTokenOld() throws Exception {
        expect(socialService.getUserByLogin("login")).andReturn(new User());
        expect(socialSecurity.getToken(anyInt())).andReturn("token");
        expect(socialSecurity.isTokenValid("token")).andReturn(true);
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                get("/token?login=login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("\"token\""));

    }

    @Test
    public void testIsUserValidTrue() throws Exception {
        expect(socialService.getUserByLogin("login"))
                .andReturn(new User("login", "password"));
        replay(socialService);
        replay(socialSecurity);
        String user = new ObjectMapper().writeValueAsString(new User("login", "password"));
        mockMvc.perform(
                post("/user/db")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    @Test
    public void testIsUserValidFalse() throws Exception {
        expect(socialService.getUserByLogin("login"))
                .andReturn(new User("login", "password1"));
        replay(socialService);
        replay(socialSecurity);
        String user = new ObjectMapper().writeValueAsString(new User("login", "password2"));
        mockMvc.perform(
                post("/user/db")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("false"));

    }

    @Test
    public void testGetUsersDtoByDate() throws Exception {
        Date date1 = getDate("2015-10-01");
        Date date2 = getDate("2015-11-01");
        expect(socialSecurity.isTokenValid("token")).andReturn(true);
        expect(socialService.getSocialUsersDtoByDate(
                date1,
                date2))
                .andReturn(new SocialDto());
        replay(socialService);
        replay(socialSecurity);
        String dto = new ObjectMapper().writeValueAsString(new SocialDto());
        mockMvc.perform(
                post("/userdtobydate?datemin=2015-10-01&datemax=2015-11-01")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("\"token\"")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(dto));
    }

    @Test
    public void testGetUsersDtoByDateInvalidToken() throws Exception {
        Date date1 = getDate("2015-10-01");
        Date date2 = getDate("2015-11-01");
        expect(socialSecurity.isTokenValid("token")).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        String dto = new ObjectMapper().writeValueAsString(new SocialDto());
        mockMvc.perform(
                post("/userdtobydate?datemin=2015-10-01&datemax=2015-11-01")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"token\"")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(""));
    }


}
