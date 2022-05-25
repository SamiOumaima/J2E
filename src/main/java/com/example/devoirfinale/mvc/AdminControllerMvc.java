package com.example.devoirfinale.mvc;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.devoirfinale.service.*;

import com.example.devoirfinale.model.*;
import com.example.devoirfinale.repository.AdministrateurRepository;
import com.example.devoirfinale.repository.TicketRepository;

@Controller
@RequestMapping("/")
public class AdminControllerMvc {
	
	@Autowired
	private DevService devService;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdministrateurRepository administrateurRepository;
	
	@GetMapping("/acceuilAdmin")
	public String index3() {
		return "admins/acceuil";
	}
	@GetMapping("/showTicketsUpdateAdmin")
	public String viewTicketsUpdateAdmin(Model model) {
		List<Ticket> listTickets = administrateurRepository.getTicketNullAdmin();
		model.addAttribute("listTickets", listTickets);
		return "admins/show_tickets_admin";
	}
	@RequestMapping("/updateAdmin/{id}")
	public ModelAndView showEditAdminForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("admins/admin");
		Ticket tickets = clientService.get(id);
		tickets.setAdmin(tickets.getAdmin());
		
		
		List<Administrateur> listDevs = adminService.lesAdmines();
		mav.addObject("listDevs", listDevs);
		
		mav.addObject("tickets", tickets);
		return mav;
	}

	@PostMapping("/saveAdmin")
	public String ajouterAdmin(@ModelAttribute("tickets") Ticket tickets) {
		ticketRepository.save(tickets);
		return "redirect:/";
	}
	
	
	@GetMapping("/ShowTicketDev")
	public String viewTicketsAdminDevsPage(Model model) {
		List<Ticket> listTickets = administrateurRepository.getTicketNullTicket();
		model.addAttribute("listTickets", listTickets);
		return "admins/show_tickets_admin_dev";
	}
	
	
	@RequestMapping("/updateDevsAdmin/{id}")
	public ModelAndView showEditDevsAdminForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("admins/devs");
		Ticket tickets = clientService.get(id);
		tickets.setDeveloppeur(tickets.getDeveloppeur());
		tickets.setAdmin(tickets.getAdmin());
		
		List<Developpeur> listDevs = devService.lesdevs();
		mav.addObject("listDevs", listDevs);
		
		mav.addObject("tickets", tickets);
		return mav;
	}

	@PostMapping("/saveDevsAdmin")
	public String ajouterDevsAdmin(@ModelAttribute("tickets") Ticket tickets) {
		ticketRepository.save(tickets);
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/ShowDevAtt")
	public String viewDevAtt(Model model) {
		List<Ticket> listTickets = administrateurRepository.getTickeNottNullAdmin();
		model.addAttribute("listTickets", listTickets);
		return "admins/show_tickets_admin_dev_attribuer";
	}
	
	@GetMapping("/newAdmin")
	public String showNewClient(Model model) {
		Administrateur admins = new Administrateur();
		model.addAttribute("admins", admins);
		
		return "admins/new_admin";
	}
	@RequestMapping(value = "/saveA", method = RequestMethod.POST)
	public String saveAd(@ModelAttribute("admins") Administrateur admin) {
		adminService.ajouter(admin);
		return "redirect:/";
	}
	
	@GetMapping("/showAllAdmin")
	public String viewAdmminPage(Model model) {
		List<Administrateur> listAdmin = adminService.lesAdmines();
		model.addAttribute("listAdmin", listAdmin);
		return "admins/show_admin";
	}
	
}