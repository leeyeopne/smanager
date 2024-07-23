<%@page import="com.yedam.vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>actionForm.jsp</title>
</head>
<body>
	<h3>액선태크연습</h3>
	<%
	request.setAttribute("myName", "홍길동");
	StudentVo student = new StudentVo();
	student.setStdNo("100");
	student.setStdName("홍길동");
	request.setAttribute("student", student);
	String msg = "Hello";
	%>

	<c:set var="msg" value="Hello2"></c:set>
	<c:set var="age" value="20" />
	<!-- 열닫 태그 위에거랑 같음 -->
	<h3>Jsp Standard tag Libray & Expression Language</h3>
	<p>${10 + 4}</p>
	<p>${10 > 20}</p>
	<p>${'Hello' += 'World' }</p>
	<p>${10 > 5 ? '참' : '거짓' }</p>
	<p>이름은 ${myName}</p>
	<p>학생정보 ${student }</p>
	<p>학생이름은 ${student.stdName },학번은 ${student.stdNo }</p>
	<p>Msg 값은 ${msg }</p>

	<!-- 삼항연산자ㅣ -->
	<p>${age >= 20? '성인' : '미성년자' }</p>

	<!-- if문 -->
	<c:if test="${age >= 20 }">
		<p>성인</p>
	</c:if>

	<!-- if else  -->
	<c:choose>
		<c:when test="${age >=20 }">
			<p>성인</p>
		</c:when>
		<c:otherwise>
			<p>미성년자</p>
		</c:otherwise>
	</c:choose>

	<!-- 반복문 -->
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>${i }</p>
	</c:forEach>
	<p>구구단 4단 출력</p>
	<c:forEach var="n" begin="1" end="9">
		<p>4* ${n } = ${4*n }</p>
	</c:forEach>

</body>
</html>