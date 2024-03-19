import java.awt.*;
import java.awt.event.*;

class myframe extends Frame implements ItemListener
{
	Label l1,l2,l3;
	TextField t1,t2;
	Checkbox ch1,ch2,ch3,ch4,ch5,ch6;
	CheckboxGroup grp1;
	String name="",d="";
	myframe()
	{
		setTitle("Operation with Checkbox radio button label");
		setSize(800,500);
		setLocation(200,200);
		setLayout(null);
		
		l1 = new Label("Enter  Your  Name");
		l2 = new Label("Your Class");
		l3 = new Label("Your Hobbies");
		t1 = new TextField();
		t2 = new TextField();
		grp1 = new CheckboxGroup();
		ch1 = new Checkbox("FY",false,grp1);
		ch2 = new Checkbox("SY",false,grp1);
		ch3 = new Checkbox("TY",false,grp1);
		ch4 = new Checkbox("Music",false);
		ch5 = new Checkbox("Dance",false);
		ch6 = new Checkbox("Sports",false);
		
		add(l1);
		add(l2);
		add(l3);
		add(t1);
		add(t2);
		add(ch1);
		add(ch2);
		add(ch3);
		add(ch4);
		add(ch5);
		add(ch6);
		
		l1.setBounds(100,100,105,30);
		t1.setBounds(220,100,125,30);
		l2.setBounds(100,150,70,30);
		ch1.setBounds(100,180,70,30);
		ch2.setBounds(100,210,70,30);
		ch3.setBounds(100,240,70,30);
		l3.setBounds(200,150,70,30);
		ch4.setBounds(200,180,70,30);
		ch5.setBounds(200,210,70,30);
		ch6.setBounds(200,240,70,30);
		t2.setBounds(100,290,300,30);
		
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);
		ch4.addItemListener(this);
		ch5.addItemListener(this);
		ch6.addItemListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
		);
		
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent e)
	{
		String name="",hb="";
		name = name+"Name="+(t1.getText())+", class=";
		if(e.getSource()==ch1||e.getSource()==ch2||e.getSource()==ch3)
		{
			ch4.setState(false);
			ch5.setState(false);
			ch6.setState(false);
			
			if(ch1.getState())
				d ="FY";
			if(ch2.getState())
				d ="SY";
			if(ch3.getState())
				d ="TY";
		}	
		
		name = name + d;
		
		if(e.getSource()==ch4||e.getSource()==ch5||e.getSource()==ch6)
		{
			hb=" And Hobbies = ";
			if(ch4.getState())
				hb =hb+"Music ";
			if(ch5.getState())
				hb = hb+"Dance ";
			if(ch6.getState())
				hb = hb+"Sports";
		}	
		
		name = name+hb;
		
		t2.setText(name);
	}	
}
class Practical2ChkBox
{
	public static void main(String args[])
	{
		new myframe();
	}
}