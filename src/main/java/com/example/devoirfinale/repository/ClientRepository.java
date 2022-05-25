package com.example.devoirfinale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.devoirfinale.model.*;

public interface ClientRepository extends JpaRepository<Client, Integer >{
	@Query(value = "select t from Ticket t where t.client.id=:idClient")
	List<Ticket> getTickets(@Param("idClient") int id);
}
