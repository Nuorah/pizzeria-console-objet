package test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.service.AddPizzaService;
import fr.pizzeria.service.DeletePizzaService;
import fr.pizzeria.service.ListPizzaService;
import fr.pizzeria.service.MenuServiceFactory;
import fr.pizzeria.service.UpdatePizzaService;

public class MenuServiceFactoryTest {
	
	int choix;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetService() {
		
		assertNull("Le choix par défaut est null",MenuServiceFactory.getService(choix));
		
		choix = 1;
		assertTrue("Le choix 1 renvoie un ListPizzaService", 
				MenuServiceFactory.getService(choix).getClass().isInstance(new ListPizzaService()));
		choix = 2;
		assertTrue("Le choix 2 renvoie un AddPizzaService", 
				MenuServiceFactory.getService(choix).getClass().isInstance(new AddPizzaService()));
		choix = 3;
		assertTrue("Le choix 3 renvoie un UpdatePizzaService", 
				MenuServiceFactory.getService(choix).getClass().isInstance(new UpdatePizzaService()));
		choix = 4;
		assertTrue("Le choix 4 renvoie un DeletePizzaService", 
				MenuServiceFactory.getService(choix).getClass().isInstance(new DeletePizzaService()));
		
	}

}
