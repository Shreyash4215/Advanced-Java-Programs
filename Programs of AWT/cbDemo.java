import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener
{	
	TextField t1;
	Checkbox ch1,ch2;	
	
	myfrm()
	{
		setTitle("Checkbox Demo");
		setSize(500,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		ch1=new Checkbox("pen",true); //true is used when we want to clicked automatically 
		ch2=new Checkbox("pencil");		
	
		t1 = new TextField();
		
		
		add(ch1);		add(ch2);
		add(t1);
		
		ch1.setBounds(100,100,50,30);
		ch2.setBounds(160,100,100,30);		
		t1.setBounds(100,140,210,30);
				
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		
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
			if(ch1.getState())
				t1.setText("pen Checked");
			else
				t1.setText("pen UNChecked");		
		else if(e.getSource()==ch2)
			if(ch2.getState())
				t1.setText("pencil Checked");
			else
				t1.setText("pencil UNChecked");	
	}
}

class cbDemo
{
	public static void main(String args[])
	{
		new myfrm();
	}
}