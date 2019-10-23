<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
<%-- jsp는 8080까지만 생략됨, 상대경로로 찾아가기는 너무 복잡, 그래서 절대 경로로함 --%>
<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>



</head>
<body>

		<form method="post" action="join">

	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="basic-addon1">아이디</span>
		</div>
		<input type="text" class="form-control" placeholder="Username"
			aria-label="Username" aria-describedby="basic-addon1">
	</div>
	
	
	

	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="basic-addon1">이름</span>
		</div>
		<input type="text" class="form-control" placeholder="Username"
			aria-label="Username" aria-describedby="basic-addon1">
	</div>
	
	
	

	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text" id="basic-addon1">비밀번호</span>
		</div>
		<input type="password" class="form-control" placeholder="Username"
			aria-label="Username" aria-describedby="basic-addon1">
	</div>
	
	<input type="submit" class="btn btn-warning"/>
	
	</form>
</body>
</html>