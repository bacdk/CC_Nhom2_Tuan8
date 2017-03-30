package com.hellokoding.springboot;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "thymeleaf/hello";
        //return "jsp/conference.jsp";
    }
    @RestController
    public class IndexController implements ErrorController{

        private static final String PATH = "/error";

        @RequestMapping(value = PATH)
        public String error() {
            return "Error handling";
        }

        @Override
        public String getErrorPath() {
            return PATH;
        }
    }
}
