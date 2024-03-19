import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener
{	
	TextField t1;
	Checkbox ch1,ch2,ch3,ch4,ch5;	
	Label l1,l2;
	
	myfrm()
	{
		setTitle("Bill");
		setSize(500,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		ch1=new Checkbox("Pen ......... 20Rs./-");
		ch2=new Checkbox("Pencil ...... 7Rs./-");	
		ch3=new Checkbox("Rubber ...... 3Rs./-");
		ch4=new Checkbox("Notebook .... 30Rs./-");	
		ch5=new Checkbox("book ........ 50Rs./-");
		
		l1 = new Label("Total Bill = ");
		l2 = new Label("Rs./-");
		t1 = new TextField();		
		
		add(ch1);	add(ch2);	add(ch3);	add(ch4);	add(ch5);	add(t1);		add(l1);	add(l2);
		
		ch1.setBounds(100,100,200,30);
		ch2.setBounds(100,130,200,30);	
		ch3.setBounds(100,160,200,30);
		ch4.setBounds(100,190,200,30);
		ch5.setBounds(100,220,200,30);
		l1.setBounds(100,300,100,30);
		t1.setBounds(200,300,70,30);
		l2.setBounds(272,300,50,30);
				
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);
		ch4.addItemListener(this);
		ch5.addItemListener(this);
		
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
		int sum=0;
		
			if(ch1.getState())
				sum=sum+20;	
		
			if(ch2.getState())
				sum=sum+7;
		
			if(ch3.getState())
				sum=sum+3;
		
			if(ch4.getState())
				sum=sum+30;
		
			if(ch5.getState())
				sum=sum+50;
		
	   t1.setText(Integer.toString(sum));
	}
}
class Ass2bill
{
	public static void main(String args[])
	{
		new myfrm();
	}
}