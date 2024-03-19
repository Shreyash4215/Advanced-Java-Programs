<%@ page language="java"%>
<html>
<head>
<title>Even number program in JSP</title>
</head>
<body>
<H1> List of Even Number = <BR>
<%
	for(int i=0;i<=10;i++)
	{
		if((i%2)==0)
		{
			out.print(Integer.toString(i));
			out.print("<br>");
		}
	}
%>
</html>
</body>
