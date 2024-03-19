import java.awt.*;

class BorderLayoutDemo extends Frame
{
	BorderLayoutDemo()
	{
		setSize(400,300);
		setLayout(new BorderLayout());
		
		add(new Button("This is across the top."),BorderLayout.NORTH);
		add(new Button("The Footer Message."),BorderLayout.SOUTH);
		add(new Button("Right"),BorderLayout.EAST);
		add(new Button("Left"),BorderLayout.WEST);
		String msg = "dddddddddddddddddddddddddddd \n"+
					 "SSSSSSSSSSSSSSSSSSSSSSSSSSSS \n"+
					 "qqqqqqqqqqqqqqqqqqqqqqqqqqqq \n";
		add(new TextArea(msg),BorderLayout.CENTER);
		setVisible(true);	
	}
	public static void main(String args[])
	{
		new BorderLayoutDemo();
	}
}