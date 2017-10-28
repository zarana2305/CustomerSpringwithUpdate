<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "find.obj">
	<!-- Enter Id: <input type = "text" name = "custId"/>
	<input type = "submit" value = "submit"/> -->
	
	
Enter Id:
			<!-- <select id="custId"  name = "custId"> -->
			<select id="custId"  name = "custId" onchange="this.form.submit()">
			 <option><c:out value="--select--"></c:out></option> 
			<c:forEach items = "${idList}" var = "list">
				<option><c:out value="${list}"></c:out></option>
			</c:forEach>
					
			</select>
			<h4><a href = "begin.obj">Back to main page</a></h4>
			<!-- <input type = "submit" value = "submit"/>-->
		
		
 
	
</form>
</body>
</html>