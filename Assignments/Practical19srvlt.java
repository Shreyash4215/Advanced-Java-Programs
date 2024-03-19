import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Practical19srvlt extends HttpServlet
{	
	Connection con; 
	Statement stm;
	ResultSet rs;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		int cnt = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title> Login </title><head>");
		out.println("<body>");
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String s1 = request.getParameter("l_name");
			String s2 = request.getParameter("pass");
			con = DriverManager.getConnection("jdbc:mysql:///sad","root", "1");
		    stm = con.createStatement();
			rs = stm.executeQuery("select * from login where loginnme='"+s1+"'");
			rs.next();
			if(s1.equals(""+rs.getString(1)) && s2.equals(""+rs.getString(2)))
			{
				out.println("<br>Correct login credentials<br><br><br>");
					
				
				Cookie cookies[] = request.getCookies();
				
				if(cookies != null)
				{
					for(int i = 0;i < cookies.length;i++)
						if(cookies[i].getName().equals("login"))
						{
							cnt = Integer.parseInt(cookies[i].getValue());
							cnt++;
							out.println("Number of times visited = " + cnt);
						}
				}
				
				if(cnt == 0)
				{
					out.println("Welcome User you are visited 1st time!!!");
					cnt = 1;
				}
				
				Cookie c = new Cookie("login",Integer.toString(cnt));
				response.addCookie(c);
				
			}
			else
			{				
				response.sendRedirect("Practical19htmlerr.html");
			}
			rs.close();  stm.close(); con.close();		
		}
		catch(Exception e)
		{
            out.println("<br>Incorrect login credentials");
			out.println(e.getMessage());
		}
		
		out.println("</table></body></html>");
	}
}