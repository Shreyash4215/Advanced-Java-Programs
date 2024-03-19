import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ActionListener
{	
	TextField t1;
	Button b1,b2,b3;	
	Font f;
	
	myfrm()
	{
		setTitle("Font Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.PLAIN,15));
		setLayout(new FlowLayout());
		
		t1 = new TextField("Welcome In Java");
		b1 = new Button("Bold");
		b2 = new Button("Italic");
		b3 = new Button("Plain");
		
		add(t1);
		add(b1);
		add(b2);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
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
	
	public void actionPerformed(ActionEvent e)
	{		
			if(e.getSource()==b1)			
			{
				f = new Font(t1.getFont().getName(),Font.BOLD,15);
				t1.setFont(f);
			}			
			else if(e.getSource()==b2)						
			{
				f = new Font(t1.getFont().getName(),Font.ITALIC + Font.BOLD,15);
				t1.setFont(f);
			}
			else if(e.getSource()==b3)	
			{
				f = new Font(t1.getFont().getName(),Font.PLAIN,15);
				t1.setFont(f);
			}
			
	}
}
class Fontdemo
{
	public static void main(String args[])
	{
		new myfrm();
	}
}