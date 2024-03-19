import javax.swing.*;
import java.sql.*;

class myfrm extends JFrame
{
	String coolHeads[] = {"Roll No","Name","Age"}; 
	String data[][];
	JTable t;	
	Connection cn;		Statement stm;        
	ResultSet rs;		int r_cnt=0,i;
	
	myfrm()
	{
		setTitle("Table & DB Connectivity");
		setSize(450,300);
		setLocation(400,100);				
	
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");			
			stm = cn.createStatement();
			rs = stm.executeQuery("select count(*) from mytable");
			rs.next();
			r_cnt=rs.getInt(1);
			
			data = new String[r_cnt][3];
			
			rs =stm.executeQuery("select * from mytable order by roll");
			while(rs.next())
			{
				data[i][0] = rs.getString(1);
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				i++;
			}			
			t = new JTable(data,coolHeads);			
			t.setEnabled(false);			
			int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			JScrollPane jsp1 = new JScrollPane(t,v1,h1);
			add(jsp1);			
		}	
		catch(Exception e )
		{
			System.out.println(e);
		}
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
	}
}
class dbJTable
{
	public static void main(String args[])
	{
		new myfrm();
	}
}