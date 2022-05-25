package com.example.devoirfinale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devoirfinale.model.Administrateur;
import com.example.devoirfinale.model.Ticket;
import com.example.devoirfinale.service.AdminService;





@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping
	public void ajouter(@RequestBody Administrateur administrateur) {
		adminService.ajouter(administrateur);
	}
	
	
	@PostMapping("/{idAdmin}/{idTicket}")
	public void affecterTicket(@PathVariable int idAdmin,@PathVariable int idTicket) {
		adminService.affecterTicketAdmin(idAdmin, idTicket);
	}
	
	@PostMapping("/att/{idDev}/{idTicket}")
	public void attrebuerTicket(@PathVariable int idDev,@PathVariable int idTicket) {
		adminService.attribuerTicket(idDev, idTicket);
	}
	
	@GetMapping
	public List<Administrateur> ListAdmine(){
		return adminService.lesAdmines();
	}
	
	@GetMapping("/{idAdmin}/ticketsNonAtt")
	public List<Ticket> ListTicket(@PathVariable int idAdmin){
		return adminService.getTicketsNonAtt(idAdmin);
	}
}
