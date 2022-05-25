package com.example.devoirfinale.service;

import java.util.List;

import com.example.devoirfinale.model.*;





public interface ClientService {
	public void ajouter(Client client);
	public List<Client> lesClients();
	public List<Ticket> lesTickets();
	public void supprimer(int id);
	public void modifier(Client client);
	public Client getClient(int id);
	public void ajouterTicket(int idClient,Ticket ticket);
	public void ajouterTicketMvc(Ticket ticket);
	public List<Ticket> getTickets(int idClient);
	
	public Ticket get(int id) ;
}
