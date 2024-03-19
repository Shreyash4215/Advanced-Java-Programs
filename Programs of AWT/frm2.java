import java.awt.*;

class frm2
{
	Frame f1;
	
	frm2()
	{
		f1 = new Frame();
		f1.setTitle("My First Frame");
		f1.setLocation(250,150);
		f1.setSize(500,500);
		f1.setVisible(true);
	}
	
	public static void main(String args[])
	{
		new frm2();
	}
}
