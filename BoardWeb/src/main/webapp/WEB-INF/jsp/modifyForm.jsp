<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>수정화면(modifyForm.jsp)</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>	
<form action="updateBoard.do">
	<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
	<table class="table">
		<tr>
			<th class="col-sm-3">글번호</th>
			<td class="col-sm-3"><%=board.getBoardNo()%></td>
			<th class="col-sm-3">조회수</th>
			<td class="col-sm-3"><%=board.getViewCnt()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title" value="<%=board.getTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" name="content"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input class="form-control" type="text" name="writer" value="<%=board.getWriter()%>"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button class="btn btn-primary" type="submit">수정</button> 
				<input class="btn btn-danger" type="submit" value="삭제">
			</td>
		</tr>

	</table>
</form>
<script>
    document.querySelector('form>table button.btn.btn-primary').addEventListener('click', function(e){
        location.href = 'updateBoard.do?bno=<%=board.getBoardNo()%>';
    }); //버튼태그찾기
</script>
