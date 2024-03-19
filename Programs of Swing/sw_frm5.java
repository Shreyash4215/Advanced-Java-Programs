import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class sw_frm5 extends JFrame implements ActionListener
{
	// 1) Declaration
	JButton b1,b2;
	JTextField t1;
	
	sw_frm5()
	{
		super("Swing Demo");
		setLocation(250,150);
		setSize(500,500);
		
		setLayout(new FlowLayout());	// IMP
		
		// 2) Memory Allocation
		b1 = new JButton("Click Me");
		b2 = new JButton("Exit");
		t1 = new JTextField(20);
		
		// 3) Add Controls on Frame
		add(t1);
		add(b1);
		add(b2);
		
		b1.setMnemonic('C');
		b2.setMnemonic('X');
		
		t1.setToolTipText("This is TextField");
		b1.setToolTipText("Click Me");
		b2.setToolTipText("Way to EXIT");
		
		// 4) Add Listener on Controls
		b1.addActionListener(this);
		b2.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
			t1.setText("Button Clicked");
		else if(e.getSource()==b2)
			System.exit(0);
	}
	
	public static void main(String args[])
	{
		new sw_frm5();
	}
}
