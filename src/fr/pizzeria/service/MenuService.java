package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzaria.exception.UpdatePizzaException;
import fr.pizzeria.dao.IPizzaDao;

/**
 * Abstract class for Menu service.
 * @author Diginamic
 *
 */
public abstract class MenuService {
	
	public abstract void executeUC(IPizzaDao dao, Scanner scanner) throws UpdatePizzaException;

}
