import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JFImgdemo extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	
	JFImgdemo()
	{
		setTitle("Demo of ToolBar");
		setSize(500,500);
		setLocation(150,150);
		setLayout(new FlowLayout());
		
		b1 = new JButton(new ImageIcon("./Image/save.png"));
		b1.setText("SAVE");
		
		b2 = new JButton(new ImageIcon("./Image/update.png"));
		b2.setText("UPDATE");
		
		b3 = new JButton(new ImageIcon("./Image/exit.png"));
		b3.setText("EXIT");
		
		b1.setToolTipText("save");
		b2.setToolTipText("Update");
		b3.setToolTipText("Delete");
		
		add(b1);
		add(b2);
		add(b3);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null,e.getActionCommand());
	}
}
class JFImg3
{
	public static void main(String args[])
	{
		new JFImgdemo();
	}
}