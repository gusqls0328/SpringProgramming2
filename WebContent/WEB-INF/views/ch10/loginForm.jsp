





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
			if($("#mid").val() == "") {
				$("#midError").text("*ID를 입력하세요");			
				result = false;
			}
			if($("#mpassword").val() == "") {
				$("#mpasswordError").text("*비밀번호를 입력하세요");			
				result = false;
			}
																																						
			return result;																	
	}
</script>


</head>

<body>

	<h5>로그인</h5>

	<form method="post" action="login" onsubmit="return checkForm()"> <!-- #은 현재 페이지를 나타내는것, writeBoard는  -->
		<div class="form-group">
			<label for="mid">ID</label>
			<input id="mid" name="mid"
				type="text" class="form-control" placeholder="아이디를 입력하세요">
			<span id="midError" class="error" style="color: red">${midError}</span>
		</div>

		<div class="form-group">
			<label for="mpassword">PASS</label>
			<input id="mpassword"
				name="mpassword" type="password" class="form-control" placeholder="비밀번호를 입력하세요"> 
			<span id="mpasswordError" class="error" style="color: red">${mpasswordError}</span>
		</div>

		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="로그인"/>
		</div>

	</form>
	
	
	
</body>
</html>





