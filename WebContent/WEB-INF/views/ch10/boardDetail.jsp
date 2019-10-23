<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
<%-- jsp는 8080까지만 생략됨, 상대경로로 찾아가기는 너무 복잡, 그래서 절대 경로로함 --%>
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
	
</script>


</head>

<body>

	<h5>게시물 내용</h5>

	<form>
		<!-- #은 현재 페이지를 나타내는것, writeBoard는  -->
		<%-- 
		<div class="form-group">
			<label for="bno">No</label>
			<input id="bno" type="text" class="form-control" value="${board.bno}" readonly>
		</div>
		--%>
		<div class="form-group">
			<label for="btitle">Title</label>
			<input id="btitle" type="text" class="form-control" value="${board.btitle}" readonly>
		</div>
		<%-- 
		<div class="form-group">
			<label for="bwriter">Writer</label>
			<input class="form-control" id="bwriter" type="text" value="${board.bwriter}" readonly>
		</div>
		--%>
		<div class="form-group">
			<label for="bhitcount">HitCount</label>
			<input class="form-control" id="bhitcount" type="text" value="${board.bhitcount}" readonly>
		</div>
		
		<div class="form-group">
			<label for="bdate">Date</label>
			<input id="bdate" type="text" class="form-control" 
		    	value='<fmt:formatDate value="${board.bdate}" pattern="yyyy년 MM월 dd일"/>' readonly>
		</div>
		
		<div class="form-group">
			<label for="bcontent">Content</label>
			<textarea class="form-control" id="bcontent" rows="3" readonly>${board.bcontent}</textarea>
		</div>

	</form>
	
	<a href="boardList?pageNo=${pageNo}" class="btn btn-primary">목록</a>
	
	<c:if test="${board.bwriter == mid}">
		<a href="updateBoard?bno=${board.bno}" class="btn btn-success">수정</a>
		<a href="deleteBoard?bno=${board.bno}" class="btn btn-danger">삭제</a>
	</c:if>
	
	
	
	
	
</body>
</html>