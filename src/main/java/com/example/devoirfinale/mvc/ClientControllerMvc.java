package com.example.devoirfinale.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.devoirfinale.model.Client;
import com.example.devoirfinale.model.Ticket;
import com.example.devoirfinale.service.ClientService;

@Controller
@RequestMapping("/")
public class ClientControllerMvc {
	@Autowired
	private ClientService clientService;
	
	
	
	@GetMapping("/acceuilClients")
	public String index() {
		return "clients/acceuil";
	}
	
	@GetMapping("/newClient")
	public String showNewClient(Model model) {
		Client clients = new Client();
		model.addAttribute("clients", clients);
		
		return "clients/new_client";
	}
	
	@GetMapping("/showClient")
	public String viewClientPage(Model model) {
		List<Client> listClients = clientService.lesClients();
		model.addAttribute("listClients", listClients);
		
		return "clients/show_client";
	}
	
	@GetMapping("/showTickets")
	public String viewTicketsPage(Model model) {
		List<Ticket> listTickets = clientService.lesTickets();
		model.addAttribute("listTickets", listTickets);
		return "clients/show_tickets";
	}
                                                                                     
	@GetMapping("/newClientTicket")
	public String showNewClientTicket(Model model) {
		Ticket ticket = new Ticket();
		ticket.setStatut("");
		ticket.setDeveloppeur(null);
		model.addAttribute("tickets", ticket);
		List<Client> listClients = clientService.lesClients();
		model.addAttribute("listClients", listClients);
		return "clients/new_tickets";
	}
	@RequestMapping(value = "/saveT", method = RequestMethod.POST)
	public String saveTickets(@ModelAttribute("tickets") Ticket ti) {
		clientService.ajouterTicketMvc(ti);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveClient(@ModelAttribute("clients") Client client) {
		clientService.ajouter(client);
		return "redirect:/";
	}
}
