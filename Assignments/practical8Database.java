import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4;
	Connection cn;	PreparedStatement prstm;        
	String sql;		Statement stm;        
	ResultSet rs;	int r_cnt=0,i;
	String coolHeads[] = {"Roll No","Name","Percentage"}; 
	String data[][];
	JTable t;		
		
	myfrm()
	{
		setTitle("Student Window");
		setSize(450,500);
		setLocation(400,100);				
		setLayout(null);
		
		l1 = new JLabel("Enter Roll Number ");
		l2 = new JLabel("Enter Name ");
		l3 = new JLabel("Enter Percentage ");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		b1 = new JButton("Add");
		b2 = new JButton("Display");
		b3 = new JButton("Clear");
		b4 = new JButton("Exit");
							
		add(l1);	add(l2);		add(l3);		add(t1);	add(t2);
		add(t3);	add(b1);		add(b2);		add(b3);	add(b4);
				
		l1.setBounds(80,37,200,30);
		t1.setBounds(232,43,150,22);
		l2.setBounds(80,68,200,30);
		t2.setBounds(232,74,150,22);
		l3.setBounds(80,98,200,30);
		t3.setBounds(232,104,150,22);
		b1.setBounds(80,140,90,22);				
		b2.setBounds(185,140,90,22);				
		b3.setBounds(290,140,90,22);				
		b4.setBounds(160,175,140,22);				
		
		b1.addActionListener(this);		b2.addActionListener(this);
		b3.addActionListener(this);		b4.addActionListener(this);
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");
			stm= cn.createStatement();
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
				sql = "insert into student values("+t1.getText()+",'"+t2.getText()+"',"+t3.getText()+")";
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
				
				JOptionPane.showMessageDialog(null,"Record Successfully Inserted");	
			}
			
			if(e.getSource()==b2)
			{
				rs = stm.executeQuery("select count(*) from student");
				rs.next();
				r_cnt=rs.getInt(1);
				
				data = new String[r_cnt][3];
				
				rs =stm.executeQuery("select * from student order by roll");
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
				jsp1.setBounds(80,212,300,200);	
				i=0;
			}
						
			if(e.getSource()==b3)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
			if(e.getSource()==b4)
				System.exit(0);		
		}
		catch(Exception eX )
		{
			System.out.println(eX);
		}
	}
}
class practical8Database
{
	public static void main(String args[])
	{
		new myfrm();
	}
} 