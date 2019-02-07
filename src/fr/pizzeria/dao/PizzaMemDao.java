package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	Pizza[] pizzaArray;
	
    public PizzaMemDao() {
    	pizzaArray = new Pizza[8];
    	pizzaArray[0] = new Pizza("PEP", "Pépéroni", 12.5);
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
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
