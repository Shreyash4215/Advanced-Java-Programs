import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JPasswordField p1,p2;
	JTextField t1,t2,t3,t4;
	JButton b1;	
	Font f;
	Random r;
	int a,b,ans;
	String s,p,q;
	
	myfrm()
	{
		setTitle("Registration Form");
		setSize(550,400);
		setLocation(400,100);
		
		f=new Font("Serif",Font.BOLD,13);
		setLayout(null);
		
		l1 = new JLabel("Registration Form ");
		l2 = new JLabel("Name ");
		l3 = new JLabel("Login Name ");
		l4 = new JLabel("Password ");
		l5 = new JLabel("Confirm Password ");
		l6 = new JLabel("Capacha ");
		t1 = new JTextField();
		t2 = new JTextField();
		p1 = new JPasswordField();
		p2 = new JPasswordField();
		t3 = new JTextField();
		t4 = new JTextField();
		b1 = new JButton("Submit");
		r = new Random();
		
		a = r.nextInt(10);
		b = r.nextInt(10);
		ans = a+b;		
		s=Integer.toString(a)+" + "+Integer.toString(b)+"  =";		
		t3.setText(s);
			
		add(l1);		add(l2);		add(l3);
		add(l4);		add(l5);		add(l6);
		add(t1);		add(t2);		add(p1);
		add(p2);		add(t3);		add(t4);
		add(b1);
		
		l1.setFont(f);
		
		l1.setBounds(201,55,150,30);
		l2.setBounds(80,90,75,30);
		t1.setBounds(222,93,250,22);
		l3.setBounds(80,120,75,30);
		t2.setBounds(222,124,250,22);
		l4.setBounds(80,152,75,30);
		p1.setBounds(222,154,250,22);
		l5.setBounds(80,180,120,30);
		p2.setBounds(222,184,250,22);
		l6.setBounds(80,210,75,30);
		t3.setBounds(222,214,100,22);
		t4.setBounds(332,214,140,22);
		b1.setBounds(180,245,200,22);				
		
		b1.addActionListener(this);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
	}
	public void actionPerformed(ActionEvent e)
	{
		int l,f=0,r=0,t=0,m=0,n=0;
		if(e.getSource()==b1)
		{
			p = p1.getText();
			q = p2.getText();			
			l=p.length();
			if(l>=6)
			{
				for(int i=0;i<l;i++)
				{			 
					if(65 <= p.charAt(i) && 90 >= p.charAt(i))
						f=1;
					if(97 <= p.charAt(i) && 122 >= p.charAt(i))
						r=1;
					if(35 <= p.charAt(i) && 38 >= p.charAt(i) || 64 == p.charAt(i))
						t=1;
				 }					
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Registration Failed!!! Password should be minimum 6 character ");
				return;
			}
			if(p.equals(q))
				m=1;
			try
			{
				if(ans == Integer.parseInt(t4.getText()))
					n=1;				
			}catch(Exception ex){}
			
			if(f==0)
				JOptionPane.showMessageDialog(null,"Registration Failed!!! Atleast Uppecase letter required ");
			else if(r==0)
				JOptionPane.showMessageDialog(null,"Registration Failed!!! Atleast Lowercase letter required ");
			else if(t==0)
				JOptionPane.showMessageDialog(null,"Registration Failed!!!  Only #,$,%,&,@ Character Allowed ");	
			else if(m==0)
				JOptionPane.showMessageDialog(null,"Registration Failed!!! Password And Confirm Password Not Matched");
			else if(n==0) 
				JOptionPane.showMessageDialog(null,"Registration Failed!!! Capacha Should Match!!!");
			
			if(f==1 && r==1 && t==1 && m==1 && n == 1)
				JOptionPane.showMessageDialog(null,"Registration Successful!!!");
		}
		}
}
class Ass13rgstrfrm
{
	public static void main(String args[])
	{
		new myfrm();
	}
}