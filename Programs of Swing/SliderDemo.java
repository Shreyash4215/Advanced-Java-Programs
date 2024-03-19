import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class JSliderr extends JFrame implements ChangeListener
{
	JSlider sldr;
	JLabel lb1;
	
	JSliderr()
	{
		setTitle("Demo of Slider");
		setLayout(new FlowLayout());
	
		setSize(500,500);
		setLocation(150,150);
		
		//JSlider(min val,max value,initial value)
		sldr = new JSlider(0,300,100);
		sldr.addChangeListener(this);
		
		add(sldr);
		add(lb1 = new JLabel("100"));
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
	public void stateChanged(ChangeEvent e)
	{
		lb1.setText(Integer.toString(sldr.getValue()));
	}	
}
class SliderDemo
{
	public static void main(String args[])
	{
		new JSliderr();
	}
}