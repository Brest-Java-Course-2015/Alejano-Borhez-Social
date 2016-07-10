package com.epam.brest.course2015.social.app;

import com.cloudinary.utils.ObjectUtils;
import com.epam.brest.course2015.social.test.Logged;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * Created by alexander_borohov on 7.7.16.
 */
@Controller
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
//    Preparing a Cloudinary instance
    private final Cloudinary cloudinary = new Cloudinary(
            ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
            )
    );



    @PostMapping("/upload")
    @Logged
    public ModelAndView uploadImage (@RequestParam("file") MultipartFile file) {
//        Preparing file to upload
        File binaryBody = new File(file.getOriginalFilename());
        ModelAndView model = new ModelAndView("user-image");
        try {
            file.transferTo(binaryBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Sending an upload request
        try {
            Map uploadResult = cloudinary.uploader().upload(
              file, ObjectUtils.asMap(
                            "public_id", file.getOriginalFilename()
                    )
            );
//        Recieving URL of uploaded image
            String url = cloudinary.url().format("jpg").
                    generate(file.getOriginalFilename());
            model.addObject("imageURL", url);
//        Persisting URL in a database
//            some Implementation
//            ...

        } catch (IOException e) {
            e.printStackTrace();
        }
//

        return model;
    }

}
