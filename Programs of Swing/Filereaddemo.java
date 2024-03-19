import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class filrddemo extends JFrame implements ActionListener
{
	JButton b1;
	JTextField t1;
	JFileChooser jc;
	
	filrddemo()
	{
		setTitle("Demo of ToolBar");
		setSize(500,500);
		setLocation(150,150);
		setLayout(new FlowLayout());
		
		t1 = new JTextField(20);
		b1 = new JButton("Browse");
		jc = new JFileChooser();
		
		add(t1);
		add(b1);
		
		b1.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			jc.setCurrentDirectory(new File("."));
			jc.showOpenDialog(this);
			File f1 = jc.getSelectedFile();
			t1.setText(f1.getPath());
		}
	}
}
class Filereaddemo
{
	public static void main(String args[])
	{
		new filrddemo();
	}
}
