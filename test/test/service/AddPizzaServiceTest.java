package test.service;

import static org.junit.Assert.*;
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
import fr.pizzeria.model.PizzaCategory;
import fr.pizzeria.service.AddPizzaService;
import fr.pizzeria.service.MenuService;

public class AddPizzaServiceTest {

	IPizzaDao dao;
	MenuService addPizzaService;

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Before
	public void setUp() throws Exception {
		dao = new PizzaMemDao();
		addPizzaService = new AddPizzaService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecuteUC() throws StockageException {
		
		systemInMock.provideLines("PIZZ1", "Pizza 1", "10", "1");
		addPizzaService.executeUC(dao, new Scanner(System.in));
		
		assertTrue("La pizza doit être dans la mêmoire", dao.pizzaExists("PIZZ1"));
		assertTrue("La pizza doit avoir le bon nom", 
				dao.findPizzaByCode("PIZZ1").getLibelle().equals("Pizza 1"));
		assertTrue("La pizza doit avoir le bon prix", 
				dao.findPizzaByCode("PIZZ1").getPrix() == 10.0);
		assertTrue("La pizza doit avoir la bonne catégorie", 
				dao.findPizzaByCode("PIZZ1").getCategory().equals(PizzaCategory.MEAT));		
	}

}
