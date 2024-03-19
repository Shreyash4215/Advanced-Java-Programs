import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener
{	
	TextField t1;
	Choice ch1;
	
	myfrm()
	{
		setTitle("Choice Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		ch1=new Choice();		
		t1 = new TextField();
				
		add(ch1);		
		add(t1);
		
		ch1.add("Apple");
		ch1.add("Bat");
		ch1.add("Cat");
		ch1.add("Dog");
		
		ch1.setBounds(100,100,210,30);		
		t1.setBounds(100,140,210,30);
				
		ch1.addItemListener(this);
		
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
			if(e.getSource()==ch1)
			{
				t1.setText(ch1.getSelectedItem() + " at Index " +ch1.getSelectedIndex());
			}
	}
}
class choicDemo
{
	public static void main(String args[])
	{
		new myfrm();
	}
}