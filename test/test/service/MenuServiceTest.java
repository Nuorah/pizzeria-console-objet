package test.service;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.model.PizzaCategory;
import fr.pizzeria.service.ListPizzaService;
import fr.pizzeria.service.MenuService;

public class MenuServiceTest {
	
	MenuService service;
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Before
	public void setUp() throws Exception {
		service = new ListPizzaService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPrice() {
		systemInMock.provideLines("10a", "10");
		Double price = service.getPrice(new Scanner(System.in));		
		assertTrue("Le prix doit être un double et celui entré par l'utilisateur"
				+ "et le service doit avoir refusé l'entrée mal formattée", price == 10.0);
	}

	@Test
	public void testGetCategory() {
		systemInMock.provideLines("5", "2a", "1");
		PizzaCategory categorie = service.getCategory(new Scanner(System.in));
		assertTrue("La categorie doit être celle choisie par l'utilisateur et le "
				+ "service doit avoir refusé les entrées mal formattées", categorie.equals(PizzaCategory.MEAT));
	}

}
