import java.awt.*;  
import java.util.*;  
import javax.swing.*;  
import java.awt.event.*;  
import javax.swing.Timer;

class Clock extends JLabel
 {  
        String stringTime;  
        int hour, minute, second;  
        String aHour = "";  
        String bMinute = "";  
        String cSecond = ""; 		
		
		Clock(String stringTime )
		{
			
		}
		
		Clock() 
		{  
			
            Timer t = new Timer(1000, new ActionListener()
			{  
                public void actionPerformed(ActionEvent e)
				{  
                    Disp(); 
                }  
            });  
            t.start();  
        }       	
                
        public void Disp() 
		{  
            Calendar rite = Calendar.getInstance();  
            hour = rite.get(Calendar.HOUR_OF_DAY);  
            minute = rite.get(Calendar.MINUTE);  
            second = rite.get(Calendar.SECOND);  
            if (hour < 10)   
                this.aHour = "0";  
            
            if (hour >= 10)   
                this.aHour = "";  
              
            if (minute < 10)   
                this.bMinute = "0";  
              
            if (minute >= 10)  
                this.bMinute = "";  
              
            if (second < 10)   
                this.cSecond = "0";  
              
            if (second >= 10)   
                this.cSecond = "";  
              
            stringTime=""+aHour+""+hour+":"+bMinute+""+minute+":"+cSecond+""+second+"";  
			setText(stringTime);
            // v.setColor(Color.RED);  	
			// Font Font1 = new Font("SansSerif", Font.BOLD, 21);  
            // v.setFont(Font1);  
            // v.drawString(stringTime,10,20);  
        }   
	}