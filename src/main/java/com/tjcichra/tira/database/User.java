package com.tjcichra.tira.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String name;

    @OneToMany(mappedBy = "reporter")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "commenter")
    private List<Comment> comments;
}
