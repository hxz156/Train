import static org.junit.Assert.*;

import org.junit.Test;

public class BurgerTest {

	@Test
	public void testBurgerCreationWithDataSuccess() {
		Burger burger = new Burger(3, 2, true);
		// expect burger to have 3 breads
		assertEquals(burger.breads, 3);
		
		// expect burger to have 2 patties
		assertEquals(burger.patties, 2);
		
		// expect burger to have lettuce
		assertEquals(burger.hasLettuce, true);
		
	}

}






