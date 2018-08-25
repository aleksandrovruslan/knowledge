package com.aleksandrov.Knowledge.controllers.apiV1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ViewController {

    @RequestMapping({"", "/", "/home", "/index.html"})
    public String index(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping("/collections")
    public String collections(Map<String, Object> model) {
        return "collections";
    }

    @RequestMapping("/words")
    public String words(Map<String, Object> models) {
        return "words";
    }
}
