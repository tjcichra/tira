package com.tjcichra.tira.database.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String subject;

    private String description;

    private String status;

    private int priority;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeCreated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reporter;

    @ManyToMany
    private List<User> assignees;

    @ManyToMany
    private List<Comment> comments;
}
