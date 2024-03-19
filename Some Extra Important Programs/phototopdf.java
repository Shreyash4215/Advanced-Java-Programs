import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.border.Border;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

class phototopdf extends JFrame implements ActionListener
{
	JButton b1;
	JTextField t1;
	JFileChooser jc;
	String filename,path=null;
	Connection cn;       Statement stm;
    ResultSet rs;        PreparedStatement prstm;
    String sql;		     	
	
	phototopdf()
	{
		setTitle("phototopdf of Insert PDF and Export PDF");
		setSize(500,500);
		setLocation(150,150);
		setLayout(null);
		
		t1 = new JTextField();		b1 = new JButton("Convert To PDF");		
		jc = new JFileChooser();		
		
		t1.setBounds(111,10,250,25);		b1.setBounds(111,50,120,25);
		
		add(t1);		add(b1);		
		
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
				rs = stm.executeQuery("select * from phototopdf");
				rs.next();
						 
				Blob b=rs.getBlob(2);  
				byte barr[]=b.getBytes(1,(int)b.length());  							  
				FileOutputStream fout=new FileOutputStream("photo.jpg");  
				fout.write(barr);  							  
				fout.close();  
				
				OutputStream file = new FileOutputStream(new File("test.pdf"));
				Document document = new Document();
				PdfWriter.getInstance(document, file);
				document.open();
				
				com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("photo.jpg");
				img.scalePercent(50);
				img.setAbsolutePosition(500, 725);
				document.add(img);				
				
				document.close();
				file.close();

				//To open the pdf file in linux & windows
				Desktop desktop = Desktop.getDesktop();
				desktop.open(new java.io.File("test.pdf"));
		
			} 
			catch (Exception ex) 
			{
				System.out.println(ex);  
			}					
	}
	public static void main(String args[])
	{
		new phototopdf();
	}
}