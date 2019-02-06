package fr.pizzeria.model;

public class Pizza {
	int id;
	String code;
	String libelle;
	double prix;
	static int count = 0;
	
	public Pizza(String code, String libelle, double prix){
		
		id = count;
		count++;
		
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String libelle, double prix){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String toString(){
		return code + " -> " + libelle + " (" + prix + "0€)";
	}
}
