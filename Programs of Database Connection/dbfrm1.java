import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5;
	Connection cn;	
	PreparedStatement prstm;        
	String sql;
	
	myfrm()
	{
		setTitle("Decimal Number Conversion");
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
		b4 = new JButton("Clear");
		b5 = new JButton("Exit");
							
		add(l1);	add(l2);		add(l3);
		add(t1);	add(t2);		add(t3);
		add(b1);	add(b2);		add(b3);
		add(b4);	add(b5);
				
		l1.setBounds(80,37,200,30);
		t1.setBounds(232,43,150,22);
		l2.setBounds(80,68,200,30);
		t2.setBounds(232,74,150,22);
		l3.setBounds(80,98,200,30);
		t3.setBounds(232,104,150,22);
		b1.setBounds(80,140,100,22);				
		b2.setBounds(195,140,90,22);				
		b3.setBounds(300,140,80,22);				
		b4.setBounds(80,175,140,22);				
		b5.setBounds(240,175,140,22);				
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","");			
		}	
		catch(Exception e )
		{
			System.out.println(e);
		}

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
				
				JOptionPane.showMessageDialog(null,"Record Successfully Inserted");	
			}
			
			if(e.getSource()==b2)
			{
				sql = "delete from mytable where roll="+t1.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
						
				JOptionPane.showMessageDialog(null,"Record Successfully Deleted");	
			}
			
			if(e.getSource()==b3)
			{
				sql = "update mytable set name='"+t2.getText()+"',age="+t3.getText()+" where roll="+t1.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
						
				JOptionPane.showMessageDialog(null,"Record Successfully Updated");
			}
			
			if(e.getSource()==b4)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
			if(e.getSource()==b5)
				System.exit(0);		
		}
		catch(Exception eX )
		{
			System.out.println(eX);
		}
	}
}
class dbfrm1
{
	public static void main(String args[])
	{
		new myfrm();
	}
}