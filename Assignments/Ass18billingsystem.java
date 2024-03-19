import frame2.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class frm extends JFrame implements ActionListener
{
	DefaultTableModel model ;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JTable table ;
	JButton b1,b2,b3,b4,b5,b6;
	String coolHeads[] = {"Product ID","Product Name","Product Price"};
	int i=0,total=0,b=0,c=0,p=0,s=1;
	Connection cn;		Statement stm;        
	ResultSet rs;	
	PreparedStatement prstm;	String sql;
	
	frm()
	{
		model = new DefaultTableModel();	
		setTitle("Billing System");
		setSize(500,650);
		setLocation(200,50);
		setLayout(null);
		
		for(int i=0; i<coolHeads.length; i++)
			model.addColumn(coolHeads[i]);
		
		Date d=new Date();
		SimpleDateFormat sdf;
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		l1 = new JLabel("Bill No");
		l2 = new JLabel("Product ID");
		l3 = new JLabel("Product Name");
		l4 = new JLabel("Product Price");
		l5 = new JLabel("Today Date");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();	
		t4 = new JTextField();	
		t5 = new JTextField(""+sdf.format(d));	
		b1 = new JButton("Add to bill");	
		b2 = new JButton("Remove from bill");	
		b3 = new JButton("New bill");	
		b4 = new JButton("Modify bill");	
		b5 = new JButton("Remove bill");	
		b6 = new JButton("Bill Summary");	
		
		model.insertRow(0,new Object[]{"","Total =",""+total});
		table = new JTable(model);
		
		table.setEnabled(false);		
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; 
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp1 = new JScrollPane(table,v1,h1);
		
		add(jsp1);	add(b1);		add(b2);  		add(b3);		add(b4);		add(b5);
		add(b6);	add(l1);		add(l2);		add(l3);		add(l4);		add(l5);
		add(t1);	add(t2);		add(t3);		add(t4);		add(t5);
			
		l5.setBounds(50,30,100,25);			t5.setBounds(135,30,150,23);
		l1.setBounds(50,65,100,25);			t1.setBounds(135,65,150,23);
		l2.setBounds(50,100,150,23);		t2.setBounds(135,100,150,23);
		l3.setBounds(50,135,150,23);		t3.setBounds(135,135,150,23);
		l4.setBounds(50,170,200,23);		t4.setBounds(135,170,150,23);
		b1.setBounds(50,210,120,25);		b2.setBounds(180,210,120,25);
		b3.setBounds(310,210,120,25);		b4.setBounds(50,250,120,25);
		b5.setBounds(180,250,120,25);		b6.setBounds(310,250,120,25);
		jsp1.setBounds(50,290,350,300);				
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(1);
		
		b1.addActionListener(this);			b2.addActionListener(this);	
		b3.addActionListener(this);			b4.addActionListener(this);	
		b5.addActionListener(this);			b6.addActionListener(this);	
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");

			stm = cn.createStatement();	
			rs = stm.executeQuery("select count(*) from billno");
			rs.next();
			c=rs.getInt(1);
			p=c;
			t1.setText(""+c);
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
				if(p==c)
					JOptionPane.showMessageDialog(null,"Entered Bill no is in Exist...Please create new bill OR Click on Modify Bill");
				else
				{
					model.removeRow(i);		
		
					model.insertRow(i,new Object[]{""+t2.getText(),""+t3.getText(),""+t4.getText()});
					total=total+Integer.parseInt(t4.getText());
					sql = "insert into product values("+t2.getText()+",'"+t3.getText()+"',"+t4.getText()+","+b+")";
					prstm = cn.prepareStatement(sql); 			
					prstm.execute();				 
					prstm.close();
									
					t2.setText("");			t3.setText("");			t4.setText("");
					i++;
					model.insertRow(i,new Object[]{"","Total",""+total});
					
					s++;
					t2.setText(""+s);
					t3.requestFocus();
				}
			}			
			if(e.getSource()==b2)
			{			
				sql = "delete from product where p_id="+t2.getText()+" and b_id="+t1.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();				
				
				while(i>0)
				{
					model.removeRow(i-1)	;
					i--;
				}
				
				total=0;
				
				if(i==0)
				{
					model.removeRow(i);
					model.insertRow(i,new Object[]{"","Total",""+total});				
				}
				
				display();	
				
				JOptionPane.showMessageDialog(null,"Product = "+t2.getText()+" Remove from Bill no = "+t1.getText());
				
				t2.setText("");								
				t2.requestFocus();
			}
			
			if(e.getSource()==b3)
			{
				s=1;
				c++;
				t1.setText(""+c);
	
				sql = "insert into billno values("+t1.getText()+",'"+t5.getText()+"')";
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
				
				b=Integer.parseInt(t1.getText());
				
				t2.setText(""+s);
				
				while(i>0)
				{
					model.removeRow(i-1)	;
					i--;
				}
				
				total=0;
				
				if(i==0)
				{
					model.removeRow(i);
					model.insertRow(i,new Object[]{"","Total",""+total});				
				}																
				t3.requestFocus();
			}			
			if(e.getSource()==b4)
			{		
				s = 1;
				try
				{
					b = Integer.parseInt(t1.getText());
				}
				catch(NumberFormatException ne)
				{
					t1.requestFocus();
					JOptionPane.showMessageDialog(null,"Enter Bill No");
					return;
				}
				while(i>0)
				{
					model.removeRow(i-1)	;
					i--;
				}
				
				total=0;
				
				if(i==0)
				{
					model.removeRow(i);
					model.insertRow(i,new Object[]{"","Total",""+total});				
				}				
				display();
				t2.setText(""+s);	
				p=1;	
				t3.requestFocus();
			}
			
			if(e.getSource()==b5)
			{
				sql = "delete from product where b_id="+t1.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				
				sql = "delete from billno where b_id="+t1.getText();
				prstm = cn.prepareStatement(sql);
				prstm.execute();				
				prstm.close();
				
				while(i>0)
				{
					model.removeRow(i-1)	;
					i--;
				}
				
				total=0;
				
				if(i==0)
				{
					model.removeRow(i);
					model.insertRow(i,new Object[]{"","Total",""+total});				
				}				
				JOptionPane.showMessageDialog(null," Bill no = "+t1.getText()+" Removed From Data");								
				t1.setText(""+(--c));										
				t2.setText("");										
				t1.requestFocus();
			}
			if(e.getSource()==b6)
				new frmm2();			
		}
		catch(NumberFormatException ne)
		{
			model.removeRow(i);
			JOptionPane.showMessageDialog(null,"Enter Correct Details Of Product");
			model.insertRow(i,new Object[]{"","Total",""+total});			
		}
		catch(SQLIntegrityConstraintViolationException ie)
		{
			total=0;
			model.removeRow(i);
			JOptionPane.showMessageDialog(null,"Create New Bill");
			model.insertRow(i,new Object[]{"","Total",""+total});		
		}
		catch(SQLSyntaxErrorException se)
		{
			JOptionPane.showMessageDialog(null,"Please Give Correct Input");
		}
		catch(Exception ex )
		{ System.out.println(ex); }
	}	
	
	public void display()
	{
		try
		{						
			rs = stm.executeQuery("select * from product where b_id="+b+" order by p_id;");
						
			while(rs.next())
			{
				model.removeRow(i);				
				model.insertRow(i,new Object[]{""+rs.getString(1),""+rs.getString(2),""+rs.getString(3)});				
				total=total+Integer.parseInt(rs.getString(3));
				s++;
				i++;
				model.insertRow(i,new Object[]{"","Total",""+total});
			}
		}	
		catch(Exception et)
		{ et.printStackTrace();}
	}	
}
class Ass18billingsystem
{
	public static void main(String args[])
	{
		new frm();
	}
}