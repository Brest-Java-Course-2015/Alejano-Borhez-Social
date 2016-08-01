package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.mail.SocialMail;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander_borohov on 26.7.16.
 */
@Controller
@RequestMapping("admin")
@ControllerAdvice
public class SocialUserAdministrator {

    @Autowired
    private SocialConsumer socialConsumer;
    @Autowired
    private SocialMail socialMail;

    @RequestMapping("recover")
    public ModelAndView recoverPassword(@RequestParam("token") String token) {
        ModelAndView mav = new ModelAndView("recovery");

        return mav;
    }

    @RequestMapping("approve")
    public ModelAndView approveRegistration(@RequestParam("token") String token) {
        ModelAndView mav = new ModelAndView("approve");

        return mav;
    }

    @RequestMapping("addusersubmit")
    @Logged
    public ModelAndView addUserSubmit(@ModelAttribute("user") User user,
                                      HttpServletRequest req,
                                      HttpServletResponse resp) throws IOException {
        ModelAndView mav = new ModelAndView("addusersubmit");

        if (socialConsumer.addUserSubmit(user)) {
            String token = socialConsumer.getToken(user.getLogin());
// Setting a Cookie
            Cookie cookie = new Cookie("uid", token);
            cookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie);
            mav.addObject("email", user.getEmail());
// Sending an E-mail with account verification details
            String path = req.getRequestURL().toString().replace(req.getServletPath(), "");
            socialMail.sendApprovalEmail(path, token, user);
            return mav;
        }

        resp.sendRedirect("../login");
        return null;
    }

}
