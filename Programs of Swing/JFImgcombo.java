import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JFImgcombodemo extends JFrame implements ItemListener
{
	JLabel l1;
	JComboBox jc;
	
	JFImgcombodemo()
	{
		setTitle("Demo of ToolBar");
		setSize(850,700);
		//setLocation(150,150);
		setLayout(null);
		
		jc = new JComboBox();
		
		jc.addItem("Rose");
		jc.addItem("Nature");
		jc.addItem("Waterfall");
		
		
		jc.addItemListener(this);
		add(jc);
		jc.setBounds(10,10,100,20);
	
		l1 = new JLabel(new ImageIcon("./Image/Rose.jpg"));
		add(l1);
		l1.setBounds(10,40,800,600);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
	public void itemStateChanged(ItemEvent i)
	{
		if(jc.getSelectedIndex()==0)
			l1.setIcon(new ImageIcon("./Image/Rose.jpg"));
	
		else if(jc.getSelectedIndex()==1)
			l1.setIcon(new ImageIcon("./Image/Nature.jpg"));	

		else if(jc.getSelectedIndex()==2)
			l1.setIcon(new ImageIcon("./Image/Waterfall.jpg"));
	}
}
class JFImgcombo
{
	public static void main(String args[])
	{
		new JFImgcombodemo();
	}
}