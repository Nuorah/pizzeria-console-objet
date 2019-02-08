package test.dao;

import static org.junit.Assert.*;

import org.junit.*;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
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
	public void testAddPizza() {
		//The dao must be empty
		assertTrue("Dao must be empty", dao.findAllPizzas().isEmpty());
		
		//We add a new pizza
		dao.saveNewPizza(new Pizza("1stPizza", "1stPizza", 10));
		// The new pizza must be here
		assertFalse("There must a new Pizza", dao.findAllPizzas().isEmpty());
		// It must be the only pizza
		assertTrue("There must be only one new Pizza", dao.findAllPizzas().size() == 1);
		// The pizza must be the one we added
		assertTrue("Pizza must have the right code", dao.findPizzaByCode("1stPizza").getCode() == "1stPizza");
		
		// We add a second pizza
		dao.saveNewPizza(new Pizza("2ndPizza", "2ndPizza", 20));
		// There must be two pizzas
		assertTrue("There must be another pizza", dao.findAllPizzas().size() == 2);
		//The first pizza must not have changed
		assertTrue("First pizza must not have changed", dao.findPizzaByCode("1stPizza").getCode() == "1stPizza");
	}
	
	@Test
	public void testUpdatePizza() {
		// We add a new pizza
		dao.saveNewPizza(new Pizza("1stPizza", "1stPizza", 10));
		// We update this pizza
		dao.updatePizza("1stPizza", new Pizza("2stPizza", "2stPizza", 20));
		// We must find this new pizza
		assertTrue("Pizza code must have changed", dao.findPizzaByCode("2stPizza") != null);
		// We must not find the old pizza
		assertTrue("Old code must not be there anymore", dao.findPizzaByCode("1stPizza") == null);
	}
	
	@Test
	public void testDeletePizza() {
		// We create a new pizza
		dao.saveNewPizza(new Pizza("1stPizza", "1stPizza", 10));
		// We delete this pizza
		dao.deletePizza("1stPizza");
		// The pizza must be deleted ie the dao must be empty
		assertTrue("Dao must be empty", dao.findAllPizzas().isEmpty());
		
		// We create two new pizzas
		dao.saveNewPizza(new Pizza("1stPizza", "1stPizza", 10));
		dao.saveNewPizza(new Pizza("2ndPizza", "2stPizza", 10));
		// We delete the first pizza
		dao.deletePizza("1stPizza");
		// The first pizza must not be there but the second pizza must still be there
		assertTrue("1st pizza must be deleted", dao.findPizzaByCode("1stPizza") == null);
		assertTrue("2nd pizza must still be there", dao.findPizzaByCode("2ndPizza") != null);
	}

}
