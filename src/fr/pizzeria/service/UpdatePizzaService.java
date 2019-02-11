package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaCategory;

public class UpdatePizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scanner) throws UpdatePizzaException {

		System.out.println("Choose the code of the pizza to modify");
		String codePizza = scanner.nextLine();
		if (!dao.pizzaExists(codePizza)){
			throw new UpdatePizzaException("This pizza doesn't exist");
		}

		System.out.println("Please write the code : ");
		String code = scanner.nextLine();

		System.out.println("Please write the name : ");
		String libelle = scanner.nextLine();
		
		double price = this.getPrice(scanner);
		
		PizzaCategory category = this.getCategory(scanner);

		try{
			dao.updatePizza(codePizza, new Pizza(code, libelle, price, category));
		}catch (UpdatePizzaException e){
			System.out.println();
			System.err.println(e);
			System.out.println();
		}
	}
}
