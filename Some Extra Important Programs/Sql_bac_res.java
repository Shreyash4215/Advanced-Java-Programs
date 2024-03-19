import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

class Sql_bac_res extends JFrame implements ActionListener
{
	JButton b1,b2,b3;
	JTextField t1;
	JFileChooser jc;
	String filename,path=null;
	
	Sql_bac_res()
	{
		setTitle("Demo of SQL Backup");
		setSize(500,500);
		setLocation(150,150);
		setLayout(new FlowLayout());
		
		t1 = new JTextField(15);		b1 = new JButton("Browse");
		b2 = new JButton("Backup");		b3 = new JButton("Restore");
		jc = new JFileChooser();
		
		add(t1);		add(b1);		add(b2);		add(b3);
		
		b1.addActionListener(this);		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
	}	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			jc.setCurrentDirectory(new File("."));
			jc.showOpenDialog(this);
			
			File f1 = jc.getSelectedFile();    //Path Conversion
			path = f1.getAbsolutePath();
			path = path.replace('\\','/');		//Symbol Replacing Process
			t1.setText(f1.getPath());			//set path to textfield
		}
		else if(e.getSource()==b2)
		{
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			path = path + "_" + date +".sql";		//creating file name with extension
					
			Process p = null;
            try 
			{
                Runtime runtime = Runtime.getRuntime();		//Inbuild method
                
				//providing path of mysqldump.exe file to for processing uroot(u is inbuild root is sql username),p1((p is inbuild 1 is sql password),(B is inbuild sad is sql database bane))
				p = runtime.exec("C:/Program Files (x86)/MySQL/MySQL Server 6.0/bin/mysqldump.exe -uroot -p1 --add-drop-database -B sad -r " +path);

                int processComplete = p.waitFor();
 
                if (processComplete == 0)
                    System.out.println("Backup created successfully!"); 
				else 
                    System.out.println("Could not create the backup");
          
			 }
			 catch (Exception ex)
			 {    ex.printStackTrace();   }	
		}			
		else if(e.getSource()==b3)
		{			
				//Making array of path of mysql.exe file for processing 
				
			String[] restoreCmd = new String[]{"C:/Program Files (x86)/MySQL/MySQL Server 6.0/bin/mysql ", "--user=root", "--password=1", "-e", "source " + path};
 
			Process runtimeProcess;
			try 
			{	 
				runtimeProcess = Runtime.getRuntime().exec(restoreCmd); 
				int processComplete = runtimeProcess.waitFor();
	 
				if (processComplete == 0)
					System.out.println("Restored successfully!"); 
				else 
					System.out.println("Could not restore the backup!");
			} 
			catch (Exception ex)
			{	ex.printStackTrace();	}
		}
	}
	public static void main(String args[])
	{
		new Sql_bac_res();
	}
}