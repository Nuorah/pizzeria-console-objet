package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.service.MenuServiceFactory;

/**
 * User interface in console mode for the administration of a pizzeria.
 * @author Haroun
 *
 */
public class PizzeriaAdminConsoleApp {

	/**
	 * Main method, launches the menu and allow the user to interact with the list of pizzas.
	 * @param args No arguments used.
	 */
	public static void main(String[] args) {

		IPizzaDao dao = new PizzaMemDao();
		
		MenuServiceFactory menuFactory =new MenuServiceFactory();

		Scanner scanner = new Scanner(System.in);		

		while(true){
			System.out.println("*****Pizzeria Administration*****");
			System.out.println("1.List pizzas.");
			System.out.println("2.Add a new pizza.");
			System.out.println("3.Update a pizza.");
			System.out.println("4.Delete a pizza.");
			System.out.println("99.Exit.");

			int choice = scanner.nextInt();
			scanner.nextLine();
			
			if (choice == 99){
				break;
			} else if (menuFactory.choseOption(choice) != null){
				menuFactory.choseOption(choice).executeUC(dao, scanner);
			}
		}
		System.out.println("Good bye :'( ");
	}

}
