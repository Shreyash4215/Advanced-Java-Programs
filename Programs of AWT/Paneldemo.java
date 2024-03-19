import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ActionListener
{	
	Panel p1;
	Button b1,b2,but[];
	Checkbox cb1,cb2;
	myfrm()
	{
		setTitle("Panel Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.PLAIN,15));
		setLayout(null);
		
		p1 = new Panel();
		b1 = new Button("Hide");
		b2 = new Button("Show");
		cb1 = new Checkbox("PEN");
		cb2 = new Checkbox("PENCIL");

		
		but = new Button[25];

		add(p1);
		add(b1);
		add(b2);
		p1.add(cb1);
		p1.add(cb2);
		
		b1.setBounds(200,100,100,30);
		b2.setBounds(310,100,100,30);
		p1.setBounds(200,150,210,210);
		
		//p1.setBackground(Color.RED);

		for(int i=0;i<25;i++)
		{
			but[i]=new Button(""+(i+1));
			p1.add(but[i]);
			
		}

		b1.addActionListener(this);
		b2.addActionListener(this);
		
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
				p1.setVisible(false);
			}			
			else if(e.getSource()==b2)						
			{
				p1.setVisible(true);
			}			
	}
}
class Paneldemo
{
	public static void main(String args[])
	{
		new myfrm();
	}
}