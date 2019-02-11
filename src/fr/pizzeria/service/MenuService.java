package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.PizzaCategory;

/**
 * Abstract class for Menu service.
 * @author Haroun
 *
 */
public abstract class MenuService {

	public abstract void executeUC(IPizzaDao dao, Scanner scanner) throws StockageException;
	
	/**
	 * Gets the price from the user, prints error message and loops if the input is invalid.
	 * @param scanner
	 * @return The price the user entered.
	 */
	public double getPrice(Scanner scanner){
		System.out.println("Please write the price : ");
		try{
			String rawPrice = scanner.nextLine();
			double price = Double.parseDouble(rawPrice);
			return price;
		} catch (NumberFormatException e){
			System.out.println("Please enter a valid price");
			return this.getPrice(scanner);
		}
	}
	
	/**
	 * Gets the category from the user, prints error message and loops if the input is invalid.
	 * @param scanner
	 * @return The PizzaCategory object the user asks for
	 */
	public PizzaCategory getCategory(Scanner scanner){
		System.out.println("Choose one of the three categories :");
		System.out.println("1.Meat");
		System.out.println("2.Fish");
		System.out.println("3.No meat");
		try{
			String rawChoice = scanner.nextLine();

			int choice = Integer.parseInt(rawChoice);

			switch(choice){
			case(1):
				return PizzaCategory.MEAT;
			case(2):
				return PizzaCategory.FISH;
			case(3):
				return PizzaCategory.NO_MEAT;
			default:
				System.out.println("Please choose one of the three options.");
				return this.getCategory(scanner);
			}
		} catch (NumberFormatException e){
			System.out.println("Please choose one of the three options.");
			return this.getCategory(scanner);
		}
	}

}
