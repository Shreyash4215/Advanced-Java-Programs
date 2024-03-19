import java.awt.*;
import java.awt.event.*;

class frm10 extends Frame implements ActionListener
{
	MenuBar mbr;
	Menu file,edit,help;
	MenuItem open1,close,copy,paste,about,exit1;
	
	frm10(String title)
	{
		super(title);
		
		mbr = new MenuBar();
		
		file = new Menu("File");
		edit = new Menu("Edit");
		help = new Menu("Help");
		
		exit1 = new MenuItem("Exit");
		about = new MenuItem("About");
		paste = new MenuItem("Paste");
		open1 = new MenuItem("Open");
		close = new MenuItem("Close");
		copy  = new MenuItem("Copy");
		
		exit1.addActionListener(this);
		
		setSize(400,400);
		
		addWindowListener(new WindowAdapter()
			{
                public void windowClosing(WindowEvent e)
                {
					System.exit(0);
				}  
			});
			
			file.add(open1);
            file.add(close );
            file.add(new MenuItem("-"));
            file.add(exit1);
			
            mbr.add(file );
			
            edit.add(copy );
            edit.add(paste );
			
            mbr.add(edit);
			
            help.add(about);
            mbr.add(help);
			
            setMenuBar(mbr);
			
            setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
        System.exit(0);
	}
	
	public static void main(String args[])
	{
        new frm10("Menu frame");
	}
}