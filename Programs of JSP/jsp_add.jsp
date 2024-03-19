<%@ page language="java"%>
<html>
<body>
<H1> Addition = <BR>
<%
		String txt1 = request.getParameter("txt1");
		String txt2 = request.getParameter("txt2");
		
		int a = Integer.parseInt(txt1);
		int b = Integer.parseInt(txt2);
		
		int c=a+b;
		out.println(c);
%>
</html>
</body>
