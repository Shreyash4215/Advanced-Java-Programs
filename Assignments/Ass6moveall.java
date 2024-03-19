import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ActionListener
{	
	List lst1,lst2;
	Button b1,b2,b3,b4;
	Label l1,l2;
	
	myfrm()
	{
		setTitle("Move Operation");
		setSize(800,500);
		setLocation(200,200);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		lst1 = new List(5,true);
		lst2 = new List(5,true);
		b1 = new Button(">");
		b2 = new Button("<");
		b3 = new Button(">>");
		b4 = new Button("<<");		
		l1 = new Label("List 1");
		l2 = new Label("List 2");		
		
		add(lst1);
		add(lst2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);		
		add(l1);
		add(l2);
		
		lst1.add("Apple");
		lst1.add("Bat");
		lst1.add("Cat");
		lst1.add("Dog");
		
		lst1.setBounds(100,100,100,200);		
		lst2.setBounds(300,100,100,200);		
		b1.setBounds(232,115,30,30);		
		b2.setBounds(232,155,30,30);		
		b3.setBounds(232,195,30,30);		
		b4.setBounds(232,235,30,30);		
		l1.setBounds(125,50,50,50);		
		l2.setBounds(325,50,50,50);		
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
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
	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
			{								
				String arr[] = lst1.getSelectedItems();
				for(int i=0;i<arr.length;i++)
				{
					lst2.add(arr[i]);
					lst1.remove(arr[i]);				
				}				
			}
		else if(ae.getSource()==b2)
			{								
				String arr[] = lst2.getSelectedItems();
				for(int i=0;i<arr.length;i++)
				{
					lst1.add(arr[i]);
					lst2.remove(arr[i]);				
				}				
			}
		else if(ae.getSource()==b3)
			{								
				String arr[] = lst1.getItems();
				for(int i=0;i<arr.length;i++)
				{
					lst2.add(arr[i]);
					lst1.remove(arr[i]);				
				}				
			}
		else if(ae.getSource()==b4)
			{								
				String arr[] = lst2.getItems();
				for(int i=0;i<arr.length;i++)
				{
					lst1.add(arr[i]);
					lst2.remove(arr[i]);				
				}				
			}		
	}
}
class Ass6moveall
{
	public static void main(String args[])
	{
		new myfrm();
	}
}