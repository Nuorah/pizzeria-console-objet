package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaCategory;

/**
 * Dao for pizzas stored in a Java List.
 * @author Haroun
 *
 */
public class PizzaMemDao implements IPizzaDao {

	List<Pizza> pizzaList;

	public PizzaMemDao() {
		pizzaList = new ArrayList<Pizza>();
		/*pizzaList.add(new Pizza("PEP", "Pépéroni", 12.5, PizzaCategory.MEAT));
		pizzaList.add(new Pizza("MAR", "Margherita", 14.0, PizzaCategory.NO_MEAT));
		pizzaList.add(new Pizza("REIN", "La Reine", 11.5, PizzaCategory.MEAT));
		pizzaList.add(new Pizza("FRO", "La 4 fromages", 12.0, PizzaCategory.NO_MEAT));
		pizzaList.add(new Pizza("CAN", "La cannibale", 12.5, PizzaCategory.MEAT));
		pizzaList.add(new Pizza("SAV", "La savoyarde", 13.0, PizzaCategory.MEAT));
		pizzaList.add(new Pizza("ORI", "L'orientale", 13.5, PizzaCategory.MEAT));
		pizzaList.add(new Pizza("IND", "L'indienne", 14.0, PizzaCategory.MEAT));*/
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return this.pizzaList;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		//add a new pizza if it doesn't exists, throws an exception else
		if(!this.pizzaExists(pizza.getCode())){
			this.pizzaList.add(pizza);
		} else {
			throw new SavePizzaException("There is already a pizza with this code");
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		//first we test if the pizza we want to change exists
		if (this.pizzaExists(codePizza)){
			/*
			 * Then we check if the code we want put doesn't already exist, but we
			 * still allow the pizza to keep the same code
			 */
			if(pizza.getCode().equals(codePizza) || !this.pizzaExists(pizza.getCode())){
				this.pizzaList.set(pizzaList.indexOf(this.findPizzaByCode(codePizza)), pizza);
			} else {
				throw new UpdatePizzaException("There is already a pizza with this code.");
			}
		} else {
			throw new UpdatePizzaException("This pizza doesn't exist.");
		}

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		
		//We check if the pizza exist and then delete it if it's the case.
		if(this.pizzaExists(codePizza)){
			this.pizzaList.remove(this.findPizzaByCode(codePizza));

			System.out.println();
			System.out.println("The pizza " + codePizza + " has been deleted.");
			System.out.println();

		} else {
			throw new DeletePizzaException("This pizza doesn't exist");			
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
