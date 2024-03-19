import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ActionListener
{
	int a=0,b=0,c;
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2,b3,b4,b5,b6;	
	
	myfrm()
	{
		setTitle("Simple Calculator");
		setSize(250,200);
		setLocation(500,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(new FlowLayout());
		
		l1 = new Label("Enter 1st Number    ");
		l2 = new Label("Enter 2nd Number   ");
		l3 = new Label("Calculation of 2 Nos");
		
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		
		b1 = new Button("ADD");
		b2 = new Button("SUB");	
		b3 = new Button("MUl");
		b4 = new Button("DIV");	
		b5 = new Button("CLR");
		b6 = new Button("EXT");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
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
		try
		{
			if(e.getSource() == b5)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				return;
			}
			else if(e.getSource() == b6)
			{
				System.exit(0);
			}		
			
			a = Integer.parseInt(t1.getText());
    		b = Integer.parseInt(t2.getText());			

			if(e.getSource() == b1)
			{			
				t3.setText(Integer.toString(a+b));				
			}
			else if(e.getSource() == b2)
			{	
				t3.setText(Integer.toString(a-b));
			}
			else if(e.getSource() == b3)
			{
				t3.setText(Integer.toString(a*b));
			}
			else if(e.getSource() == b4)
			{
				t3.setText(Integer.toString(a/b));
			}		
		}
		catch(NumberFormatException ex)
		{
			System.out.println("\n\t Enter two number for Calculation");
		}
		catch(ArithmeticException ex)
		{
			System.out.println("\n\t Cannot Divide by 0");
		}
		catch(Exception ex)
		{
			System.out.println("\n\t "+ex);
		}
	}
}

class Ass1cal
{
	public static void main(String args[])
	{
		new myfrm();
	}
}