package com.epam.brest.course2015.social.app;

import com.cloudinary.utils.ObjectUtils;
import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.test.Logged;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


/**
 * Created by alexander_borohov on 7.7.16.
 */
@Controller
@RequestMapping("/gallery")
public class SocialUploader {
    @Value("${server.prefix}")
    private String serverPrefix;
    @Value("${cloud.name}")
    private String cloudName;
    @Value("${api.key}")
    private String apiKey;
    @Value("${api.secret}")
    private String apiSecret;
    @Value("${api.url}")
    private String apiUrl;
    @Value("${delivery.url}")
    private String deliveryUrl;

    @Autowired
    private SocialConsumer socialConsumer;


//    Preparing a Cloudinary instance
    private Cloudinary cloudinary = new Cloudinary(
            ObjectUtils.asMap(
                "cloud_name", "simple-social",
                "api_key", "543582919166178",
                "api_secret", "ZJuERS_91Sda3qhiLog6ZQ4DRgQ"
            )
    );



    @PostMapping("/upload")
    @Logged
    public String uploadImage (@RequestParam("file") MultipartFile file,
                               @CookieValue(name = "uid", required = false) Cookie cookie)
            throws IOException {
        if (cookie != null) {
        String token = cookie.getValue();
//      Preparing file to upload
            File binaryBody = new File(file.getOriginalFilename());
            file.transferTo(binaryBody);
            String filename = FilenameUtils.getBaseName(file.getOriginalFilename());
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//      Sending an upload request
            Transformation transformation =
                    new Transformation().width(200).crop("fill").gravity("face");

            Map uploadResult = cloudinary.uploader().upload(
                    binaryBody,
                    ObjectUtils.asMap(
                            "eager", Arrays.asList(transformation),
                            "public_id", filename
                    )
            );

            binaryBody.delete();
//      Receiving URL of uploaded image

            Transformation transformation50 =
                    new Transformation().height(50).crop("fill");
            Transformation transformation81 =
                    new Transformation().height(81).crop("fill");
            String url = cloudinary.url().format(extension).transformation(transformation).
                    generate(filename);
            String url50 = cloudinary.url().format(extension).transformation(transformation50).
                    generate(filename);
            String url81 = cloudinary.url().format(extension).transformation(transformation81).
                    generate(filename);
//      Persisting URL in a database
            socialConsumer.addImage(token, url, url50, url81);

        }
//
        return "redirect:/photo";
    }

    @RequestMapping("/delete")
    @Logged
    public String deleteImage (@CookieValue(name = "uid", required = false) Cookie cookie,
                               @RequestParam("imageId") Integer imageId) {
        if (cookie != null) {
            String token = cookie.getValue();
            socialConsumer.deleteImage(token, imageId);
        }
        return "redirect:/user";

    }

    @PutMapping("/rename")
    @Logged
    public void renameImage (@CookieValue(name = "uid", required = false) Cookie cookie,
                             @RequestParam("name") String name) {
        if (cookie != null) {
            String token = cookie.getValue();
            socialConsumer.renameImage(token, name);
        }
    }

    @RequestMapping("/cloudAPI")
    @Logged
    @ResponseBody
    public String cloudinaryAPI() {

        return "{ cloud_name: '" +
                cloudName +
                "', api_key: '" +
                apiKey +
                "'}";
    }

}
