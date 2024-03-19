import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Practical14Servlet extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>");
		java.util.Properties p = System.getProperties();
        out.println("Server Name: " + request.getServerName()+"<BR>");
        out.println("Remote Address: " + request.getRemoteAddr()+"<BR>");
        out.println("Remote User: " + request.getRemoteUser()+"<BR>");
        out.println("Server Port: " + request.getServerPort()+"<BR>");
        out.println("Remote Host: " + request.getRemoteHost()+"<BR>");
        out.println("Local Name: " + request.getLocalName()+"<BR>");
        out.println("Local Address: " + request.getLocalAddr()+"<BR>");
        out.println("Servlet Name: " +this.getServletName()+"<BR>");
        out.println("OS name: " + p.getProperty("os.name")+"<BR>");
        out.println("</body></html></h1>");
    }
 }