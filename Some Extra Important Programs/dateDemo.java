
import java.util.Date;
import java.text.SimpleDateFormat;

class dateDemo
{
	public static void main(String args[])
	{
		Date d=new Date();
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("1. Current Date is : "+sdf.format(d));
		sdf=new SimpleDateFormat("yyyy");
		System.out.println("2. Current Date is : "+sdf.format(d));
		sdf=new SimpleDateFormat("EEEE MMMM dd yyyy");
		System.out.println("3. Current Date is : "+sdf.format(d));
		
		System.out.println("4. Current Date and Time is : "+d);
		sdf=new SimpleDateFormat("dd-MMM-yy");
		System.out.println("5. Current Date and Time is : "+sdf.format(d));
		sdf=new SimpleDateFormat("HH:mm:ss");
		System.out.println("6. Current Time is : "+sdf.format(d));
		sdf=new SimpleDateFormat("w");
		System.out.println("7. Current week of year : "+sdf.format(d));
		sdf=new SimpleDateFormat("W");
		System.out.println("8. Current week of month : "+sdf.format(d));
		sdf=new SimpleDateFormat("D");
		System.out.println("9. Current Day of year : "+sdf.format(d));
		
		
		
	}
}