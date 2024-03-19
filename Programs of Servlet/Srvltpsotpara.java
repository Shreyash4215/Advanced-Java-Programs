import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Srvltpsotpara extends GenericServlet
 {
    public void service(ServletRequest req, ServletResponse res)throws IOException, ServletException
    {
		
		PrintWriter pw = res.getWriter();
		
		Enumeration e = req.getParameterNames();
		
		while(e.hasMoreElements())
		{
			String pname = (String)e.nextElement();
			pw.print("Parameter Name = "+pname+"=> ");
			
			String pvalue = req.getParameter(pname);
			pw.println("Parameter Value = "+pvalue+"<BR><BR> ");
		}
		pw.close();       
    }
}