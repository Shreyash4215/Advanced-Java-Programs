import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class filrddemo extends JFrame implements ActionListener
{
	JButton b1;
	JTextField t1;
	JFileChooser jc;
	TextArea ta;
	
	filrddemo()
	{
		setTitle("Demo of ToolBar");
		setSize(600,400);
		setLocation(150,150);
		setLayout(null);
		
		t1 = new JTextField();
		ta = new TextArea();
		b1 = new JButton("Browse");
		jc = new JFileChooser();
		
		add(t1);
		add(ta);
		add(b1);
		
		t1.setBounds(50,50,200,20);
		b1.setBounds(260,50,100,20);
		ta.setBounds(50,80,500,200);
		
		b1.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
	
	public void actionPerformed(ActionEvent e)
	{
		jc.setCurrentDirectory(new File("."));
		jc.showOpenDialog(this);
		File f1 = jc.getSelectedFile();
		t1.setText(f1.getPath());
		
		try
		{
			//read file
			int i;
			String temp="";
			FileInputStream fin = new FileInputStream(f1.getPath());
			do
			{
				i = fin.read();
				
				if(i != -1)
					temp = temp+((char)i);
			}while(i != -1);
			fin.close();
			ta.setText(temp);
		}
		catch(Exception ex){}
	}
		
	}

class Filereaddemo2
{
	public static void main(String args[])
	{
		new filrddemo();
	}
}
