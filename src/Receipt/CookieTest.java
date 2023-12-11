package Receipt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class CookieTest {

	@Test
	void testGetCookiesQty() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		assertEquals(c3.getCookiesQty(), 6);

	}

	@Test
	void testGetpricePerDozen() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		assertEquals(c3.getpricePerDozen(), 3.999);
	}

	@Test
	void testSetCookiesQty() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		c3.setCookiesQty(500);
		assertEquals(c3.getCookiesQty(), 500);
	}

	@Test
	void testGetpricePerDozenDouble() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		c3.setpricePerDozen(500.25);
		assertEquals(c3.getpricePerDozen(), 500.25);
	}
	
	@Test
	void testcalculateCost() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		assertEquals(c3.calculateCost(), 1.9994999999999998);
	}
	
	@Test
	void testcalculateTax() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		assertEquals(c3.calculateTax(), 0.14496374999999997);
	}
	
	@Test
	void testGetPackaging() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		assertEquals(c3.getPackaging(), "Box");
	}
	
	@Test
	void testSetPackaging() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		c3.setPackaging("Cruise Ship");
		assertEquals(c3.getPackaging(), "Cruise Ship");
	}
	
	@Test
	void testisSameAs() {
		Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
		Cookie c4 = new Cookie("Chocolate Chip", 2, 3.999);
		assertEquals(c3.isSameAs(c4), true);
	}

}
