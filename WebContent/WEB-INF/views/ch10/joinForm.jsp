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
		$(".error").css("color", "red");

		// 입력값 겁사
		if ($("#mid").val() == "") {
			$("#midError").text("*ID를 입력하세요");
			result = false;
		}
		if ($("#mname").val() == "") {
			$("#mnameError").text("*이름을 입력하세요");
			result = false;
		}
		if ($("#mpassword").val() == "") {
			$("#mpasswordError").text("*비밀번호를 입력하세요");
			result = false;
		}

		return result;
	}
	
	function checkMid() {
		console.log("bbb");
		$.ajax({
			url: "checkMid",
			data: {mid:$("#mid").val()},
			success: function(data) {
				console.log("aaaa");
				if(data.result) {
					
					$("#midError").text("*사용할 수 있는 아이디입니다");
					$("#midError").css("color", "green");
					
				} else {
					
					$("#midError").text("*사용할 수 없는 아이디입니다");
					$("#midError").css("color", "red");
					
				}
					
			}
			
			
		});
		
		
	}
</script>


</head>

<body>

	<h5>회원가입</h5>

	<form method="post" action="join" onsubmit="return checkForm()">
		<!-- #은 현재 페이지를 나타내는것, writeBoard는  -->
		<%-- 
		<div class="form-group">
			<label for="mid">ID</label> <input id="mid" name="mid" type="text"
				 placeholder="아이디를 입력하세요"> <input
				type="button" value="중복체크" onclick="checkMid()"
				class="btn btn-warning" /> <span id="midError" class="error"
				style="color: red">${midError}</span>
				--%>
		<div class="form-group">
			  <label for="mid">ID</label>
			  <div class="input-group">
				<input id="mid" name="mid" type="text" class="form-control" placeholder="아이디를 입력하세요">
				<div class="input-group-append">
				  <input onclick="checkMid()" type="button" class="btn btn-danger" value="중복체크"/>
				</div>
			  </div>		
			  <span id="midError" class="error" style="color: red"></span>		
		  </div>
	
	
		<div class="form-group">
			<label for="mname">NAME</label> <input id="mname" name="mname"
				type="text" class="form-control" placeholder="이름을 입력하세요"> <span
				id="mnameError" class="error" style="color: red">${mnameError}</span>
		</div>

		<div class="form-group">
			<label for="mpassword">PASS</label> <input id="mpassword"
				name="mpassword" type="password" class="form-control"
				placeholder="비밀번호를 입력하세요"> <span id="mpasswordError"
				class="error" style="color: red">${mpasswordError}</span>
		</div>


		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="회원가입" />
		</div>

	</form>



</body>
</html>