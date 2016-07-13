package com.epam.brest.course2015.social.app;

import com.cloudinary.utils.ObjectUtils;
import com.epam.brest.course2015.social.consumer.SocialConsumer;
import com.epam.brest.course2015.social.core.Image;
import com.epam.brest.course2015.social.core.User;
import com.epam.brest.course2015.social.dto.SocialDto;
import com.epam.brest.course2015.social.test.Logged;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.IOException;
import java.util.Date;
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
    SocialConsumer socialConsumer;

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
                               @RequestParam("id") Integer id) {
        try {
//      Preparing file to upload
            File binaryBody = new File(file.getOriginalFilename());
            file.transferTo(binaryBody);
            String filename = FilenameUtils.getBaseName(file.getOriginalFilename());
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//      Sending an upload request
            Map uploadResult = cloudinary.uploader().upload(
              binaryBody,
              ObjectUtils.asMap(
                   "public_id", filename
              )
            );
//      Receiving URL of uploaded image
            String url = cloudinary.url().format(extension).
                    generate(filename);
//      Persisting URL in a database
            socialConsumer.addImage(id, url);

        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return "redirect:/user?id=" + id;
    }

    @DeleteMapping("/delete")
    @Logged
    public void deleteImage (@RequestParam("userId") Integer userId,
                               @RequestParam("imageId") Integer imageId) {
        socialConsumer.deleteImage(userId, imageId);

    }

    @PutMapping("/rename")
    @Logged
    public void renameImage (@RequestParam("id") Integer id,
                             @RequestParam("name") String name) {
        socialConsumer.renameImage(id, name);
    }
}
