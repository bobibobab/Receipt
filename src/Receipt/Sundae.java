package Receipt;

public class Sundae extends IceCream{
	// attribute
	private String toppingName;
	private double toppingPrice;
	//constructor
	Sundae(){
		super();
		toppingName = "";
		toppingPrice = 0.0;
		setPackaging("");
	}
	
	Sundae(String n, int SC, double PPS, String TN, double TP){
		super(n, SC, PPS);
		toppingName = TN;
		toppingPrice = TP;
		setPackaging("Boat");
	}
	//Method
	public String getToppingName() {
		return toppingName;
	}
	
	public double getToppingPrice() {
		return toppingPrice;
	}
	
	public void setToppingName(String TN) {
		toppingName = TN;
	}
	
	public void setToppingPrice(double TP) {
		toppingPrice = TP;
	}
	// calculate topping price.
	public double calculateCost() {
		return (getScoopCount() * getPricePerScoop()+toppingPrice);
	}
	//calculate the tax
	public double calculateTax() {
		double taxPercent = 7.25/100;
		return calculateCost() * taxPercent;
	}
	public String toString() {
	String line1 = String.format("%n%s %s (%s)",this.getToppingName(),this.getDesertItem(),getPackaging());
	String line2Pt1 = String.format("%d scoops of %s ice cream  ", super.getScoopCount(),this.getDesertItem());
	String line2Pt2 = String.format("@$%.3f /scoop ", super.getPricePerScoop());
	String line2 = String.format("%s", this.getToppingName());
	String line3 = String.format("@$%.3f:", this.getToppingPrice());
	String line2Pt3 = String.format("$%.3f", this.calculateCost());
	String line2Pt4 = String.format("[Tax: $%.2f]", this.calculateTax());
	
	String outputVar = String.format("%s\n\t%-45s%5s%n\t%-36s%17s%20s%17s", line1, line2Pt1, line2Pt2, line2, line3, line2Pt3, line2Pt4);
	return outputVar;
	}
}
