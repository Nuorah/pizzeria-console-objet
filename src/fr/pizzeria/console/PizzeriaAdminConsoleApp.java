package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	/**
	 * Main method, launches the menu and allow the user to interact with the list of pizzas.
	 * @param args No arguments used.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Generate a Pizza Array to use in the app.

		IPizzaDao dao = new PizzaMemDao();

		Scanner userChoice = new Scanner(System.in);
		int choice = 0;		

		while(choice != 99){
			System.out.println("*****Pizzeria Administration*****");
			System.out.println("1.List pizzas.");
			System.out.println("2.Add a new pizza.");
			System.out.println("3.Update a pizza.");
			System.out.println("4.Delete a pizza.");
			System.out.println("99.Exit.");

			choice = userChoice.nextInt();
			userChoice.nextLine();

			/*
			 * Menu : if the user types 1, 2, 3, 4, perform the actions, else quit if he types 99,
			 * else print the menu again.
			 */

			switch(choice) {
			case 1:
				Pizza[] allPizzas = dao.findAllPizzas();
				System.out.println();
				for(int i = 0; i < allPizzas.length; i++){
					System.out.println(allPizzas[i].toString());
				}
				System.out.println();
				break;
			case 2:

				System.out.println("Please write the code : ");
				String code = userChoice.nextLine();

				System.out.println("Please write the name : ");
				String libelle = userChoice.nextLine();

				System.out.println("Please write the price : ");
				double price = userChoice.nextDouble();

				dao.saveNewPizza(new Pizza(code, libelle, price));

				break;
			case 3:

				System.out.println("Chose the code of the pizza to modify");
				String codePizza = userChoice.nextLine();				

				System.out.println("Please write the code : ");
				code = userChoice.nextLine();

				System.out.println("Please write the name : ");
				libelle = userChoice.nextLine();

				System.out.println("Please write the price : ");
				price = userChoice.nextDouble();

				dao.updatePizza(codePizza, new Pizza(code, libelle, price));

				break;
			case 4:	
				System.out.println("Chose the code of the pizza to delete : ");
				codePizza = userChoice.nextLine();

				dao.deletePizza(codePizza);

				break;
			default:
				break;

			}
		}
		System.out.println("Good bye :'( ");
	}

}
