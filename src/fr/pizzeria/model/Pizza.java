package fr.pizzeria.model;
/**
 * This class represents a pizza in the pizzeria.
 * @author Diginamic
 *
 */
public class Pizza implements Comparable<Pizza>{
	
	int id;
	String code;
	String libelle;
	double prix;
	static int count = 0;
	PizzaCategory category;
	
	/**
	 * Constructor for the class Pizza without imposing an id. An id is generated with a 
	 * static counter.
	 * @param code String. Code that represents the pizza. Usually some sort of abbreviation 
	 * of the name of the pizza.
	 * @param libelle String. Complete name of the pizza.
	 * @param prix Double. Price of the pizza in euros.
	 * @param category TODO
	 */
	
	public Pizza(String code, String libelle, double prix, PizzaCategory category){
		
		id = count;
		count++;
		
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.category = category;
	}
	
	/**
	 * Constructor for the class Pizza where you impose an id.
	 * @param id int. Id that identifies the pizza.
	 * @param code String. Code that represents the pizza. Usually some sort of abbreviation 
	 * of the name of the pizza.
	 * @param libelle String. Complete name of the pizza.
	 * @param prix double. Price of the pizza in euros.
	 * @param category TODO
	 */
	public Pizza(int id, String code, String libelle, double prix, PizzaCategory category){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.category = category;
	}
	
	/**
	 * 
	 * @return The attribute code.
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * 
	 * @return The attribute id.
	 */
	public int getId(){
		return this.id;
	}
	
	public double getPrix() {
		return prix;
	}

	public PizzaCategory getCategory() {
		return category;
	}

	public String getLibelle(){
		return this.libelle;
	}
	
	public String toString(){
		return this.code + " -> " + "(" + category.getCategory() + ") " + this.libelle + " (" + this.prix + "0�)";
	}

	@Override
	public int compareTo(Pizza o) {
		return this.code.compareTo(o.code);
	}
}
