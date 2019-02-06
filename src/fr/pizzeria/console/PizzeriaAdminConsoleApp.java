package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pizza[] pizzaArray = new Pizza[8];

		pizzaArray[0] = new Pizza("PEP", "Pépéroni", 12.5);
		pizzaArray[1] = new Pizza("MAR", "Margherita", 14.0);
		pizzaArray[2] = new Pizza("REIN", "La Reine", 11.5);
		pizzaArray[3] = new Pizza("FRO", "La 4 fromages", 12.0);
		pizzaArray[4] = new Pizza("CAN", "La cannibale", 12.5);
		pizzaArray[5] = new Pizza("SAV", "La savoyarde", 13.0);
		pizzaArray[6] = new Pizza("ORI", "L'orientale", 13.5);
		pizzaArray[7] = new Pizza("IND", "L'indienne", 14.0);

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

			switch(choice) {
			case 1:
				System.out.println();
				for(int i = 0; i < pizzaArray.length; i++){
					System.out.println(pizzaArray[i].toString());
				}
				System.out.println();
				break;
			case 2:
				System.out.println("Add a new pizza");
				break;
			case 3:
				System.out.println("Update a pizza");
				break;
			case 4:
				System.out.println("Delete a pizza");
				break;
			default:
				break;

			}
		}
		System.out.println("Good bye :'( ");
	}

}
