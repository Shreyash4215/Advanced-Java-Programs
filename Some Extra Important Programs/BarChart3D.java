import java.io.*; 
import javax.swing.*;
import java.awt.*;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ChartUtilities; 

public class BarChart3D extends JFrame
{
    JLabel l1;

	BarChart3D()
	{
		super("BarChart3D Demo");
		setSize(800,600);
		setLocation(200,100);
		
		l1 = new JLabel(new ImageIcon("barChart3D.jpeg"));
		add(l1);        
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main( String[ ] args )throws Exception 
	{
		final String fait = "FAIT";              
		final String audi = "AUDI";              
		final String ford = "FORD";              
		final String speed = "Speed";              
		final String popular = "Popular";              
		final String mailage = "Mailage";              
		final String userrating = "User Rating";              
		final String safety = "safety";        
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 
		
		dataset.addValue( 1.0 , fait , speed );              
		dataset.addValue( 4.0 , fait , popular );              
		dataset.addValue( 3.0 , fait , userrating );              
		dataset.addValue( 5.0 , fait , mailage );              
		dataset.addValue( 5.0 , fait , safety );              
		
		dataset.addValue( 5.0 , audi , speed );              
		dataset.addValue( 7.0 , audi , popular );              
		dataset.addValue( 6.0 , audi , userrating );              
		dataset.addValue( 10.0 , audi , mailage );              
		dataset.addValue( 4.0 , audi , safety ); 
		
		dataset.addValue( 4.0 , ford , speed );              
		dataset.addValue( 3.0 , ford , popular );              
		dataset.addValue( 2.0 , ford , userrating );              
		dataset.addValue( 3.0 , ford , mailage );              
		dataset.addValue( 6.0 , ford , safety );                 
		
		JFreeChart barChart = ChartFactory.createBarChart3D(
			"Car Usage Statistics",             
			"Category",             
			"Score",             
			dataset,            
			PlotOrientation.VERTICAL,             
		true, true, false);
		
		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File barChart3D = new File( "barChart3D.jpeg" );
		ChartUtilities.saveChartAsJPEG( barChart3D, barChart, width, height);
		
		new BarChart3D();	// call to con_or
	}
}
