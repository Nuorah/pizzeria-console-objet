package fr.pizzeria.service;

public class MenuServiceFactory {

	public MenuService choseOption(int choice){
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
