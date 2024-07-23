<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>게시판 상세(board.jsp)</h3>
<form action="boardRemove.do">
	<input type="hidden" name="bno" value="${board.boardNo}"> <input
		type="hidden" name="page" value="${page}">
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
			<th>내용</th>
			<td colspan="3">${board.content}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer}</td>
		</tr>
		<c:choose>
			<c:when test="${empty board.image }">
			</c:when>
			<c:otherwise>
				<tr>
					<th>파일</th>
					<td colspan="3"><img width="250px" src="images/${board.image}"></td>
				</tr>
			</c:otherwise>
		</c:choose>

		<tr>
			<td colspan="2" align="center"><c:choose>
					<c:when test="${logid == board.writer }">
						<button class="btn btn-primary" type="button">수정</button>
						<input class="btn btn-danger" type="submit" value="삭제">
					</c:when>
					<c:otherwise>
						<button class="btn btn-primary" disabled type="button">수정</button>
						<input class="btn btn-danger" disabled type="submit" value="삭제">
					</c:otherwise>
				</c:choose></td>
		</tr>

	</table>
</form>

<script>
	document.querySelector('form>table button.btn.btn-primary')
			.addEventListener('click', function(e) {
				location.href = 'modifyBoard.do?bno=${board.boardNo}';
			}); //버튼태그찾기
</script>


