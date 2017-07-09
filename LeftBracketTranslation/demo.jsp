<html>
<head>
	<title>demo</title>
</head>
<body>
    <!-- 1. JSP Directives -->
    <%@ page import="java.util.*" %>
    <%@ include file="demo.html" %>
    <!-- 2. Scripting Elements -->
    <!-- 2.1 Declarations -->
    <%! int i = 0; %>
    <%! int icubed = 0; %>
    <%! public int cubed(int j) {
			return (j*j*j);
		}
	%>
    <!-- 2.2 Scripting Elements -->
    <%
		try {
			i = Integer.parseInt(request.getParameter("mynum"));
		} catch (NumberFormatException nfe) {
			out.println("Go back and enter a valid number.");
			i = 0;
		}
		icubed = cubed(i);
	%>
    <!-- 2.3 Expressions -->
    <p>You entered the value <%= i %></p>
    <p>That number cubed is <%= icubed %></p>
    <p>I can say the same thing with <%= cubed(i) %></p>
    <p>I can also use Scriptlets to get <% out.println(icubed); %></p>
	<!-- 3. Actions -->
    <jsp:include page="demo.html" flush="true" />
    <!-- 4. Expression Language -->
    ${1+2+3}
    ${1>2}
    <% application.setAttribute("name", "Eric"); %>
    ${applicationScope.name}
</body>
</html>
