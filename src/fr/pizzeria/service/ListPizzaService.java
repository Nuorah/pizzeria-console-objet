package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao dao, Scanner scanner) {
		
		Pizza[] allPizzas = dao.findAllPizzas();
		System.out.println();
		for(int i = 0; i < allPizzas.length; i++){
			System.out.println(allPizzas[i].toString());
		}
		System.out.println();	
		
	}

}
