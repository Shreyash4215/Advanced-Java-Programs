import java.awt.*;
import java.awt.event.*;

class frm_combo extends Frame implements ItemListener
{
	// 1) Declaration
	TextField t1;
	Choice ch;
	
	frm_combo()
	{
		super("WindowAdapter Demo");
		setLocation(250,150);
		setSize(500,500);
		
		setLayout(new FlowLayout());	// IMP
		
		// 2) Memory Allocation
		t1 = new TextField("Demo of Choice");
		ch = new Choice();
		
		// 3) Add Controls on Frame
		add(ch);
		add(t1);
		
		ch.add("Apple");
		ch.add("Banana");
		ch.add("Cat");
		ch.add("Dog");
		ch.add("Frog");
						
		// 5) Add Listener on Controls
		ch.addItemListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setVisible(true);
	}	
	
	public void itemStateChanged(ItemEvent e)
	{
		t1.setText(ch.getSelectedItem() + " at Index = " + ch.getSelectedIndex());
	}
		
	public static void main(String args[])
	{
		new frm_combo();
	}
}
