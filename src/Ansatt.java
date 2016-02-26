import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ansatt extends Card implements Konstanter {

	private Double timelonn = 255.55;
	private Double kredittFaktor = 25.00;
	private Integer Ansinitet = 0;
	private Double bonusFaktor = 800.00;
	
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
	
	public void settFornavn(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String hentFornavn()
	{
		return firstName;
	}
	public void settEtternavn(String lastName)
	{
		this.lastName = lastName;
	}
	public String hentEtternavn()
	{
		return lastName;
	}
	
	public void setFulltNavn(String fullName)
	{
		String names = fullName.trim();
		int endIndex = names.lastIndexOf(" ");
		if(endIndex > 1)
		{
		System.out.println("Too many names, max 2");
		}
		else
		{
			firstName = names.substring(0, 0);
			lastName = names.substring(1, 1);
		}
	}
	
	public String hentFulltNavn()
	{
		String fullName = firstName + " " + lastName;
		return fullName; 
	}
	
	public double beregnKreditt()
	{
		return timelonn * kredittFaktor;
	}
	
	public double beregnBonus()
	{
		return bonusFaktor * Ansinitet;	
	}

}
