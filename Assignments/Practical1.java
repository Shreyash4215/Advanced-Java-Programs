import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener
{	
	TextField t1;	
	Font f;
	Choice ch1,ch2;
	Checkbox c1,c2;
	Label l1,l2,l3;
	int s;
	String n="";
		
	myfrm()
	{
		setTitle("Font Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Andalus",Font.BOLD,15));
		setLayout(null);
		
		t1 = new TextField("Welcome In Java");
		ch1 = new Choice();
		ch2 = new Choice();
		c1 = new Checkbox("Bold");
		c2 = new Checkbox("Italic");
		l1 = new Label("Font");
		l2 = new Label("Size");
		l3 = new Label("Style");
		
		ch1.add("Arial");
		ch1.add("Serif");
		ch1.add("SansSerif");
		ch2.add("10");
		ch2.add("20");
		ch2.add("25");
		
		add(l1);
		add(l2);
		add(l3);
		add(ch1);
		add(ch2);
		add(c1);
		add(c2);
		add(t1);
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		
		l1.setBounds(100,100,100,30);
		l2.setBounds(100,160,100,30);
		l3.setBounds(270,100,100,30);
		c1.setBounds(270,140,100,30);
		c2.setBounds(270,180,100,30);
		ch1.setBounds(100,130,125,30);
		ch2.setBounds(100,190,125,30);
		t1.setBounds(100,230,220,30);
		
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
		int y=0;
		
			if(e.getSource()==ch1)			
			{
				if(ch1.getSelectedIndex()==0)
				{
					n="Arial";
				}		
				else if(ch1.getSelectedIndex()==1)						
				{
					n="Serif";					
				}
				else if(ch1.getSelectedIndex()==2)	
				{
					n="SansSerif";
				}
			}
			if(e.getSource()==ch2)			
			{					
				if(ch2.getSelectedIndex()==0)
				{
					s=10;	
				}		
				else if(ch2.getSelectedIndex()==1)						
				{
					s=20;
				}
				else if(ch2.getSelectedIndex()==2)	
				{
					s=25;
				}
			}
		
			if(c1.getState())
			{
				y=y+Font.BOLD;	
			}		
			if(c2.getState())						
			{
				y=y+Font.ITALIC;
			}
						
			f = new Font(n,y,s);
			t1.setFont(f);
	}
}
class Practical1
{
	public static void main(String args[])
	{
		new myfrm();
	}
}