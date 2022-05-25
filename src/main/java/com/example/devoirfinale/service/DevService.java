package com.example.devoirfinale.service;

import java.util.List;

import com.example.devoirfinale.model.Developpeur;
import com.example.devoirfinale.model.Ticket;

public interface DevService {
	
	
	public void ajouter(Developpeur developpeur);
	
	public List<Developpeur> lesdevs();
	
	public void supprimer(int id);
	
	public void modifier(Developpeur developpeur);
	
	public Developpeur getdev(int id);
	
	public void changerStatut(String statut,int idTicket);
	
	public List<Ticket> getTickets(int idDev);
}
