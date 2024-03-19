//Components And Event

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myfrm extends JFrame implements ActionListener
{
	//1) Declaration
	
	JLabel lbl1;
	JButton btn1;
	int cnt=0;
	
	myfrm()
	{
		setTitle("My First Frame");
		setSize(500,500);
		setLocation(500,200);
		setLayout(new FlowLayout());
		setFont(new Font("Arial",Font.BOLD,15));
		
		//2) Memory Allocation
		lbl1 = new JLabel("Welcome");
		btn1 = new JButton("Click me");
		
		//3) Add Control on frame
		
		add(lbl1);
		add(btn1);
		
		//4)Add Listeners on Controls

		btn1.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);		
	}	
	public void actionPerformed(ActionEvent e)
	{
		cnt++;
		
		lbl1.setText("Clicked="+cnt);
	}	

}	
class jfrm3
{
	public static void main(String args[])
	{
		new myfrm();
	}
}