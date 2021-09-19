package com.tjcichra.tira;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.tjcichra.tira.database.models.Category;
import com.tjcichra.tira.database.models.Ticket;
import com.tjcichra.tira.database.models.User;
import com.tjcichra.tira.database.repositories.CategoryRepository;
import com.tjcichra.tira.database.repositories.TicketRepository;
import com.tjcichra.tira.database.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WebServerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Utils utils;

    @GetMapping("/")
    public String index(Model model) {
        User user = utils.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/ticketlist")
    public String ticketlist(Model model, @RequestParam(required = false) Long category) {
        List<Ticket> tickets;
        if(category != null) {
            Category category2 = categoryRepository.findById(category).get();
            tickets = category2.getTickets();            
        } else {
            tickets = ticketRepository.findAll();
        }
        model.addAttribute("tickets", tickets);
        return "ticketlist";
    }

    @GetMapping("/createticket")
    public String createticket(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "createticket";
    }

    @GetMapping("/createcategory")
    public String createcategory(Model model) {
        return "createcategory";
    }

    @GetMapping("/ticket/{id}")
    public String ticket(Model model, @PathVariable Long id) {
        Optional<Ticket> ticket = this.ticketRepository.findById(id);
        ticket.orElseThrow(() -> new IllegalArgumentException("Ticket not found"));
        model.addAttribute("ticket", ticket.get());
        return "ticket";
    }

    @PostMapping("/createnewticket")
    public RedirectView createticketPost(Model model, @RequestBody MultiValueMap<String, String> formData) {
        User user = utils.getCurrentUser();
        System.out.println(formData);
        Ticket ticket = new Ticket();
        ticket.setSubject(formData.get("subject").get(0));
        ticket.setDescription(formData.get("description").get(0));
        ticket.setReporter(user);
        ticket.setCategory(categoryRepository.findById(Long.valueOf(formData.get("category").get(0))).get());
        ticket.setDatetimeCreated(new Date());

        List<User> assignees = new ArrayList<>();
        for(String sUserId : formData.get("assignees")) {
            long userId = Long.valueOf(sUserId);
            User assignee = userRepository.findById(userId).get();
            System.out.println(assignee);
            assignees.add(assignee);
        }

        ticket.setAssignees(assignees);
        Ticket savedTicket = ticketRepository.save(ticket);
        return new RedirectView("/ticket/" + savedTicket.getId());
    }

    @PostMapping("/createnewcategory")
    public RedirectView createcategoryPost(Model model, @RequestBody MultiValueMap<String, String> formData) {
        Category category = new Category();
        category.setName(formData.get("name").get(0));
        category.setDescription(formData.get("description").get(0));
        category.setDatetimeCreated(new Date());
        categoryRepository.save(category);
        return new RedirectView("/");
    }
}
