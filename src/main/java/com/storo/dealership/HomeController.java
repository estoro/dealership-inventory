package com.storo.dealership;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController implements ErrorController {

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "error.html";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
