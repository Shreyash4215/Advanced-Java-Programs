import java.util.*;
import java.sql.*;

class Practical11DatabaseOpp
{
	public static void main(String args[])
	{
		int cnt=0,ch;
		Connection cn;		Statement stm;
		ResultSet rs;		PreparedStatement prstm;        
		String name;		String sql;
		int roll,age;		Scanner sc;
	
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");
			stm = cn.createStatement();
			
			sc = new Scanner(System.in);

			while(true)
			{
				System.out.print("\n\n\t***** MENU ******");
				System.out.print("\n\t 1. Display");
				System.out.print("\n\t 2. Insert");
				System.out.print("\n\t 3. Update");
				System.out.print("\n\t 4. Delete");
				System.out.print("\n\t 5. Search");
				System.out.print("\n\t 6. Exit");
				System.out.print("\n\n\t Enter Your Choice : ");
				ch = sc.nextInt();
				
				if(ch==6)
					System.exit(0);
				
				switch(ch)
				{
					case 1:
						cnt=0;
						System.out.print("\n\t Roll no \t Name	\t Percentage");
						System.out.print("\n\t------------------------------------------------");
						rs = stm.executeQuery("select * from student");
						while(rs.next())
						{
							System.out.print("\n\t   "+rs.getString("roll")+"\t");
							System.out.print("\t"+rs.getString(2)+"\t");
							System.out.print("		"+rs.getString(3));
							
							cnt++;
						}
						System.out.print("\n\t------------------------------------------------");
						rs.close();			
						System.out.print("\n\t *** Total No. of Records : "+cnt);
						break;
				   
				   case 2:
						System.out.print("\n\t Enter the roll no , name ,per");
						roll = sc.nextInt();
						name = sc.next();
						per = sc.nextInt();

						sql = "insert into student values("+roll+",'"+name+"',"+per+")";
						prstm = cn.prepareStatement(sql);
						prstm.execute();
						prstm.close();
						System.out.println("\n\t *** Record Successfully Inserted ***");
						break;
				   
				   case 3:
						System.out.print("\n\t Enter the roll no to Update");
						roll = sc.nextInt();
						
						System.out.print("\n\t Enter the new name And new per");
						name = sc.next();
						per = sc.nextInt();
						
						sql = "update student set name='"+name+"',per="+per+" where roll="+roll;
						prstm = cn.prepareStatement(sql);
						prstm.execute();
						prstm.close();
						System.out.println("\n\t *** Record Successfully Updated ***");
						break;

				   case 4:
						System.out.print("\n\t Enter the roll no to Delete");
						roll = sc.nextInt();
						
						sql = "delete from student where roll="+roll;
						prstm = cn.prepareStatement(sql);
						prstm.execute();
						prstm.close();
						System.out.println("\n\t *** Record Successfully deleted ***");
						break;

				   case 5:
						try
						{
							System.out.print("\n\t Enter the roll no to Search");
							roll = sc.nextInt();
							
							rs = stm.executeQuery("select * from student where roll = "+roll);
							rs.first();
							System.out.println("\n\t Roll = "+rs.getString(1)+"\t Name = "+rs.getString(2)+"\t Per "+rs.getString(3));
						}
						catch(Exception e)
						{
							System.out.println("\n\t Student NOT Found !!!");
						}						
				}				
				
			}
				
		}		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
