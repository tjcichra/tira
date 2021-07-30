package com.tjcichra.tira;

import java.util.ArrayList;
import java.util.List;

import com.tjcichra.tira.database.models.Ticket;
import com.tjcichra.tira.database.models.User;
import com.tjcichra.tira.database.repositories.TicketRepository;
import com.tjcichra.tira.database.repositories.UserRepository;
import com.tjcichra.tira.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebServerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/")
    public String index(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);

        return "index";
    }

    @GetMapping("/ticketlist")
    public String ticketlist(Model model) {
        List<Ticket> tickets = this.ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "ticketlist";
    }

    @GetMapping("/createticket")
    public String createticket(Model model) {
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        model.addAttribute("users", userRepository.findAll());
        return "createticket";
    }

    @GetMapping("/ticket/{id}")
    public String ticket(int id) {
        return "ticket";
    }

    @PostMapping("/createnewticket")
    public String createticketPost(@RequestBody MultiValueMap<String, String> formData) {
        System.out.println(formData);
        Ticket ticket = new Ticket();
        ticket.setSubject(formData.get("subject").get(0));
        ticket.setDescription(formData.get("description").get(0));
        ticket.setReporter(userRepository.findById(Long.valueOf(formData.get("reporter").get(0))).get());

        List<User> assignees = new ArrayList<>();
        for(String sUserId : formData.get("assignees")) {
            long userId = Long.valueOf(sUserId);
            User user = userRepository.findById(userId).get();
            System.out.println(user);
            assignees.add(user);
        }

        ticket.setAssignees(assignees);
        ticketRepository.save(ticket);

        System.out.println(ticket);
        return "createticket_error";
    }
}
