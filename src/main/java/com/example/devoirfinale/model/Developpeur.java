package com.example.devoirfinale.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Developpeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	@OneToMany
	@JoinColumn(name="developpeur_id")
	private List<Ticket> tickets=new ArrayList<>();
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Ticket ticket) {
		this.tickets.add(ticket);
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getNom() {
	return nom;
	}
	public void setNom(String nom) {
	this.nom = nom;
	}
	public String getPrenom() {
	return prenom;
	}
	public void setPrenom(String prenom) {
	this.prenom = prenom;
	}
	@Override
	public String toString() {
	return  nom + " " + prenom ;
	}
}
