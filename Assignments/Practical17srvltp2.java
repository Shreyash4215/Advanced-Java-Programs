import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Practical17srvltp2 extends HttpServlet
 {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
		response.setContentType("text/html");		
		PrintWriter pw = response.getWriter();
		int sum2=0;
		String[] value = request.getParameterValues("item");
		if(value != null)
		{
			for(int i=0;i<value.length;i++)
				sum2=sum2+Integer.parseInt(value[i]);
		}
		HttpSession hs = request.getSession();
		int sum1 = ((Integer)hs.getAttribute("Srvltwbb4")).intValue();
		pw.println("<HTML>");	
		pw.println("<Title> Summary </Title><BODY>");	
		pw.println("<B> Total of page 1 = "+sum1+"\n <BR>");	
		pw.println("<B> Total of page 2 = "+sum2+"\n <BR><BR>");	
		int total=sum1+sum2;
		pw.println("<B> Total Bill = "+total);
		pw.println("</HTML></BODY>");
	}
}