
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myfrmf extends JFrame implements ActionListener
{	
	JLabel lbl1;
	JButton btn1;
	JTextField t1;
	
	myfrmf()
	{
		setTitle("My First Frame");
		setSize(500,500);
		setLocation(500,200);
		setLayout(new FlowLayout());
		setFont(new Font("Arial",Font.BOLD,15));
		
		//2) Memory Allocation
		lbl1 = new JLabel("Enter Your Name");
		t1 = new JTextField(20);
		btn1 = new JButton("Submit");
		
		//3) Add Control on frame
		
		add(lbl1);
		add(t1);
		add(btn1);
		
		//4)Add Listeners on Controls

		btn1.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}	
	public void actionPerformed(ActionEvent e)
	{
		new nmyfrm(t1.getText());
		dispose();
	}	

}	
class frmtoframe2
{
	public static void main(String args[])
	{
		new myfrmf();
	}
}

class nmyfrm extends JFrame implements ActionListener
{
	//1) Declaration
	
	JLabel lbl1;
	JButton btn1;
	
	nmyfrm(String temp)
	{
		setTitle("My Secound Frame");
		setSize(500,500);
		setLocation(500,200);
		setLayout(new FlowLayout());
		setFont(new Font("Arial",Font.BOLD,15));
		
		//2) Memory Allocation
		lbl1 = new JLabel("Welcome "+temp);
		btn1 = new JButton("Back");
		
		//3) Add Control on frame
		
		add(lbl1);
		add(btn1);
		
		//4)Add Listeners on Controls

		btn1.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		setVisible(true);		
	}	
	public void actionPerformed(ActionEvent e)
	{
		new myfrmf();
		dispose();
	}	

}	
