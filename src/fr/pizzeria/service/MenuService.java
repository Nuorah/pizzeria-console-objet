package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

/**
 * Abstract class for Menu service.
 * @author Diginamic
 *
 */
public abstract class MenuService {
	
	public abstract void executeUC(IPizzaDao dao, Scanner scanner) throws StockageException;

}
