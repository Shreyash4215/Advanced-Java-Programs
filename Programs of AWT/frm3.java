import java.awt.*;
import java.awt.event.*;

class frm3 extends Frame implements WindowListener
{
	frm3()
	{
		super("WindowListener Demo");
		setLocation(250,150);
		setSize(500,500);
		
		addWindowListener(this);
		setVisible(true);
	}
	
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	
	public static void main(String args[])
	{
		new frm3();
	}
}
