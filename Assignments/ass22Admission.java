import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ass22Admission extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox cb;
	JPanel p1;
	Font f;
	
	ass22Admission()
	{
		setTitle("Admission System");
		setSize(531,400);
		setLocation(250,150);			
		setLayout(null);
		f = new Font("Arial",Font.BOLD,15);
		
		b1 = new JButton("Total");				b2= new JButton("Clear");
		b3= new JButton("Exit");				b4= new JButton("Submit");
		p1 =new JPanel();						l1 =new JLabel("Marks of Sub 1");
		l2 =new JLabel("Marks of Sub 2");		l3 =new JLabel("Marks of Sub 3");
		l4 =new JLabel("Total Marks");			l5 =new JLabel("Percentage");
		l6 =new JLabel("CET Marks");			l7 =new JLabel("out of 200");
		l8 =new JLabel("Select Cast");			cb =new JComboBox();
		t1 =new JTextField();					t2 =new JTextField();
		t3 =new JTextField();					t4 =new JTextField();
		t5 =new JTextField();					t6 =new JTextField();
				
		add(b1);		add(b2);		add(b3);		add(p1);		add(t1);
		add(t2);		add(t3);		add(t4);		add(t5);		add(l1);
		add(l2);		add(l3);		add(l4);		add(l5);		p1.add(l6);
		p1.add(l7);		p1.add(l8);		p1.add(t6);		p1.add(cb);		p1.add(b4);

		t4.setEnabled(false);			t5.setEnabled(false);	
		
		l1.setBounds(50,50,150,20);		t1.setBounds(200,47,120,25);
		l2.setBounds(50,85,150,20);		t2.setBounds(200,82,120,25);
		l3.setBounds(50,120,150,20);	t3.setBounds(200,117,120,25);
		l4.setBounds(50,155,150,20);	t4.setBounds(200,152,120,25);
		l5.setBounds(50,190,150,20);	t5.setBounds(200,187,120,25);
		b1.setBounds(350,47,130,47);	b2.setBounds(350,105,130,47);
		b3.setBounds(350,164,130,47);	p1.setBounds(50,250,430,90);
		l6.setBounds(0,0,150,30);		t6.setBounds(150,0,120,25);	
		l7.setBounds(305,0,120,25);		l8.setBounds(0,40,150,25);	
		cb.setBounds(150,40,120,25);	b4.setBounds(305,40,125,25);	
				
		p1.setLayout(null);				p1.setVisible(false);
		
		b1.addActionListener(this);		b2.addActionListener(this);
		b3.addActionListener(this);		b4.addActionListener(this);
		cb.addActionListener(this);
		
		b1.setMnemonic('T');			b2.setMnemonic('C');
		b3.setMnemonic('E');			b4.setMnemonic('u');
		
		cb.addItem("<Select>");			cb.addItem("OBC");	
		cb.addItem("ST");				cb.addItem("SC");	
		cb.addItem("NT");				cb.addItem("Open");	
	
		Validate(t1);		Validate(t2);		Validate(t3);		Validate(t6);		
	
		l1.setFont(f);		l2.setFont(f);		l3.setFont(f);		l4.setFont(f);		
		l5.setFont(f);		l6.setFont(f);		l7.setFont(f);		l8.setFont(f);
		b1.setFont(f);		b2.setFont(f);		b3.setFont(f);		b4.setFont(f);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
	void Validate(final JTextField tt)
	{
				
		tt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(tt.getText().length()<3 && e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
					super.keyTyped(e);	//Optional
				else
				{
					e.consume();
					
					Toolkit tk = Toolkit.getDefaultToolkit();
					tk.beep();
				}					
			}
		});		
	}
	
    public void actionPerformed(ActionEvent e)
	{
		try
		{
			int a,b,c,sum=0,avg=0,d;
			
			if(e.getSource()==b1)
			{
				if(t1.getText().length() == 0)			t1.requestFocus();
				else if(t2.getText().length() == 0)		t2.requestFocus();
				else									t3.requestFocus();
				
				a = Integer.parseInt(t1.getText());
				b = Integer.parseInt(t3.getText());
				c = Integer.parseInt(t2.getText());

				if(a>100 || b>100 || c>100)
					JOptionPane.showMessageDialog(null,"Marks Must Be Between 0 to 100 !","Invalid Marks !!!",JOptionPane.WARNING_MESSAGE);
				else	
				{
					sum = a+b+c;
					avg = sum/3;
					
					t4.setText(""+sum);
					t5.setText(""+avg+"%");
				
					if(avg >=35 )
					{
						p1.setVisible(true);
						JOptionPane.showMessageDialog(null,"You are Eligible For CET Exam !!!");
					}
					else
						JOptionPane.showMessageDialog(null,"You are FAIL Board Exam !!!","FAIL",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(e.getSource()==b2)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				cb.setSelectedIndex(0);
				p1.setVisible(false);			
			}
			else if(e.getSource()==b3)
			{
				System.exit(0);
			}
			else if(e.getSource()==b4)
			{
				d = Integer.parseInt(t6.getText());
				
				if(d>200)
					JOptionPane.showMessageDialog(null,"Marks Must Be Between 0 to 200 !","Invalid Marks !!!",JOptionPane.WARNING_MESSAGE);
				else
					if((cb.getSelectedIndex()==0))	
						JOptionPane.showMessageDialog(null,"All Field Are Necessary");
					else					
						if((d >= 170 && (cb.getSelectedIndex()==1)) || (d >= 150 && (cb.getSelectedIndex()==2)) || (d >= 160 && (cb.getSelectedIndex()==3)) || (d >= 180 && (cb.getSelectedIndex()==4)) || (d >= 190 && (cb.getSelectedIndex()==5))) 		
						JOptionPane.showMessageDialog(null,"You are Eligible For Admission !!!");
						else
							JOptionPane.showMessageDialog(null,"You are FAIL CET Exam !!!","FAIL",JOptionPane.ERROR_MESSAGE);					
			}		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"All Field Are Necessary");
		}
	}	
    public static void main(String args[])
	{
        new ass22Admission();
	}
}