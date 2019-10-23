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



</head>
<body>
	<h4>[요청 매핑]</h4>

	<p>
		<a href="getMethod" class="btn btn-primary">방식 테스트</a>
	</p>

	<p>
	<form method="post" action="postMethod">
		<input type="submit" value="post 방식 테스트" class="btn btn-primary">
		<%-- <button>post 방식 테스트</button>--%>
	</form>
	</p>

	<p>
		<a href="joinForm" class="btn btn-primary">회원 가입 양식 요청</a>
	</p>
		
	

</body>
</html>