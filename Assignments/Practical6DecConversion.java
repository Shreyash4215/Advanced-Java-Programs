import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3;	
	
	myfrm()
	{
		setTitle("Decimal Number Conversion");
		setSize(450,300);
		setLocation(400,100);				
		setLayout(null);
		
		l1 = new JLabel("Enter Decimal Number ");
		l2 = new JLabel("Binary Number ");
		l3 = new JLabel("Octal Number ");
		l4 = new JLabel("Hexadecimal Number");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		b1 = new JButton("Convert");
		b2 = new JButton("Clear");
		b3 = new JButton("Exit");
					
		add(l1);		add(l2);		add(l3);
		add(l4);		add(t1);		add(t2);
		add(t3);		add(t4);		add(b1);
		add(b2);		add(b3);
				
		l1.setBounds(80,37,200,30);
		t1.setBounds(232,43,150,22);
		l2.setBounds(80,68,200,30);
		t2.setBounds(232,74,150,22);
		l3.setBounds(80,98,200,30);
		t3.setBounds(232,104,150,22);
		l4.setBounds(80,129,200,30);
		t4.setBounds(232,134,150,22);
		b1.setBounds(80,180,100,22);				
		b2.setBounds(195,180,90,22);				
		b3.setBounds(300,180,80,22);				
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
	}
	public void actionPerformed(ActionEvent e)
	{		
		if(e.getSource()==b1)
		{
			int n = Integer.parseInt(t1.getText());
			t2.setText(Integer.toBinaryString(n));
			t3.setText(Integer.toOctalString(n));
			t4.setText(Integer.toHexString(n));
		}
		if(e.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}
		if(e.getSource()==b3)
			System.exit(0);		
	}
}
class Practical6DecConversion
{
	public static void main(String args[])
	{
		new myfrm();
	}
}