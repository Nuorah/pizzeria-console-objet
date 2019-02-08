package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class DeletePizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scanner) {

		System.out.println("Choose the code of the pizza to delete : ");
		String codePizza = scanner.nextLine();
		try{
		dao.deletePizza(codePizza);
		} catch (DeletePizzaException e){
			System.out.println();
			System.err.println(e);
			System.out.println();
		}

	}

}
