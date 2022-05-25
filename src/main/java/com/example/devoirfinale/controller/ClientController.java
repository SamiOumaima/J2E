package com.example.devoirfinale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devoirfinale.service.*;
import com.example.devoirfinale.model.*;



@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public void ajouter(@RequestBody Client client) {
		clientService.ajouter(client);
	}
	
	@PostMapping("/{idClient}")
	public void ajouter(@PathVariable int idClient, @RequestBody Ticket ticket) {
		ticket.setStatut("");
		clientService.ajouterTicket(idClient,ticket);
	}
	
	@GetMapping
	public List<Client> ListClient(){
		return clientService.lesClients();
	}
	
	@GetMapping("/{id}/tickets")
	public List<Ticket> ListTicket(@PathVariable int id){
		return clientService.getTickets(id);
	}
	
}
