package com.andruha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by andrusha on 19.06.17.
 */
@Controller
public class IndexController {

    /**
     * It redirects to index.
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    /**
     * It shows login page.
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "pages/login.html";
    }

    /**
     * It redirects to index.
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String books() {
        return "index.html";
    }

}
