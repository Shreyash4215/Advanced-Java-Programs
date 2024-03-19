
<%@ page language = "java" import = "java.util.*"%>
<html>
<head>
	<title>Greeting message</title>
</head>
<body><center><h1>
<%
	String s1 = request.getParameter(("txt1"));
	out.println("Welcome " + s1);
	
	Calendar cal = Calendar.getInstance();
	int h = cal.get(Calendar.HOUR_OF_DAY);
	
	if(h>=1 && h<=11)
		out.println("<br> Good Morning...");
	else if(h>=12 && h<=16)
		out.println("<br> Good Afternoon...");
	else if(h>=17 && h<=19)
		out.println("<br> Good Evening...");
	else
		out.println("<br> Good Night...");
%>
</h1></center></body></html>