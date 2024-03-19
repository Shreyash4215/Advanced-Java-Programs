import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

class myfrm extends JFrame implements ActionListener,ItemListener
{	
	JMenuBar mbr ;
	JMenu m1,m2,m3,mi10;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9;
	JRadioButtonMenuItem jr1,jr2;
	ButtonGroup grp;
	TextArea ta;
	Random r;
	int a[];
	String data;
	Double avg;
	FileOutputStream out;
	PrintStream p;
	
	myfrm()
	{
		setTitle("Menubar Demo");
		setSize(800,500);
		setLocation(200,200);
		
		setLayout(null);
		
		a = new int[50];
		r = new Random();
		mbr = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Compute");
		m3 = new JMenu("Operations");
		mi1 = new JMenuItem("Load");
		mi2 = new JMenuItem("Save");
		mi3 = new JMenuItem("Exit");
		mi4 = new JMenuItem("Sum");
		mi5 = new JMenuItem("Average");
		mi6 = new JMenuItem("Maximum");
		mi7 = new JMenuItem("Minimum");
		mi8 = new JMenuItem("Median");
		mi9 = new JMenuItem("Search");
		mi10 = new JMenu("Sort");
		jr1 = new JRadioButtonMenuItem("Ascending");
		jr2 = new JRadioButtonMenuItem("Descending");
		grp = new ButtonGroup();
		ta = new TextArea();
			
		ta.setFont(new Font("Arial",Font.BOLD,25));
			
		grp.add(jr1);
		grp.add(jr2);
		m1.add(mi1);
		m1.add(mi2);
		m1.addSeparator();
		m1.add(mi3);
		mbr.add(m1);
		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
		m2.add(mi7);
		m2.add(mi8);		
		mbr.add(m2);
		m3.add(mi9);
		m3.addSeparator();
		mi10.add(jr1);
		mi10.add(jr2);
		m3.add(mi10);
		mbr.add(m3);
		setJMenuBar(mbr);
		add(ta);
		
		ta.setBounds(0,0,780,430);

		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		jr1.addItemListener(this);
		jr2.addItemListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}		
	public void actionPerformed(ActionEvent e)
	{	
		int cnt=0,temp;
		Double sum=0.0,m;
		
		if(e.getSource()==mi1)
		{
			data="50 Random Numbers Are : ";			
			for(int i=0;i<=49;i++)
			{
				int n = r.nextInt(99);
				
				if(n>10)
				{
					a[i]=n;
					
					if(i == cnt)
					{
						cnt=cnt+10;
						data=data+"\n";
					}
					data=data+Integer.toString(n)+" ";				
					ta.setText(data);
				}
				else
					i--;
			}			
		}		
		for(int i=0;i<=49;i++)
				sum=sum+a[i];
		
		if(e.getSource()==mi2) 
		{
			try
			{
				out = new FileOutputStream("Number.txt");
				p = new PrintStream(out);	
				
				p.print("50 Random Numbers Are : ");
				for(int i=0;i<=49;i++)
				{								
					if(i == cnt)
					{
						cnt=cnt+10;
						p.println("");
					}
					p.print(Integer.toString(a[i])+" ");				
				}
				JOptionPane.showMessageDialog(null,"File Saved Succefully!!!");
			}catch(Exception ex){}
		}
		if(e.getSource()==mi3)
			System.exit(0);
		
		if(e.getSource()==mi4)						
			JOptionPane.showMessageDialog(null,"Sum = "+sum);
		
		if(e.getSource()==mi5)
		{
			avg=sum/50;
			JOptionPane.showMessageDialog(null,"Average = "+avg);
		}
		if(e.getSource()==mi6)
		{			
			temp=a[1];
			for(int i=0;i<=49;i++)
			{
				if(temp<a[i])
					temp=a[i];
			}
			JOptionPane.showMessageDialog(null,"Maximum = "+temp);
		}
		if(e.getSource()==mi7)
		{			
			temp=a[1];
			for(int i=0;i<=49;i++)
			{
				if(temp>a[i])
					temp=a[i];
			}
			JOptionPane.showMessageDialog(null,"Minimum = "+temp);
		}
		if(e.getSource()==mi8)
		{	
			data="Sorted 50 Random Numbers For Calculate Madian : ";
			for(int i=0;i<50;i++)
			 {
			  for(int j=i+1;j<50;j++)
			  {
			   if(a[i]>a[j])
			   {
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			   }
			  }
			 }
			for(int i=0;i<=49;i++)
			{					
				if(i == cnt)
				{
					cnt=cnt+10;
					data=data+"\n";
				}
					data=data+Integer.toString(a[i])+" ";				
					ta.setText(data);
			}		
				m=(a[(50-1)/2]+a[50/2])/2.0;
				
			JOptionPane.showMessageDialog(null,"Median = "+m);
		}
		if(e.getSource()==mi9)
		{
			int flag=0;
			
			int sr =Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Number To Search : "));
			
			for(int i=0;i<=49;i++)
			{					
				if(sr==a[i])
				{
					flag=1;
				}
			}
			if(flag==1)
				JOptionPane.showMessageDialog(null,"Number Fournd ");
			else
				JOptionPane.showMessageDialog(null,"Number Not Fournd ");	
		}	
	}
	public void itemStateChanged(ItemEvent ie)
	{
		int cnt=0,temp;		
			if(jr1.isSelected())
			{
				data="50 Random Numbers Are In Ascending Order : ";
				for(int i=0;i<50;i++)
				 {
				  for(int j=i+1;j<50;j++)
				  {
				   if(a[i]>a[j])
				   {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				   }
				  }
				 }				
			}	
			else
			{
				data="50 Random Numbers Are In Descending Order : ";
				for(int i=0;i<50;i++)
				 {
				  for(int j=i+1;j<50;j++)
				  {
				   if(a[i]<a[j])
				   {
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				   }
				}					
			}
			for(int i=0;i<=49;i++)
			{					
				if(i == cnt)
				{
					cnt=cnt+10;
					data=data+"\n";
				}
			  data=data+Integer.toString(a[i])+" ";				
			  ta.setText(data);
			}	
	}
}
class Practical4FileOpp 
{
	public static void main(String args[])
	{
		new myfrm();
	}
}