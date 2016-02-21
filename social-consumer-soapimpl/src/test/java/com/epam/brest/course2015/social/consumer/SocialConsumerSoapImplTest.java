package com.epam.brest.course2015.social.consumer;

import com.epam.brest.course2015.social.soap.*;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.core.User;
//import com.epam.brest.course2015.social.dto.SocialWebService;
//import com.epam.brest.course2015.social.dto.SocialWebServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


/**
 * Created by alexander on 30.1.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:social-consumer-soapimpl-test.xml")
public class SocialConsumerSoapImplTest {

    SocialWebService webService = new SocialWebServiceService().getSocialWebServicePort();

    @Test
    public void testHello() throws Exception {
        String hello = webService.sayHello();
        assertNotNull(hello);
        assertEquals(hello.getClass(), String.class);
        assertEquals(hello, "HellO!");

    }

    @Test
    public void testGetUser() throws Exception {

    }

    @Test
    public void testGetAllUsers() throws Exception {
        SocialDto dto = webService.getAllUsers();
        System.out.println(dto);
        assertNotNull(dto);
        assertEquals(dto.getClass(), SocialDto.class);
        assertEquals(dto.getUser().getClass(), User.class);
        assertNotNull(dto.getUsers());
        assertEquals(dto.getUsers().get(0).getClass(), User.class);
    }
    @Test
    public void testGetAllUsersByDate() throws Exception {

    }

    @Test
    public void testGetAllFriends() throws Exception {

    }

    @Test
    public void testGetAllNoFriendsOfAUser() throws Exception {

    }

    @Test
    public void testAddUserSubmit() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testAddFriendship() throws Exception {

    }

    @Test
    public void testDeleteFriend() throws Exception {

    }

    @Test
    public void testChangePassword() throws Exception {

    }

    @Test
    public void testChangeLogin() throws Exception {

    }

    @Test
    public void testChangeFirstName() throws Exception {

    }

    @Test
    public void testChangeLastName() throws Exception {

    }
}