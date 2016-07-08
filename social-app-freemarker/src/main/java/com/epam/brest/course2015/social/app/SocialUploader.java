package com.epam.brest.course2015.social.app;

import com.epam.brest.course2015.social.test.Logged;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.sync.CloseableHttpClient;
import org.apache.hc.core5.http.HttpEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import org.apache.hc.client5.http.impl.sync.HttpClients;
import org.apache.hc.client5.http.methods.CloseableHttpResponse;
import org.apache.hc.client5.http.methods.HttpPost;
import org.apache.hc.core5.http.entity.ContentType;
import org.apache.hc.core5.http.entity.EntityUtils;
import org.apache.hc.core5.http.entity.InputStreamEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Created by alexander_borohov on 7.7.16.
 */
@Controller
public class SocialUploader {
    @Value("${server.prefix}")
    private String serverPrefix;


    @PostMapping("/upload")
    @Logged
    public String uploadImage (@RequestParam("file") MultipartFile file) {

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("/2/files/upload");
        httpPost.addHeader("Host", "https://content.dropboxapi.com");
        httpPost.addHeader("User-Agent", "api-explorer-client");
        httpPost.addHeader("Authorization", "Bearer xLx86vd_jMQAAAAAAAAHsG7UhMs7vDmrff9czwnXMvdYGtDn1E1oWOXu3BpXea3b");
        httpPost.addHeader("Content-Type", "application/octet-stream");


        File binaryBody = new File(file.getOriginalFilename());

        try {
            file.transferTo(binaryBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addBinaryBody("image", binaryBody);

        HttpEntity httpEntity = entityBuilder.build();
        httpPost.setEntity(httpEntity);
        try {
            client.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            httpPost.reset();
        }


        return "redirect:/users?" + file.getName();
    }

}
