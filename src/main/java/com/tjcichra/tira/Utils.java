package com.tjcichra.tira;

import java.util.Optional;

import com.tjcichra.tira.database.models.User;
import com.tjcichra.tira.database.repositories.UserRepository;
import com.tjcichra.tira.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Utils {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser() {
        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findById(myUserDetails.getUserId());
        user.orElseThrow(() -> new IllegalStateException("User not found"));
        return user.get();
    }
}
