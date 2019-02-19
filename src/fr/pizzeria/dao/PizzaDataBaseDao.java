package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDataBaseDao implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
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
