package com.example.devoirfinale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.devoirfinale.*;
import com.example.devoirfinale.model.Administrateur;
import com.example.devoirfinale.model.Ticket;


public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer>{

	@Query(value = "select t from Ticket t WHERE t.developpeur.id is not  null")
	List<Ticket> getTicketAttribues();
	
	@Query(value = "select t from Ticket t WHERE t.developpeur.id is  null and t.admin.id is not  null")
	List<Ticket> getTicketNullTicket();
	
	
	@Query(value = "select t from Ticket t WHERE t.admin.id is  null")
	List<Ticket> getTicketNullAdmin();
	
	@Query(value = "select t from Ticket t WHERE t.admin.id is not  null and t.developpeur.id is not  null")
	List<Ticket> getTickeNottNullAdmin();
	
	

}
