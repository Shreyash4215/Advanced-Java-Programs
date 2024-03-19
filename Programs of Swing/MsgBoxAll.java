import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MsgBoxAll extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7;

    MsgBoxAll()
    {
        super("Message Box");
        setSize(220,300);
        setLocation(150,200);
        setLayout(new FlowLayout());

        b1 = new JButton("Simple MSG Box");
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Warning MSG Box");
        add(b2);
        b2.addActionListener(this);

        b3 = new JButton("Error MSG Box");
        add(b3);
        b3.addActionListener(this);

        b4 = new JButton("Y/N/Cncel MSG Box");
        add(b4);
        b4.addActionListener(this);

        b5 = new JButton("Ok/Cacel MSG Box");
        add(b5);
        b5.addActionListener(this);

        b6 = new JButton("Show Input Box");
        add(b6);
        b6.addActionListener(this);

        b7 = new JButton("User Defined");
        add(b7);
        b7.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b1)
            JOptionPane.showMessageDialog(null, "This is Simple Msg Box");

        if (e.getSource()==b2)
            JOptionPane.showMessageDialog(null,"Please Try Again !","Invalid Password !!!",JOptionPane.WARNING_MESSAGE);

        if (e.getSource()==b3)
            JOptionPane.showMessageDialog(null,"Please Try Again !","Invalid Password !!!",JOptionPane.ERROR_MESSAGE);

        if (e.getSource()==b4)
        {
            int ans=JOptionPane.showConfirmDialog(null,"This is the Y/N/Cancel Msg box.");
            if (ans==0)
                JOptionPane.showMessageDialog(null, "You clicked on YES Button");
            if (ans==1)
                JOptionPane.showMessageDialog(null, "You clicked on NO Button");
            if (ans==2)
                JOptionPane.showMessageDialog(null, "You clicked on CANCEL Button");
        }
		
        if (e.getSource()==b5)
        {
			int ans = JOptionPane.showConfirmDialog(null,"Message","Msg Box Title",	JOptionPane.OK_CANCEL_OPTION);			
			if(ans==0)
				JOptionPane.showMessageDialog(null,"You clicked on Ok Button");
			else
				JOptionPane.showMessageDialog(null,"You clicked Cancel button");
        }

        if (e.getSource()==b6)
        {
            String str = JOptionPane.showInputDialog(null, "Enter some text : ");
            if (str != null)
                JOptionPane.showMessageDialog(null, "You entered the text : " + str);
            else
                JOptionPane.showMessageDialog(null, "You pressed CANCEL button.");
        }

        if (e.getSource()==b7)
        {
            Object[] options = {"Yes, Why Not","No, thanks"};
            int n = JOptionPane.showOptionDialog(null,"Question","Title",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        }

    }

    public static void main(String args[])
    {
        new MsgBoxAll();
    }
}
