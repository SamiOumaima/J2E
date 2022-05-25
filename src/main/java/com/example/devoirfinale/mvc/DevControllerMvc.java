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
import org.springframework.web.servlet.ModelAndView;

import com.example.devoirfinale.model.Administrateur;
import com.example.devoirfinale.model.Client;
import com.example.devoirfinale.model.Developpeur;
import com.example.devoirfinale.model.Ticket;
import com.example.devoirfinale.repository.AdministrateurRepository;
import com.example.devoirfinale.repository.TicketRepository;
import com.example.devoirfinale.service.ClientService;
import com.example.devoirfinale.service.DevService;

@Controller
@RequestMapping("/")
public class DevControllerMvc {
	@Autowired
	private DevService devService;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	private AdministrateurRepository administrateurRepository;
	
	@GetMapping("/acceuilDevs")
	public String index2() {
		return "devs/acceuil";
	}
	@GetMapping("/newDevs")
	public String showNewDevs(Model model) {
		Developpeur developpeur = new Developpeur();
		model.addAttribute("devs", developpeur);
		return "devs/new_devs";
	}
	
	@RequestMapping(value = "/saveD", method = RequestMethod.POST)
	public String saveDevs(@ModelAttribute("devs") Developpeur devs) {
		devService.ajouter(devs);
		return "redirect:/";
	}
	@GetMapping("/showDevs")
	public String viewDevsPage(Model model) {
		List<Developpeur> listDevs = devService.lesdevs();
		model.addAttribute("listDevs", listDevs);
		
		return "devs/show_devs";
	}
	@RequestMapping("/updateStatut/{id}")
	public ModelAndView showEditStatusForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("devs/status");
		Ticket tickets = clientService.get(id);
		tickets.setStatut(tickets.getStatut());
		mav.addObject("tickets", tickets);
		return mav;
	}
	
	@PostMapping("/saveStatus")
	public String ajouterStatus(@ModelAttribute("tickets") Ticket tickets) {
		ticketRepository.save(tickets);
		return "redirect:/";
	}
	
	@RequestMapping("/updateDevs/{id}")
	public ModelAndView showEditDevsForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("devs/devs");
		Ticket tickets = clientService.get(id);
		//Liste Des Developpeurs
		List<Developpeur> listDevs = devService.lesdevs();
		mav.addObject("listDevs", listDevs);
		
		mav.addObject("tickets", tickets);
		return mav;
	}
	
	@PostMapping("/saveDevs")
	public String ajoutersaveDevs(@ModelAttribute("tickets") Ticket tickets) {
		ticketRepository.save(tickets);
		return "redirect:/";
	}
	@GetMapping("/showTicketsUpdate")
	public String viewTicketsUpdatePage(Model model) {
		List<Ticket> listTickets = administrateurRepository.getTickeNottNullAdmin();
		model.addAttribute("listTickets", listTickets);
		return "devs/show_tickets";
	}
	
	@GetMapping("/showTicketDev")
	public ModelAndView viewTicketsDevs() {
		ModelAndView mav = new ModelAndView("devs/show_ticketsdevs");
		List<Ticket> tickets = administrateurRepository.getTicketAttribues();
		mav.addObject("tickets", tickets);
		return mav;
	}

}
