package Receipt;

public abstract class DessertItem implements Packaging, Comparable<DessertItem>{
	//Attribute
	
	private String name;
	private double taxPercent = 7.25/100;
	private String packaging;
	//Constructor
	
	public DessertItem() {
		name = "";
	}
	
	public DessertItem(String n) {
		name = n;		
	}

	//Method
	
	public String getDesertItem() {
		return name;
	}
	
	public void setDesertItem(String n) {
		name = n;
	}
	//Tax get and set
	public double getTaxPercent() {
		return taxPercent;
	}
	
	public void setTaxPercent(double taxPercent) {
		this.taxPercent = taxPercent;
	}
	//calculate cost
	public abstract double calculateCost();
	//calculate tax
	public abstract double calculateTax();
	
	public String getPackaging() {
		return packaging;
	}
		
	public void setPackaging(String pack) {
		packaging = pack;
	}
	
	public int compareTo(DessertItem other) {
		
		if(this.calculateCost() < other.calculateCost()) {
			return -1;
		}// end of if statement
		else if(this.calculateCost() > other.calculateCost()) {
			return 1;
		}// end of else if
		else {
			return 0;
		}// end of else
	}// end of compareTo method
	
	
}// end of DesertItem

