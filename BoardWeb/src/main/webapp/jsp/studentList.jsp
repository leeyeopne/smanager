<%@page import="com.yedam.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.mapper.StudentMapper"%>
<%@page import="com.yedam.common.DataSource"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<thead><tr><th>학번</th><th>이름</th><th>전화번호</th></tr></thead>
<tbody>
	<%
	SqlSession sqlSeesion = DataSource.getInstance().openSession(true);
	StudentMapper mapper = sqlSeesion.getMapper(StudentMapper.class);
	List<StudentVo> list = mapper.studentList();
	
	for(StudentVo svo : list){
		
	%>
	<tr><td><a href="student.jsp?sno=<%= svo.getStdNo() %>"><%= svo.getStdNo() %></a></td>
		<td> <%= svo.getStdName() %></td>
		<td>  <%= svo.getStdPhone() %></td>
	</tr>
	<%} %>
	</tbody>
	</table>
</body>
</html>