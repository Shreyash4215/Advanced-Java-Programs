import java.sql.*;
import java.io.*;

class Practical9Database
{
	public static void main(String args[])throws Exception
	{
		Connection cn = null;
		ResultSet rs = null;
		cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");
		
		DatabaseMetaData dbmd = cn.getMetaData();
		System.out.println("Database Product name = "+dbmd.getDatabaseProductName());
		System.out.println("User name = "+dbmd.getUserName());
		System.out.println("Database Driver name = "+dbmd.getDriverName());
		System.out.println("Database Driver Version = "+dbmd.getDriverVersion());
		System.out.println("Database Version = "+dbmd.getDriverMajorVersion());
		
		//Get Procedure
		ResultSet rs1 = dbmd.getProcedures(null,null,null);
		/*getProcedures(String catalog , String schemaPattern,String ProcedureNamePattern)*/
		
		while(rs1.next())
			System.out.println(rs1.getString(1));
		
		//get Tables
		rs = dbmd.getTables(null,null,null, new String[]{"TABlE"});
		/*getTables(String catalog , String schemaPattern,String ProcedureNamePattern,String[] Type)*/
		
		System.out.println("\n\t ***** List Of Tables *****");
			while(rs.next())
			{
				String name = rs.getString("TABLE_NAME");
				System.out.println("Table : "+name);
			}
			cn.close();			
	}
}