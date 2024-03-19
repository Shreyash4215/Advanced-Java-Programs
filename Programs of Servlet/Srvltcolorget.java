import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Srvltcolorget extends HttpServlet
 {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
		String clr = request.getParameter("color");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<B>The Selected Color is: ");
        out.println(clr);
        out.close();
       
    }
}