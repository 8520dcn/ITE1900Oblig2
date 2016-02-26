import java.util.Calendar;
import java.util.Date;

public class Gjest extends Card {

	public Gjest(String firstName, String lastName) {
		super(firstName, lastName);
		pinCode = "9999";
		doExpire = true;
		expireDate = storeExpirationDate();
		// TODO Auto-generated constructor stub
	}
	
	Calendar storeExpirationDate()
	{
		Calendar expireDate = Calendar.getInstance();
		expireDate.setTime(new Date());
		expireDate.add(Calendar.DATE, 7);
		return expireDate;
	}

}
