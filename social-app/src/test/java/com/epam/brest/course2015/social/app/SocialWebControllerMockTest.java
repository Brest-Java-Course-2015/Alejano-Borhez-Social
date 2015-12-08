package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by alexander on 8.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-app-spring-mock-rest-test.xml"})
@WebAppConfiguration
public class SocialWebControllerMockTest {
    @Value("${rest.prefix}")
    private String restPrefix;

    @Resource
    SocialWebController socialWebController;

    @Autowired
    private RestTemplate restTemplate;

    private MockMvc mockMvc;

    private MockRestServiceServer mockServer;



    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = standaloneSetup(socialWebController)
                .setMessageConverters(
                        new MappingJackson2HttpMessageConverter())
                .setViewResolvers(viewResolver)
                .build();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInit() throws Exception {
        mockServer.expect(
                requestTo(restPrefix))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(
                        "redirect:users",
                        MediaType.APPLICATION_JSON));

        mockMvc.perform(
                get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("users"));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        mockServer.expect(
                requestTo(restPrefix + "userdto"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(
                        "{\"users\":null,\"totalUsers\":null,\"user\":null}",
                        MediaType.APPLICATION_JSON));

        mockMvc.perform(
                get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/users.jsp"));
    }

    @Test
    public void testGetAllUsersByDate() throws Exception {

        mockServer.expect(
                requestTo(restPrefix +
                        "userdtobydate" +
                        "?datemin=2015-10-01&datemax=2015-11-01"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(
                        "{\"users\":null,\"totalUsers\":null,\"user\":null}",
                        MediaType.APPLICATION_JSON));

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

        mockServer.expect(
                requestTo(restPrefix +
                "friendsdto" +
                "?id=2"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(
                        "{\"users\":null,\"totalUsers\":null,\"user\":null}",
                        MediaType.APPLICATION_JSON));

        mockMvc.perform(
                get("/friends?id=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/friends.jsp"));

    }

    @Test
    public void testDeleteFriend() throws Exception {

        mockServer.expect(
                requestTo(restPrefix +
                        "user/friendship"
                        + "?id1=5"
                        + "&id2=6"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withSuccess(
                        "forward:/nofriends?id=5",
                        MediaType.APPLICATION_JSON));

        mockMvc.perform(
                get("/user/friendship/del?id1=5&id2=6")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/friends?id=5"));
    }

    @Test
    public void testAddFriendship() throws Exception {

        mockServer.expect(
                requestTo(restPrefix +
                        "user/friendship"
                        + "?id1=5"
                        + "&id2=6"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess(
                        "forward:/nofriends?id=",
                        MediaType.APPLICATION_JSON));

        mockMvc.perform(
                get("/user/friendship/add?id1=5&id2=6")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/nofriends?id=5"));
    }

    @Test
    public void testGetUser() throws Exception {
        mockServer.expect(
                requestTo(restPrefix +
                        "friendsdto"
                        + "?id=2"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess());

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
        String user = new ObjectMapper()
                .writeValueAsString(new SocialDto());
        mockServer.expect(
                requestTo(restPrefix +
                        "user"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess());

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
        mockMvc.perform(
                get("/adduser")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/adduser.jsp"))
                .andExpect(view().name("adduser"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockServer.expect(
                requestTo(restPrefix +
                        "user" +
                        "?id=1"))
                .andExpect(method(HttpMethod.DELETE))
                .andRespond(withSuccess());

        mockMvc.perform(
                get("/user/delete?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testChangePassword() throws Exception {
        mockServer.expect(
                requestTo(restPrefix
                        + "user/password"
                        + "?id=1"
                        + "&password=password"))
                .andExpect(method(HttpMethod.PUT))
                .andRespond(withSuccess());

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
        mockServer.expect(
                requestTo(restPrefix
                        + "user/login"
                        + "?id=1"
                        + "&login=login"))
                .andExpect(method(HttpMethod.PUT))
                .andRespond(withSuccess());

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
        mockServer.expect(
                requestTo(restPrefix
                        + "user/firstname"
                        + "?id=1"
                        + "&firstname=firstname"))
                .andExpect(method(HttpMethod.PUT))
                .andRespond(withSuccess());

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
        mockServer.expect(
                requestTo(restPrefix
                        + "user/lastname"
                        + "?id=1"
                        + "&lastname=lastname"))
                .andExpect(method(HttpMethod.PUT))
                .andRespond(withSuccess());

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
        mockServer.expect(
                requestTo(restPrefix +
                                "nofriendsdto"
                                + "?id=4"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess());

        mockMvc.perform(
                get("/nofriends?id=4")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/view/nofriends.jsp"))
                .andExpect(view().name("nofriends"));
    }
}