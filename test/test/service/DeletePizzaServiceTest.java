package test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaCategory;
import fr.pizzeria.service.DeletePizzaService;
import fr.pizzeria.service.MenuService;

public class DeletePizzaServiceTest {
	
	IPizzaDao dao;
	MenuService deletePizzaService;

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Before
	public void setUp() throws Exception {
		dao = new PizzaMemDao();
		dao.saveNewPizza(new Pizza("PIZZ1", "Pizza 1", 10.0, PizzaCategory.MEAT));
		deletePizzaService = new DeletePizzaService();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testExecuteUC() throws StockageException {
		systemInMock.provideLines("PIZZ1");
		deletePizzaService.executeUC(dao, new Scanner(System.in));
		
		assertFalse("La pizza ne doit plus être en memoire", dao.pizzaExists("PIZZ1"));
	}

}
