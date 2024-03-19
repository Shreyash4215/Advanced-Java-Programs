import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ActionListener
{	
	List lst1,lst2;
	Button b1,b2,b3,b4,b5,b6,b7,b8;
	Label l1,l2;
	TextField t1,t2;
	
	myfrm()
	{
		setTitle("Move Operation");
		setSize(600,500);
		setLocation(170,150);
		
		setFont(new Font("Arial",Font.BOLD,15));
		setLayout(null);
		
		lst1 = new List(5,true);
		lst2 = new List(5,true);
		b1 = new Button(">");
		b2 = new Button("<");
		b3 = new Button(">>");
		b4 = new Button("<<");		
		b5 = new Button("ADD");		
		b6 = new Button("REMOVE");		
		b7 = new Button("ADD");		
		b8 = new Button("REMOVE");		
		l1 = new Label("List 1");
		l2 = new Label("List 2");		
		t1 = new TextField();		
		t2 = new TextField();		
		
		add(lst1);
		add(lst2);
		add(b1);
		add(b2);
		add(b3);
		add(b4);		
		add(b5);		
		add(b6);		
		add(b7);		
		add(b8);		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		
		lst1.add("a");
		lst1.add("b");
		lst1.add("c");
		lst1.add("d");
		lst1.add("e");	
	
		lst2.add("a");
		lst2.add("b");
		lst2.add("c");
		
		lst1.setBounds(100,100,171,250);		
		lst2.setBounds(340,100,171,250);		
		t1.setBounds(100,370,171,25);		
		t2.setBounds(340,370,171,25);		
		b1.setBounds(285,115,40,40);		
		b2.setBounds(285,170,40,40);		
		b3.setBounds(285,225,40,40);		
		b4.setBounds(285,285,40,40);		
		b5.setBounds(100,410,80,25);		
		b6.setBounds(190,410,80,25);		
		b7.setBounds(340,410,80,25);		
		b8.setBounds(430,410,80,25);		
		l1.setBounds(150,50,50,50);		
		l2.setBounds(400,50,50,50);		
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		
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
		int flag=0;
		
		if(ae.getSource()==b1)
			{								
				String arr[] = lst1.getSelectedItems();
				String arr1[] = lst2.getItems();
				
				for(int i=0;i<arr.length;i++)
				{
					for(int j=0;j<arr1.length;j++)
						if(arr[i].equals(arr1[j]))
							flag=1;

					if(flag==0)
						lst2.add(arr[i]);
					lst1.remove(arr[i]);				
				}				
			}
		else if(ae.getSource()==b2)
			{								
				String arr[] = lst2.getSelectedItems();
				String arr1[] = lst1.getItems();
			
				for(int i=0;i<arr.length;i++)
				{
					for(int j=0;j<arr1.length;j++)
						if(arr[i].equals(arr1[j]))
							flag=1;

					if(flag==0)
						lst1.add(arr[i]);
					lst2.remove(arr[i]);				
				}				
			}
		else if(ae.getSource()==b3)
			{								
				String arr[] = lst1.getItems();
				String arr1[] = lst2.getItems();
				
				for(int i=0;i<arr.length;i++)
				{
					for(int j=0;j<arr1.length;j++)	
						if(arr[i].equals(arr1[j]))
							flag=1;

						if(flag==0)
							lst2.add(arr[i]);
						lst1.remove(arr[i]);
						
						flag=0;	
				}				
			}
		else if(ae.getSource()==b4)
			{								
				String arr[] = lst2.getItems();
				String arr1[] = lst1.getItems();
				
				for(int i=0;i<arr.length;i++)
				{
					for(int j=0;j<arr1.length;j++)
						if(arr[i].equals(arr1[j]))
							flag=1;

					if(flag==0)						
						lst1.add(arr[i]);
					lst2.remove(arr[i]);
					flag=0;	
				}				
			}
		else if(ae.getSource()==b5)
			{								
				String arr[] = lst1.getItems();
				for(int i=0;i<arr.length;i++)
					if(arr[i].equals(t1.getText()))
							flag=1;

				if(flag==0 && ("".equals(t1.getText())==false))
					lst1.add(t1.getText());
				t1.setText("");
			}
		else if(ae.getSource()==b6)
			{	
				String arr[] = lst1.getSelectedItems();
				
				for(int i=0;i<arr.length;i++)
				{	
					lst1.remove(arr[i]);
					flag=1;
				}
				if(flag==0)
					lst1.remove(t1.getText());				
					
				t1.setText("");
			}
		else if(ae.getSource()==b7)
			{								
				String arr[] = lst2.getItems();
				for(int i=0;i<arr.length;i++)
					if(arr[i].equals(t2.getText()))
							flag=1;

				if(flag==0 && ("".equals(t2.getText())==false))
					lst2.add(t2.getText());
				t2.setText("");
			}
		else if(ae.getSource()==b8)
			{	
				String arr[] = lst2.getSelectedItems();
				
				for(int i=0;i<arr.length;i++)
				{	
					lst2.remove(arr[i]);
					flag=1;
				}
				if(flag==0)
					lst2.remove(t2.getText());				
				t2.setText("");
			}		
	}
}
class Ass20strwthdupli
{
	public static void main(String args[])
	{
		new myfrm();
	}
}