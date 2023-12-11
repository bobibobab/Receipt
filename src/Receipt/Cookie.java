package Receipt;

public class Cookie extends DessertItem implements SameItem<Cookie> {
	// Attribute
	private int cookiesQty;
	private double pricePerDozen;

	// Constructor
	Cookie() {
		super();
		cookiesQty = 0;
		pricePerDozen = 0.0;
		setPackaging("");
	}

	Cookie(String n, int q, double d) {
		super(n);
		cookiesQty = q;
		pricePerDozen = d;
		setPackaging("Box");
	}

	// Method

	public int getCookiesQty() {
		return cookiesQty;
	}

	public double getpricePerDozen() {
		return pricePerDozen;
	}

	public void setCookiesQty(int q) {
		cookiesQty = q;
	}

	public void setpricePerDozen(double d) {
		pricePerDozen = d;
	}

	// Calculate the cookies cost.
	public double calculateCost() {
		return pricePerDozen / 12 * cookiesQty;
	}

	public double calculateTax() {
		double taxPercent = 7.25 / 100;
		return calculateCost() * taxPercent;
	}

	public String toString() {
		String line1 = String.format("%n%s (%s)", this.getDesertItem(), this.getPackaging());
		String line2 = String.format("%d cookies", this.getCookiesQty());
		String line3 = String.format("@$%.3f/dozen:", this.getpricePerDozen());
		String line4 = String.format("$%.3f", this.calculateCost());
		String line5 = String.format("[Tax: %.2f]", this.calculateTax());
		String outputVar = String.format("%s\n\t%-45s%s%17s%17s", line1, line2, line3, line4, line5);
		return outputVar;
	}

	public boolean isSameAs(Cookie other) {
		if (this.getDesertItem().equals(other.getDesertItem())) {
			if (this.pricePerDozen == other.pricePerDozen) {
				return true;
			}// end of if statement price
			else {
				return false;
			}// end of else statement
		} // end of if statement name
		else {
			return false;
		}// end of else
		
	}

}// end of Cookie item
