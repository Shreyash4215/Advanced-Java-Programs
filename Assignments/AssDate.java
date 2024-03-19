import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

class AssDate extends JFrame implements ActionListener
{
    JLabel lroll,lnm,date;
    JTextField troll,tnm,total;
    JButton clr,add,dspall,dspinrng,ext;
	DateButton calb1,calb2,calb3;
	JPanel pnl;
	JTable tbl;	
	DefaultTableModel model ;
	String coolHeads[] = {"Roll No","Student Name","Date"};
    Connection cn;    Statement stm;
    ResultSet rs;     String sql;
    PreparedStatement prstm;
	int i=0;
	
    AssDate(String title)
    {
        super(title);
        setLayout(null);
        setSize(666,451);
        setLocation(150,100);
	
		model = new DefaultTableModel();	
		for(int j=0; j<coolHeads.length; j++)
			model.addColumn(coolHeads[j]);
        
		lroll = new JLabel("Roll No.");      lnm = new JLabel("Name");
		date = new JLabel("Date");           troll = new JTextField("");
		tnm = new JTextField("");    	     total = new JTextField("");    
		clr = new JButton("Clear");          add = new JButton("ADD");
		dspall = new JButton("Display All"); ext = new JButton("EXIT");
		dspinrng = new JButton("Display In Range");
		calb1 = new DateButton();		     calb2 = new DateButton();		   
		calb3 = new DateButton();		     pnl = new JPanel();
		tbl = new JTable(model);
		
		tbl.setEnabled(false);		
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; 
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(tbl,v1,h1);
		
		add(lroll);	  	add(lnm);		  add(date);	  add(troll);	  add(tnm); 		 	add(total);		add(clr);  		  add(add);		  add(ext);   	  add(dspinrng);	  add(dspall);    add(calb1);		add(calb2);		add(calb3);		add(pnl);			pnl.add(jsp);
		
		pnl.setLayout(null);			  pnl.setVisible(false);
		
		lroll.setBounds(10,10,80,20);     troll.setBounds(100,10,100,20);
		lnm.setBounds(10,40,80,20);       tnm.setBounds(100,40,100,20);
		date.setBounds(10,70,80,20);      clr.setBounds(10,100,90,25);					      add.setBounds(110,100,90,25);		ext.setBounds(10,135,190,25);
		dspall.setBounds(10,212,220,25);  dspinrng.setBounds(10,313,220,25);
		calb1.setBounds(100,70,100,20);   calb2.setBounds(10,275,105,25);
		calb3.setBounds(125,275,105,25);  pnl.setBounds(250,10,350,330);					total.setBounds(250,345,100,21);  jsp.setBounds(10,10,320,310);
		
		clr.addActionListener(this);        add.addActionListener(this);
		dspinrng.addActionListener(this);   dspall.addActionListener(this);
		ext.addActionListener(this);         
		
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","1");
			stm = cn.createStatement();
		}
		catch (Exception e)
		{   e.printStackTrace();}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		int tot=0;
		try
		{
			if(e.getSource() == clr)
			{
				troll.setText("");
				tnm.setText("");
				troll.requestFocus();
			}			
			if(e.getSource() == add)
			{
				sql = "insert into datedemo values(" +troll.getText()+ ",'" +tnm.getText()+"','" +calb1.getText()+"')";
				prstm = cn.prepareStatement(sql);
				prstm.execute() ;
				JOptionPane.showMessageDialog(null,"Record Added Successfully ");
			}			
			if(e.getSource() == dspall)
			{
				if(i>0)
					{
						while(i>0)
						{
							model.removeRow(i-1)	;
							i--;
						}
					}
										
					rs = stm.executeQuery("select * from datedemo order by date;");
									
					while(rs.next())
					{
						model.insertRow(i,new Object[]{""+rs.getString(1),""+rs.getString(2),""+rs.getString(3)});
						
						tot = tot+Integer.parseInt(rs.getString(1));
						i++;
					}
				pnl.setVisible(true);	
			}			
			if(e.getSource() ==dspinrng)
			{
				if(i>0)
					{
						while(i>0)
						{
							model.removeRow(i-1)	;
							i--;
						}
					}
										
					rs = stm.executeQuery("select * from datedemo where date between '"+calb2.getText()+"' and '"+calb3.getText()+"' order by date;");
																		
					while(rs.next())
					{
						model.insertRow(i,new Object[]{""+rs.getString(1),""+rs.getString(2),""+rs.getString(3)});
						tot = tot+Integer.parseInt(rs.getString(1));
						i++;
					}
				pnl.setVisible(true);	
			}			
			if(e.getSource() == ext)
				System.exit(0);
			
			total.setText(""+tot);
		}
		catch(Exception ex)
		{  ex.printStackTrace();}
	}			
	public static void main(String args[])
	{  new AssDate("DB Connectivity");
	}
}