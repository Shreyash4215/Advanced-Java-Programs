import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener
{	
	TextField t1;
	Checkbox ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8;
	CheckboxGroup grp1,grp2,grp3;	
	String temp="";
	
	myfrm()
	{
		setTitle("OS Support");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
				
		grp1 = new CheckboxGroup();
		grp2 = new CheckboxGroup();
		grp3 = new CheckboxGroup();
		
		ch1=new Checkbox("Win 7",false,grp1);
		ch2=new Checkbox("Win 8",false,grp1);
		ch3=new Checkbox("Win 10",false,grp1); 
		ch4=new Checkbox("Supports",false,grp2);
		ch5=new Checkbox("Not Supports",false,grp2);
		ch6=new Checkbox("C",false,grp3);
		ch7=new Checkbox("C++",false,grp3); 
		ch8=new Checkbox("Java",false,grp3);
		t1 = new TextField();
		
		add(ch1);		add(ch2);		add(ch3);		add(ch4);		add(ch5);
		add(ch6);		add(ch7);		add(ch8);		add(t1);
		
		ch1.setBounds(100,100,70,30);
		ch2.setBounds(190,100,70,30);
		ch3.setBounds(280,100,70,30);
		ch4.setBounds(115,140,100,30);		
		ch5.setBounds(215,140,120,30);
		ch6.setBounds(100,180,50,30);
		ch7.setBounds(190,180,50,30);
		ch8.setBounds(280,180,50,30);
		t1.setBounds(110,250,210,30);
				
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);
		ch4.addItemListener(this);
		ch5.addItemListener(this);
		ch6.addItemListener(this);
		ch7.addItemListener(this);
		ch8.addItemListener(this);
		
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
			if(ch1.getState())			
				temp="Win 7 ";			
			else if(ch2.getState())						
				temp="Win 8 ";			
			else if(ch3.getState())	
				temp="Win 10 ";
			
			if(ch4.getState())
				temp=temp+"Supports ";
			else if(ch5.getState())
				temp=temp+"Not Supported ";	

			if(ch6.getState())
				temp=temp+"C ";
			else if(ch7.getState())
				temp=temp+"C++ ";	
			else if(ch8.getState())
				temp=temp+"Java ";
			
			t1.setText(temp);
	}
}
class Ass3os
{
	public static void main(String args[])
	{
		new myfrm();
	}
}