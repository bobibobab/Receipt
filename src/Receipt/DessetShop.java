package Receipt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DessetShop {

	private static HashMap<String, Customer> customerDB = new HashMap<String, Customer>();

	public static void main(String[] args) {

		// make order!
		boolean closed = false;
		while (!closed) {

			Order order = new Order();

			Scanner sIn = new Scanner(System.in);
			String choice;
			DessertItem orderItem;
			String paymentMethod;

			Candy c1 = new Candy("Candy Corn", 1.5, .25);
			order.add(c1);
			// Add candy corn

			Candy c2 = new Candy("Gummy Bears", .25, .35);
			order.add(c2);
			// Add gummy bear

			Cookie c3 = new Cookie("Chocolate Chip", 6, 3.999);
			order.add(c3);
			// Add chocolate chip

			IceCream c4 = new IceCream("Pistachio", 2, .79);
			order.add(c4);
			// Add pistachio

			Sundae c5 = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
			order.add(c5);
			// Add Vanilla

			Cookie c6 = new Cookie("Oatmeal Raisin", 2, 3.45);
			order.add(c6);
			// Add Oatmeal Raisin
			boolean done = false;
			while (!done) {
				System.out.println("\n1: Candy");
				System.out.println("2: Cookie");
				System.out.println("3: Ice Cream");
				System.out.println("4: Sunday");
				System.out.println("5: Admin Module");

				System.out.print("\nWhat would you like to add to the order? (1-4, Enter for done): ");
				choice = sIn.nextLine();

				if (choice.equals("")) {
					done = true;
				} else {
					switch (choice) {
					case "1":
						orderItem = userPromptCandy();
						order.add(orderItem);
						break;
					case "2":
						orderItem = userPromptCookie();
						order.add(orderItem);
						break;
					case "3":
						orderItem = userPromptIceCream();
						order.add(orderItem);
						break;
					case "4":
						orderItem = userPromptSundae();
						order.add(orderItem);
						break;
					case "5":
						menuAdmin();

						break;

					}// end of switch (choice)
				} // end of if (choice.equals(""))
			} // end of while (!done)
			System.out.println("\n");

			String customerName = "";

			System.out.println("Enter the customer name: ");
			customerName = sIn.nextLine();

			if (!customerDB.containsKey(customerName)) {
				Customer cust = new Customer(customerName);
				customerDB.put(customerName, cust);
				cust.setName(customerName);
				customerDB.get(customerName).addToHistory(order);
			} // end of if statement
			else {
				customerDB.get(customerName).addToHistory(order);
			} // end of else statement.

			boolean valid = false;
			while (!valid) {
				
				System.out.println("What form of payment will be used? (CASH, CARD, PHONE):");
				paymentMethod = sIn.nextLine();

				for (Payable.paytype type : Payable.paytype.values()) {
					if (paymentMethod.toUpperCase().equals(type.name())) {
						order.setPayType(type);
						paymentMethod = type.name();
					} // end of if statement.
				} // end of for loop
				switch (paymentMethod) {

				case "CASH":
					valid = true;
					break;

				case "CARD":
					valid = true;
					break;

				case "PHONE":
					valid = true;
					break;

				default:
					System.out.println("That is not a valid form of payment.");
					break;
				}// end of switch statement.

			} // end of while loop

			Collections.sort(order.getOrderList());
			System.out.println(order.toString());
			System.out.printf("%n Customer Name: %s        Customer ID: %d%n  Total Orders: %d %n",
					customerDB.get(customerName).getName(), customerDB.get(customerName).getId(),
					customerDB.get(customerName).getOrderHistory().size());

			/*
			 * // print the item for (DessertItem DI : order.getOrderList()) {
			 * System.out.printf("%-15s $%f [Tax:$%f] %n", DI.getDesertItem(),
			 * DI.calculateCost(), DI.()); } // end of for loop
			 * 
			 * System.out.println("--------------------------------------------------------"
			 * );
			 * 
			 * // Print subtotal and tax
			 * System.out.printf("Order Subtotals:$%f [Tax:$%f]%n", order.orderCost(),
			 * order.orderTax());
			 * 
			 * // Print order total System.out.printf("Order Total: $%f", order.orderCost()
			 * + order.orderTax());
			 * 
			 * // print item count.
			 * System.out.printf("\nTotal number of items in order: %d", order.itemCount());
			 */
		} // end of while loop for whole thing.
	}// end of main

	private static DessertItem userPromptCandy() {

		Scanner scan = new Scanner(System.in);

		String answer = "";
		double quantity = 0.0;
		double ppd = 0.0;

		Candy candy1 = new Candy();

		boolean valid = false;
		while (!valid) {
			// Ask Question
			System.out.println("Enter the type of candy: ");
			answer = scan.nextLine();

			try {
				candy1.setDesertItem(answer);
				valid = true;
			} catch (Exception e) {
				System.out.println("Please use letters for a name and numbers for the other variables");
			} // end of try and catch statement.
		} // end of while loop

		boolean validOfnum = false;
		while (!validOfnum) {
			// Ask Question of qty
			System.out.println("Enter the weight of the candy: ");
			answer = scan.nextLine();

			try {
				quantity = Double.parseDouble(answer);
				validOfnum = true;
			} catch (Exception e) {
				System.out.println("Please use letters for a name and numbers for the other variables");
			} // end of try&catch statement.
		} // end of while loop
		candy1.setCandyWeight(quantity);

		boolean validOfPPD = false;
		while (!validOfPPD) {
			// Ask Question of PPD
			System.out.println("Enter the price per pound: ");
			answer = scan.nextLine();

			try {
				ppd = Double.parseDouble(answer);
				validOfPPD = true;
			} catch (Exception e) {
				System.out.println("Please use letters for a name and numbers for the other variables");
			} // end of try&catch statement
		} // end of while loop
		candy1.setPricePerPound(ppd);

		candy1 = new Candy(candy1.getDesertItem(), candy1.getCandyWeight(), candy1.getPricePerPound());

		return candy1;
	}// end of userPromptCandy method

	private static DessertItem userPromptCookie() {

		Scanner scan = new Scanner(System.in);

		String answer = "";
		int quantity = 0;
		double ppd = 0.0;

		Cookie cookie = new Cookie();

		boolean valid = false;
		while (!valid) {
			// Ask Question
			System.out.println("Enter the type of cookies: ");
			answer = scan.nextLine();

			try {
				cookie.setDesertItem(answer);
				valid = true;
			} catch (Exception e) {
				System.out.println("Please use letters for a name and numbers for the other variables");
			} // end of try and catch statement.
		} // end of while loop

		boolean validOfnum = false;
		while (!validOfnum) {
			// Ask Question of qty
			System.out.println("Enter the quantity purchased: ");
			answer = scan.nextLine();

			try {
				quantity = Integer.parseInt(answer);
				validOfnum = true;
			} catch (Exception e) {
				System.out.println("Please use letters for a name and numbers for the other variables");
			} // end of try&catch statement.
		} // end of while loop
		cookie.setCookiesQty(quantity);

		boolean validOfPPD = false;
		while (!validOfPPD) {
			// Ask Question of PPD
			System.out.println("Enter the price per dozen: ");
			answer = scan.nextLine();

			try {
				ppd = Double.parseDouble(answer);
				validOfPPD = true;
			} catch (Exception e) {
				System.out.println("Please use letters for a name and numbers for the other variables");
			} // end of try&catch statement
		} // end of while loop
		cookie.setpricePerDozen(ppd);
		// end of try&catch statement.
		cookie = new Cookie(cookie.getDesertItem(), cookie.getCookiesQty(), cookie.getpricePerDozen());
		return cookie;
	}// end of userPromptCookie method.

	private static DessertItem userPromptIceCream() {

		Scanner scan = new Scanner(System.in);
		IceCream ice1 = new IceCream();

		String answer = "";

		boolean valid = false;
		while (!valid) {

			System.out.println("Enter the type of IceCream used: ");
			try {
				answer = scan.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Please enter a name");
			} // end of try and catch
			ice1.setDesertItem(answer);
		} // end of while loop

		int nos = 0;
		boolean valid3 = false;

		while (!valid3) {
			System.out.println("Enter the number of scoops: ");
			try {
				answer = scan.nextLine();
				nos = Integer.parseInt(answer);
				valid3 = true;
			} catch (Exception e) {
				System.out.println("Enter a number");
			} // end of try and catch
			ice1.setScoopCount(nos);
		} // end of while loop

		double pps = 0;
		boolean valid4 = false;

		while (!valid4) {
			System.out.println("Enter the price per scoop: ");
			try {
				pps = scan.nextDouble();
				valid4 = true;
			} catch (Exception e) {
				System.out.println("Enter a number");
			} // end of try and catch
			ice1.setPricePerScoop(pps);
		} // end of while loop

		ice1 = new IceCream(ice1.getDesertItem(), ice1.getScoopCount(), ice1.getPricePerScoop());
		return ice1;
	}// end of userPromptIceCream method.

	private static DessertItem userPromptSundae() {
		Scanner scan = new Scanner(System.in);
		Sundae sundae1 = new Sundae();

		String answer = "";

		boolean valid = false;
		while (!valid) {

			System.out.println("Enter the type of IceCream used: ");
			try {
				answer = scan.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Please enter a name");
			} // end of try and catch
			sundae1.setDesertItem(answer);
		} // end of while loop

		String toppingName = "";
		boolean valid2 = false;

		while (!valid2) {
			System.out.println("Enter the topping name: ");
			try {
				toppingName = scan.nextLine();
				valid2 = true;
			} catch (Exception e) {
				System.out.println("Please enter a name");
			} // end of try and catch
			sundae1.setToppingName(toppingName);
		} // end of while loop

		int nos = 0;
		boolean valid3 = false;

		while (!valid3) {
			System.out.println("Enter the number of scoops: ");
			try {
				toppingName = scan.nextLine();
				nos = Integer.parseInt(toppingName);
				valid3 = true;
			} catch (Exception e) {
				System.out.println("Enter a number");
			} // end of try and catch
			sundae1.setScoopCount(nos);
		} // end of while loop

		double pps = 0;
		boolean valid4 = false;

		while (!valid4) {
			System.out.println("Enter the price per scoop: ");
			try {
				pps = scan.nextDouble();
				valid4 = true;
			} catch (Exception e) {
				System.out.println("Enter a number");
			} // end of try and catch
			sundae1.setPricePerScoop(pps);
		} // end of while loop

		double ppt = 0;
		boolean valid5 = false;

		while (!valid5) {
			System.out.println("Enter the topping price: ");
			try {
				ppt = scan.nextDouble();
				valid5 = true;
			} catch (Exception e) {
				System.out.println("Enter a number");
			} // end of try and catch
			sundae1.setToppingPrice(ppt);
		} // end of while loop

		sundae1 = new Sundae(sundae1.getDesertItem(), sundae1.getScoopCount(), sundae1.getPricePerScoop(),
				sundae1.getToppingName(), sundae1.getToppingPrice());

		return sundae1;
	}// end of userPromptSundae method.

	public static void menuAdmin() {

		Scanner sIn = new Scanner(System.in);
		ArrayList<String> listName = new ArrayList<String>(customerDB.keySet());

		String choice = "";
		boolean valid2 = false;
		while (!valid2) {
			System.out.println("\n1: Shop Customer List" + "\n2: Customer Order History" + "\n3: Best Customer"
					+ "\n4: Exit Admin Module" + "\n\nWhat would you like to do?(1-4): ");

			choice = sIn.nextLine();

			switch (choice) {
			case "1":

				for (String cusName : listName) {
					System.out.printf("Customer Name: %s Customer ID: %d\n", customerDB.get(cusName).getName(),
							customerDB.get(cusName).getId());
				} // end of for loop
				break;

			case "2":
				String name;
				System.out.println("Enter the name of the customer: ");
				name = sIn.nextLine();

				if (customerDB.containsKey(name)) {
					for (int i = 0; i < customerDB.get(name).getOrderHistory().size(); i++) {

						System.out.println("-------------------------------------------");
						System.out.printf("Order #%d", i + 1);
						System.out.println("\n-------------------------------------------");
						System.out.println(customerDB.get(name).getOrderHistory().get(i));

					} // end of for loop
				} else {
					System.out.println("Error. Please enter the customer name again.");

				} // end of else statement

				break;
			case "3":

				String MVC = "";
				double comp = customerDB.get(listName.get(0)).getOrderHistory().get(0).orderCost();

				for (String ValueName : listName) {
					double sum = 0;

					for (int j = 0; j < customerDB.get(ValueName).getOrderHistory().size(); j++) {
						sum += customerDB.get(ValueName).getOrderHistory().get(j).orderCost();
					}
					if (sum > comp) {
						comp = sum;
						MVC = ValueName;
					} // end of if statement.

				} // end of for each loop.
				System.out.printf("The Dessert Shop's most valued customer is: %s %n", customerDB.get(MVC).getName());
				break;
			case "4":
				valid2 = true;
				break;

			}// end of switch
		} // end of while loop

	}

}// end of class
