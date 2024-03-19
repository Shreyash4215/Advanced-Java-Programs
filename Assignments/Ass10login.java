import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JPasswordField t2;
	JTextField t1;
	JButton b1,b2;	
	Font f;
	int count=3;
	
	myfrm()
	{
		setTitle("Login");
		setSize(250,250);
		setLocation(400,100);
		
		f=new Font("Serif",Font.BOLD,13);
		setLayout(null);
		
		l1 = new JLabel("Login Name ");
		l2 = new JLabel("Password ");
		t1 = new JTextField();
		t2 = new JPasswordField();
		b1 = new JButton("Login");
		b2 = new JButton("Exit");
		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		l1.setFont(f);
		l2.setFont(f);
		
		l1.setBounds(25,50,75,30);
		t1.setBounds(120,55,100,25);
		l2.setBounds(25,90,75,30);
		t2.setBounds(120,95,100,25);
		b1.setBounds(25,130,75,25);
		b2.setBounds(120,130,100,25);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String ln,ps;		
		
		ln=t1.getText();
		ps=t2.getText();
		
		if(e.getSource()==b1)
		{
			if(ln.equals("") && ps.equals(""))
				JOptionPane.showMessageDialog(null,"Enter Login Name And Password");
			else if(ln.equals(""))
				JOptionPane.showMessageDialog(null,"Enter Login Name");
			else if(ps.equals(""))
				JOptionPane.showMessageDialog(null,"Enter Password");
			else if(ln.equals("admin") || ps.equals("ADMIN"))
			{	
				JOptionPane.showMessageDialog(null,"Login Successfully");
				count=3;
				t1.setText("");
				t2.setText("");
			}
			else
			{				
				count--;
				if(count==0)
				{
					JOptionPane.showMessageDialog(null,"Access Denied !!!","Login Failed !!!",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				JOptionPane.showMessageDialog(null,"Please Try Again ! "+count+" More Chance Remaining","Invalid Password Or Login !!!",JOptionPane.WARNING_MESSAGE);
				t1.setText("");
				t2.setText("");
			}								
		}		
		else if(e.getSource()==b2)
			System.exit(0);
	}
}
class Ass10login
{
	public static void main(String args[])
	{
		new myfrm();
	}
}