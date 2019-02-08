package test.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {
	
	IPizzaDao dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new PizzaMemDao();
	}
	
	@After
	public void tearDown() throws Exception{
		
	}

	@Test
	public void testAddPizza() throws StockageException {
		//The dao must be empty
		assertTrue("Dao must be empty", dao.findAllPizzas().isEmpty());
		
		//We add a new pizza
		dao.saveNewPizza(new Pizza("PIZ1", "1stPizza", 10));
		// The new pizza must be here
		assertFalse("There must a new Pizza", dao.findAllPizzas().isEmpty());
		// It must be the only pizza
		assertTrue("There must be only one new Pizza", dao.findAllPizzas().size() == 1);
		// The pizza must be the one we added
		assertTrue("Pizza must have the right code", dao.findPizzaByCode("PIZ1").getCode() == "PIZ1");
		
		// We add a second pizza
		dao.saveNewPizza(new Pizza("PIZ2", "2ndPizza", 20));
		// There must be two pizzas
		assertTrue("There must be another pizza", dao.findAllPizzas().size() == 2);
		//The first pizza must not have changed
		assertTrue("First pizza must not have changed", dao.findPizzaByCode("PIZ1").getCode() == "PIZ1");
	}
	
	@Test
	public void testUpdatePizza() throws StockageException {
		// We add a new pizza
		dao.saveNewPizza(new Pizza("PIZ1", "1stPizza", 10));		
		// We update this pizza with the same code
		dao.updatePizza("PIZ1", new Pizza("PIZ1", "2stPizza", 20));
		// We update this pizza with a different code
		dao.updatePizza("PIZ1", new Pizza("PIZ2", "2stPizza", 20));
		// We must find this new pizza
		assertTrue("Pizza code must have changed", dao.findPizzaByCode("PIZ2") != null);
		// We must not find the old pizza
		assertTrue("Old code must not be there anymore", dao.findPizzaByCode("PIZ1") == null);
	}
	
	@Test
	public void testDeletePizza() throws StockageException {
		// We create a new pizza
		dao.saveNewPizza(new Pizza("PIZ1", "1stPizza", 10));
		// We delete this pizza
		dao.deletePizza("PIZ1");
		// The pizza must be deleted ie the dao must be empty
		assertTrue("Dao must be empty", dao.findAllPizzas().isEmpty());
		
		// We create two new pizzas
		dao.saveNewPizza(new Pizza("PIZ1", "1stPizza", 10));
		dao.saveNewPizza(new Pizza("PIZ2", "2stPizza", 10));
		// We delete the first pizza
		dao.deletePizza("PIZ1");
		// The first pizza must not be there but the second pizza must still be there
		assertTrue("1st pizza must be deleted", dao.findPizzaByCode("PIZ1") == null);
		assertTrue("2nd pizza must still be there", dao.findPizzaByCode("PIZ2") != null);
	}

}
