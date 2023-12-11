package Receipt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void testGetName() {
		Customer mike = new Customer("mike");
		assertEquals(mike.getName(), "mike");
	}

	@Test
	void testGetId() {
		Customer mike = new Customer("mike");
		assertEquals(mike.getId(), 1000);
	}

	@Test
	void testGetOrderHistory() {
		Customer mike = new Customer("mike");
		Order order = new Order();
		ArrayList<Order> test = new ArrayList<Order>();
		test.add(order);
		mike.addToHistory(order);
		assertEquals( mike.getOrderHistory(), test);
	}

	@Test
	void testSetName() {
		Customer mike = new Customer("mike");
		mike.setName("Jisu");
		assertEquals(mike.getName(), "Jisu");
	}
	@Test
	void testAddToHistory() {
		Customer mike = new Customer("mike");
		Order order = new Order();
		ArrayList<Order> test = new ArrayList<Order>();
		test.add(order);
		mike.addToHistory(order);
		assertEquals( mike.getOrderHistory(), test);
	}

}
