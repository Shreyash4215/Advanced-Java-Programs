
<%@ page language = "java" import = "java.io.*"%>
<html><body><center><h1>
<%
	String s1 = request.getParameter(("txt1"));
	out.println("Entered file extension = " + s1);
	File dirs = new File("f:\\New folder (3)");
	String []files = dirs.list();
	for(int i = 0;i < files.length;i++)
		if(files[i].endsWith("."+s1) == true)
			out.println("<br><a href = ''> " + files[i] + "</a>");
%>
</h1></center></body></html>