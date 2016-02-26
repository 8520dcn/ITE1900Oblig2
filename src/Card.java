import java.util.Calendar;
import java.util.Date;
abstract public class Card
{
	protected String firstName;
	protected String lastName;
	protected String pinCode;
	protected String cardNumber;
	protected Boolean cardDisabled;
	protected Calendar creationDate;
	protected Boolean doExpire;
	protected Calendar expireDate;
	
	public Card(String firstName, String lastName)
	{
		try
		{
		this.firstName = firstName;
		this.lastName = lastName;
		cardNumber = generateCardNumber();
		cardDisabled = false;
		creationDate = storeCreationDate();
		}
		catch (Exception a)
		{
			System.out.println("Failed to create new Card");
		}

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
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat ("E dd.MM.yyyy hh:mm");
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		calendar.add(Calendar.DATE, 7);
		
		System.out.print(cardInfoName + cardInfoNumber + cardInfoCode + cardInfoCardDisabled);
	}
	
	Calendar storeCreationDate()
	{
		Calendar createDate = Calendar.getInstance();
		createDate.setTime(new Date());
		return createDate;
	}
	
	
	Boolean checkPin(String pinCode)
	{
		if(pinCode.equals(this.pinCode))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

//Date format codes:
/*
Character 	Description 	Example
G 	Era designator 	AD
y 	Year in four digits 	2001
M 	Month in year 	July or 07
d 	Day in month 	10
h 	Hour in A.M./P.M. (1~12) 	12
H 	Hour in day (0~23) 	22
m 	Minute in hour 	30
s 	Second in minute 	55
S 	Millisecond 	234
E 	Day in week 	Tuesday
D 	Day in year 	360
F 	Day of week in month 	2 (second Wed. in July)
w 	Week in year 	40
W 	Week in month 	1
a 	A.M./P.M. marker 	PM
k 	Hour in day (1~24) 	24
K 	Hour in A.M./P.M. (0~11) 	10
z 	Time zone 	Eastern Standard Time
' 	Escape for text 	Delimiter
" 	Single quote 	`
*/
