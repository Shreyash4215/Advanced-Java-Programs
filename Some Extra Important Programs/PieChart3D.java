import java.io.*; 
import javax.swing.*;
import java.awt.*;

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.data.general.DefaultPieDataset; 
import org.jfree.chart.ChartUtilities;

public class PieChart3D extends JFrame
{
    JLabel l1;

	PieChart3D()
	{
		super("PieChart3D Demo");
		setSize(800,600);
		setLocation(200,100);
		
		l1 = new JLabel(new ImageIcon("pie_Chart3D.jpeg"));
		add(l1);        
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


   public static void main( String[ ] args )throws Exception {
      DefaultPieDataset dataset = new DefaultPieDataset( );             
      dataset.setValue( "IPhone 5s" , new Double( 20 ) );             
      dataset.setValue( "SamSung Grand" , new Double( 20 ) );             
      dataset.setValue( "MotoG" , new Double( 40 ) );             
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) ); 

      JFreeChart chart = ChartFactory.createPieChart3D( 
         "Mobile Sales" ,  // chart title                   
         dataset ,         // data 
         true ,            // include legend                   
         true, 
         false);

      final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
      plot.setStartAngle( 270 );             
      plot.setForegroundAlpha( 0.60f );             
      plot.setInteriorGap( 0.02 );             
      int width = 640;   /* Width of the image */             
      int height = 480;  /* Height of the image */                             
      File pieChart3D = new File( "pie_Chart3D.jpeg" );                           
      ChartUtilities.saveChartAsJPEG( pieChart3D , chart , width , height );   
	  new PieChart3D();	// call to def. con_or
   }
}