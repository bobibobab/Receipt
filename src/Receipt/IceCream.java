package Receipt;

public class IceCream extends DessertItem{
		//Attribute
		private int scoopCount;
		private double pricePerScoop;
		//Constructor.
		IceCream(){
			super();
			scoopCount = 0;
			pricePerScoop = 0.0;
			setPackaging("");
		}
		
		IceCream(String n, int SC, double PPS){
			super(n);
			scoopCount = SC;
			pricePerScoop = PPS;
			setPackaging("Bowl");
		}
		//Method.
		public int getScoopCount() {
			return scoopCount;
		}
		
		public double getPricePerScoop() {
			return pricePerScoop;
		}
		
		public void setScoopCount(int SC) {
			scoopCount = SC;
		}
		
		public void setPricePerScoop(double PPS) {
			pricePerScoop = PPS;
		}
		//Calculate the Ice cream.
		public double calculateCost() {
			return (scoopCount * pricePerScoop);
		}
		public double calculateTax() {
			double taxPercent = 7.25/100;
			return calculateCost() * taxPercent;
		}
		
		public String toString() {
			String line1 = String.format("%n%s(%s)",getDesertItem(), getPackaging());
			String line2Pt1 = String.format("%d scoops  ", this.getScoopCount());
			String line2Pt2 = String.format("@$%.3f /scoop: ", this.pricePerScoop);
			String line2Pt3 = String.format("$%.3f", this.calculateCost());
			String line2Pt4 = String.format("[Tax: $%.2f]", this.calculateTax());
			String outputVar = String.format("%s\n\t%-45s%s%17s%17s", line1, line2Pt1, line2Pt2, line2Pt3, line2Pt4);
			return outputVar;
			
		}

		
	}

