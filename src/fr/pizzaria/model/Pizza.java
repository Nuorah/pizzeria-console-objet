package fr.pizzaria.model;

public class Pizza {
	int id;
	String code;
	String libelle;
	double prix;
	static int count = 0;
	
	Pizza(String code, String libelle, double prix){
		
		id = count;
		count++;
		
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	Pizza(int id, String code, String libelle, double prix){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
}
