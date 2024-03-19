import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ItemListener,ActionListener
{	
	Label l1,l2,l3,l4;
	TextField t1,t2,t3;
	Choice ch1;
	Button b1,b2,b3;
	
	myfrm()
	{
		setTitle("Choice Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		ch1=new Choice();		
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		l1 = new Label("Select Pizza Type ");
		l2 = new Label("Price");
		l3 = new Label("Quantity");
		l4 = new Label("Total Bill");
		b1 = new Button("Total");		
		b2 = new Button("Clear");
		b3 = new Button("Exit");
		
		add(ch1);		
		add(t1);
		add(t2);
		add(t3);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(b1);
		add(b2);
		add(b3);
		
		
		ch1.add("Select Type");
		ch1.add("Cheese Pizza");
		ch1.add("Corn Pizza");
		ch1.add("Veg Pizza");
		ch1.add("Special Pizza");
		
		l1.setBounds(100,100,200,30);
		ch1.setBounds(260,100,200,30);		
		l2.setBounds(100,150,200,30);
		t1.setBounds(260,150,200,30);
		l3.setBounds(100,200,200,30);
		t2.setBounds(260,200,200,30);
		l4.setBounds(100,240,200,30);
		t3.setBounds(260,240,200,30);
		b1.setBounds(115,290,70,30);
		b2.setBounds(222,290,70,30);
		b3.setBounds(330,290,70,30);
		
		ch1.addItemListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);		
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}	
		}
		);
		
		setVisible(true);		
	}	
	
	public void itemStateChanged(ItemEvent e)
	{		
			if(e.getSource()==ch1)
			{
				if(ch1.getSelectedIndex()==1)
					t1.setText("200");
				else if(ch1.getSelectedIndex()==2)
					t1.setText("300");
				else if(ch1.getSelectedIndex()==3)
					t1.setText("400");
				else if(ch1.getSelectedIndex()==4)
					t1.setText("500");			
			}
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b1)
			{
				int a = Integer.parseInt(t2.getText());
				
					if(ch1.getSelectedIndex()==1)
						t3.setText(Integer.toString(a*200));
					else if(ch1.getSelectedIndex()==2)
						t3.setText(Integer.toString(a*300));
					else if(ch1.getSelectedIndex()==3)
						t3.setText(Integer.toString(a*400));
					else if(ch1.getSelectedIndex()==4)
						t3.setText(Integer.toString(a*500));			
			}
			else if(ae.getSource()==b2)
			{
				ch1.select(0);			
				t1.setText("");
				t2.setText("");
				t3.setText("");
				ch1.requestFocus();
			}
			else if(ae.getSource()==b3)
				System.exit(0);
			
		}
		catch(NumberFormatException ex)
		{
			System.out.println("\n\t Enter Valid Record");
		}
		catch(Exception ex)
		{
			System.out.println("\n\t "+ex);
		}
	}
}
class Ass4pizza
{
	public static void main(String args[])
	{
		new myfrm();
	}
}