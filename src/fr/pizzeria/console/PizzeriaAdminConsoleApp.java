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
				String code;
				String libelle;
				double price;

				System.out.println("Please write the code : ");
				code = userChoice.nextLine();

				System.out.println("Please write the name : ");
				libelle = userChoice.nextLine();

				System.out.println("Please write the price : ");
				price = userChoice.nextDouble();
				
				/*
				 * Add a Pizza by looping through the array into an array of length+1 and
				 * adding the Pizza on the last index
				 */
				Pizza[] pizzaArrayTemp = new Pizza[pizzaArray.length + 1];
				for(int i = 0; i < pizzaArray.length; i++){
					pizzaArrayTemp[i] = pizzaArray[i];
				}
				pizzaArrayTemp[pizzaArray.length] = new Pizza(code, libelle, price);
				pizzaArray = pizzaArrayTemp;
				break;
			case 3:
				String codeChosen;
				boolean found = false;
				int index = -1;
				int id = -1;

				System.out.println("Chose the code of the pizza to modify");
				codeChosen = userChoice.nextLine();
				/*
				 * Go through the array looking for the pizza with the right code, returns
				 * a message if it's not found. If found, replace the pizza with attributes from
				 * the input of the user.
				 */
				for(int i = 0; i < pizzaArray.length; i++){
					if(pizzaArray[i].getCode().equals(codeChosen)){
						found = true;
						index = i;
						id = pizzaArray[i].getId();
						break;
					}
				}
				if (found){

					System.out.println("Please write the code : ");
					code = userChoice.nextLine();

					System.out.println("Please write the name : ");
					libelle = userChoice.nextLine();

					System.out.println("Please write the price : ");
					price = userChoice.nextDouble();

					pizzaArray[index] = new Pizza(id, code, libelle, price);

				} else {
					System.out.println("This pizza doesn't exist.");
					break;
				}

				break;
			case 4:				
				codeChosen = "";
				found = false;
				index = -1;

				System.out.println("Chose the code of the pizza to delete : ");
				codeChosen = userChoice.nextLine();
				
				/*
				 * Go through the array looking for the pizza with the right code, returns
				 * a message if it's not found. If found, go through the array to transfer it 
				 * into a smaller array of size length-1 minus the index of the Pizza the user
				 * wants to delete.
				 */
				
				for(int i = 0; i < pizzaArray.length; i++){
					if(pizzaArray[i].getCode().equals(codeChosen)){
						found = true;
						index = i;
						break;
					}
				}

				if(found){
					pizzaArrayTemp = new Pizza[pizzaArray.length - 1];

					for(int i = 0; i < pizzaArray.length; i++){
						if(i < index){
							pizzaArrayTemp[i] = pizzaArray[i];
						} else if (i > index){
							pizzaArrayTemp[i-1] = pizzaArray[i];
						}
					}
					pizzaArray = pizzaArrayTemp;
					
					System.out.println("Pizza " + codeChosen + " has been deleted.");
				} else {
					System.out.println("This pizza doesn't exist.");
					break;
				}

				break;
			default:
				break;

			}
		}
		System.out.println("Good bye :'( ");
	}

}
