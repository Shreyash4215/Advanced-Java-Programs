import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ActionListener
{	
	List lst1,lst2;
	Button b1,b2;
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
		b1 = new Button(">>");
		b2 = new Button("<<");		
		l1 = new Label("List 1");
		l2 = new Label("List 2");		
		
		add(lst1);
		add(lst2);
		add(b1);
		add(b2);
		add(l1);
		add(l2);
		
		lst1.add("Apple");
		lst1.add("Bat");
		lst1.add("Cat");
		lst1.add("Dog");
		
		lst1.setBounds(100,100,100,200);		
		lst2.setBounds(300,100,100,200);		
		b1.setBounds(222,150,50,50);		
		b2.setBounds(222,210,50,50);		
		l1.setBounds(125,50,50,50);		
		l2.setBounds(325,50,50,50);		
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		
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
	}
}
class Ass5move
{
	public static void main(String args[])
	{
		new myfrm();
	}
}