import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener
{	
	TextField t1;
	List lst;
	
	myfrm()
	{
		setTitle("List Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		lst = new List();		
		t1 = new TextField();
				
		add(lst);	add(t1);
		
		lst.add("Apple");
		lst.add("Bat");
		lst.add("Cat");
		lst.add("Dog");
		
		lst.setBounds(100,100,100,150);		
		t1.setBounds(100,270,210,30);
				
		lst.addItemListener(this);
		
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
			if(e.getSource()==lst)
			{
				t1.setText(lst.getSelectedItem() + " at Index " +lst.getSelectedIndex());
			}
	}
}
class lstDemo
{
	public static void main(String args[])
	{
		new myfrm();
	}
}