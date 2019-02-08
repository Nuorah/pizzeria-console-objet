package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
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
	 * @throws StockageException 
	 */
	public static void main(String[] args) throws StockageException {

		IPizzaDao dao = new PizzaMemDao();

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
			} else if (MenuServiceFactory.getService(choice) != null){
				try {
				MenuServiceFactory.getService(choice).executeUC(dao, scanner);
				} catch (UpdatePizzaException e){
					System.out.println();
					System.err.println(e);
					System.out.println();
				}
			}
		}
		System.out.println("Good bye :'( ");
	}

}
