/*
javac -cp ".;c:\*" LineChart1_DB.java
java -cp ".;c:\*" LineChart1_DB
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import org.jfree.chart.*; 
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 

/*
	use ras;
	drop table gym;
	create table gym
	(
	  dt date,
	  wt integer
	);
	
	insert into gym values('2020-01-2',60);
	insert into gym values('2020-01-4',58);
	insert into gym values('2020-01-6',56);
	insert into gym values('2020-01-8',54);
	insert into gym values('2020-01-10',72);
	insert into gym values('2020-01-12',60);
	insert into gym values('2020-01-14',58);
	insert into gym values('2020-01-16',56);
	insert into gym values('2020-01-18',54);
	insert into gym values('2020-01-20',72);
	select * from gym;
	
*/

class LineChart1_DB extends JFrame
{
	JFreeChart lineChart;
	ChartPanel chartPanel;
	
	LineChart1_DB() 
    {
		super("Line Chart Demo");        
		setSize(1000,600);
        setLocation(100,100);		
		
		lineChart = ChartFactory.createLineChart(
		"Date vs Weight",
		"Dates","Weight in KG",
		createDataset(),
		PlotOrientation.VERTICAL,
		true,true,false);
		
		chartPanel = new ChartPanel( lineChart );
		setContentPane( chartPanel );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	DefaultCategoryDataset createDataset( ) 
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

		Connection cn;
        Statement stm;
        ResultSet rs;      
		
        try
        {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ras","root", "");
			stm = cn.createStatement();
			
            rs = stm.executeQuery("select * from gym");
            while(rs.next())
            {
				dataset.addValue( rs.getInt(2) , "Weight" , rs.getString(1) );
            }
            rs.close();
		}
		catch (Exception e)
		{
			System.out.println(e);            
		}
	
	
		return dataset;
	}
	
    public static void main(String args[])
    {    
		new LineChart1_DB();
	}
}
