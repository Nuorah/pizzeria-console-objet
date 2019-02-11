package fr.pizzeria.service;

/**
 * Factory for the Menu services.
 * @author Haroun
 *
 */
public class MenuServiceFactory {

	/**
	 * 
	 * @param choice User choice.
	 * @return A service that the user requested.
	 */
	public static MenuService getService(int choice){
		switch(choice){
		case 1:
			return new ListPizzaService();
		case 2:
			return new AddPizzaService();
		case 3: 
			return new UpdatePizzaService();
		case 4:
			return new DeletePizzaService();
		default:
			return null;
		}
	}

}
