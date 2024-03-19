import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.Date;
import java.text.*;

public class FocusListenerDemo extends JFrame implements FocusListener
{
	JTextField t,textField;
		DateFormat date;		Date d;
	JButton b;
	
	FocusListenerDemo()
	{
		
		date = new SimpleDateFormat("yyyy-MM-dd");
		d=new Date();
		
		 textField = new JTextField("A TextField");
		textField.addFocusListener(this);
	
		 b= new JButton("daaa");
		// b.addFocusListener(this);
		add(b,"Center");
		
		 t = new JTextField();
		add(textField,"North");
		add(t,"South");
		
		
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		public void focusGained(FocusEvent e)
	    {
			DateChooser DATE_CHOOSER = new DateChooser((JFrame)null,"Select Date");
		try
		{
			Date newDate = DATE_CHOOSER.select(d);
			 textField.setText(date.format(newDate));	    
		}catch(Exception n){}
		
		t.requestFocus();
		}

		public void focusLost(FocusEvent e) 
		{
		b.requestFocus();
			System.out.println("Focus lost");
		}

		public static void main(String[] a) 
		{
			new FocusListenerDemo();
		}
  }