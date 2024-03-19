/*Updatable Resultset

In order to make the Resultset object as updatable and scrollable ,
use the following constants which are present in resultset.

int Type => TYPE_SCROLL_SENSITIVE 
int Mode => CONCUR_UPDATABLE

public Statement createStatement(int Type,int Mode);
*/
import java.sql.*;

class dos2
{
	public static void main(String args[])
	{
		int cnt=0;
		Connection cn;			//this interface so we can create instance only
		Statement stm;			//it is for only select * from tablename
		ResultSet rs;			
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");
			stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);	
						
			rs = stm.executeQuery("select * from mytable order by roll");
			while(rs.next())
			{
				System.out.print("\n\t"+rs.getString("roll")+"\t");
				System.out.print("\t"+rs.getString(2)+"\t");
				System.out.print("\t"+rs.getString(3));
				
				cnt++;
			}
				System.out.print("\n\n\t *** Operations on ResultSet");
				//Updating Second Row From table
				rs.absolute(2);
				rs.updateString(2,"Row2");	
				rs.updateInt(3,55);	
				rs.updateRow();
				
				//Deleting Third Row From TableCellEditor

				rs.absolute(4);
				rs.deleteRow();
				
				//Inserting Row in Table
				
				rs.moveToInsertRow(); //Move to end
				rs.updateInt(1,18);
				rs.updateString(2,"NewAbcd");
				rs.updateInt(3,99);
				rs.insertRow();
				
				rs.beforeFirst();
				while(rs.next())
				{
					System.out.print("\n\t"+rs.getString(1)+"\t");
					System.out.print("\t"+rs.getString(2)+"\t");
					System.out.print("\t"+rs.getString(3));
				}
			
			rs.close();

		}		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
