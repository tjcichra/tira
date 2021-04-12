package com.tjcichra.tira;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebServerController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/ticketlist")
    public String ticketlist() {
        return "ticketlist";
    }

    @RequestMapping(value = "/createticket")
    public String createticket() {
        return "createticket";
    }

    @RequestMapping(value = "/ticket")
    public String ticket() {
        return "ticket";
    }
}
