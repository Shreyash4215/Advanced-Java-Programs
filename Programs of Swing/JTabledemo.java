import javax.swing.*;

class JTablede extends JFrame
{
	JTablede()
	{
		setTitle("Demo of ToolBar");
		setSize(500,500);
		setLocation(150,150);

		String coolHeads[] = {"Name","Phone","Fax"};
		
		String data[][]=
		{
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"},
			{"abcd","1234","5678"}
		};
		
		JTable table = new JTable(data,coolHeads);
		add(table);
		
		table.setEnabled(false);
		
		int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;  //IMP
		int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp1 = new JScrollPane(table,v1,h1);
		add(jsp1);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);				
	}
}
class JTabledemo
{
	public static void main(String args[])
	{
		new JTablede();
	}
}