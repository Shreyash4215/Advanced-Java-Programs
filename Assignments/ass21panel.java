import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ass21panel extends JFrame implements ActionListener
{
	JButton b1,b2;
	JLabel l1,l2,lbl[];
	JTextField t1,t2,t[];
	JPanel p1;
	int x1=10,x2=140,y1=10,y2=15,cnt=0,sum=0,tot=0;
	Font f;
	
	ass21panel()
	{
		setTitle("List Box");
		setSize(1350,700);
		setLocation(10,30);			
		setLayout(null);
		f = new Font("Arial",Font.BOLD,15);
		
		b1 = new JButton("Submit");
		b2= new JButton("Calculate Average");
		p1 =new JPanel();
		l1 =new JLabel("Enter Roll No Range From");
		l2 =new JLabel("To");
		t1 =new JTextField("1");
		t2 =new JTextField("");
		t2.requestFocus();
		
		add(b1);		add(b2);		add(p1);		add(t1);
		add(t2);		add(l1);		add(l2);
							
		
		l1.setBounds(410,70,190,20);		t1.setBounds(610,69,35,25);
		l2.setBounds(655,70,30,20);			t2.setBounds(695,69,35,25);
		b1.setBounds(540,110,90,25);		p1.setBounds(15,150,1320,425);
		
		b1.addActionListener(this);		b2.addActionListener(this);
		
		p1.setLayout(null);	
		l1.setFont(f);		l2.setFont(f);		t1.setFont(f);
		t2.setFont(f);		b1.setFont(f);		b2.setFont(f);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
    public void actionPerformed(ActionEvent e)
	{
        if(e.getSource()==b1)
        {
			try
			{
				int a = Integer.parseInt(t1.getText());
				int b = Integer.parseInt(t2.getText());
				int c = (b-a)+1;
				
				t = new JTextField[c];
				lbl = new JLabel[c];
							 
				for(int i=0;i<c;i++)
				{
					lbl[i] = new JLabel("Roll No "+a+" Marks");
					t[i] = new JTextField();
					
					p1.add(lbl[i]);
					p1.add(t[i]);
					
					t[i].setFont(f);
					lbl[i].setFont(f);

					lbl[i].setBounds(x1,y1,120,30);
					t[i].setBounds(x2,y2,40,20);
									
					y1 = y1+40; 	y2 = y2+40;
					if(y1==410)
					{
						x1 = x2+55; 	x2 = x1+135;	y1=10;		y2=15;
					}
					a++;	cnt++; 		tot++;	
				}
				t1.setText(""+a);
				t2.setText("");
				b2.setBounds(550,590,200,25);
				setVisible(true);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Enter Range Of Student");
			}
		}
		else if(e.getSource()==b2)
        {
			try
			{
				int avg=0;
				
				for(int i=0;i<cnt;i++)
				{
					int mrk = Integer.parseInt(t[i].getText());
					sum = sum+mrk;	
				}
				avg = sum/tot;
				
				cnt=0;
			
				JOptionPane.showMessageDialog(null,"Average Of "+tot+" Student is "+avg);		
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Enter Students Marks To Calculate Average");
			}
		}
	}
	
    public static void main(String args[])
	{
        new ass21panel();
	}
}