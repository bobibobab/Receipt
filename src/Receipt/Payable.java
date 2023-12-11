package Receipt;

public interface Payable {

	enum paytype {
		CASH,
		CARD,
		PHONE
	}
	public abstract paytype getPaytype();
	
	public abstract paytype setPayType(paytype Payment);
}
