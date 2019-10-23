<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	function checkForm() {
			
			var result = true;
			
			// 모든 error 내용 지우기
			$(".error").text(""); // 클래스가 error인것을 다 찾아라, 단순히 텍스트만이면 text
			
			// 입력값 겁사
			if($("#btitle").val() == "") {
				$("#btitleError").text("*제목을 입력하세요");			
				result = false;
			}
			<%--
			if($("#bwriter").val() == "") {
				$("#bwriterError").text("*글쓴이를 입력하세요");			
				result = false;
			}
			--%>
			if($("#bcontent").val() == "") {
				$("#bcontentError").text("*내용을 입력하세요");			
				result = false;
			}
																																			
			return result;																	
	}
</script>


</head>

<body>

	<h5>게시물 수정</h5>
	
	<form method="post" action="updateBoard" onsubmit="return checkForm()"> <!-- #은 현재 페이지를 나타내는것, writeBoard는  -->
		<input type="hidden" name="bno" value="${board.bno}"/>
		<div class="form-group">
			<label for="btitle">Title</label>
			<input id="btitle" name="btitle" value="${board.btitle}"
				type="text" class="form-control" placeholder="제목을 입력하세요">
			<span id="btitleError" class="error" style="color: red"></span>
		</div>
		<%--
		<div class="form-group">
			<label for="bwriter">Writer</label>
			<input id="bwriter"
				name="bwriter" type="text" class="form-control" placeholder="글쓴이를 입력하세요"> 
			<span id="bwriterError" class="error" style="color: red"></span>
		</div>
		--%>
		<div class="form-group">
			<label for="bcontent">Content</label>
			<textarea class="form-control" id="bcontent" name="bcontent" rows="3"
				placeholder="내용을 입력하세요">${board.bcontent}</textarea>
			<span id="bcontentError" class="error" style="color: red"></span>
		</div>

		<div class="form-group">
			<input type="submit" class="btn btn-success" value="글수정"/>
		</div>

	</form>



</body>
</html>