package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * Interface for the dao.
 * @author Haroun
 *
 */
public interface IPizzaDao {
	
	/**
	 * 
	 * @return An array with all the Pizza objects stored.
	 */
	List<Pizza> findAllPizzas();
	/**
	 * Saves a new Pizza object.
	 * @param pizza A Pizza object to save.
	 */
	void saveNewPizza(Pizza pizza);
	/**
	 * Change a Pizza object identified by its attribute code.
	 * @param codePizza The code attribute of the Pizza Object to change.
	 * @param pizza The Pizza object to replace the other one with.
	 */
	void updatePizza(String codePizza, Pizza pizza);
	/**
	 * Deletes a Pizza Object.
	 * @param codePizza The code attribute of the Pizza Object to delete.
	 */
	void deletePizza(String codePizza);
	/**
	 * Finds a Pizza Object with its attribute code.
	 * @param codePizza The code attribute of the Pizza Object to find.
	 * @return The Pizza object with the code codePizza.
	 */
	Pizza findPizzaByCode(String codePizza);
	/**
	 * Tells if a Pizza object exists in data by its code attribute.
	 * @param codePizza The code attribute of the Pizza object to find.
	 * @return true if the Pizza exists in data, false if not.
	 */
	boolean pizzaExists(String codePizza);

}
