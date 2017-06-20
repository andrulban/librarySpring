package com.andruha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by andrusha on 19.06.17.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/imageUpload")
    public String imageUpload() {
        return "pages/imageUpload.html";
    }


}
