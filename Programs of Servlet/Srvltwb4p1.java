import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Srvltwb4p1 extends HttpServlet
 {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
		int sum=0;
		String[] value = request.getParameterValues("item");
		if(value != null)
		{
			for(int i=0;i<value.length;i++)
				sum=sum+Integer.parseInt(value[i]);
		}
		HttpSession hs = request.getSession(true);
		hs.setAttribute("Srvltwbb4",sum);
		response.sendRedirect("Page 2.html");
    }
}