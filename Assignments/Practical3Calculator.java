import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myfrm extends JFrame implements ActionListener
{	
	JPanel p1;
	JButton b[],b16,b17;
	JTextField t1;
	String arr[]={"1","2","3","+","4","5","6","-","7","8","9","*","0",".","=","/"};
	String n="",o="";
	Double p,q,ans;
	static int c=0;
	
	myfrm()
	{
		setTitle("Calculator");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.PLAIN,15));
		setLayout(null);
		
		p1 = new JPanel();
		t1 = new JTextField();
		b = new JButton[16];
		b16 = new JButton("Clear");
		b17 = new JButton("Exit");
				
		add(p1);
		add(b16);
		add(b17);
		add(t1);
				
		b16.setBounds(200,295,100,30);
		b17.setBounds(310,295,98,30);
		t1.setBounds(200,100,210,30);
		p1.setBounds(200,140,210,150);
		
		p1.setLayout(new GridLayout(4,4,5,5));
		for(int i=0;i<16;i++)
		{
			b[i]=new JButton(""+arr[i]);
			p1.add(b[i]);
		    b[i].addActionListener(this);
		}

		b16.addActionListener(this);
		b17.addActionListener(this);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}	
	
	public void actionPerformed(ActionEvent e)
	{	
		String ch = e.getActionCommand();
		try
		{
			try
			{
				if(".".equals(ch) && c==0)
				{
					n=n+ch;
					c++;	
				}
				if(0<=Integer.parseInt(ch))
					n=n+ch;				
				
				t1.setText(n);
				
			}catch(Exception ex){}
			
			if("+".equals(ch) || "-".equals(ch) || "*".equals(ch) || "/".equals(ch))
			{
				c=0;
				o=ch;
				p=Double.parseDouble(t1.getText());
				t1.setText("");
				n="";
			}				
			if("=".equals(ch))
			{	
				q=Double.parseDouble(t1.getText());
				
				if("+".equals(o))
					ans=p+q;
				if("-".equals(o))
					ans=p-q;
				if("*".equals(o))
					ans=p*q;
				if("/".equals(o))
					ans=p/q;
				
				t1.setText(Double.toString(ans));
				n="";
			}		
		if(e.getSource()==b16)
		{
			c=0;
			n="";
			t1.setText("");
		}
		if(e.getSource()==b17)
			System.exit(0);		
		}	
		catch(ArithmeticException ae)
		{
			t1.setText("Infinity");
			n="";
		}
		catch(Exception ex){}
	}
}
class Practical3Calculator
{
	public static void main(String args[])
	{
		new myfrm();
	}
}