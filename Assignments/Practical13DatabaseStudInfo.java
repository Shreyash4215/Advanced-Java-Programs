import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

class Practical13DatabaseStudInfo extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JPanel pnl1,pnl2,pnl3;
	JRadioButton rb1,rb2,rb3;
	ButtonGroup grp;	
	Connection cn;
	String sql,trns;
	PreparedStatement prstm;
	ResultSet rs;
	Statement stm;
	Font f1,f2;	int id,i;
	DefaultTableModel model;	JTable tbl;		
	String coolHeads[] = { "Stud ID", "Student Name"};
	JScrollPane jsp;

	Practical13DatabaseStudInfo()
	{
		super("Student");
		setLayout(null);
		setSize(900,650);
		setLocation(150,25);
		setVisible(true);

		f1=new Font("Serif",Font.BOLD,18);
		f2=new Font("Serif",Font.BOLD,17);
		
		model = new DefaultTableModel();	
		for(int j=0; j<coolHeads.length; j++)
			model.addColumn(coolHeads[j]);
		
		rb1 = new JRadioButton("Course",true);
		rb2 = new JRadioButton("Student");
		rb3 = new JRadioButton("Allocation");
		grp = new ButtonGroup();
		pnl1 = new JPanel();
		l1 = new JLabel("Enter Course ID");	
		t1 = new JTextField();
		l2 = new JLabel("Enter Course Name");	
		t2 = new JTextField();
		l3 = new JLabel("Enter Instructor Name");	
		t3 = new JTextField();
		b1 = new JButton("Add Course");
		b2 = new JButton("All Stud by Course");
		pnl2 = new JPanel();
		l4 = new JLabel("Student ID");	
		t4 = new JTextField("");
		l5 = new JLabel("Student Name");	
		t5 = new JTextField("");
		b3 = new JButton("Add Student");
		b4 = new JButton("Delete Student");
		b5 = new JButton("Search Student");
		b6 = new JButton("View All Student");
		pnl3 = new JPanel();
		l6 = new JLabel("Student ID");	
		t6 = new JTextField("");
		l7 = new JLabel("Course ID");	
		t7 = new JTextField("");
		b7 = new JButton("Add Informatiom");
		tbl = new JTable(model);
		
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; 
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		jsp = new JScrollPane(tbl,v1,h1);
					
		pnl1.setLayout(null);		pnl2.setLayout(null);		pnl3.setLayout(null);
		
		add(rb1);		add(rb2);		add(rb3); 		grp.add(rb3);	grp.add(rb2);	
		grp.add(rb1);	add(pnl1);		pnl1.add(l1);	pnl1.add(l2);	pnl1.add(l3);
		pnl1.add(t1); 	pnl1.add(t2); 	pnl1.add(t3);	pnl1.add(b1);	pnl1.add(b2);
		add(pnl2);		pnl2.add(l4);	pnl2.add(l5);	pnl2.add(t4);	pnl2.add(t5); 
		pnl2.add(b3);	pnl2.add(b4);	pnl2.add(b5);	pnl2.add(b6);	add(pnl3);
		pnl3.add(l6); 	pnl3.add(l7);	pnl3.add(t6); 	pnl3.add(t7);	pnl3.add(b7); 
				
		rb1.setFont(f1);		rb2.setFont(f1);		rb3.setFont(f1);
		l1.setFont(f2);			l2.setFont(f2);			l3.setFont(f2);
		l4.setFont(f2);			l5.setFont(f2);			l6.setFont(f2);
		l7.setFont(f2);
		
		pnl1.setVisible(true);		pnl2.setVisible(false);		pnl3.setVisible(false);
		
		rb1.setBounds(250,50,150,30);
		rb2.setBounds(400,50,150,30);
		rb3.setBounds(550,50,150,30);		
		pnl1.setBounds(150,100,600,500);
		l1.setBounds(100,50,180,30);
		t1.setBounds(320,50,200,25);
		l2.setBounds(100,100,180,30);
		t2.setBounds(320,100,200,25);
		l3.setBounds(100,150,180,30);
		t3.setBounds(320,150,200,25);
		b1.setBounds(150,200,100,30);
		b2.setBounds(300,200,150,30);
		jsp.setBounds(150,350,600,150);		
		pnl2.setBounds(150,100,600,500);
		l4.setBounds(100,50,150,30);
		t4.setBounds(290,50,200,25);
		l5.setBounds(100,100,150,30);
		t5.setBounds(290,100,200,25);
		b3.setBounds(125,150,150,30);
		b4.setBounds(325,150,150,30);
		b5.setBounds(125,200,150,30);
		b6.setBounds(325,200,150,30);		
		pnl3.setBounds(150,100,600,500);
		l6.setBounds(100,50,150,30);
		t6.setBounds(290,50,200,25);
		l7.setBounds(100,100,150,30);
		t7.setBounds(290,100,200,25);
		b7.setBounds(200,180,150,30);
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");
			stm = cn.createStatement();
		}
		catch(Exception e)
		{	e.printStackTrace();		}
		
		b1.addActionListener(this);		b2.addActionListener(this);
		b3.addActionListener(this);		b4.addActionListener(this);
		b5.addActionListener(this);		b6.addActionListener(this);
		b7.addActionListener(this);		rb1.addItemListener(this);
		rb2.addItemListener(this);		rb3.addItemListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource() == b1)
			{
				if(t1.getText().length()==0  ||	t2.getText().length()==0	||t3.getText().length()==0)
					JOptionPane.showMessageDialog(null,"Please Enter All Informatiom");	
				else
				{
					sql = "insert into course values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"')";
					prstm = cn.prepareStatement(sql);
					prstm.execute();		prstm.close();
					JOptionPane.showMessageDialog(null, "Course Info saved Successfully !!!");
					t1.setText("");			t2.setText("");			t3.setText("");
				}
			}
			else if(e.getSource() == b2)
			{
				if(t1.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Please Enter Course ID");	
					t4.requestFocus();
				}
				else
				{
					trns="select * from studnt as t1 left outer join crs_stud as t2 on t1.s_id=t2.s_id where c_id="+t1.getText();
					updateTable(trns);
				}
			}
			else if(e.getSource() == b3)
			{
				if(t4.getText().length()==0  ||	t5.getText().length()==0)
					JOptionPane.showMessageDialog(null,"Please Enter All Informatiom");	
				else
				{					
					sql = "insert into studnt values("+t4.getText()+",'"+t5.getText()+"')";
					prstm = cn.prepareStatement(sql);
					prstm.execute();
					prstm.close();
					JOptionPane.showMessageDialog(null, "Student Info saved Successfully !!!");
					t4.setText("");
					t5.setText("");
				}			
			}
			else if(e.getSource() == b4)
			{
				if(t4.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Please Enter Student ID");	
					t4.requestFocus();
				}
				else
				{					
					rs = stm.executeQuery("select * from studnt where s_id="+t4.getText());
					rs.next();
					int ans=JOptionPane.showConfirmDialog(null,"<html>Student Name is "+rs.getString(2)+"<br>Are You Confirm To Delete this Student</html>");
					if (ans==0)
					{
						prstm = cn.prepareStatement("delete from crs_stud where s_id="+t4.getText());
						prstm.execute();
						prstm = cn.prepareStatement("delete from studnt where s_id="+t4.getText());
						prstm.execute();			prstm.close();
						
						JOptionPane.showMessageDialog(null,"Record Successfully Deleted");		
					}
				}
			}
			else if(e.getSource() == b5)
			{
				if(t4.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Please Enter Student ID");	
					t4.requestFocus();
				}
				else
				{
					trns="select * from studnt where s_id="+t4.getText();
					updateTable(trns);
				}
			}
			else if(e.getSource() == b6)
			{
				trns="select * from studnt";
				updateTable(trns);
			}
			else if(e.getSource() == b7)
			{				
				if(t6.getText().length()==0  ||	t7.getText().length()==0)
					JOptionPane.showMessageDialog(null,"Please Enter All Informatiom");	
				else
				{					
					sql = "insert into crs_stud values("+t6.getText()+","+t7.getText()+")";
					prstm = cn.prepareStatement(sql);
					prstm.execute();			prstm.close();
					JOptionPane.showMessageDialog(null, "Record saved Successfully !!!");
					t6.setText("");				t7.setText("");
				}
			}
		}
		catch(Exception exx)
		{
			JOptionPane.showMessageDialog(null, "Incorect Informatiom!!! Please Check Informatiom Once!!!");
		}
	}	
	public void itemStateChanged(ItemEvent i)
	{		
		if(rb1.isSelected())
		{
			pnl1.setVisible(true);			pnl2.setVisible(false);
			pnl3.setVisible(false);
		}
		else if(rb2.isSelected())
		{
			pnl1.setVisible(false);			pnl2.setVisible(true);
			pnl3.setVisible(false);
		}
		else if(rb3.isSelected())
		{
			pnl1.setVisible(false);			pnl2.setVisible(false);
			pnl3.setVisible(true);
		}	
	}
	
	void updateTable(String s1)
    {
		add(jsp);
	    try
        {	
            if(i>0)
			{
				while(i>0)
				{
					model.removeRow(i-1)	;
					i--;
				}
			}
			
			rs = stm.executeQuery(s1);
			while(rs.next())
			{					
				model.insertRow(i,new Object[]{""+rs.getString(1),""+rs.getString(2)});
				i++;
			}	
		}
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }	
	public static void main(String[] args)
	{
		new Practical13DatabaseStudInfo();
	}	
}