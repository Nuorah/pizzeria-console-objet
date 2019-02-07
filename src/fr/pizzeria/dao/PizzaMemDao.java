package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * Dao for pizzas stored in a Java List.
 * @author Haroun
 *
 */
public class PizzaMemDao implements IPizzaDao {

	List<Pizza> pizzaList;

	public PizzaMemDao() {
		pizzaList = new ArrayList<Pizza>();
		pizzaList.add(new Pizza("PEP", "Pépéroni", 12.5));
		pizzaList.add(new Pizza("MAR", "Margherita", 14.0));
		pizzaList.add(new Pizza("REIN", "La Reine", 11.5));
		pizzaList.add(new Pizza("FRO", "La 4 fromages", 12.0));
		pizzaList.add(new Pizza("CAN", "La cannibale", 12.5));
		pizzaList.add(new Pizza("SAV", "La savoyarde", 13.0));
		pizzaList.add(new Pizza("ORI", "L'orientale", 13.5));
		pizzaList.add(new Pizza("IND", "L'indienne", 14.0));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return this.pizzaList;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		this.pizzaList.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		if (this.pizzaExists(codePizza)){
			this.pizzaList.set(pizzaList.indexOf(this.findPizzaByCode(codePizza)), pizza);
		} else {
			System.out.println();
			System.out.println("This pizza doesn't exist.");
			System.out.println();
		}

	}

	@Override
	public void deletePizza(String codePizza) {

		if (this.pizzaExists(codePizza)){
			
			this.pizzaList.remove(this.findPizzaByCode(codePizza));
			
			System.out.println();
			System.out.println("The pizza " + codePizza + " has been deleted.");
			System.out.println();

		} else {			
			System.out.println();
			System.out.println("This pizza doesn't exist.");
			System.out.println();			
		}

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {

		if (this.pizzaExists(codePizza)){

			/*
			 * Loop through the pizza list until it finds a pizza with 
			 * the code. Then return the pizza.
			 */

			for(Pizza pizza : this.pizzaList){
				if(pizza.getCode().equals(codePizza)){
					return pizza;
				}
			}
		}
		//If t return null
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {

		/*
		 * Loop through the pizza list until it finds a pizza with 
		 * the code. Then return true.
		 */
		
		for(Pizza pizza : this.pizzaList){
			if(pizza.getCode().equals(codePizza)){
				return true;
			}
		}
		//If it didn't find a pizza return false.
		return false;
	}



}
