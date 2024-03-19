import java.awt.*;
import javax.imageio.ImageIO;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;

class assphoto extends JFrame implements ActionListener
{
	JTextField t1;
	JButton b1,b2;
	JFileChooser jc;
	JLabel l1;
	String path;			int photoid=0;
	Connection cn;		    Statement stm;
    ResultSet rs;    		PreparedStatement prstm;
	File f1;
	BufferedImage image;
	
    assphoto()
    {
		super("File Path");
		setSize(500,400);
		setLocation(150,150);
		setLayout(null);
		
		t1 = new JTextField();
		b1 = new JButton("Browse");
		b2 = new JButton("Upload");
		jc = new JFileChooser();
		l1= new JLabel();
		
		t1.setBounds(50,10,250,25);
		b1.setBounds(313,10,120,25);
		l1.setBounds(150,50,150,150);
		b2.setBounds(165,212,120,25);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		l1.setBorder(blackline);
		
		add(t1);
		add(b1);
		add(b2);
		add(l1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		try
		{
		    cn = DriverManager.getConnection("jdbc:mysql:///sad","root", "1");
			stm = cn.createStatement();
			rs = stm.executeQuery("select * from photo");
			rs.last();
			photoid=Integer.parseInt(rs.getString(1));	
		}
		catch(Exception e)
		{		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	    
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{		
					jc.setCurrentDirectory(new File("."));
					jc.showOpenDialog(this);
					f1 = jc.getSelectedFile();
						
					t1.setText(f1.getPath());
					
					image = ImageIO.read(f1);
					Image tmp = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
					BufferedImage resized = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
					Graphics2D g2d = resized.createGraphics();
					g2d.drawImage(tmp, 0, 0, null);
					g2d.dispose();
					
					l1.setIcon(new ImageIcon(resized));
			}
			if(e.getSource()==b2)
			{	
				photoid=photoid+1;
				
				path="F:/Photo/"+(photoid)+".jpg";	
				File output = new File(path);
				ImageIO.write(image, "jpg", output);	
				
				prstm = cn.prepareStatement("INSERT INTO photo(photo) VALUES('"+path+"')");
				prstm.execute();	prstm.close();	
				JOptionPane.showMessageDialog(null,"Image Upload Successfully !!!");
				image=null;
				l1.setIcon(new ImageIcon());
			}
		}
		catch(java.lang.IllegalArgumentException il)
		{
				photoid=photoid-1;
				JOptionPane.showMessageDialog(null,"Please Select Image !!!");
		}			
		catch(Exception ex)
		{
			System.out.println(ex);
		}			
	}
	
	public static void main(String args[])
	{
		new assphoto();
	}
}
/*
create table photo
(
id integer primary key AUTO_INCREMENT,
photo varchar(100)
);*/