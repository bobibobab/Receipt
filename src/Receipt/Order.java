package Receipt;

import java.util.ArrayList;

public class Order extends DessertItem implements Payable {
	// Attribute
	private ArrayList<DessertItem> order;
	private paytype payMethod;

	// Constructor
	Order() {
		order = new ArrayList<DessertItem>();
		payMethod = paytype.CASH;
	}

	// Method
	public ArrayList<DessertItem> getOrderList() {
		return order;
	}

	// add the item
	public ArrayList add(DessertItem item) {
		
		if (item instanceof Candy) {
			
			for (DessertItem DI : order) {
				
				if (DI instanceof Candy) {
					if (((Candy) item).isSameAs((Candy) DI)) {
						double addition = ((Candy) DI).getCandyWeight() + ((Candy) item).getCandyWeight();
						((Candy) DI).setCandyWeight(addition);
						return order;
					} // end of if sameAs statement
					
				} // end of if instanceof candy statement
			} // end of for loop
		} // end of if instanceof statement
		else if (item instanceof Cookie) {
			for (DessertItem DI : order) {
				if (DI instanceof Cookie) {
					if (((Cookie) item).isSameAs((Cookie) DI)) {

						((Cookie) DI).setCookiesQty(
								((Cookie) DI).getCookiesQty()+ ((Cookie) item).getCookiesQty());
						return order;
					} // end of if issameAs statement
				} // end of if instance statement
			} // end of for loop
		} // end of is instanceof statement1
		
		order.add(item);
		return order;
			
	}

	// count item.
	public int itemCount() {
		return order.size();
	}

	public double calculateCost() {
		return 0;
	}

	// calculate total cost
	public double orderCost() {
		double total = 0.0;
		for (DessertItem d : order) {
			total += d.calculateCost();
		}
		return total;
	}

	// Calculate total tax
	public double orderTax() {
		double totalTax = 0.0;
		for (DessertItem d : order) {
			totalTax = totalTax + (d.calculateCost() * d.getTaxPercent());
		}
		return totalTax;
	}// end of orderTax method.

	public String toString() {
		String finalOutput = "";

		finalOutput += "-----------------Receipt----------------------------------------";

		for (DessertItem DI : order) {
			finalOutput += DI.toString();
		} // end of for loop

		finalOutput += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		finalOutput += String.format("\nTotal number of items in order: %d", this.itemCount());
		finalOutput += String.format("%nOrder Subtotals:$%.2f [Tax:$%.2f]%n", this.orderCost(), this.orderTax());
		finalOutput += String.format("%nOrder Total: $%.2f", this.orderCost() + this.orderTax());
		finalOutput += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		finalOutput += String.format("%nPaid for with %s.", this.getPaytype());
		finalOutput += "\n-------------------------------------------------------";
		
		return finalOutput;
	}// end of toString method.

	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public paytype getPaytype() {
		return payMethod;
	}// end of getPaytype method

	@Override
	public paytype setPayType(paytype Payment) {
		payMethod = Payment;
		return payMethod;
	}// end of setPayType method

}// end of Order class
