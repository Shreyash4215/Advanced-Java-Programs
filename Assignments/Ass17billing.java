import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class JTablede extends JFrame implements ActionListener
{
	DefaultTableModel model ;
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JTable table ;
	JButton b1;
	String coolHeads[] = {"Item ID","Item Name","Item Price"};
	int i=0,total=0;
	
	JTablede()
	{
		model = new DefaultTableModel();	
		setTitle("Demo of ToolBar");
		setSize(500,550);
		setLocation(150,150);
		setLayout(null);
		
		for(int i=0; i<coolHeads.length; i++)
			model.addColumn(coolHeads[i]);
		
		l1 = new JLabel("Item ID");
		l2 = new JLabel("Item Name");
		l3 = new JLabel("Item Price");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();	
	
		b1 = new JButton("Add to bill");	
		model.insertRow(0,new Object[]{"","Total =",""+total});
		table = new JTable(model);
		
		table.setEnabled(false);		
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED; 
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp1 = new JScrollPane(table,v1,h1);
		
		add(jsp1);					add(b1);
		add(l1);	add(l2);		add(l3);
		add(t1);	add(t2);		add(t3);
			
		l1.setBounds(50,30,100,25);
		t1.setBounds(135,30,150,23);
		l2.setBounds(50,65,150,23);
		t2.setBounds(135,65,150,23);
		l3.setBounds(50,100,150,23);
		t3.setBounds(135,100,150,23);
		b1.setBounds(70,145,200,25);
		jsp1.setBounds(50,200,350,300);
				
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(1);
		
		b1.addActionListener(this);	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);				
	}
	public void actionPerformed(ActionEvent e)
	{
		model.removeRow(i);		
		if(e.getSource()==b1)
		{			
			model.insertRow(i,new Object[]{""+t1.getText(),""+t2.getText(),""+t3.getText()});
			total=total+Integer.parseInt(t3.getText());
			t1.setText("");			t2.setText("");			t3.setText("");
			i++;
			model.insertRow(i,new Object[]{"","Total",""+total});
		}
		t1.requestFocus();
	}	
}
class Ass17billing
{
	public static void main(String args[])
	{
		new JTablede();
	}
}