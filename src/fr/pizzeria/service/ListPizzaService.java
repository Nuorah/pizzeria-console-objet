package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scanner) {
		
		List<Pizza> allPizzas = dao.findAllPizzas();
		System.out.println();
		for(Pizza pizza : allPizzas){
			System.out.println(pizza.toString());
		}
		System.out.println();	
		
	}

}
