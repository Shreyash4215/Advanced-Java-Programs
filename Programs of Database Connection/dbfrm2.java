import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	Connection cn;	
	PreparedStatement prstm;        
	String sql;
	Statement stm;
	ResultSet rs;
	
	myfrm()
	{
		setTitle("");
		setSize(450,300);
		setLocation(400,100);				
		setLayout(null);
		
		l1 = new JLabel("Enter Roll Number ");
		l2 = new JLabel("Enter Name ");
		l3 = new JLabel("Enter Age ");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		b1 = new JButton("Add");
		b2 = new JButton("Delete");
		b3 = new JButton("UPDT");
		b4 = new JButton("Next");
		b5 = new JButton("Prev.");
		b6 = new JButton("First");
		b7 = new JButton("Last");
		b8 = new JButton("Clear");
		b9 = new JButton("Exit");
							
		add(l1);	add(l2);		add(l3);
		add(t1);	add(t2);		add(t3);
		add(b1);	add(b2);		add(b3);
		add(b4);	add(b5);        add(b6);	
		add(b7);	add(b8);		add(b9);
		
		l1.setBounds(80,37,200,30);
		t1.setBounds(232,43,150,22);
		l2.setBounds(80,68,200,30);
		t2.setBounds(232,74,150,22);
		l3.setBounds(80,98,200,30);
		t3.setBounds(232,104,150,22);		
		b1.setBounds(80,140,66,22);				
		b2.setBounds(152,140,70,22);				
		b3.setBounds(232,140,69,22);				
		b8.setBounds(312,140,69,22);				
		b4.setBounds(80,175,66,22);				
		b5.setBounds(152,175,70,22);				
		b6.setBounds(232,175,69,22);				
		b7.setBounds(312,175,69,22);				
		b9.setBounds(80,210,300,22);				
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");
			stm = cn.createStatement();				
			rs = stm.executeQuery("select * from mytable order by roll");
			rs.first();
			display();
		}	
		catch(Exception e )
		{ System.out.println(e); }

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
	}
	public void actionPerformed(ActionEvent e)
	{		
		try
		{
			if(e.getSource()==b1)
			{
				sql = "insert into mytable values("+t1.getText()+",'"+t2.getText()+"',"+t3.getText()+")";
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
				refresh();
				
				JOptionPane.showMessageDialog(null,"Record Successfully Inserted");	
			}			
			if(e.getSource()==b2)
			{
				sql = "delete from mytable where roll="+t1.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
				refresh();	
				
				JOptionPane.showMessageDialog(null,"Record Successfully Deleted");	
			}			
			if(e.getSource()==b3)
			{
				sql = "update mytable set name='"+t2.getText()+"',age="+t3.getText()+" where roll="+t1.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
				refresh();
						
				JOptionPane.showMessageDialog(null,"Record Successfully Updated");
			}			
			if(e.getSource()==b4)
			{
				rs.next();
				if(rs.isAfterLast())
					rs.last();
				
				display();
			}
			if(e.getSource()==b5)
			{
				rs.previous();
				if(rs.isBeforeFirst())
					rs.first();
				
				display();
			}
			if(e.getSource()==b6)
			{
				rs.first();
				display();
			}
			if(e.getSource()==b7)
			{
				rs.last();
				display();
			}			
			if(e.getSource()==b8)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
			if(e.getSource()==b9)
				System.exit(0);		
		}
		catch(Exception eX )
		{
			System.out.println(eX);
		}
	}	
	public void refresh()
	{
		try
		{
			rs = stm.executeQuery("select * from mytable order by roll");
			rs.next();
			display();
			prstm.close();
		}
		catch(Exception ep)
		{ ep.printStackTrace();}
	}
	public void display()
	{
		try
		{
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
		}	
		catch(Exception et)
		{ et.printStackTrace();}
	}
}
class dbfrm2
{
	public static void main(String args[])
	{
		new myfrm();
	}
}