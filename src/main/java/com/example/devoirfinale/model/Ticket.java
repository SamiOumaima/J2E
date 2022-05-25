package com.example.devoirfinale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String logiciel;
	private String environnement;
	private String urgence;
	private String statut;
	
	@ManyToOne
	private Client client;
	@ManyToOne
	private Developpeur developpeur;
	@ManyToOne
	private Administrateur admin;
	
	
	
	public Administrateur getAdmin() {
		return admin;
	}
	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	public Developpeur getDeveloppeur() {
		return developpeur;
	}
	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}
	public String getDescription() {
	return description;
	}
	public void setDescription(String description) {
	this.description = description;
	}
	public String getLogiciel() {
	return logiciel;
	}
	public void setLogiciel(String logiciel) {
	this.logiciel = logiciel;
	}
	public String getEnvironnement() {
	return environnement;
	}
	public void setEnvironnement(String environnement) {
	this.environnement = environnement;
	}
	public String getUrgence() {
	return urgence;
	}
	public void setUrgence(String urgence) {
	this.urgence = urgence;
	}
	public String getStatut() {
	return statut;
	}
	public void setStatut(String statut) {
	this.statut = statut;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
	return "Ticket [id=" + id + ", description=" + description + ", logiciel=" + logiciel + ", environnement="
	+ environnement + ", urgence=" + urgence + ", statut=" + statut + "]";
	}
}
