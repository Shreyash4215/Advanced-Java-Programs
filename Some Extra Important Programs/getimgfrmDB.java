import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

class getimgfrmDB extends JFrame implements ActionListener
{
	JButton b1,b2;
	Connection cn;       Statement stm;
    ResultSet rs;
	JLabel l1;
	ImageIcon format=null;	
	
	demmo()
	{
		super("Getting Image From Database");
		setLocation(250,150);
		setSize(500,500);		
		setLayout(null);
		
		b1 = new JButton("Click Me");
		
		add(b1);
		
		b1.setBounds(150,30,150,25);
		
		b1.addActionListener(this);
		try
		{
		    cn = DriverManager.getConnection("jdbc:mysql:///ims","root", "1");
            stm = cn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			rs = stm.executeQuery("select * from demo");
			rs.next();
                     
			byte[] imagedata=rs.getBytes(2);
			format=new ImageIcon(imagedata);
			l1= new JLabel(format);
			add(l1);
			l1.setBounds(150,70,150,150);
        } 
		catch (Exception ex) 
		{
         System.out.println(ex);  
        }	
	}	
	public static void main(String args[])
	{
		new demmo();
	}
}