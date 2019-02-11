package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaCategory;

public class AddPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scanner) {

		System.out.println("Please write the code : ");
		String code = scanner.nextLine();

		System.out.println("Please write the name : ");
		String libelle = scanner.nextLine();

		double price = this.getPrice(scanner);

		PizzaCategory category = this.getCategory(scanner);		

		try {
			dao.saveNewPizza(new Pizza(code, libelle, price, category));
		} catch (SavePizzaException e) {
			System.out.println();
			System.err.println(e);
			System.out.println();
		}		
	}
}
