import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ansatt extends Card {
//	protected String firstName;
//	protected String lastName;
//	protected String pinCode;
//	private String cardNumber;
//	private Boolean cardDisabled;
//	protected String creationDate;
//	protected Boolean doExpire;
//	protected Boolean expireDate;

	public Ansatt(String firstName, String lastName) {
		super(firstName, lastName);
		doExpire = false;
		pinCode = generatePin();
		// TODO Auto-generated constructor stub
	}
	
	String generatePin()
	{
		String tempPin = String.format("%s%s%s%s", genInt(),genInt(),genInt(),genInt());
		return tempPin;
	}
	
	Boolean pinInputNeeded()
	{
		String stopTimeString = "07:00";
		String startTimeString = "17:00";
		Date stopTime = null;
		Date startTime = null;
		try
		{
		stopTime = new SimpleDateFormat("HH:mm").parse(stopTimeString);
		startTime = new SimpleDateFormat("HH:mm").parse(startTimeString);
		}
		catch (ParseException e) 
		{
		    e.printStackTrace();
		}
		
		Date currentTime = new Date();

	    Calendar calendarStopTime = Calendar.getInstance();
	    Calendar calendarStartTime = Calendar.getInstance();	
	    Calendar calendarCurrentTime = Calendar.getInstance();
	    calendarStopTime.setTime(stopTime);
	    calendarStartTime.setTime(startTime);
	    calendarCurrentTime.setTime(currentTime);

	    if(calendarCurrentTime.after(calendarStopTime) && calendarCurrentTime.before(calendarStartTime))
	    {
	    	return false;
	    }
	    
	    else return false;
	}

}
