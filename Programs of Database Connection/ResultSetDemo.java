import java.sql.*;
import java.io.*;

class ResultSetDemo
{
	public static void main(String args[])throws Exception
	{
		Connection cn = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd ;
		Statement stm;
		
		cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");
		stm = cn.createStatement();
		rs = stm.executeQuery("select * from student");
		rsmd = rs.getMetaData();
		
		int numcol = rsmd.getColumnCount();
		System.out.println("Number Of Column = "+ numcol);
		
		for(int i=1; i<=numcol; i++)
		{			
			System.out.println("\nColumn No = "+i);
			System.out.println("Column name = "+rsmd.getColumnName(i));
			System.out.println("Column Type = "+rsmd.getColumnTypeName(i));
			System.out.println("Column Display size = "+rsmd.getColumnDisplaySize(i));			
		}
			cn.close();			
	}
}