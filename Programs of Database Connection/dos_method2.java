import java.util.*;
import java.sql.*;

class dos_method2
{
	public static void main(String args[])
	{
		try
		{
			String name;
			int roll,age;
			
			Scanner sc = new Scanner(System.in);
			
			Connection cn;			//this interface so we can create instance only
			PreparedStatement prstm;
			String sql;
			
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");
			
			System.out.print("\n\t Enter the roll no , name ,age");
			roll = sc.nextInt();
			name = sc.next();
			age = sc.nextInt();

			sql = "insert into mytable values(?,?,?)";
			prstm = cn.prepareStatement(sql);
			prstm.setInt(1,roll);
			prstm.setString(2,name);
			prstm.setInt(3,age);
			prstm.execute();
			prstm.close();
			System.out.println("\n\t *** Record Successfully Inserted ***");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
