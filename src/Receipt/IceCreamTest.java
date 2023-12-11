package Receipt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IceCreamTest {

	@Test
	void testGetScoopCount() {
		IceCream vanilla = new IceCream("vanilla", 3, 1.2);
		assertEquals(vanilla.getScoopCount(), 3);
	}

	@Test
	void testGetPricePerScoop() {
		IceCream vanilla = new IceCream("vanilla", 3, 1.2);
		assertEquals(vanilla.getPricePerScoop(), 1.2);
	}

	@Test
	void testSetScoopCount() {
		IceCream vanilla = new IceCream("vanilla", 3, 1.2);
		vanilla.setScoopCount(4);
		assertEquals(vanilla.getScoopCount(), 4);
	}

	@Test
	void testSetPricePerScoop() {
		IceCream vanilla = new IceCream("vanilla", 3, 1.2);
		vanilla.setPricePerScoop(2.1);
		assertEquals(vanilla.getPricePerScoop(), 2.1);

	}

	@Test
	void testCalculateCost() {
		IceCream Pistachio = new IceCream("Pistachio", 2, .79);
		assertEquals(Pistachio.calculateCost(), 1.580000);
	}

	@Test
	void testCalculateTax() {
		IceCream Pistachio = new IceCream("Pistachio", 2, .79);
		assertEquals(Pistachio.calculateTax(), 0.114550);
	}
	
	@Test
	void testGetPackaging() {
		IceCream Pistachio = new IceCream("Pistachio", 2, .79);
		assertEquals(Pistachio.getPackaging(), "Bowl");
	}
	
	@Test
	void testSetPackaging() {
		IceCream Pistachio = new IceCream("Pistachio", 2, .79);
		Pistachio.setPackaging("Tub");
		assertEquals(Pistachio.getPackaging(), "Tub");
	}
	
	

}
