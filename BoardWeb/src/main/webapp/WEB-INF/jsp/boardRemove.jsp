<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>
${board}
<form action="deleteBoard.do">
<input type="hidden" name="bno" value="${board.boardNo}">
<input type="hidden" name="page" value="${page}">
<table class="table">
    <tr>
        <th class="col-sm-3">글번호</th>
        <td class="col-sm-3">${board.boardNo}</td>
        <th class="col-sm-3">조회수</th>
        <td class="col-sm-3">${board.viewCnt}</td>
    </tr>
    <tr>
        <th>제목</th>
        <td colspan="3">${board.title}</td>
    </tr>
    <tr>
        <th colspan="3">내용</th>
        <td>${board.content}</td>
    </tr>
    <tr>
        <th>작성자</th>
        <td colspan="3">${board.writer}</td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button class="btn btn-primary" type="button">수정</button> <input
            class="btn btn-danger" type="submit" value="삭제">
        </td>
    </tr>
</table>
</form>
