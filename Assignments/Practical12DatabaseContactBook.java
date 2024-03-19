import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3,b4,b5;
	Connection cn;	
	Statement stm;
	ResultSet rs;
	PreparedStatement prstm;        
	String sql;
	
	myfrm()
	{
		setTitle("Phone Book");
		setSize(450,300);
		setLocation(400,100);				
		setLayout(null);
		
		l1 = new JLabel("Enter Name ");
		l2 = new JLabel("Enter Address ");
		l3 = new JLabel("Enter Phone ");
		l4= new JLabel("Enter Email ");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		b1 = new JButton("Delete");
		b2 = new JButton("UPDT");
		b3 = new JButton(">>");
		b4 = new JButton("<<");
		b5 = new JButton("Exit");
							
		add(l1);	add(l2);		add(l3);		add(l4);
		add(t1);	add(t2);		add(t3);		add(t4);
		add(b1);	add(b2);		add(b3);		add(b4);      	add(b5);		
		
		l1.setBounds(80,37,200,30);
		t1.setBounds(232,43,150,22);
		l2.setBounds(80,68,200,30);
		t2.setBounds(232,74,150,22);
		l3.setBounds(80,98,200,30);
		t3.setBounds(232,104,150,22);		
		l4.setBounds(80,128,200,30);
		t4.setBounds(232,134,150,22);		
		b4.setBounds(80,180,50,22);				
		b1.setBounds(140,180,70,22);				
		b2.setBounds(217,180,65,22);				
		b3.setBounds(291,180,50,22);				
		b5.setBounds(351,180,55,22);				
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");
			stm = cn.createStatement();				
			rs = stm.executeQuery("select * from phonebook order by name");
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
			if(e.getSource()==b5)
				System.exit(0);
			else	
			{
				if(e.getSource()==b3)
				{
					rs.next();
					if(rs.isAfterLast())
						rs.last();
				}
				else if(e.getSource()==b4)
				{
					rs.previous();
					if(rs.isBeforeFirst())
						rs.first();
				}
				else
				{
					if(e.getSource()==b1)
					{
						sql = "delete from phonebook where phone='"+t3.getText()+"'";
						prstm = cn.prepareStatement(sql);
						prstm.execute();
						prstm.close();
						refresh();	
						
						JOptionPane.showMessageDialog(null,"Record Successfully Deleted");	
					}			
					if(e.getSource()==b2)
					{
						if(t1.getText().length()==0 && Double.parseDouble(t3.getText())<0)
							JOptionPane.showMessageDialog(null,"Name Is Blanked And Number Is Negative");
						else if(t1.getText().length()==0)
							JOptionPane.showMessageDialog(null,"Name Is Blanked");
						else if( Double.parseDouble(t3.getText())<0)
							JOptionPane.showMessageDialog(null,"Number Is Negative");
						else
						{	
							sql = "update phonebook set name='"+t1.getText()+"',adress='"+t2.getText()+"',email='"+t4.getText()+"' where phone='"+t3.getText()+"'";
							prstm = cn.prepareStatement(sql);
							prstm.execute();
							prstm.close();
							refresh();
									
							JOptionPane.showMessageDialog(null,"Record Successfully Updated");
						}
					}
					rs.first();
				}	
				display();			
			}		
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
			rs = stm.executeQuery("select * from phonebook order by name");
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
			t4.setText(rs.getString(4));
			
			if(t1.getText().length()==0 && Double.parseDouble(t3.getText())<0)
				JOptionPane.showMessageDialog(null,"Name Is Blanked And Number Is Negative");
			else if(t1.getText().length()==0)
				JOptionPane.showMessageDialog(null,"Name Is Blanked");
			else if( Double.parseDouble(t3.getText())<0)
				JOptionPane.showMessageDialog(null,"Number Is Negative");
		}	
		catch(Exception et)
		{ et.printStackTrace();}
	}
}
class Practical12DatabaseContactBook
{
	public static void main(String args[])
	{
		new myfrm();
	}
}

/*
create table phonebook
(
name varchar(50),
adress varchar(50),
phone varchar(50) primary key,
email varchar(50)
);

insert into phonebook values('Shre','Baramati','9823339451','shreyash@gmail.com');
insert into phonebook values('Shreyash','Baramati',9823339452,'shreyash@gmail.com');

insert into phonebook values('','sds','-97823339453','shreyash@gmail.com');


*/