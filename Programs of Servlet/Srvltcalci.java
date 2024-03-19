import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Srvltcalci extends HttpServlet
 {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
		String txt1 = request.getParameter("txt1");
		String txt2 = request.getParameter("txt2");
		
		int a = Integer.parseInt(txt1);
		int b = Integer.parseInt(txt2);
		int c=0;
		
		String op = request.getParameter("op");
		if(op.equals("ADD"))
			c=a+b;
		else if(op.equals("SUB"))
			c=a-b;
		else if(op.equals("MUL"))
			c=a*b;
		else if(op.equals("DIV"))
			c=a/b;
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<BR>First No : "+a);
        out.println("<BR>second No : "+b);
        out.println("<BR>Ans : "+c);
        out.close();       
    }
}