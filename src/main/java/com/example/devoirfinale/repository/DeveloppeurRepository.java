package com.example.devoirfinale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.devoirfinale.model.*;
public interface DeveloppeurRepository extends JpaRepository<Developpeur, Integer>{
	@Query(value = "select t from Ticket t where t.developpeur.id=:idDev")
	List<Ticket> getTickets(@Param("idDev") int id);
}
