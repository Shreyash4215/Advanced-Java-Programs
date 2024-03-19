import java.awt.*;
import javax.swing.*;

class BoxLayoutDemo extends Frame
{
	BoxLayoutDemo()
	{
		setSize(400,300);
		Panel pv = new Panel();
		
		pv.setLayout(new BoxLayout(pv, BoxLayout.Y_AXIS));
				
		for(int i=0;i<10;i++)
			pv.add(new Button(""+(i+1)));
		
		Panel ph = new Panel();
		
		ph.setLayout(new BoxLayout(ph,BoxLayout.X_AXIS));
				
		for(int i=0;i<5;i++)
			ph.add(new Button(""+(i+1)));
		
		add(BorderLayout.EAST,pv);
		add(BorderLayout.SOUTH,ph);
		
		setVisible(true);	
	}
	public static void main(String args[])
	{
		new BoxLayoutDemo();
	}
}
