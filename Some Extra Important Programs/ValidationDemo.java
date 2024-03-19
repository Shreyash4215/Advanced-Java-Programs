import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ValidationDemo extends JFrame
{
	JTextField t1;
	JLabel l1;
	
	ValidationDemo()
	{
		setTitle("Validation Demo");
		setSize(450,200);
		setLocation(250,150);			
		setLayout(null);
		
		t1 =new JTextField();
		l1 =new JLabel("Enter 3 Digit Number");
		
		add(t1);
		add(l1);
		
		l1.setBounds(50,50,150,20);
		t1.setBounds(200,47,120,25);
	
		Validate(t1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
	void Validate(final JTextField tt)
	{				
		tt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(tt.getText().length()<3 && e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
					super.keyTyped(e);	//Optional
				else
				{
					e.consume();		//Write Accessed Denied
					
					Toolkit tk = Toolkit.getDefaultToolkit();
					tk.beep();			//Raised the beep Sound
				}					
			}
		});		
	}
		
    public static void main(String args[])
	{
        new ValidationDemo();
	}
}