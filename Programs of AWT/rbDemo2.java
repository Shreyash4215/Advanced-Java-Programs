import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener
{	
	TextField t1;
	Checkbox ch1,ch2,ch3,ch4;
	CheckboxGroup grp1,grp2;	
	
	myfrm()
	{
		setTitle("Radiobox Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		grp1 = new CheckboxGroup();
		grp2 = new CheckboxGroup();
		
		ch1=new Checkbox("pen",false,grp1);
		ch2=new Checkbox("pencil",false,grp1);
		ch3=new Checkbox("Books",false,grp2); 
		ch4=new Checkbox("Notebooks",false,grp2);		
		t1 = new TextField();		
		
		add(ch1);
		add(ch2);
		add(ch3);
		add(ch4);		
		add(t1);
		
		ch1.setBounds(100,100,100,30);
		ch2.setBounds(210,100,100,30);
		ch3.setBounds(320,100,100,30);
		ch4.setBounds(430,100,100,30);		
		t1.setBounds(100,140,210,30);
				
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);
		ch4.addItemListener(this);
		
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
				t1.setText("pen Selected");
			else if(ch2.getState())	
				t1.setText("pencil Selected");		
			if(ch3.getState())
				t1.setText("Book Selected");
			else if(ch4.getState())
				t1.setText("Notebook Selected");	
	}
}
class rbDemo2
{
	public static void main(String args[])
	{
		new myfrm();
	}
}