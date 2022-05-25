package com.example.devoirfinale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devoirfinale.model.Developpeur;
import com.example.devoirfinale.model.Ticket;
import com.example.devoirfinale.repository.DeveloppeurRepository;
import com.example.devoirfinale.repository.TicketRepository;

@Service
public class DevServiceImpl implements DevService{

	@Autowired 
	DeveloppeurRepository developpeurRepository;
	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public void ajouter(Developpeur developpeur) {
		// TODO Auto-generated method stub
		developpeurRepository.save(developpeur);
	}

	@Override
	public List<Developpeur> lesdevs() {
		// TODO Auto-generated method stub
		return developpeurRepository.findAll();
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub
		developpeurRepository.deleteById(id);
	}

	@Override
	public void modifier(Developpeur developpeur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Developpeur getdev(int id) {
		// TODO Auto-generated method stub
		return developpeurRepository.findById(id).get();
	}

	@Override
	public void changerStatut(String statut,int idTicket) {
		// TODO Auto-generated method stub
		Ticket t= ticketRepository.findById(idTicket).get();
		t.setStatut(statut);
	}

	@Override
	public List<Ticket> getTickets(int idDev) {		
		return developpeurRepository.getTickets(idDev);
	}

}
