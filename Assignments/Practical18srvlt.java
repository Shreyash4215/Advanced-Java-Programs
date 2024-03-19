import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Practical18srvlt extends HttpServlet
 {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
		String data = request.getParameter("hobby");
		response.setContentType("text/html");		
		PrintWriter out = response.getWriter();
		//out.println("<html><body>");
		Cookie[] cook = request.getCookies();
		if(cook != null)
		{
			for (int i = 0; i < cook.length; i++)
				if(cook[i].getName().equals("myhobby"))	
					out.println("<H1>Cookie exists for = "+cook[i].getValue());
		}
		Cookie c = new Cookie("myhobby",data);
        response.addCookie(c);
		out.println("<H1>Cookie added for Hobby "+data);
		//out.println("</HTML></BODY>");
	}
}