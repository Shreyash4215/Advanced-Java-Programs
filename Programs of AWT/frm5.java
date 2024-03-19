import java.awt.*;
import java.awt.event.*;

class frm5 extends Frame implements ActionListener
{
	// 1) Declaration
	Button b1;
	TextField t1;
	
	frm5()
	{
		super("WindowAdapter Demo");
		setLocation(250,150);
		setSize(500,500);
		
		setLayout(new FlowLayout());	// IMP
		
		// 2) Memory Allocation
		b1 = new Button("Click Me");
		t1 = new TextField("Welcome");
		
		// 3) Add Controls on Frame
		add(t1);
		add(b1);
		
		// 4) Add Listener on Controls
		b1.addActionListener(this);
		
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
		t1.setText("Button Clicked");
	}
	
	public static void main(String args[])
	{
		new frm5();
	}
}
