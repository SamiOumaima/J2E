package com.example.devoirfinale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.devoirfinale.model.Developpeur;
import com.example.devoirfinale.model.Ticket;
import com.example.devoirfinale.repository.TicketRepository;
import com.example.devoirfinale.service.DevService;

@RestController
@RequestMapping("/dev")
public class DevController {
	@Autowired
	DevService devService;
	@Autowired
	TicketRepository ticketRepository;
	
	@PostMapping
	public void ajouter(@RequestBody Developpeur developpeur) {
		devService.ajouter(developpeur);
	}
	
	@PostMapping("/{idTicket}/{statut}")
	public void ajouter(@PathVariable int idTicket , @PathVariable String statut) {
		Ticket t= ticketRepository.findById(idTicket).get();
		t.setStatut(statut);
		ticketRepository.save(t);
	}

	@GetMapping("list")
	public List<Developpeur> ListDev(){
		return devService.lesdevs();
	}
	
	@GetMapping("/{idDev}/tickets")
	public List<Ticket> ListTicket(@PathVariable int idDev){
		return devService.getTickets(idDev);
	}
}
