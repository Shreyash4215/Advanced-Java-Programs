import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myfrm extends JFrame implements ActionListener
{	
	JPanel p1;
	JButton b[][],b1,b2,b3,b4;
	int i=0,j=0;
	
	myfrm()
	{
		setTitle("Moving Star");
		setSize(800,500);
		setLocation(200,200);
		setLayout(null);
		
		p1 = new JPanel();
		b = new JButton[4][4];
		b1 = new JButton("Up");
		b2 = new JButton("Down");
		b3 = new JButton("Left");
		b4 = new JButton("Right");
				
		add(p1);		add(b1);
		add(b2);		add(b3);
		add(b4);
				
		p1.setBounds(100,70,300,300);
		b1.setBounds(410,72,70,70);
		b2.setBounds(410,147,70,70);
		b3.setBounds(410,222,70,70);
		b4.setBounds(410,297,70,70);
		
		p1.setLayout(new GridLayout(4,4,-2,-2));
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{		
				b[i][j]=new JButton();
				p1.add(b[i][j]);
				b[i][j].setBackground(Color.WHITE);
				b[i][j].setFont(new Font("Arial",Font.BOLD,51));
			}
		}
		b[i][j].setText("*");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}	
	
	public void actionPerformed(ActionEvent e)
	{
		b[i][j].setText("");	
		if(e.getSource()==b1)
		{
			if(i!=0)		
				i--;
			else
				JOptionPane.showMessageDialog(null,"Up is Error!!!");			
		}
		if(e.getSource()==b2)
		{
			if(i!=3)
				i++;				
			else
				JOptionPane.showMessageDialog(null,"Down is Error!!!");		
		}
		if(e.getSource()==b3)
		{
			if(j!=0)
				j--;
			else
				JOptionPane.showMessageDialog(null,"Left is Error!!!");
		}
		if(e.getSource()==b4)
		{
			if(j!=3)		
				j++;
			else				
				JOptionPane.showMessageDialog(null,"Right is Error!!!");
		}
		b[i][j].setText("*");
	}
}
class Ass14movingstr
{
	public static void main(String args[])
	{
		new myfrm();
	}
}