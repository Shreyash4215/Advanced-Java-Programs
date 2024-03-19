/*
javac -cp ".;c:\*" PieChart2.java 
java -cp ".;c:\*" PieChart2
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.ui.*;
 
/*
	public static JFreeChart createPieChart(String title,
	PieDataset dataset,
	boolean legend,
	boolean tooltips,
	boolean urls)
	
	Creates a pie chart with default settings.
	The chart object returned by this method uses a PiePlot instance as the plot.
	
	Parameters:
    title - the chart title (null permitted).
    dataset - the dataset for the chart (null permitted).
    legend - a flag specifying whether or not a legend is required.
    tooltips - configure chart to generate tool tips?
    urls - configure chart to generate URLs?
	Returns:
    A pie chart. 	 	
*/

class PieChart2 extends JFrame
{
	JFreeChart pieChart;
	ChartPanel chartPanel;
	
	PieChart2() 
    {
		super("Pie Chart Demo");        
		setSize(600,600);
        setLocation(300,100);		
		
		pieChart = ChartFactory.createPieChart(      
		"Mobile Sales",   // chart title 
		createDataset(),  // data    
		true,             // include legend   
		true, 
		false);
		
		chartPanel = new ChartPanel( pieChart );
		setContentPane( chartPanel );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	static PieDataset createDataset( ) 
	{
		DefaultPieDataset dataset = new DefaultPieDataset( );
		dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
		dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
		dataset.setValue( "MotoG" , new Double( 40 ) );    
		dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
		return dataset;        
	}
	
    public static void main(String args[])
    {    
		new PieChart2();
	}
}
