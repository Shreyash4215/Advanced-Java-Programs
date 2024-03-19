import javax.swing.*;
import java.awt.*;

class JF_Tab extends JFrame
{
	JTabbedPane jtp;
	
	JF_Tab()
	{
		super("My Tabbed Pane");
		setSize(380,110);
		setLocation(250,150);
		setLayout(new FlowLayout());
		
		jtp = new JTabbedPane();
		
		jtp.addTab("Cities", new CitiesPanel()); 
		jtp.addTab("Colors", new ColorsPanel()); 
		jtp.addTab("Flavors", new FlavorsPanel());
		
		add(jtp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String args[])
	{
		new JF_Tab();
	}
} 

class CitiesPanel extends JPanel
{
	CitiesPanel()
	{
		add(new JButton("New York")); 
		add(new JButton("London")); 
		add(new JButton("Hong Kong")); 
		add(new JButton("Tokyo")); 
	} 
} 

class ColorsPanel extends JPanel
{
	ColorsPanel()
	{
		JCheckBox cb1 = new JCheckBox("Red"); 
		add(cb1); 
		JCheckBox cb2 = new JCheckBox("Green"); 
		add(cb2); 
		JCheckBox cb3 = new JCheckBox("Blue"); 
		add(cb3); 
	} 
	
} 

class FlavorsPanel extends JPanel
{
	FlavorsPanel()
	{
		JComboBox jcb = new JComboBox(); 
		jcb.addItem("Vanilla"); 
		jcb.addItem("Chocolate"); 
		jcb.addItem("Strawberry"); 
		add(jcb); 
	} 
}   
