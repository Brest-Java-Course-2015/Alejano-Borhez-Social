package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.easymock.EasyMock.*;

/**
 * Created by alexander on 28.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-app-spring-mock-test.xml"})
@WebAppConfiguration
public class SocialWebControllerTest extends TestCase {
    @Value("${rest.prefix}")
    private String restPrefix;

    public static Logger logger = LogManager.getLogger();

    @Resource
    private SocialWebController socialController;

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
        verify(socialController);
        reset(socialController);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        expect(socialController.getAllUsers()).andReturn(new ModelAndView("users", "dto", new SocialDto()));
        replay(socialController);
        mockMvc.perform(
                get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/users.jsp"));
    }

    @Test
    public void testGetAllUsersByDate() throws Exception {
        expect(socialController.getAllUsersByDate("2015-10-01", "2015-11-01"))
                .andReturn(new ModelAndView("usersbydate", "dto", new SocialDto()));
        replay(socialController);
        mockMvc.perform(
                get("/usersbydate?datemin=2015-10-01&datemax=2015-11-01")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/usersbydate.jsp"))
                .andExpect(view().name("usersbydate"));
    }

    @Test
    public void testGetAllFriends() throws Exception {
        expect(socialController.getAllFriends(2))
                .andReturn(new ModelAndView("friends", "dto", new SocialDto()));
        replay(socialController);
        mockMvc.perform(
                get("/friends?id=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/friends.jsp"));
    }

    @Test
    public void testDeleteFriend() throws Exception {
        expect(socialController.deleteFriend(5, 6))
        .andReturn("forward:/friends?id=5");
        replay(socialController);
        mockMvc.perform(
                get("/user/friendship/del?id1=5&id2=6")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/friends?id=5"));

    }

    @Test
    public void testAddFriend() throws Exception {
        expect(socialController.addFriendship(5, 6))
                .andReturn("forward:/nofriends?id=5");
        replay(socialController);
        mockMvc.perform(
                get("/user/friendship/add?id1=5&id2=6")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/nofriends?id=5"));
    }

    @Test
    public void testGetUser() throws Exception {
        expect(socialController.getUser(2))
                .andReturn(new ModelAndView("user", "dto", new SocialDto()));
        replay(socialController);
        mockMvc.perform(
                get("/user?id=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/user.jsp"))
                .andExpect(view().name("user"));

    }

    @Test
    public void testAddUserSubmit() throws Exception {
        User testUser = new User(
                "login"
                , "password"
                , "firstName"
                , "lastName"
                , 29
        );
        expect(socialController.addUserSubmit(anyObject(User.class)))
                .andReturn("forward:/users");
        replay(socialController);
        String user = new ObjectMapper().writeValueAsString(testUser);
        mockMvc.perform(
                post("/addusersubmit")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(user))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/users"));

    }

    @Test
    public void testAddUser() throws Exception {
        expect(socialController.addUser())
                .andReturn(new ModelAndView("adduser"));
        replay(socialController);

        mockMvc.perform(
                get("/adduser")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/adduser.jsp"))
                .andExpect(view().name("adduser"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        expect(socialController.deleteUser(1))
                .andReturn("forward:/users");
        replay(socialController);

        mockMvc.perform(
                get("/user/delete?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testChangePassword() throws Exception {
        expect(socialController.changePassword(1, "password"))
                .andReturn("forward:/user?id=1");
        replay(socialController);

        mockMvc.perform(
                get("/user/password" +
                        "?id=1&password=password")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/user?id=1"));
    }

    @Test
    public void testChangeLogin() throws Exception {
        expect(socialController.changeLogin(1, "login"))
                .andReturn("forward:/user?id=1");
        replay(socialController);

        mockMvc.perform(
                get("/user/" +
                        "login" +
                        "?id=1" +
                        "&login=login")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/user?id=1"));
    }

    @Test
    public void testChangeFirstName() throws Exception {
        expect(socialController.changeFirstName(1, "firstname"))
                .andReturn("forward:/user?id=1");
        replay(socialController);

        mockMvc.perform(
                get("/user/" +
                        "firstname" +
                        "?id=1" +
                        "&firstname=firstname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/user?id=1"));
    }

    @Test
    public void testChangeLastName() throws Exception {
        expect(socialController.changeLastName(1, "lastname"))
                .andReturn("forward:/user?id=1");
        replay(socialController);

        mockMvc.perform(
                get("/user/" +
                        "lastname" +
                        "?id=1" +
                        "&lastname=lastname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/user?id=1"));
    }

    @Test
    public void testGetAllNoFriendsOfAUser() throws Exception {
        expect(socialController.getAllNoFriendsOfAUser(4))
                .andReturn(new ModelAndView("nofriends"
                                          , "dto"
                                          , new SocialDto()));
        replay(socialController);

        mockMvc.perform(
                get("/nofriends?id=4")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/nofriends.jsp"))
                .andExpect(view().name("nofriends"));
    }
}