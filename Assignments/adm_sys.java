import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class adm_sys extends JFrame implements ActionListener
{
    JPanel pp;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t6,ltot,lavg;
    JComboBox cb1;
    JButton b1,b2,b3,b4;
    int tot,avg;
	
    adm_sys()
    {
        super("Admission System");
        setSize(400,320);
        setLocation(250,300);
        setLayout(null);
		
        l1 = new JLabel("Marks of Sub. 1");
        l2 = new JLabel("Marks of Sub. 2");
        l3 = new JLabel("Marks of Sub. 3");
        l4 = new JLabel("Total Marks ");
        l5 = new JLabel("Percentage");
		
        t1 = new JTextField();      
		t2 = new JTextField();  
		t3 = new JTextField();
        ltot = new JTextField();    
		lavg = new JTextField();
        ltot.setEditable(false);    
		lavg.setEditable(false);
		
        b1 = new JButton("Total");
        b2 = new JButton("Clear");
        b3 = new JButton("Exit");
		
        add(l1);    add(l2);    add(l3);    add(l4);    add(l5);
        add(t1);    add(t2);    add(t3);    add(ltot);    add(lavg);
        add(b1);    add(b2);    add(b3);
		
        l1.setBounds(30,30,100,20);        t1.setBounds(140,30,100,20);
        l2.setBounds(30,60,100,20);        t2.setBounds(140,60,100,20);
        l3.setBounds(30,90,100,20);        t3.setBounds(140,90,100,20);
        l4.setBounds(30,120,100,20);       ltot.setBounds(140,120,100,20);
        l5.setBounds(30,150,100,20);       lavg.setBounds(140,150,100,20);
        b1.setBounds(260,30,100,40);       b2.setBounds(260,80,100,40);
        b3.setBounds(260,130,100,40);
		
        pp = new JPanel();
        pp.setLayout(null);
        pp.setVisible(false);
		
        l6 = new JLabel("CET Marks");
        l7 = new JLabel("out of 200");
        l8 = new JLabel("Select Cast");
		
        t6 = new JTextField();
        cb1 = new JComboBox();
        cb1.addItem("<Select>");
        cb1.addItem("OBC");        cb1.addItem("SC");
        cb1.addItem("NT");         cb1.addItem("Open");
        b4 = new JButton("Submit");
		
        pp.add(l6);     pp.add(l7);     pp.add(l8);
        pp.add(t6);     pp.add(cb1);    pp.add(b4);
        add(pp);
		
        pp.setBounds(30,180,330,100);
		
        l6.setBounds(0,20,100,20);        t6.setBounds(110,20,100,20);
        l7.setBounds(230,20,100,20);      l8.setBounds(0,50,100,20);
        cb1.setBounds(110,50,100,20);     b4.setBounds(230,50,100,20);
		
        b1.addActionListener(this);        b2.addActionListener(this);
        b3.addActionListener(this);        b4.addActionListener(this);
		
        text_validator(t1);        text_validator(t2);
        text_validator(t3);        text_validator(t6);
		
        b1.setMnemonic('T');        b2.setMnemonic('C');
        b3.setMnemonic('X');        b4.setMnemonic('S');
		
        setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE );
        setVisible(true);
	}
	
    void text_validator(final JTextField tt)
    {
		tt.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent e)
				{
					if (tt.getText().length() < 3 && e.getKeyChar() >= '0'
					&& e.getKeyChar() <= '9')
						super.keyTyped(e);  // Optional
					else
					{
						e.consume();        // Discard the event
						
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();          // Raise the Sound
					}
				}
			});
	}
	
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(t1.getText().length() ==0 || t2.getText().length() ==0 || t3.getText().length() ==0)
            {
                JOptionPane.showMessageDialog(null,"All Fields are Neccessary");
				
                if(t1.getText().length() ==0)         t1.requestFocus() ;
                else if(t2.getText().length() ==0)    t2.requestFocus() ;
                else                                  t3.requestFocus() ;
			}
            else if(Integer.parseInt(t1.getText())>100 || Integer.parseInt(t2.getText())>100 || Integer.parseInt(t3.getText())>100)
				JOptionPane.showMessageDialog(null,"Marks must be between 0 to 100",			"Invalid Marks",JOptionPane.WARNING_MESSAGE);
            else
            {
				tot = Integer.parseInt(t1.getText()) + Integer.parseInt(t2.getText()) +Integer.parseInt(t3.getText()) ;
				ltot.setText(Integer .toString(tot));
				
				avg = tot/3;
				lavg.setText(Integer .toString(avg)+" %");
				
				if(avg<40)
					JOptionPane.showMessageDialog(null,"You are FAIL Board Exam !!!"				,"FAIL",JOptionPane.ERROR_MESSAGE);
				else if(avg >= 40 && avg<50)
					JOptionPane.showMessageDialog(null,"You are NOT Eligible for CET Exam !!!"				,"Eligibility",JOptionPane.WARNING_MESSAGE);
				else
				{
					pp.setVisible(true);
					JOptionPane.showMessageDialog(null,"You are Eligible for CET Exam !!!");
					t6.requestFocus() ;
				}
			}
		}
        else if(e.getSource()==b2)
        {
            t1.setText("");            t2.setText("");
            t3.setText("");            ltot.setText("");
            lavg.setText("");          t6.setText("");
            cb1.setSelectedIndex(0);
            pp.setVisible(false);
            t1.requestFocus() ;
		}
        else if(e.getSource()==b4)
        {
            if(t6.getText() .length()==0 || cb1.getSelectedIndex() ==0)
            {
				JOptionPane.showMessageDialog(null,"All Fields are Neccessary");
				
                if(t6.getText().length() ==0)   t6.requestFocus() ;
                else                            cb1.requestFocus() ;
			}
            else if(Integer.parseInt(t6.getText())>200)
				JOptionPane.showMessageDialog(null,"Marks must be between 0 to 200"			,"Invalid Marks",JOptionPane.WARNING_MESSAGE);
            else
            {
                int cet = Integer.parseInt(t6.getText());
				
                if((cet>=160 && cb1.getSelectedIndex() ==1) ||
					(cet>=170 && cb1.getSelectedIndex() ==2) ||
					(cet>=180 && cb1.getSelectedIndex() ==3) ||
					(cet>=190 && cb1.getSelectedIndex()==4 ))
					JOptionPane.showMessageDialog(null,"Congrats !!! You are Passed !!!");
                else
					JOptionPane.showMessageDialog(null,"You are FAIL in CET Exam !!!"
				,"FAIL",JOptionPane.ERROR_MESSAGE);
			}
		}
        else
			System.exit(0);
	}
	
    public static void main(String args[])
    {        new adm_sys();
	}
}
