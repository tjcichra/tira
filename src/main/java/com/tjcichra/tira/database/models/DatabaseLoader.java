package com.tjcichra.tira.database.models;

import java.util.ArrayList;

import com.tjcichra.tira.database.repositories.CategoryRepository;
import com.tjcichra.tira.database.repositories.TicketRepository;
import com.tjcichra.tira.database.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // User u = new User();
        // u.setUsername("tim");
        // u.setPassword("test");
        // u.setName("Tim");
        // this.userRepository.save(u);

        // User u2 = new User();
        // u2.setUsername("justin");
        // u2.setPassword("test");
        // u2.setName("Justin");
        // this.userRepository.save(u2);

        // Category c = new Category();
        // c.setName("Tira");
        // this.categoryRepository.save(c);

        // Ticket tick = new Ticket();
        // tick.setSubject("Finish Tira");
        // tick.setDescription("Work on Tira until it is finished.");
        // tick.setStatus("In Progress");
        // tick.setPriority(1);
        // tick.setCategory(c);
        // tick.setReporter(u);
        // tick.setAssignees(new ArrayList<User>());
        // tick.setComments(new ArrayList<Comment>());
        // this.ticketRepository.save(tick);
    }
}
