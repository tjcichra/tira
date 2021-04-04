package com.tjcichra.tira.database;

import com.tjcichra.tira.database.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setUsername("user");
        u.setPassword("test");
        u.setName("Test User");
        this.userRepository.save(u);
    }
}
