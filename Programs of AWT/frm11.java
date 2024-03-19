import java.awt.*;
import java.awt.event.*;

class frm11 extends Frame implements ActionListener
{
	Button b1,b2;
	Panel p1;
	
	frm11()
	{
		setTitle("List Box");
		setSize(500,400);
		setLocation(300,300);			
		setLayout(null);
		
		b1 = new Button("Hide");
		b2= new Button("Show");
		p1 =new Panel();
		
		add(b1);
		add(b2);
		add(p1);
		
		p1.setBackground(Color.RED);
		p1.setLayout(new GridLayout(5,2,5,5));

		for(int i=0;i<10;i++)
			p1.add(new Button(""+(i+1)));
				
		b1.setBounds(100,100,100,20);
		b2.setBounds(210,100,100,20);
		p1.setBounds(100,130,210,100);
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});            
			
			setVisible(true);
	}
	
    public void actionPerformed(ActionEvent e)
	{
        if(e.getSource()==b1)
        {
			p1.setVisible(false);
		}
		
        if(e.getSource()==b2)
		{
			p1.setVisible(true);
		}
		
	}
	
    public static void main(String args[])
	{
        new frm11();
	}
}
