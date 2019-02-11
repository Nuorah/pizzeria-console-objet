package fr.pizzeria.model;

public enum PizzaCategory {

	MEAT("Meat"),
	FISH("Fish"),
	NO_MEAT("No meat");

	private String category;

	private PizzaCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setCategory(String category){
		this.category = category;
	}

}
