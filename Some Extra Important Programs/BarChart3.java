/*
javac -cp ".;c:\*" BarChart3.java 
java -cp ".;c:\*" BarChart3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.*; 
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 

/*
	public static JFreeChart createBarChart(String title,
	String categoryAxisLabel,
	String valueAxisLabel,
	CategoryDataset dataset,
	PlotOrientation orientation,
	boolean legend,
	boolean tooltips,
	boolean urls)
	
	Creates a bar chart. 
	The chart object returned by this method uses a CategoryPlot instance as the plot, 
	with a CategoryAxis for the domain axis, a NumberAxis as the range axis, 
	and a BarRenderer as the renderer.
	
	Parameters:
    title - the chart title (null permitted).
    categoryAxisLabel - the label for the category axis (null permitted).
    valueAxisLabel - the label for the value axis (null permitted).
    dataset - the dataset for the chart (null permitted).
    orientation - the plot orientation (horizontal or vertical) (null not permitted).
    legend - a flag specifying whether or not a legend is required.
    tooltips - configure chart to generate tool tips?
    urls - configure chart to generate URLs?
	Returns:
    A bar chart. 	
*/

class BarChart3 extends JFrame
{
    JFreeChart barChart;
	ChartPanel chartPanel;
	
	BarChart3() 
    {
		super("Bar Chart Demo");        
		setSize(600,600);
        setLocation(300,100);		
		
		barChart = ChartFactory.createBarChart(
		"Which car do you like?",
		"Category",
		"Score",
		createDataset(), 
		PlotOrientation.VERTICAL,true, true, false);
		
		chartPanel = new ChartPanel( barChart );        
		setContentPane( chartPanel ); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	CategoryDataset createDataset( ) 
	{
		String fiat = "FIAT";        
		String audi = "AUDI";        
		String ford = "FORD";        
		
		String speed = "Speed";        
		String millage = "Millage";        
		String userrating = "User Rating";        
		String safety = "safety";       
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
		
		dataset.addValue( 1.0 , fiat , speed );        
		dataset.addValue( 3.0 , fiat , userrating );        
		dataset.addValue( 5.0 , fiat , millage ); 
		dataset.addValue( 5.0 , fiat , safety );           
		
		dataset.addValue( 5.0 , audi , speed );        
		dataset.addValue( 6.0 , audi , userrating );       
		dataset.addValue( 10.0 , audi , millage );        
		dataset.addValue( 4.0 , audi , safety );
		
		dataset.addValue( 4.0 , ford , speed );        
		dataset.addValue( 2.0 , ford , userrating );        
		dataset.addValue( 3.0 , ford , millage );        
		dataset.addValue( 6.0 , ford , safety );               
		
		return dataset; 
	}
	
    public static void main(String args[])
    {    
		new BarChart3();
	}
}
