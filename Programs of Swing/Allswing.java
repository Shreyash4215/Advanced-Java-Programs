import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class myfrm extends JFrame implements ActionListener,ItemListener,ListSelectionListener
{	
	JMenuBar mbr ;
	JMenu m1,m2,m3;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13;
	JLabel l1,l2;
	JPasswordField t2;
	JTextField t1;
	JButton b1,b2,b3,but[];
	JComboBox ch1;
	JCheckBox cb1,cb2;
	JList lst;	
	JTextArea ta;
	JPanel p1;
	String s_arr[]={"Apple","Banana","Cat","Dog"};
	JRadioButton rb1,rb2;
	ButtonGroup grp;
	Font f;
	JSeparator sep;
	
	int cnt=0;
	
	myfrm()
	{
		setTitle("All AWT Demo");
		setSize(800,700);
		setLocation(200,30);
		
		f=new Font("Arial",Font.BOLD,16);
		setLayout(null);
		
		mbr = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Colors");
		m3 = new JMenu("MessageDailogs");
		mi1 = new JMenuItem("New");
		mi2 = new JMenuItem("Open");
		mi3 = new JMenuItem("Save");
		mi4 = new JMenuItem("Red");
		mi5 = new JMenuItem("Green");
		mi6 = new JMenuItem("Blue");
		mi7 = new JMenuItem("Exit");
		mi8 = new JMenuItem("Simple Msg Box");
		mi9 = new JMenuItem("Warning Msg Box");
		mi10 = new JMenuItem("Error Msg Box");
		mi11 = new JMenuItem("Confirm Box");
		mi12 = new JMenuItem("Confirm Box 2");
		mi13 = new JMenuItem("Input Dailog");
		l1 = new JLabel("Enter Your Name ");
		l2 = new JLabel("Enter Password ");
		t1 = new JTextField("Welcome");
		b1 = new JButton("Click Me");
		
		cb1 = new JCheckBox("pen"); 
		cb2 = new JCheckBox("pencil",true);
		ch1 = new JComboBox();
		
		lst = new JList(s_arr);
		ta = new JTextArea();
		sep= new JSeparator();
		p1 = new JPanel();
		b2 = new JButton("Hide Panel");
		b3 = new JButton("Show Panel");
		but = new JButton[12];
		rb1 = new JRadioButton("Books",true);
		rb2 = new JRadioButton("Notebooks");
		grp = new ButtonGroup();
		t2 = new JPasswordField();
		
		m1.add(mi1);
		m1.add(mi2);
		m1.addSeparator();
		m1.add(mi7);
		mbr.add(m1);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
		mbr.add(m2);
		m3.add(mi8);
		m3.add(mi9);
		m3.add(mi10);
		m3.add(mi11);
		m3.add(mi12);
		m3.add(mi13);
		mbr.add(m3);
		setJMenuBar(mbr);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(ch1);
		add(cb1);
		add(cb2);
		add(rb1);
		add(rb2);
		//add(lst);
		add(ta);
		add(p1);
		add(b2);
		add(b3);
		grp.add(rb1);
		grp.add(rb2);
		
		p1.setLayout(new GridLayout(4,3,5,5));
		
		for(int i=0;i<12;i++)
		{
			but[i]=new JButton("Button "+(i+1));
			p1.add(but[i]);
		}
		
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;  //IMP
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp1 = new JScrollPane(lst,v1,h1);
		add(jsp1);
		
		JScrollPane jsp2 = new JScrollPane(ta,v1,h1);
		add(jsp2);
		
		ch1.addItem("Apple");
		ch1.addItem("Banana");
		ch1.addItem("Dog");
		ch1.addItem("Cat");

		t1.setFont(f);

		l1.setBounds(100,100,150,30);
		t1.setBounds(250,100,375,30);
		b1.setBounds(100,150,375,30);
		l2.setBounds(100,200,150,30);
		t2.setBounds(225,200,250,30);
		ch1.setBounds(500,150,125,30);
		cb1.setBounds(100,235,50,30);
		cb2.setBounds(222,235,70,30);
		rb1.setBounds(100,265,70,30);
		rb2.setBounds(222,265,90,30);
		jsp1.setBounds(500,195,125,200);	//IMP
		jsp2.setBounds(100,300,375,100);	//IMP
		p1.setBounds(100,420,375,170);
		b2.setBounds(500,420,125,80);
		b3.setBounds(500,510,125,80);
		
		p1.setBackground(Color.YELLOW);
		
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		mi10.addActionListener(this);
		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		ch1.addItemListener(this);
		lst.addListSelectionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		t1.setToolTipText("Result shown here");		
		b1.setToolTipText("This is a Button");		
		
		b1.setMnemonic('c');
		m1.setMnemonic('F');
		m2.setMnemonic('C');
		m3.setMnemonic('M');
		
		setVisible(true);		
	}	
	
	public void actionPerformed(ActionEvent e)
	{		
		if(e.getSource()==mi7)
			System.exit(0);
		if(e.getSource()==mi4)			
			p1.setBackground(Color.RED);	
		if(e.getSource()==mi5)						
			p1.setBackground(Color.GREEN);
		if(e.getSource()==mi6)						
			p1.setBackground(Color.BLUE);
			
		if(e.getSource()==b1)
		{
			cnt++;		
			t1.setText("Clicked="+cnt);
		}
		if(e.getSource()==b2)
			p1.setVisible(false);
		if(e.getSource()==b3)
			p1.setVisible(true);
		
		if(e.getSource()== mi8)
			JOptionPane.showMessageDialog(null,"This is Simple Msg Box");
		
		if(e.getSource()== mi9)
			JOptionPane.showMessageDialog(null,"Please Try Again !","Invalid Password !!!",JOptionPane.WARNING_MESSAGE);
		
		if(e.getSource()== mi10)
			JOptionPane.showMessageDialog(null,"Please Try Again !","Invalid Password !!!",JOptionPane.ERROR_MESSAGE);	
		
		if(e.getSource()== mi11)
		{
			int ans = JOptionPane.showConfirmDialog(null,"This is the Y/N/Cancel Msg Box");	
			if(ans==0)
				t1.setText("You clicked Yes Button");
			else if(ans==1)
				t1.setText("You clicked No Button");
			else
				t1.setText("You clicked Cancel Button");
		}
		if(e.getSource()== mi12)
		{
			int ans = JOptionPane.showConfirmDialog(null,"Message","Msg Box Title",JOptionPane.OK_CANCEL_OPTION);	
			if(ans==0)
				t1.setText("You clicked Ok Button");
			else
				t1.setText("You clicked Cancel Button");
		}
		if(e.getSource()== mi13)
		{
			String str = JOptionPane.showInputDialog(null,"Enter Some Text : ");	
			if(str != null)
				t1.setText("Your entered text : "+str);
			else
				t1.setText("You clicked Cancel Button");
		}
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==cb1)
			if(cb1.isSelected())
				t1.setText("Pen Checked");
			else
				t1.setText("Pen Unchecked");
		if(ie.getSource()==cb2)
			if(cb2.isSelected())
				t1.setText("Pencil Checked");
			else
				t1.setText("Pencil Unchecked");
			
		if(ie.getSource()==rb1 || ie.getSource()==rb2)
		{
			if(rb1.isSelected())
				t1.setText("Book Checked");
			else
				t1.setText("Note Book Checked");
		}	
		if(ie.getSource()==ch1)
			t1.setText(ch1.getSelectedItem() + " at Index " +ch1.getSelectedIndex());
	
		}
		
		public void valueChanged(ListSelectionEvent p)
		{
			t1.setText("Selected Item = "+lst.getSelectedValue());
		}		
}
class Allswing
{
	public static void main(String args[])
	{
		new myfrm();
	}
}