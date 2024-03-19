import java.awt.*;
import java.awt.event.*;

class frm7 extends Frame implements ActionListener
{
	// 1) Declaration
	Button b1,b2;
	TextField t1;
	
	frm7()
	{
		super("WindowAdapter Demo");
		setLocation(250,150);
		setSize(500,500);
		
		setLayout(new FlowLayout());	// IMP
		
		// 2) Memory Allocation
		b1 = new Button("Click Me");
		b2 = new Button("Exit");
		t1 = new TextField("Welcome");
		
		// 3) Add Controls on Frame
		add(t1);
		add(b1);
		add(b2);
		
		// 4) Add Listener on Controls
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
		if(e.getActionCommand().equals("Click Me"))
		{
			t1.setText("Button Clicked");
		}
		else if(e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		new frm7();
	}
}
