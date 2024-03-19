/*
javac -cp ".;c:\*" GeneratePDF.java
java -cp ".;c:\*" GeneratePDF

export CLASSPATH=/root/*:/root:.
*/

import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;

class GeneratePDF
{
    public static void main(String[] args) 
    {
        try
        {
			String path="Test.pdf";
            OutputStream file = new FileOutputStream(new File(path));

			Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("Good Morning ..."));
            document.close();
            file.close();      

			//To open the pdf file in linux & windows
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new java.io.File(path));

			} catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}
