import com.epam.brest.course2015.social.core.Friendship;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.rest.SocialRestController;
import com.epam.brest.course2015.social.service.SocialService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import javax.annotation.Resource;


import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.easymock.EasyMock.*;

/**
 * Created by alexander on 10.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:social-rest-spring-mock-test.xml"})
public class SocialRestControllerMockTest {
    //Универсальный Логгер, который показывает имя тестового класса и имя тестового метода
    private static final Logger LOGGER = LogManager.getLogger();
    private static void LOGGERDO() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        LOGGER.debug("Started test: " + elements[2].getMethodName());
    }
    @Resource
    SocialRestController socialRestController;

    private MockMvc mockMvc;

    @Autowired
    SocialService socialService;

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

    @Test
    public void testGetAllUsers() throws Exception {
        expect(socialService.getAllUsers()).andReturn(Arrays.<User>asList(new User(3)));
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/users")
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testGetAllFriendships() throws Exception {
        expect(socialService.getAllFriendships()).andReturn(Arrays.<Friendship>asList(new Friendship(1, 2)));
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/friendships")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testGetUserById() throws Exception {
        expect(socialService.getUserById(1)).andReturn(new User(1));
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/user?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserByLogin() throws Exception {
        expect(socialService.getUserByLogin("login")).andReturn(new User(1));
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/user/login?login=login")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserFriends() throws Exception {
        expect(socialService.getFriends(1)).andReturn(Arrays.<User>asList(new User(2), new User(3)));
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/user/friends?id=1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddUser() throws Exception {
        expect(socialService.addUser(anyObject(User.class))).andReturn(5);
        replay(socialService);
        String user = new ObjectMapper().writeValueAsString(new User());
        LOGGERDO();
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
    public void testUpdateUser() throws Exception {
        socialService.updateUser(1, "password");
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                put("/user?id=1&password=password")
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
        LOGGERDO();
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
        LOGGERDO();
        mockMvc.perform(
                delete("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testAddFriendship() throws Exception {
        socialService.addFriendship(anyObject(User.class), anyObject(User.class));
        expectLastCall();
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                post("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testIsAFriend() throws Exception {
        expect(socialService.isAFriend(anyObject(User.class), anyObject(User.class))).andReturn(true);
        replay(socialService);
        LOGGERDO();
        mockMvc.perform(
                get("/user/friendship?id1=1&id2=2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
