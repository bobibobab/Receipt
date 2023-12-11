package Receipt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DesertItemTest {

	@Test
	void testGetDesertItem() {
		Candy c1 = new Candy("Candy Corn", 1.5, .25);
		assertEquals(c1.getDesertItem(),"Candy Corn");
	}

	@Test
	void testSetDesertItem() {
		Candy c1 = new Candy("Candy Corn", 1.5, .25);
		c1.setDesertItem("Candy");
		assertEquals(c1.getDesertItem(),"Candy");
	}
	
	@Test
	void getTaxPercent() {
		Candy c1 = new Candy("Candy Corn", 1.5, .25);
		assertEquals(c1.getTaxPercent(),0.0725);
	}
	
	@Test
	void setTaxPercent() {
		Candy c1 = new Candy("Candy Corn", 1.5, .25);
		c1.setTaxPercent(0.082);
		assertEquals(c1.getTaxPercent(),0.082);
	}

	@Test
	void compareTo() {
		Candy c1 = new Candy("Candy Corn", 1.5, .25);
		Candy c2 = new Candy("Cow", 3, .35);
		assertEquals(c1.compareTo(c2),-1);
	}
}
