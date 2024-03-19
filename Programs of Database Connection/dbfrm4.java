import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class myfrm extends JFrame implements ItemListener
{
	JLabel l1,l2,l3;
	JTextField t2,t3;
	JComboBox cb1;
	Connection cn;	
	Statement stm;        
	ResultSet rs;
	
	myfrm()
	{
		setTitle("Decimal Number Conversion");
		setSize(450,300);
		setLocation(400,100);				
		setLayout(null);
		
		l1 = new JLabel("Enter Roll Number ");
		l2 = new JLabel("Enter Name ");
		l3 = new JLabel("Enter Age ");
		cb1 = new JComboBox();
		t2 = new JTextField();
		t3 = new JTextField();
		
		add(l1);	add(l2);		add(l3);
		add(t2);	add(t3);		add(cb1);	
				
		l1.setBounds(80,37,200,30);
		cb1.setBounds(232,43,150,22);
		l2.setBounds(80,68,200,30);
		t2.setBounds(232,74,150,22);
		l3.setBounds(80,98,200,30);
		t3.setBounds(232,104,150,22);		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");			
			stm = cn.createStatement();
			rs = stm.executeQuery("select * from mytable");
			while(rs.next())
				cb1.addItem(rs.getString(1));
		}	
		catch(Exception e )
		{
			System.out.println(e);
		}
		
		cb1.addItemListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
}
	public void itemStateChanged(ItemEvent e)
	{	
		String sql;
		sql = "select * from mytable where roll = "+cb1.getSelectedItem().toString();
		try
		{
			rs = stm.executeQuery(sql);
			rs.first();
			t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
		}
		catch(Exception eX )
		{
			System.out.println(eX);
		}
	}
}
class dbfrm4
{
	public static void main(String args[])
	{
		new myfrm();
	}
}