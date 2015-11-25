package com.epam.brest.course2015.social.web;

import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexander on 12.11.15.
 */
public class WebOptionsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException,
                                                    ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (response.getHeader("Access-Control-Allow-Origin") == null) {
            response.addHeader("Access-Control-Allow-Origin",
                                request.getHeader("Origin"));
            response.addHeader("Access-Control-Allow-Credentials",
                                "true");
        }
        response.addHeader("Access-Control-Allow-Methods",
                           "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.addHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
