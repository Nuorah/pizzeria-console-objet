package test.service;

import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaCategory;
import fr.pizzeria.service.ListPizzaService;
import fr.pizzeria.service.MenuService;

public class ListPizzaServiceTest {
	
	IPizzaDao dao;
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Before
	public void setUp() throws Exception {
		dao = new PizzaMemDao();
		dao.saveNewPizza(new Pizza("PIZZ1", "Pizza 1", 10, PizzaCategory.MEAT));
		dao.saveNewPizza(new Pizza("PIZZ2", "Pizza 2", 11, PizzaCategory.NO_MEAT));
		dao.saveNewPizza(new Pizza("PIZZ3", "Pizza 3", 12, PizzaCategory.FISH));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecuteUC() {
		MenuService listPizzaService = new ListPizzaService();
		
				
		fail("Not yet implemented");
	}

}
