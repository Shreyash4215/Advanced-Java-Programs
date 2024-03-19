import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class JTBar2 extends JFrame implements ActionListener
{
    JToolBar bar;
    JButton b1,b2,b3;

    JTBar2()
    {
        super("Demo of ToolBar");
        setSize(500,500);
        setLocation(150,150);
        setLayout(null);
		
        bar = new JToolBar();

        b1 = new JButton(new ImageIcon("b1.png"));
//		b1.setText("SAVE");
        b2 = new JButton(new ImageIcon("b2.png"));	
	//	b2.setText("UPDT");
        b3 = new JButton(new ImageIcon("b3.png"));	
		//b3.setText("DELT");

        bar.add(b1);  bar.addSeparator();
        bar.add(b2);  bar.addSeparator();
        bar.add(b3);
		
		b1.setToolTipText("Save");
		b2.setToolTipText("Update");
		b3.setToolTipText("Delete");

        add(bar,BorderLayout .NORTH);
        bar.setFloatable(false);

		bar.setBounds(0,0,500,64);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
      JOptionPane.showMessageDialog(null,e.getActionCommand());
    }

    public static void main(String args[])
    {
        new JTBar2();
    }
}
