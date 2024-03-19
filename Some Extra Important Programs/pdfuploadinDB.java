import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.border.Border;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

class pdfuploadinDB extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	JTextField t1;
	JFileChooser jc;
	String filename,path=null;
	Connection cn;       Statement stm;
    ResultSet rs;        PreparedStatement prstm;
    String sql;		     	
	
	pdfuploadinDB()
	{
		setTitle("pdfuploadinDB of Insert PDF and Export PDF");
		setSize(500,500);
		setLocation(150,150);
		setLayout(null);
		
		t1 = new JTextField();		b1 = new JButton("Insert PDF");
		b2 = new JButton("Retrive PDF");		
		jc = new JFileChooser();		
		
		t1.setBounds(111,10,250,25);		b1.setBounds(111,50,120,25);
		b2.setBounds(240,50,120,25);	
		
		add(t1);		add(b1);		add(b2);
		
		b1.addActionListener(this);		b2.addActionListener(this);
		
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
		if(e.getSource()==b1)
		{
			try
			{			
				jc.setCurrentDirectory(new File("."));
				jc.showOpenDialog(this);
				
				File f1 = jc.getSelectedFile();   
				path = f1.getAbsolutePath();								
				path = path.replace('\\','/');
				
				sql="INSERT INTO pdfuploadinDB(id,img) VALUES(1,LOAD_FILE('"+path+"'))";	
				prstm = cn.prepareStatement(sql);
				prstm.execute();	prstm.close();
					
				t1.setText(f1.getPath());
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==b2)
		{
			try
			{
				rs = stm.executeQuery("select * from pdfuploadinDB");
				rs.next();
						 
				byte[] imagedata=rs.getBytes(2);
				
				OutputStream file = new FileOutputStream(new File(path));

				PdfReader reader = new PdfReader(imagedata);
				int n = reader.getNumberOfPages();
				Document document = new Document();
				PdfCopy copy = new PdfCopy(document, file);
				document.open();
				for(int i=1;i<=n;i++)
					copy.addPage(copy.getImportedPage(reader, i));
				document.close();
				file.close();      

				//To open the pdf file in linux & windows
				Desktop desktop = Desktop.getDesktop();
				desktop.open(new java.io.File(path));
		
			} 
			catch (Exception ex) 
			{
				System.out.println(ex);  
			}		
		}			
	}
	public static void main(String args[])
	{
		new pdfuploadinDB();
	}
}