package com.lln.api.controller;

import com.lln.api.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/9/24 11:14
 */

@Controller
@CrossOrigin
public class ImageController {

    public final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/img")
    public void image(String url, HttpServletResponse response) {
        imageService.image(url, response);
    }
}
