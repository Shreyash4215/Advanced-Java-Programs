import java.awt.*;

class frm1 extends Frame
{
	frm1()
	{
//		setTitle("My First Frame");
		super("My First Frame");
		setLocation(250,150);
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new frm1();
	}
}
