import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

class myfrm extends JFrame implements ActionListener
{
	int w=0,r=0,n,a,ans,atmpt,que=0,r_cnt,cnt=0;
	Random rn;
	JLabel l1,l2,l3;
	JButton b1,b2,b3;
	JRadioButton rb1,rb2,rb3,rb4;
	ButtonGroup grp;
	Connection cn;	
	String sql;
	Statement stm;
	PreparedStatement prstm;
	ResultSet rs;
		
	myfrm()
	{
		setTitle("Exam Paper");
		setSize(500,500);
		setLocation(200,200);
		setLayout(null);
		
		l1 = new JLabel("Welcome To Entrance Exam");
		l2 = new JLabel("");
		l3 = new JLabel("");
		rb1 = new JRadioButton("",true);		
		rb2 = new JRadioButton("");		
		rb3 = new JRadioButton("");		
		rb4 = new JRadioButton("");		
		grp = new ButtonGroup();
		b1 = new JButton("Submit");
		b2 = new JButton("Next");
		b3 = new JButton("Reset");
		rn = new Random();	
		
		add(l1);		add(l2);		add(l3);
		add(rb1);		add(rb2);		add(rb3);		add(rb4);
		grp.add(rb1);	grp.add(rb2);	grp.add(rb3);	grp.add(rb4);		
		add(b1);		add(b2);		add(b3);
		
		l1.setBounds(121,25,300,30);
		l2.setBounds(90,85,300,30);
		l3.setBounds(90,231,250,200);
		rb1.setBounds(100,120,50,30);
		rb2.setBounds(200,120,50,30);
		rb3.setBounds(100,160,50,30);
		rb4.setBounds(200,160,50,30);
		b1.setBounds(80,210,80,30);
		b2.setBounds(175,210,80,30);
		b3.setBounds(270,210,80,30);
				
		b1.addActionListener(this);		b2.addActionListener(this);		b3.addActionListener(this);
		rb1.addActionListener(this);	rb2.addActionListener(this);
		rb3.addActionListener(this);	rb4.addActionListener(this);
		
		l1.setFont(new Font("Arial",Font.BOLD,19));
		l2.setFont(new Font("Arial",Font.BOLD,14));
		l3.setFont(new Font("Arial",Font.BOLD,15));
		rb1.setFont(new Font("Arial",Font.BOLD,13));
		rb2.setFont(new Font("Arial",Font.BOLD,13));
		rb3.setFont(new Font("Arial",Font.BOLD,13));
		rb4.setFont(new Font("Arial",Font.BOLD,13));
				
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");			
			stm = cn.createStatement();
			Display();
		}	
		catch(Exception e )
		{System.out.println(e);}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}		
	public void actionPerformed(ActionEvent e)
	{				
			if(e.getSource()==b1)
			{
				if(cnt==0)
				{
					atmpt++;
					
					if(rb1.isSelected())
						ans = Integer.parseInt(rb1.getText());
					if(rb2.isSelected())
						ans = Integer.parseInt(rb2.getText());
					if(rb3.isSelected())
						ans = Integer.parseInt(rb3.getText());
					if(rb4.isSelected())
						ans = Integer.parseInt(rb4.getText());
					
					if(a==ans)
						r++;
					else
						w++;					
				}
			}		
			if(e.getSource()==b2)
			{
				if(r_cnt!=0)
					Display();				
				else
				{					
					l3.setText("<html><br><br> No More Quetions Left <br><br>Total Quetions is "+que+" You Attempt "+atmpt+" <br><br>Your Right Answers Is "+r+" <br><br> Your Wrong Answers Is "+w+"</html>");
					cnt=1;		
				}
			}
			if(e.getSource()==b3)
			{
				try
				{
					atmpt=0;que=0;r=0;w=0;cnt=0;
					
					l3.setText("");
					sql = "update exam set flg=0 where flg=1";
					prstm = cn.prepareStatement(sql);
					prstm.execute();
					prstm.close();
					Display();
				}						
				catch(Exception ex)
				{System.out.println(ex);}				
			}
		}	
		public void Display()
		{
			try
			{	
				rs = stm.executeQuery("select count(*) from exam where flg=0");
				rs.next();
				r_cnt=rs.getInt(1);
			
				rs = stm.executeQuery("select * from exam where flg=0");
			
				n = rn.nextInt(r_cnt+1);
				if(n==0)
					n=n+1;
				int i=0;
				while(i!=n)
				{	
					i++;
					rs.next();
				}
												
				l2.setText("Q "+rs.getString(1)+". "+rs.getString(2));
				rb1.setText(""+rs.getString(3));
				rb2.setText(""+rs.getString(4));
				rb3.setText(""+rs.getString(5));
				rb4.setText(""+rs.getString(6));
				a = Integer.parseInt(rs.getString(7));			
				que++;
				sql = "update exam set flg=1 where Q_no="+rs.getString(1);
				prstm = cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
						
				rs = stm.executeQuery("select count(*) from exam where flg=0");
				rs.next();
				r_cnt=rs.getInt(1);				
				}						
				catch(Exception ex)
				{System.out.println(ex);}				
		}
}
class dem
{
	public static void main(String args[])
	{
		new myfrm();
	}
}