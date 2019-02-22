package test.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.UpdatePizzaService;

public class UpdatePizzaServiceTest {

	IPizzaDao dao;
	MenuService updatePizzaService;

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Before
	public void setUp() throws Exception {
		dao = new PizzaMemDao();
		dao.saveNewPizza(new Pizza("PIZZ1", "Pizza 1", 10.0, PizzaCategory.MEAT));
		updatePizzaService = new UpdatePizzaService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecuteUC() throws StockageException {
		//Test quand on la change avec un code different
		systemInMock.provideLines("PIZZ1", "PIZZ2", "Pizza 2", "11", "2");
		updatePizzaService.executeUC(dao, new Scanner(System.in));
		
		assertFalse("La pizza ne doit plus être dans la mêmoire avec le code précedent",
				dao.pizzaExists("PIZZ1"));
		assertTrue("La pizza doit être dans la mêmoire", dao.pizzaExists("PIZZ2"));
		assertTrue("La pizza doit avoir le bon nom", 
				dao.findPizzaByCode("PIZZ2").getLibelle().equals("Pizza 2"));
		assertTrue("La pizza doit avoir le bon prix", 
				dao.findPizzaByCode("PIZZ2").getPrix() == 11.0);
		assertTrue("La pizza doit avoir la bonne catégorie", 
				dao.findPizzaByCode("PIZZ2").getCategory().equals(PizzaCategory.FISH));
		//Test quand on la change avec le même code
		systemInMock.provideLines("PIZZ2", "PIZZ2", "Pizza 2.1", "12", "3");
		updatePizzaService.executeUC(dao, new Scanner(System.in));
		
		assertTrue("La pizza doit être dans la mêmoire", dao.pizzaExists("PIZZ2"));
		assertTrue("La pizza doit avoir le bon nom", 
				dao.findPizzaByCode("PIZZ2").getLibelle().equals("Pizza 2.1"));
		assertTrue("La pizza doit avoir le bon prix", 
				dao.findPizzaByCode("PIZZ2").getPrix() == 12.0);
		assertTrue("La pizza doit avoir la bonne catégorie", 
				dao.findPizzaByCode("PIZZ2").getCategory().equals(PizzaCategory.NO_MEAT));
	}

}
