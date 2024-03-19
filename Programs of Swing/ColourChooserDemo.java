import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class Colorch extends JFrame implements ChangeListener
{
	JColorChooser cc;
	JLabel l1;
	
	Colorch()
	{
		setTitle("Demo of ColorChoose");
		setLayout(null);
	
		setSize(900,500);
		setLocation(150,150);
		
		l1 = new JLabel("Welcome to the Tutorail Zone!",JLabel .CENTER);
		l1.setForeground(Color.yellow);
		l1.setBackground(Color.black);
		l1.setOpaque(true);
		/*
			javax.swing.Jcomponent
			public void setOpaque(boolean isOpaque)
			if true the component paints every pixel
			within its bounds.
			Otherwise,the component may not paint some 
			or all of its pixels,allowing the uderlying pixels,
			allowing the underlying pixels to show through.
			the default value of this propert is false for Jcomponent.
			However,the default value for this property on most
			standard Jcomponent Subclass (such as JButton and JTree)is 
			look-and-feel dependent.
		*/	
			
		
		l1.setFont(new Font("SansSerif",Font.BOLD,30));
		l1.setBorder(BorderFactory.createTitledBorder("Display"));
		
		//l1.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
		
		cc = new JColorChooser(l1.getForeground());
		cc.getSelectionModel().addChangeListener(this);
		cc.setBorder(BorderFactory.createTitledBorder("Choose Text Color"));
				
		add(l1);
        add(cc);
		
		l1.setBounds(15,15,500,80);
		cc.setBounds(15,105,700,350);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
	public void stateChanged(ChangeEvent e)
	{
		Color clr = cc.getColor();
		l1.setForeground(clr);
	}	
}
class ColourChooserDemo
{
	public static void main(String args[])
	{
		new Colorch();
	}
}