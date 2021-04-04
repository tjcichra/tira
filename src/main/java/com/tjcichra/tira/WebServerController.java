package com.tjcichra.tira;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebServerController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
