package Receipt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CandyTest {

	@Test
	void testGetCandyWeight() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		assertEquals(cand.getCandyWeight(), 1.5);
	}

	@Test
	void testGetPricePerPound() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		assertEquals(cand.getPricePerPound(), .25);
	}

	@Test
	void testSetCandyWeight() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		cand.setCandyWeight(8.8);
		assertEquals(cand.getCandyWeight(), 8.8);
	}

	@Test
	void testSetPricePerPound() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		cand.setPricePerPound(10.2);
		assertEquals(cand.getPricePerPound(), 10.2);
	}
	
	@Test
	void testcalculateCost() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		assertEquals(cand.calculateCost(), 0.375000);
	}
	
	@Test
	void testcalculateTax() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		assertEquals(cand.calculateTax(), 0.027187499999999996);
	}
	
	@Test
	void testGetPackaging() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		assertEquals(cand.getPackaging(), "Bag");
	}
	
	@Test
	void testSetPackaging() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		cand.setPackaging("Tub");
		assertEquals(cand.getPackaging(), "Tub");
	}
	
	@Test
	void testisSameAs() {
		Candy cand = new Candy("Candy Corn", 1.5, .25);
		Candy cand1 = new Candy("Candy Corn", 2.5, .25);
		assertEquals(cand.isSameAs(cand1), true);
	}
}
