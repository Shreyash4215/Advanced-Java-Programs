//jdbc => java database connectivity
//odbc => Open database connectivity
//SQL => Structure Query Language
//DBMS => Database Management System 
//JAR => Java Archieve File 
//API => Application Programming Interface its a Driver to connect database

//PreparedStatement is a interface
//prepareStatement is a Method

import java.util.*;
import java.sql.*;

class dos
{
	public static void main(String args[])
	{
		try
		{
			String name;
			int roll,age;
			
			Scanner sc = new Scanner(System.in);
			
			Connection cn;				//this interface so we can create instance only
			PreparedStatement prstm;	//it is for insert,update,delete
			String sql;
			
			//DriverManager is Also interface
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");
			//Established a Connectionn 
			
			System.out.print("\n\t Enter the roll no , name ,age");
			roll = sc.nextInt();
			name = sc.next();
			age = sc.nextInt();

			sql = "insert into mytable values("+roll+",'"+name+"',"+age+")";
			prstm = cn.prepareStatement(sql); //sending Sql statement to Databse			
			prstm.execute();				 //Sql Query Fired On Database
			prstm.close();
			System.out.println("\n\t *** Record Successfully Inserted ***");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
