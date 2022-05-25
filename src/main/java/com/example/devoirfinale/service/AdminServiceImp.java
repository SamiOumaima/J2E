package com.example.devoirfinale.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devoirfinale.model.*;
import com.example.devoirfinale.repository.*;


@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired 
	AdministrateurRepository administrateurRepository;
	@Autowired 
	TicketRepository ticketRepository;
	@Autowired 
	DeveloppeurRepository developpeurRepository;
	@Override
	public void ajouter(Administrateur administrateur) {
		administrateurRepository.save(administrateur);
		
	}

	@Override
	public List<Administrateur> lesAdmines() {

		return administrateurRepository.findAll();
	}

	@Override
	public void supprimer(int id) {
	
		administrateurRepository.deleteById(id);
	}

	@Override
	public void modifier(Administrateur administrateur) {
		
		Administrateur a=administrateurRepository.findById(administrateur.getId()).get();
		if(a != null)
			administrateurRepository.save(administrateur);
	}

	@Override
	public Administrateur getAdmine(int id) {
		
		return administrateurRepository.getById(id);
	}

	@Override
	public void attribuerTicket(int idDev, int idTicket) {
		
		Developpeur d= developpeurRepository.findById(idDev).get();
		Ticket t= ticketRepository.findById(idTicket).get();
		t.setDeveloppeur(d);
		developpeurRepository.save(d);
	}

	@Override
	public List<Ticket> getTicketsNonAtt(int idAdmin) {
	
		Administrateur a=administrateurRepository.findById(idAdmin).get();
		List<Ticket> lstNonAttribu = new ArrayList<Ticket>();
		List<Ticket> lst=a.getTickets();
		for (Ticket ticket : lst) {
			if(ticket.getDeveloppeur()==null) {
				lstNonAttribu.add(ticket);
			}
		}
		return lstNonAttribu;
	}

	@Override
	public void affecterTicketAdmin(int idAdmin, int idTicket) {
		
		Administrateur a= administrateurRepository.findById(idAdmin).get();
		Ticket t= ticketRepository.findById(idTicket).get();
		a.setTickets(t);
		administrateurRepository.save(a);
	}
	
}
