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
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${test.userId1}")
    private Integer testUserId;
    @Value("${test.userId2}")
    private Integer testUserId2;
    @Value("${test.token}")
    private String testToken;
    @Value("${test.token1}")
    private String testToken1;
    @Value("${test.role}")
    private String testRole;
    @Value("${test.role1}")
    private String testRole1;
    @Value("${test.role2}")
    private String testRole2;
    @Value("${test.login}")
    private String testLogin;
    @Value("${test.password}")
    private String testPassword;
    @Value("${test.firstName}")
    private String testFirstName;
    @Value("${test.lastName}")
    private String testLastName;
    @Value("${test.age}")
    private Integer testAge;
    @Value("${test.email}")
    private String testEmail;
    private User testUser;

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
        testUser = new User(testLogin, testPassword, testFirstName, testLastName, testAge, testEmail);
        testUser.setUserId(testUserId);
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
    public void testDeleteUser() throws Exception {
        socialService.deleteUser(testUserId);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                delete("/user?id=" + testUserId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetTokenValid() throws Exception {
        expect(socialService.getUserByLogin(testLogin)).andReturn(testUser);
        expect(socialSecurity.getToken(testUserId)).andReturn(testToken);
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1, testRole2)).andReturn(true);
        replay(socialSecurity);
        replay(socialService);

        mockMvc.perform(get("/token")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .header("Role", testRole)
            .param("login", testLogin)
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(new ObjectMapper().writeValueAsString(testToken)));
    }

    @Test
    public void testGetTokenTemp() throws Exception {
        expect(socialService.getUserByLogin(testLogin)).andReturn(testUser);
        expect(socialSecurity.getToken(testUserId)).andReturn(testToken);
        expect(socialSecurity.generateSecurityToken(testUserId, testRole2)).andReturn(testToken1);
        replay(socialSecurity);
        replay(socialService);

        mockMvc.perform(get("/token")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("login", testLogin)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(new ObjectMapper().writeValueAsString(testToken1)));
    }

    @Test
    public void testGetTokenTemp2() throws Exception {
        expect(socialService.getUserByLogin(testLogin)).andReturn(testUser);
        expect(socialSecurity.getToken(testUserId)).andReturn(null);
        expect(socialSecurity.generateSecurityToken(testUserId, testRole2)).andReturn(testToken1);
        replay(socialSecurity);
        replay(socialService);

        mockMvc.perform(get("/token")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("login", testLogin)
                .header("Role", testRole)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(new ObjectMapper().writeValueAsString(testToken1)));
    }

    @Test
    public void testGetTokenRole() throws Exception {
        expect(socialService.getUserByLogin(testLogin)).andReturn(testUser);
        expect(socialSecurity.getToken(testUserId)).andReturn(testToken);
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1, testRole2)).andReturn(false);
        expect(socialSecurity.generateSecurityToken(testUserId, testRole)).andReturn(testToken1);
        replay(socialSecurity);
        replay(socialService);

        mockMvc.perform(
                get("/token")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("login", testLogin)
                .header("Role", testRole)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(new ObjectMapper().writeValueAsString(testToken1)));

    }

    @Test
    public void testIsTokenValidTrue() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        replay(socialSecurity);
        replay(socialService);

        String token = new ObjectMapper().writeValueAsString(testToken);

        mockMvc.perform(
                post("/token/validate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(content().string("true"));
    }

    @Test
    public void testIsTokenValidFalse() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(false);
        replay(socialSecurity);
        replay(socialService);

        String token = new ObjectMapper().writeValueAsString(testToken);

        mockMvc.perform(
                post("/token/validate")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(token)
        )
                .andDo(print())
                .andExpect(content().string("false"));
    }

    @Test
    public void testAddUser() throws Exception {
        expect(socialService.addUser(testUser))
        .andReturn(testUserId);
        replay(socialService);
        replay(socialSecurity);

        String user = new ObjectMapper().writeValueAsString(testUser);
        mockMvc.perform(
                post("/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string("true"));
    }

    @Test
    public void testAddUserFail() throws Exception {
        expect(socialService.addUser(testUser))
                .andReturn(null);
        replay(socialService);
        replay(socialSecurity);

        String user = new ObjectMapper().writeValueAsString(testUser);
        mockMvc.perform(
                post("/user")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(user))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string("false"));
    }

    @Test
    public void testChangePassword() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changePassword(testUserId, testPassword);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString(testToken);
        mockMvc.perform(
                post("/user/password?param=" + testPassword)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testChangeLogin() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changeLogin(testUserId, testLogin);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString(testToken);
        mockMvc.perform(
                post("/user/login?param=" + testLogin)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testChangeFirstName() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changeFirstName(testUserId, testFirstName);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString(testToken);
        mockMvc.perform(
                post("/user/firstname?param=" + testFirstName)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testChangeLastName() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changeLastName(testUserId, testLastName);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString(testToken);
        mockMvc.perform(
                post("/user/lastname?param=" + testLastName)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testDiscardFriendship() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.discardFriendship(testUserId, testUserId2);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString(testToken);
        mockMvc.perform(
                post("/friendship/delete?id2=" + testUserId2)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testAddFriendship() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.addFriendship(testUserId, testUserId2);
        expectLastCall();
        replay(socialService);
        replay(socialSecurity);
        String token = new ObjectMapper().writeValueAsString(testToken);
        mockMvc.perform(
                post("/friendship/add?id2=" + testUserId2)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(token)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testUserActionLogin() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changeLogin(testUserId, testLogin);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/login?param=" + testLogin)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(testToken))
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionPassword() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changePassword(testUserId, testPassword);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/password?param=" + testPassword)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionFirstName() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changeFirstName(testUserId, testFirstName);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/firstname?param=" + testFirstName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionLastName() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        socialService.changeLastName(testUserId, testLastName);
        expectLastCall();
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/lastname?param=" + testLastName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUserActionInvalidToken() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(false);
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/lastname?param=" + testLastName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test (expected = NestedServletException.class)
    public void testUserActionInvalidAction() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                post("/user/action?param=" + testLastName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserDto() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialService.getSocialUsersDto())
                .andReturn(new SocialDto());
        replay(socialService);
        replay(socialSecurity);
        String dto = new ObjectMapper().writeValueAsString(new SocialDto());
        mockMvc.perform(
                post("/userdto")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(testToken))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(dto));
    }

    @Test
    public void testGetUserDtoInvalidToken() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                post("/userdto")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetFriendsDto() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        expect(socialService.getSocialFriendsDto(testUserId))
                .andReturn(new SocialDto());
        replay(socialService);
        replay(socialSecurity);

        String dto = new ObjectMapper().writeValueAsString(new SocialDto());

        mockMvc.perform(
                post("/friendsdto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(testToken))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(dto));
    }

    @Test
    public void testGetFriendsDtoInvalidToken() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                post("/friendsdto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetNoFriendsDto() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
        expect(socialSecurity.getUserId(testToken)).andReturn(testUserId);
        expect(socialService.getSocialNoFriendsDto(testUserId))
                .andReturn(new SocialDto());
        replay(socialService);
        replay(socialSecurity);

        String dto = new ObjectMapper().writeValueAsString(new SocialDto());

        mockMvc.perform(
                post("/nofriendsdto")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(testToken))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(dto));
    }

    @Test
    public void testGetNoFriendsDtoInvalidToken() throws Exception {
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        mockMvc.perform(
                post("/nofriendsdto")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(testToken))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testAddTokenNew() throws Exception {

        expect(socialService.getUserByLogin(testLogin)).andReturn(testUser);
        expect(socialSecurity.getToken(testUserId)).andReturn(null);
        expect(socialSecurity.generateSecurityToken(anyInt(), anyString()))
                .andReturn(testToken);
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                get("/token?login=" + testLogin)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(new ObjectMapper().writeValueAsString(testToken)));

    }

    @Test
    public void testAddTokenOld() throws Exception {
        expect(socialService.getUserByLogin(testLogin)).andReturn(testUser);
        expect(socialSecurity.getToken(testUserId)).andReturn(testToken);
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1, testRole2)).andReturn(true);
        replay(socialSecurity);
        replay(socialService);
        mockMvc.perform(
                get("/token?login=" + testLogin)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Role", testRole)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(new ObjectMapper().writeValueAsString(testToken)));

    }

    @Test
    public void testIsUserValidTrue() throws Exception {
        expect(socialService.getUserByLogin(testLogin))
                .andReturn(testUser);
        replay(socialService);
        replay(socialSecurity);
        String user = new ObjectMapper().writeValueAsString(testUser);
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
        expect(socialService.getUserByLogin(testLogin))
                .andReturn(new User(testLogin, testPassword));
        replay(socialService);
        replay(socialSecurity);
        String user = new ObjectMapper().writeValueAsString(new User(testLogin, testPassword + testUserId2));
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
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(true);
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
                .content(new ObjectMapper().writeValueAsString(testToken))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(dto));
    }

    @Test
    public void testGetUsersDtoByDateInvalidToken() throws Exception {
        Date date1 = getDate("2015-10-01");
        Date date2 = getDate("2015-11-01");
        expect(socialSecurity.isTokenValid(testToken, testRole, testRole1)).andReturn(false);
        replay(socialService);
        replay(socialSecurity);
        String dto = new ObjectMapper().writeValueAsString(new SocialDto());
        mockMvc.perform(
                post("/userdtobydate?datemin=2015-10-01&datemax=2015-11-01")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(testToken))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(""));
    }


}
