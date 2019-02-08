package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AddPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scanner) {

		System.out.println("Please write the code : ");
		String code = scanner.nextLine();

		System.out.println("Please write the name : ");
		String libelle = scanner.nextLine();

		System.out.println("Please write the price : ");
		double price = scanner.nextDouble();

		try {
			dao.saveNewPizza(new Pizza(code, libelle, price));
		} catch (SavePizzaException e) {
			System.out.println();
			System.err.println(e);
			System.out.println();
		}		
	}


}
