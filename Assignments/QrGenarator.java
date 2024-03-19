import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import java.io.*;


public class QrGenarator extends JFrame implements ActionListener
{
    JButton QRcode;
    JTextField URL;
    JLabel enterURL,QRicon;
			
    QrGenarator()
    {
        setBounds(500,100,450,650);
        setLayout(null);

        enterURL = new JLabel("Enter URL:-");
        URL = new JTextField();
        QRcode = new JButton("Generate QR Code");
		QRicon = new JLabel();
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        
		enterURL.setBounds(30,150,120,30);        URL.setBounds(150,150,220,30);
        QRcode.setBounds(120,250,200,30);	      QRicon.setBounds(120,350,200,200);
        
		add(enterURL);        add(URL);        add(QRcode);		add(QRicon);		
		
		QRicon.setBorder(blackline);			
                   
		QRcode.addActionListener(this);	
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae)
    {
        try{
            String data = String.format(URL.getText());
            ByteArrayOutputStream OutputStream = QRCode.from(data).withSize(200, 200).to(ImageType.PNG).stream();
            
			byte[] QR = OutputStream.toByteArray();
			QRicon.setIcon(new ImageIcon(QR));
	    }
        catch(Exception e){
            System.out.println(e);

        }
    }

    public static void main(String[] args)
    {
        new QrGenarator();
    }
}