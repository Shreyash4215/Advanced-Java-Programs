import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myfrm extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JButton b1;
	JComboBox cb1,cb2;	
	int a=0,b=0;
	
	myfrm()
	{
		setTitle("Length Conversion");
		setSize(500,225);
		setLocation(400,100);				
		setLayout(null);
		
		l1 = new JLabel("Input ");
		l2 = new JLabel("Output ");
		l3 = new JLabel("Unit ");
		l4 = new JLabel("Unit");
		t1 = new JTextField();
		t2 = new JTextField();
		cb1 = new JComboBox();
		cb2 = new JComboBox();		
		b1 = new JButton("Convert");
					
		add(l1);		add(l2);		add(l3);
		add(cb1);		add(l4);		add(t1);
		add(t2);		add(cb2);		add(b1);
		
		cb1.addItem("Feet");
		cb1.addItem("Inches");
		cb1.addItem("Centimeters");
		cb1.addItem("Meters");
		cb1.addItem("Kilometers");		
		cb2.addItem("Feet");
		cb2.addItem("Inches");
		cb2.addItem("Centimeters");
		cb2.addItem("Meters");
		cb2.addItem("Kilometers");

		l1.setBounds(50,50,50,25);				
		t1.setBounds(100,52,100,22);				
		l2.setBounds(232,50,50,25);				
		t2.setBounds(290,52,100,22);				
		l3.setBounds(50,93,50,25);				
		cb1.setBounds(100,93,100,22);				
		l4.setBounds(232,93,50,25);				
		cb2.setBounds(290,93,100,22);				
		b1.setBounds(50,131,340,25);				
		
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		b1.addActionListener(this);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
	}
	public void actionPerformed(ActionEvent e)
	{
		Double n;
		
		if(e.getSource()==cb1)
			a=cb1.getSelectedIndex();
			
		if(e.getSource()==cb2)
			b=cb2.getSelectedIndex();
				
		if(e.getSource()==b1)
		{
			n=Double.parseDouble(t1.getText());
			
			if(a==0 && b==1)
				t2.setText(Double.toString(n*12));
			if(a==0 && b==2)
				t2.setText(Double.toString(n*30.48));
			if(a==0 && b==3)
				t2.setText(Double.toString(n/3.2));
			if(a==0 && b==4)
				t2.setText(Double.toString(n/3));
			
			if(a==1 && b==0)
				t2.setText(Double.toString(n/12));
			if(a==1 && b==2)
				t2.setText(Double.toString(n*2.54));
			if(a==1 && b==3)
				t2.setText(Double.toString(n/39.37));
			if(a==1 && b==4)
				t2.setText(Double.toString(n/39370));
		
			if(a==2 && b==0)
				t2.setText(Double.toString(n/30.48));
			if(a==2 && b==1)
				t2.setText(Double.toString(n/2.54));
			if(a==2 && b==3)
				t2.setText(Double.toString(n/100));
			if(a==2 && b==4)
				t2.setText(Double.toString(n/100000));
		
			if(a==3 && b==0)
				t2.setText(Double.toString(n*3.281));
			if(a==3 && b==1)
				t2.setText(Double.toString(n*39.37));
			if(a==3 && b==2)
				t2.setText(Double.toString(n*100));
			if(a==3 && b==4)
				t2.setText(Double.toString(n/1000));
			
			if(a==4 && b==0)
				t2.setText(Double.toString(n*3281));
			if(a==4 && b==1)
				t2.setText(Double.toString(n*39370));
			if(a==4 && b==2)
				t2.setText(Double.toString(n*100000));
			if(a==4 && b==3)
				t2.setText(Double.toString(n*1000));
		}		
	}
}
class Practical7ConvertUnt
{
	public static void main(String args[])
	{
		new myfrm();
	}
}