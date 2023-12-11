package Receipt;

public class Candy extends DessertItem implements SameItem<Candy> {

	// Attribute
	private double candyWeight;
	private double pricePerPound;

	// Constructor
	Candy() {
		super();
		candyWeight = 0;
		pricePerPound = 0.0;
		setPackaging("");
	}

	Candy(String n, double w, double p) {
		super(n);
		candyWeight = w;
		pricePerPound = p;
		setPackaging("Bag");
	}

	// Method

	public double getCandyWeight() {
		return candyWeight;
	}

	public double getPricePerPound() {
		return pricePerPound;
	}

	public void setCandyWeight(double w) {
		candyWeight = w;
	}

	public void setPricePerPound(double p) {
		pricePerPound = p;
	}

	// Calculate Candy
	public double calculateCost() {
		return candyWeight * pricePerPound;
	}

	public double calculateTax() {
		double taxPercent = 7.25 / 100;
		return calculateCost() * taxPercent;
	}

	@Override
	public boolean isSameAs(Candy other) {
		if (this.pricePerPound == other.pricePerPound) {
			if (this.getDesertItem().equals(other.getDesertItem())) {
				return true;
			}// end of if name if statement 
			else {
				return false;
			}// end of else 
		}// end of if for price per pound. 
		else {
			return false;
		}// end of else statement.
	}

	public String toString() {
		String line1 = String.format("%n%s(%s)", getDesertItem(), this.getPackaging());
		String line2Pt1 = String.format("%.3f lbs.  ", this.getCandyWeight());
		String line2Pt2 = String.format("@$%.3f/lb.:", this.getPricePerPound());
		String line2Pt3 = String.format("$%.3f", this.calculateCost());
		String line2Pt4 = String.format("[Tax: $%.2f]", this.calculateTax());
		String outputVar = String.format("%s\n\t%-45s%s%17s%17s", line1, line2Pt1, line2Pt2, line2Pt3, line2Pt4);
		return outputVar;
	}// end of toString method.

}// end of Cookie item
