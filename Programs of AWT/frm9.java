import java.awt.*;
import java.awt.event.*;

class frm9 extends Frame implements ActionListener
{
	List l1,l2;
	Button b1,b2;
	
	frm9()
	{
		setTitle("List Box");
		setSize(500,400);
		setLocation(300,300);			
		setLayout(null);
		
		l1 = new List(15,true);
		l2 = new List(15,true);
		
		b1 = new Button(">>");
		b2= new Button("<<");
		
		add(l1);
		add(l2);
		add(b1);
		add(b2);
		
		l1.add("Windows 98");
		l1.add("windows 2000");
		l1.add("windows xp");
		l1.add("windows nt");
		
		l1.setBounds(50,50,150,200);
		l2.setBounds(260,50,150,200);
		
		b1.setBounds(210,70,40,40);
		b2.setBounds(210,125,40,40);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});            
			
			setVisible(true);
	}
	
    public void actionPerformed(ActionEvent e)
	{
        if(e.getSource()==b1)
        {
            int i;
            String s[] = l1.getSelectedItems();
            if(s.length != 0)
			{
				for(i=0;i<s.length;i++)
				{
					l2.add(s[i]);
					l1.remove(s[i]);
				}
			}
		}
		
        if(e.getSource()==b2)
		{
			int i;
			String s[] = l2.getSelectedItems();
			if(s.length != 0)
			{
				for(i=0;i<s.length;i++)
				{
					l1.add(s[i]);
					l2.remove(s[i]);
				}
			}
		}
		
	}
	
    public static void main(String args[])
	{
        new frm9();
	}
}
