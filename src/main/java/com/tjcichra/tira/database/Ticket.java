package com.tjcichra.tira.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private String subject;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reporter;

    @ManyToMany
    private List<User> assignees;

    @ManyToMany
    private List<Comment> comments;
}