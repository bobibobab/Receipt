package Receipt;

import java.util.ArrayList;

public class Customer {
	// Attribute
	private String custName;
	private ArrayList<Order> orderHistory;
	private int custID;
	private static int nextCustID = 1000;
	
	// Constructor
	Customer (String n){
		custName = n;
		orderHistory = new ArrayList<Order>();
		custID = nextCustID;
		nextCustID ++;
	}// end of constructor
	
	// Method
	
	public String getName() {
		return custName;
	}
	
	public int getId() {
		return custID;
	}
	
	public ArrayList<Order> getOrderHistory(){
		return orderHistory;
	}

	public String setName(String n) {
		custName= n;
		return custName;
	}
	
	public void addToHistory(Order o) {
		orderHistory.add(o);
	}
}
