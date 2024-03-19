import javax.swing.*;
import java.awt.*;

class JFImgdemo extends JFrame
{
	ImageIcon i;
	JLabel l1;
	
	JFImgdemo()
	{
		setTitle("Demo of ToolBar");
		setSize(500,500);
		setLocation(150,150);
		setLayout(null);

		l1 = new JLabel(new ImageIcon("./Image/_DSC0584.jpg"));
		add(l1);
		l1.setBounds(50,50,385,425);
						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
}
class JFImg2
{
	public static void main(String args[])
	{
		new JFImgdemo();
	}
}