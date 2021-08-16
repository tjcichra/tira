package com.tjcichra.tira.database.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datetimeCreated;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Ticket> tickets;
}
