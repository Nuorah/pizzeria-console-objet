package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * Dao for pizzas stored in a Java array.
 * @author Haroun
 *
 */
public class PizzaMemDao implements IPizzaDao {

	Pizza[] pizzaArray;

	public PizzaMemDao() {
		pizzaArray = new Pizza[8];
		pizzaArray[0] = new Pizza("PEP", "P�p�roni", 12.5);
		pizzaArray[1] = new Pizza("MAR", "Margherita", 14.0);
		pizzaArray[2] = new Pizza("REIN", "La Reine", 11.5);
		pizzaArray[3] = new Pizza("FRO", "La 4 fromages", 12.0);
		pizzaArray[4] = new Pizza("CAN", "La cannibale", 12.5);
		pizzaArray[5] = new Pizza("SAV", "La savoyarde", 13.0);
		pizzaArray[6] = new Pizza("ORI", "L'orientale", 13.5);
		pizzaArray[7] = new Pizza("IND", "L'indienne", 14.0);
	}

	@Override
	public Pizza[] findAllPizzas() {
		return this.pizzaArray;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {

		//Temp array to store all pizzas + new pizza.
		Pizza[] pizzaArrayTemp = new Pizza[this.pizzaArray.length + 1];

		//Adding all old pizzas in the temp array.
		for(int i = 0; i < this.pizzaArray.length; i++){
			pizzaArrayTemp[i] = this.pizzaArray[i];
		}

		//Adding the new pizza to the temp array.
		pizzaArrayTemp[this.pizzaArray.length] = pizza;

		//Replacing the old pizzaArray.
		this.pizzaArray = pizzaArrayTemp;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		//Loop through the pizzaArray in memory and replace the pizza if it finds it.
		if (this.pizzaExists(codePizza)){
			for(int i = 0; i < this.pizzaArray.length; i++){
				if (this.pizzaArray[i].equals(this.findPizzaByCode(codePizza))){
					this.pizzaArray[i] = pizza;
				}
			}
		} else {
			System.out.println();
			System.out.println("This pizza doesn't exist.");
			System.out.println();
		}

	}

	@Override
	public void deletePizza(String codePizza) {

		if (this.pizzaExists(codePizza)){
			
			//Temp array to move the array minus one pizza.
			Pizza[] pizzaArrayTemp = new Pizza[this.pizzaArray.length - 1];
			
			//Bool to tell where we are in the array comparatively to the index of the pizza to delete.
			boolean leftOfPizzaInArray = true;

			for(int i = 0; i < this.pizzaArray.length; i++){
				
				//Jumps to the next step if we are on the pizza to delete
				if(this.pizzaArray[i].getCode().equals(codePizza)){
					leftOfPizzaInArray = false;
					continue;
				}
				
				//Fill the temp array, different if we are before or after the pizza to delete.
				if(leftOfPizzaInArray){
					pizzaArrayTemp[i] = this.pizzaArray[i];
				} else {
					pizzaArrayTemp[i-1] = this.pizzaArray[i];
				}
			}
			
			this.pizzaArray = pizzaArrayTemp;
			
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
			 * Loop through the pizza array until it finds a pizza with 
			 * the code. Then return the pizza.
			 */

			for(int i = 0; i < this.pizzaArray.length; i++){
				if(this.pizzaArray[i].getCode().equals(codePizza)){
					return this.pizzaArray[i];
				}
			}
		}
		//If not return null
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {

		/*
		 * Loop through the pizza array until it finds a pizza with 
		 * the code. Then return true.
		 */

		for(int i = 0; i < this.pizzaArray.length; i++){
			if(this.pizzaArray[i].getCode().equals(codePizza)){
				return true;
			}
		}
		//If it didn't find a pizza return false.
		return false;
	}



}
