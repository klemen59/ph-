package fr.formation.inti.entities;

import java.util.Date;

public class EntityView {
	
	private String nom;
	private String prenom;
	private Date dateRdv;
	private int poids;
	
	public EntityView() {
	}

	public EntityView(String nom, String prenom, Date dateRdv, int poids) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateRdv = dateRdv;
		this.poids = poids;
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

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}
	
	
}
