package com.tjcichra.tira.database.repositories;

import com.tjcichra.tira.database.models.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tickets", path = "tickets")
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
