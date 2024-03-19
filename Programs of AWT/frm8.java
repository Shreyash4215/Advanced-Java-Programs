import java.awt.*;
import java.awt.event.*;

class frm8 extends Frame implements ActionListener
{
	// 1) Declaration
	Label l1,l2,l3;
	Button b1,b2,b3;
	TextField t1,t2,t3;
	
	frm8()
	{
		super("WindowAdapter Demo");
		setLocation(250,150);
		setSize(500,500);
		
		setLayout(null);	// IMP
		
		// 2) Memory Allocation
		b1 = new Button("ADD");
		b2 = new Button("CLR");
		b3 = new Button("EXT");
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		l1 = new Label("Enter 1st No.");
		l2 = new Label("Enter 2nd No.");
		l3 = new Label("Addition of 2");
		
		// 3) Add Controls on Frame
		add(l1);	add(l2);	add(l3);
		add(b1);	add(b2);	add(b3);
		add(t1);	add(t2);	add(t3);
		
		// 4) setBounds(x,y,width,height)
		l1.setBounds(150,150,100,20);
		t1.setBounds(260,150,100,20);
			l2.setBounds(150,180,100,20);
			t2.setBounds(260,180,100,20);
		l3.setBounds(150,210,100,20);
		t3.setBounds(260,210,100,20);
		
		b1.setBounds(150,240,60,20);
		b2.setBounds(225,240,60,20);
		b3.setBounds(300,240,60,20);
		
		// 5) Add Listener on Controls
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
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
			int a = Integer.parseInt(t1.getText());
			int b = Integer.parseInt(t2.getText());
			int c=a+b;
//			t3.setText(""+c);			
			t3.setText(Integer.toString(c));			
		}
		else if(e.getSource()==b2)
		{
			t1.setText("");			
			t2.setText("");			
			t3.setText("");	
			t1.requestFocus();
		}
		else if(e.getSource()==b3)
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		new frm8();
	}
}
