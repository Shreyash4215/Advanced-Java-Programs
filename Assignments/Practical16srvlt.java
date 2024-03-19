import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Practical16srvlt extends HttpServlet
 {
 	Connection cn;	
	Statement stm;        
	ResultSet rs;

    public void service(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException
    {
		res.setContentType("text/html");		
		PrintWriter pw = res.getWriter();
		
		pw.println("<HTML><HEAD><TITLE>Database Connectivity</TITLE></HEAD>");
		pw.println("<BODY>");
		pw.println("<P align=center><BIG>Data From Database</BIG></p>");
		pw.println("<TABLE align=center border=1>");
		pw.println("<TR>");
		pw.println("<TH>Roll Number</TH><TH>Name</TH><TH>Age</TH></TR>");
		
		try
		{
			int roll = Integer.parseInt(req.getParameter("txt1"));
			cn = DriverManager.getConnection("jdbc:mysql:///sad","root","123456789");
			stm=cn.createStatement();
			rs=stm.executeQuery("select * from mytable where roll = "+roll);
			
			rs.next();
			pw.println("<TR>");
			pw.println("<TD>"+ rs.getString(1)+"</TD>");
			pw.println("<TD>"+ rs.getString(2)+"</TD>");
			pw.println("<TD>"+ rs.getString(3)+"</TD>");
			pw.println("<?TR>");
			rs.close();		stm.close();		cn.close();
		}
		catch(Exception e)
		{
			pw.println("<TR><TD colspan=3>Student Info NOT Fount</TD></TR>");
		}
		
		pw.println("</TABLE></BODY></HTML>");
		pw.close();       
    }
}