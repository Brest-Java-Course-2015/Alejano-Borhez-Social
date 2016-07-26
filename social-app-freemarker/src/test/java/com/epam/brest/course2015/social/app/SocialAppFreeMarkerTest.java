package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static org.easymock.EasyMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by alexander_borohov on 27.6.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:freemarker-test.xml"})
public class SocialAppFreeMarkerTest {
    private static final String TEST_TOKEN = "token";

    @Resource
    private SocialAppFreeMarker socialController;


    private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".ftl");

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
    public void testDeleteFriend() throws Exception {
        expect(socialController.deleteFriend(anyObject(Cookie.class), anyInt()))
                .andReturn("forward:/friends");
        replay(socialController);
        mockMvc.perform(
                get("/user/friendship/del?id2=6")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/friends"));

    }

    @Test
    public void testAddFriend() throws Exception {
        expect(socialController.addFriendship(anyObject(Cookie.class), anyInt()))
                .andReturn("forward:/nofriends");
        replay(socialController);
        mockMvc.perform(
                get("/user/friendship/add?id2=6")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/nofriends"));
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
        expect(socialController.addUserSubmit(anyObject(User.class), anyObject(HttpServletResponse.class)))
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
                .andExpect(forwardedUrl("/WEB-INF/view/adduser.ftl"))
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
//  Tests for newly implemented methods

    @Test
    public void testChangePassword() throws Exception {
        expect(socialController.changePassword(anyObject(Cookie.class), anyString()))
                .andReturn("forward:/user");
        replay(socialController);

        mockMvc.perform(
                get("/user/password" +
                        "?password=password")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/user"));
    }

    @Test
    public void testChangeLogin() throws Exception {
        expect(socialController.changeLogin(anyObject(Cookie.class), anyString()))
                .andReturn("forward:/user");
        replay(socialController);

        mockMvc.perform(
                get("/user/" +
                        "login" +
                        "?login=login")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/user"));
    }

/*    @Test
    public void testChangeFirstName() throws Exception {
        expect(socialController.changeFirstName(anyObject(Cookie.class), anyString()))
                .andReturn("forward:/user");
        replay(socialController);

        mockMvc.perform(
                get("/user/" +
                        "firstname" +
                        "?firstname=firstname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(forwardedUrl("/user"));
    }*/

    @Test
    public void testChangeLastName() throws Exception {
        expect(socialController.changeLastName(anyObject(Cookie.class), anyString()))
                .andReturn("forward:/user");
        replay(socialController);

        mockMvc.perform(
                get("/user/" +
                        "lastname" +
                        "?lastname=lastname")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/user"));
    }

    @Test
    public void testGetUsersDto() throws Exception {
        ModelAndView testMav = new ModelAndView("users", "dto", new SocialDto());
        String testMA = new ObjectMapper().writeValueAsString(testMav);
        expect(socialController.getAllUsersDto(anyObject(Cookie.class), anyObject(HttpServletResponse.class)))
                .andReturn(testMav);
        replay(socialController);

        mockMvc.perform(
                get("/users")
                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/users.ftl"))
                .andExpect(view().name("users"));
    }


    @Test
    public void testGetAllUsersByDate() throws Exception {
        expect(socialController
                .getAllUsersByDate(anyObject(Cookie.class)
                        , anyObject(HttpServletResponse.class),
                        anyString(),
                        anyString())
        )
                .andReturn(new ModelAndView("usersbydate", "dto", new SocialDto()));
        replay(socialController);
        mockMvc.perform(
                get("/usersbydate?datemin=2015-10-01&datemax=2015-11-01")
                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/usersbydate.ftl"))
                .andExpect(view().name("usersbydate"));
    }

}