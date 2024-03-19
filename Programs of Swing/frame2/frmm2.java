package frame2;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.*;

public class frmm2 extends JFrame implements ActionListener
{
	JComboBox cb1,cb2;
	JLabel l1,l2;
	JTable table;
	DefaultTableModel model ;
	String coolHeads[] = {"Product Id","Product Name","Product Price"}; 
	String date="";
	JTable t;	
	Connection cn;		Statement stm;        
	ResultSet rs;		int total=0,i=0;
	
	public frmm2()
	{
		model = new DefaultTableModel();
		setTitle("Bill Summary");
		setSize(500,500);
		setLocation(400,100);
		setLayout(null);
		
		for(int i=0; i<coolHeads.length; i++)
			model.addColumn(coolHeads[i]);

		l1 = new JLabel("Choose Bill Date ");		l2 = new JLabel("Choose Bill No. ");
		cb1 = new JComboBox();						cb2 = new JComboBox();		
		table = new JTable(model);
		
		table.setEnabled(false);		
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; 
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp1 = new JScrollPane(table,v1,h1);

		add(l1);	add(l2);	add(cb1);	add(cb2);	add(jsp1);

		cb1.addItem("Choose Date");		cb2.addItem("Choose Bill No");

		l1.setBounds(80,37,200,30);		cb1.setBounds(212,43,150,22);
		l2.setBounds(80,73,200,30);		cb2.setBounds(212,75,150,22);
		jsp1.setBounds(80,130,350,300);		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");			
			stm = cn.createStatement();
			rs = stm.executeQuery("select * from billno");
			
			while(rs.next())
			{				
				if((rs.getString(2).equals(date))==false)
				{	
					date = rs.getString(2);
					cb1.addItem(rs.getString(2));
				}				
			}
		 }	
		catch(Exception e )
		{System.out.println(e);		}
		
		cb1.addActionListener(this);		cb2.addActionListener(this);
			
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		setVisible(true);				
	}
	public void actionPerformed(ActionEvent e)
	{
		String sql;		
		try
		{
			if(e.getSource()==cb1)
			{	
				if(i>0)
				{
					while(i>0)
					{
						model.removeRow(i)	;
						i--;
					}
					model.removeRow(i);
				}
				
				cb2.removeAllItems();
				cb2.addItem("Choose Bill No");	
				
				sql = "select * from billno where b_date = '"+cb1.getSelectedItem()+"'";
				rs = stm.executeQuery(sql);
				while(rs.next())
				{				
					cb2.addItem(rs.getString(1));
				}
			}			
			else if(e.getSource()==cb2)
			{
				if(cb2.getSelectedIndex()>0)
				{
					if(i>0)
					{
						while(i>0)
						{
							model.removeRow(i)	;
							i--;
						}
							model.removeRow(i);
					}
					
					total=0;
										
					rs = stm.executeQuery("select * from product where b_id="+cb2.getSelectedItem()+" order by p_id;");
									
					while(rs.next())
					{
						model.insertRow(i,new Object[]{""+rs.getString(1),""+rs.getString(2),""+rs.getString(3)});
						
						total=total+Integer.parseInt(rs.getString(3));							
						i++;
					}
						model.insertRow(i,new Object[]{"","Total",""+total});
					}	
			}					
			}		
			catch(Exception eX )
			{
				System.out.println(eX);
			}
	}
}