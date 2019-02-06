package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				System.out.println("Pizza list");
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
