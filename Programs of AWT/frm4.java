import java.awt.*;
import java.awt.event.*;

class frm4 extends Frame
{
	frm4()
	{
		super("WindowListener Demo");
		setLocation(250,150);
		setSize(500,500);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setVisible(true);
	}	
	
	public static void main(String args[])
	{
		new frm4();
	}
}
