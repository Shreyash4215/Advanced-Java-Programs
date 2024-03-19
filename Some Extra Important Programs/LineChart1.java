/*
javac -cp ".;c:\*" LineChart1.java
java -cp ".;c:\*" LineChart1
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.jfree.chart.*; 
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 

/*
	public static JFreeChart createLineChart(String title,
	String categoryAxisLabel,
	String valueAxisLabel,
	CategoryDataset dataset,
	PlotOrientation orientation,
	boolean legend,
	boolean tooltips,
	boolean urls)
	
	Creates a line chart with default settings. 
	The chart object returned by this method uses a CategoryPlot instance as the plot, 
	with a CategoryAxis for the domain axis, a NumberAxis as the range axis, 
	and a LineAndShapeRenderer as the renderer.
	
	Parameters:
    title - the chart title (null permitted).
    categoryAxisLabel - the label for the category axis (null permitted).
    valueAxisLabel - the label for the value axis (null permitted).
    dataset - the dataset for the chart (null permitted).
    orientation - the chart orientation (horizontal or vertical) (null not permitted).
    legend - a flag specifying whether or not a legend is required.
    tooltips - configure chart to generate tool tips?
    urls - configure chart to generate URLs?
	Returns:
    A line chart. 	
*/

class LineChart1 extends JFrame
{
	JFreeChart lineChart;
	ChartPanel chartPanel;
	
	LineChart1() 
    {
		super("Line Chart Demo");        
		setSize(600,600);
        setLocation(300,100);		
		
		lineChart = ChartFactory.createLineChart(
		"Number of Schools vs years",
		"Years","Number of Schools",
		createDataset(),
		PlotOrientation.HORIZONTAL,
		true,true,false);
		
		chartPanel = new ChartPanel( lineChart );
		setContentPane( chartPanel );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	DefaultCategoryDataset createDataset( ) 
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		dataset.addValue( 300 , "schools" , "2014" );
		dataset.addValue( 240 , "schools" , "2010" );
		dataset.addValue( 120 , "schools" , "2000" );
		dataset.addValue( 60 , "schools" ,  "1990" );
		dataset.addValue( 30 , "schools" , "1980" );
		dataset.addValue( 15 , "schools" , "1970" );
		return dataset;
	}
	
    public static void main(String args[])
    {    
		new LineChart1();
	}
}
