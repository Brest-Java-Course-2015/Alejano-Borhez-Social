package com.epam.brest.course2015.social.appmarker;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alexander_borohov on 27.6.16.
 */
@Controller
public class SocialAppFreeMarker {

    @Value("${rest.prefix}")
    private String restPrefix;

    @Autowired
    private SocialConsumer socialConsumer;

    @Logged
    @RequestMapping ("/hello")
    public ModelAndView hello () {
        String hello = "Hello!";
        return new ModelAndView("hello", "hello", hello);
    }

    @Logged
    @RequestMapping ("/users")
    public ModelAndView users () {
        SocialDto dto = socialConsumer.getAllUsers();
        ModelAndView model = new ModelAndView("users", "dto", dto);
        model.addObject("restPrefix", restPrefix);
        return model;
    }

    @Logged
    @RequestMapping ("/user")
    public ModelAndView user (@RequestParam("id") Integer id) {
        SocialDto dto = socialConsumer.getUser(id);
        ModelAndView model = new ModelAndView("user", "dto", dto);
        model.addObject("restPrefix", restPrefix);
        model.addObject("mapping", "usertab");

        return model;
    }

//  used for
    @Logged
    @RequestMapping ("/restAPI")
    @ResponseBody
    public String restPrefix () {
        return restPrefix + "/websocket/endpoint";
    }
}
