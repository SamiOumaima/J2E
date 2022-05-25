package com.example.devoirfinale.service;

import java.util.List;

import com.example.devoirfinale.model.*;

public interface AdminService {
	
	public void ajouter(Administrateur administrateur);
	public List<Administrateur> lesAdmines();
	public void supprimer(int id);
	public void modifier(Administrateur administrateur);
	public Administrateur getAdmine(int id);
	public void affecterTicketAdmin(int idAdmin,int idTicket);
	public void attribuerTicket(int idDev,int idTicket);
	public List<Ticket> getTicketsNonAtt(int idAdmin);
	
}
