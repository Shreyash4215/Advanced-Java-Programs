import javax.swing.*;
import java.awt.*;
class JFImg extends JFrame
{
	ImageIcon i;
    JLabel l1;
	
    JFImg()
	{
		super("Image Demo");
		setSize(1024,768);
		
		i = new ImageIcon("Rose.jpg");
		l1 = new JLabel(i);
		add(l1);        
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new JFImg();
	}
}