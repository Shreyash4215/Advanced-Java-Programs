import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class Practical15Servlet extends HttpServlet 
{
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
		int i,cnt=0;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		out.println("<html><body>");
		Cookie cookies[] = request.getCookies();
		if(cookies != null)
		{
			for (i = 0; i < cookies.length; i++)
				if(cookies[i].getName().equals("counter"))	
					cnt = Integer.parseInt(cookies[i].getValue());
		}
		
		if(cnt==0)
		{
			out.println("Welcome User!!! ");
			cnt=1;			
		}
		else
		{
			cnt++;
			out.println("<BR>Number of Time Visited = "+cnt);			
		}
		
		Cookie c = new Cookie("counter",Integer.toString(cnt));
        response.addCookie(c);
		out.println("</body></html>");
		out.close();
    }
 }