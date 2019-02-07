package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class DeletePizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scanner) {

		System.out.println("Choose the code of the pizza to delete : ");
		String codePizza = scanner.nextLine();
		dao.deletePizza(codePizza);

	}

}
