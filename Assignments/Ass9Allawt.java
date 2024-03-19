import java.awt.*;
import java.awt.event.*;

class myfrm extends Frame implements ActionListener,ItemListener
{	
	MenuBar mbr ;
	Menu m1,m2,m3;
	MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7;
	Label l1;
	TextField t1;
	Button b1,b2,b3,but[];
	Choice ch1;
	Checkbox cb1,cb2;
	Checkbox rb1,rb2;
	CheckboxGroup grp1;
	List lst;	
	TextArea ta;
	Panel p1;
	int cnt=0;
	
	myfrm()
	{
		setTitle("All AWT Demo");
		setSize(800,700);
		setLocation(200,30);
		
		setFont(new Font("Arial",Font.BOLD,16));
		setLayout(null);
		
		mbr = new MenuBar();
		m1 = new Menu("File");
		m2 = new Menu("Colors");
		m3 = new Menu("Exit");
		mi1 = new MenuItem("New");
		mi2 = new MenuItem("Open");
		mi3 = new MenuItem("Save");
		mi4 = new MenuItem("Red");
		mi5 = new MenuItem("Green");
		mi6 = new MenuItem("Blue");
		mi7 = new MenuItem("Exit");
		l1 = new Label("Enter Your Name ");
		t1 = new TextField("Welcome");
		b1 = new Button("Click Me");
		ch1 = new Choice();
		cb1 = new Checkbox("pen"); 
		cb2 = new Checkbox("pencil",true);
		grp1 = new CheckboxGroup();
		rb1 = new Checkbox("Books",true,grp1); 
		rb2 = new Checkbox("Notebooks",false,grp1);
		lst = new List(10,true);
		ta = new TextArea();
		p1 = new Panel();
		b2 = new Button("Hide Panel");
		b3 = new Button("Show Panel");
		but = new Button[12];
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		mbr.add(m1);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
		mbr.add(m2);
		m3.add(mi7);
		mbr.add(m3);
		setMenuBar(mbr);
		add(l1);
		add(t1);
		add(b1);
		add(ch1);
		ch1.add("Apple");
		ch1.add("Bat");
		ch1.add("Cat");
		ch1.add("Dog");
		add(cb1);
		add(cb2);
		add(rb1);
		add(rb2);
		add(lst);
		lst.add("Apple");
		lst.add("Bat");
		lst.add("Cat");
		lst.add("Dog");
		add(ta);
		add(p1);
		add(b2);
		add(b3);
		p1.setLayout(new GridLayout(4,3,5,5));
		for(int i=0;i<12;i++)
		{
			but[i]=new Button("Button "+(i+1));
			p1.add(but[i]);
		}

		l1.setBounds(100,100,150,30);
		t1.setBounds(250,100,375,30);
		b1.setBounds(100,150,375,30);
		ch1.setBounds(500,150,125,30);
		cb1.setBounds(100,200,50,30);
		cb2.setBounds(222,200,70,30);
		rb1.setBounds(100,250,70,30);
		rb2.setBounds(222,250,90,30);
		lst.setBounds(500,195,125,200);
		ta.setBounds(100,300,375,100);
		p1.setBounds(100,420,375,170);
		b2.setBounds(500,420,125,80);
		b3.setBounds(500,510,125,80);
		
		p1.setBackground(Color.YELLOW);
		
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		ch1.addItemListener(this);
		lst.addItemListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}	
		}
		);
		
		setVisible(true);		
	}	
	
	public void actionPerformed(ActionEvent e)
	{		
		if(e.getSource()==mi7)
			System.exit(0);
		if(e.getSource()==mi4)			
			setBackground(Color.RED);	
		if(e.getSource()==mi5)						
			setBackground(Color.GREEN);
		if(e.getSource()==mi6)						
			setBackground(Color.BLUE);
			
		if(e.getSource()==b1)
		{
			cnt++;		
			t1.setText("Clicked="+cnt);
		}
		if(e.getSource()==b2)
			p1.setVisible(false);
		if(e.getSource()==b3)
			p1.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==cb1)
			if(cb1.getState())
				t1.setText("Pen Checked");
			else
				t1.setText("Pen Unchecked");
		if(ie.getSource()==cb2)
			if(cb2.getState())
				t1.setText("Pencil Checked");
			else
				t1.setText("Pencil Unchecked");
			
		if(ie.getSource()==rb1)
			if(rb1.getState())
				t1.setText("Book Checked");
		if(ie.getSource()==rb2)
			if(rb2.getState())
				t1.setText("Note Book Checked");
			
		if(ie.getSource()==ch1)
			t1.setText(ch1.getSelectedItem() + " at Index " +ch1.getSelectedIndex());
			
		if(ie.getSource()==lst)
		{
			String arr[] = lst.getSelectedItems();
			String temp="";				
			for(int i=0;i<arr.length;i++)
				temp = temp+arr[i]+",";
				
			t1.setText(temp);
		}		
	}		
}
class Ass9Allawt
{
	public static void main(String args[])
	{
		new myfrm();
	}
}