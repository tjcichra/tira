package com.tjcichra.tira.database.models;

import java.util.ArrayList;

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

    @Override
    public void run(String... args) throws Exception {
        // User u = new User();
        // u.setUsername("user");
        // u.setPassword("test");
        // u.setName("Test User");
        // this.userRepository.save(u);

        // Ticket tick = new Ticket();
        // tick.setSubject("Finish Tira");
        // tick.setDescription("Work on Tira until it is finished.");
        // tick.setStatus("In Progress");
        // tick.setPriority(1);
        // tick.setReporter(u);
        // tick.setAssignees(new ArrayList<User>());
        // tick.setComments(new ArrayList<Comment>());
        // this.ticketRepository.save(tick);
    }
}
