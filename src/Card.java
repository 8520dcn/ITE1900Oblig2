
abstract public class Card
{
	private String firstName;
	private String lastName;
	private String pinCode;
	private String cardNumber;
	private Boolean cardDisabled;
	
	public Card(String firstName, String lastName)
	{
		try
		{
		this.firstName = firstName;
		this.lastName = lastName;
		this.pinCode = generatePin();
		this.cardNumber = generateCardNumber();
		this.cardDisabled = false;
		}
		catch (Exception a)
		{
			System.out.println("Failed to create new Card");
		}

	}
	
	String generatePin()
	{
		String tempPin = String.format("%s%s%s%s", genInt(),genInt(),genInt(),genInt());
		return tempPin;
	}
	
	String generateCardNumber()
	{
		String tempNr = String.format("%s%s%s%s%s%s", genInt(),genInt(),genInt(),genInt(),genInt(),genInt());
		return tempNr;		
	}
	
	Integer genInt()
	{
		Integer min = 0;
		Integer max = 9;
		return (min + (int)(Math.random() * max)); 
	}
	
	String getName()
	{
		return lastName + ", " + firstName; 
	}
	
	Boolean isDiasbled()
	{
		return cardDisabled;
	}

	void cardToString()
	{
		//build text
		String cardInfoName = "Name: " + lastName + ", " + firstName + "\n";
		String cardInfoNumber = "CardNumber: " + cardNumber + "\n";
		String cardInfoCode = "Pin: " + pinCode + "\n";
		String cardInfoCardDisabled = "Card Disabled: " + Boolean.toString(cardDisabled) + "\n";
		
		System.out.print(cardInfoName + cardInfoNumber + cardInfoCode + cardInfoCardDisabled);
	}
	
	Boolean checkPinCode(int Pin)
	{
		if(pinCode.equals(Pin))
		return true;
		else return false;
	}
}
