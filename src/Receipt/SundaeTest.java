package Receipt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SundaeTest {

	@Test
	void testGetToppingName() {
		Sundae McSundae = new Sundae("Sundae", 2, 1.3, "Chocolate", 1.2);
		assertEquals(McSundae.getToppingName(), "Chocolate");
	}

	@Test
	void testGetToppingPrice() {
		Sundae McSundae = new Sundae("McSundae", 2, 1.3, "Chocolate", 1.2);
		assertEquals(McSundae.getToppingPrice(), 1.2);
	}

	@Test
	void testSetToppingName() {
		Sundae McSundae = new Sundae("McSundae", 2, 1.3, "Chocolate", 1.2);
		McSundae.setToppingName("King Sundae");
		assertEquals(McSundae.getToppingName(), "King Sundae");
	}

	@Test
	void testSetToppingPrice() {
		Sundae McSundae = new Sundae("McSundae", 2, 1.3, "Chocolate", 1.2);
		McSundae.setToppingPrice(1.6);
		assertEquals(McSundae.getToppingPrice(), 1.6);
	}
	@Test
	void testCalculateCost() {
		Sundae McSundae = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
		assertEquals(McSundae.calculateCost(), 3.360000);
	}
	
	@Test
	void testCalculateTax() {
		Sundae McSundae = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
		assertEquals(McSundae.calculateTax(), 0.24359999999999998);
	}
	
	@Test
	void testGetPackaging() {
		Sundae McSundae = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
		assertEquals(McSundae.getPackaging(), "Boat");
	}
	
	@Test
	void testSetPackaging() {
		Sundae McSundae = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
		McSundae.setPackaging("Cruise Ship");
		assertEquals(McSundae.getPackaging(), "Cruise Ship");
	}

}
