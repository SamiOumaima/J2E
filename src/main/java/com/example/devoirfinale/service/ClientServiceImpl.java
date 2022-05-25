package com.example.devoirfinale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devoirfinale.model.*;
import com.example.devoirfinale.repository.ClientRepository;
import com.example.devoirfinale.repository.TicketRepository;



@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientRepository clientRepository;
	@Autowired 
	TicketRepository ticketRepository;
	@Override
	public void ajouter(Client client) {
		clientRepository.save(client);
	}

	@Override
	public List<Client> lesClients() {
		
		return clientRepository.findAll();
	}

	@Override
	public void supprimer(int id) {
		clientRepository.deleteById(id);
		
	}

	@Override
	public void modifier(Client client) {
		Client c=clientRepository.getById(client.getId());
		if(c !=null) {
			clientRepository.save(client);
		}
		
	}

	@Override
	public Client getClient(int id) {
		// TODO Auto-generated method stub
		return clientRepository.getById(id);
	}

	@Override
	public void ajouterTicket(int idClient, Ticket ticket) {
		// TODO Auto-generated method stub
		ticket.setClient(clientRepository.getById(idClient));
		ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getTickets(int idClient) {
		return clientRepository.getTickets(idClient);
	}

	@Override
	public void ajouterTicketMvc(Ticket ticket) {
		ticketRepository.save(ticket);
		
	}

	@Override
	public List<Ticket> lesTickets() {
		// TODO Auto-generated method stub
		return  ticketRepository.findAll();
	}
	
	@Override
	public Ticket get(int id) {
		return ticketRepository.findById(id).get();
	}

}
