import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Srvlt1 extends HttpServlet
 {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body bgcolor=Green>");
        out.println("<h1>TyBcs!!!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}