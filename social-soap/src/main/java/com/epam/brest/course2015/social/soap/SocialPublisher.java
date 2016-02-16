package com.epam.brest.course2015.social.soap;

import org.springframework.beans.factory.annotation.Value;

import javax.xml.ws.Endpoint;

/**
 * Created by alexander on 16.2.16.
 */

public class SocialPublisher {
    private static String url = "http://localhost:8081/soap";
    public static void main(String[] args) {
        Endpoint.publish(url, new SocialWebService());
    }
}
