//Whenever we create a resultset object , which never allows us to update the database through Resultset object and it allows retrieving the data only in forward direction. such type of resultset is known as non-updatable and non-scrollable resultset.

////when we use STATEMENT also we want to use RESULTSET beacause we cant display result without resultset

import java.sql.*;

class dos1
{
	public static void main(String args[])
	{
		int cnt=0;
		Connection cn;			//this is interface so we can create instance only
		Statement stm;			//this is interface so we can create instance only
		ResultSet rs;			//this is interface so we can create instance only
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");
			stm = cn.createStatement();	
			
			rs = stm.executeQuery("select * from mytable");
			while(rs.next())
			{
				System.out.print("\n\t"+rs.getString("roll")+"\t");
				System.out.print("\t"+rs.getString(2)+"\t");
				System.out.print("\t"+rs.getString(3));
				
				cnt++;
			}	
			rs.close();
			
			System.out.print("\n\t *** Total No. of Records : "+cnt);
		}		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
