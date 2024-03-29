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
		<a
			href="join?mid=fall&mname=홍길동&mpassword=12345&mage=25&mbirth=1995-12-25"
			class="btn btn-primary">get 방식 테스트</a> <a
			href="join2?mid=fall&mname=홍길동&mpassword=12345&mage=25&mbirth=1995-12-25"
			class="btn btn-primary">get 방식 테스트(객체로 받기)</a>
	</p>

	<p>
		<%-- <form method="post" action="join"> --%>
	<form id="joinForm" name="joinForm" method="post" action="join2">

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">아이디</span>
			</div>
			<input id="mid" name="mid" value="fall" type="text"
				class="form-control" placeholder="Username" aria-label="Username"
				aria-describedby="basic-addon1">
		</div>


		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">이름</span>
			</div>
			<input id="mname" name="mname" value="홍길동" type="text"
				class="form-control" placeholder="Username" aria-label="Username"
				aria-describedby="basic-addon1">
		</div>



		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">비밀번호</span>
			</div>
			<input id="mpassword" name="mpassword" value="12345" type="password"
				class="form-control" placeholder="Username" aria-label="Username"
				aria-describedby="basic-addon1">
		</div>



		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">나이</span>
			</div>
			<input id="mage" name="mage" value="25" type="number"
				class="form-control" placeholder="Username" aria-label="Username"
				aria-describedby="basic-addon1">
		</div>



		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">생년월일</span>
			</div>
			<input id="mbirth" name="mbirth" value="1995-12-25" type="date"
				class="form-control" placeholder="Username" aria-label="Username"
				aria-describedby="basic-addon1">
		</div>


		<input type="submit" class="btn btn-warning" />
	</form>
	</p>


	<p>
		<script type="text/javascript">
			function join() {
				/*
				// How1
				//if(mid == "") return;
				var mid = $("#joinForm #mid").val();
				var mname = $("#joinForm #mname").val();
				var mpassword = $("#joinForm #mpassword").val();
				var mage = $("#joinForm #mage").val();
				var mbirth = $("#joinForm #mbirth").val();
				var params = "";
				params += "mid=" + mid + "&";
				params += "mname=" + mname + "&";
				params += "mpassword=" + mpassword + "&";
				params += "mage=" + mage + "&";
				params += "mbirth=" + mbirth;
				
				window.location.href = "join2?" + params;
				*/
				
				// How2
				//var joinForm = document.querySelector("#joinForm"); // Id로 찾는거임
				//var joinForm = document.joinForm; // name이 있어야함
				//joinForm.submit(); // 이 메소드 하나로 submit한거 부를 수 있음
				
				
				// How3
				document.joinForm.submit(); // 역시 name이 있어야함
				
				
				
			}
		</script>
		<button onclick="join()" class="btn btn-warning">자바 스크립트를
			이용해서 데이터 전달</button>

	</p>



	<p>
		<script type="text/javascript">
			function joinAjax() {
				$.ajax({
					url: "join3",
					//mid=fall&mname=홍길동, 
					data: {mid:"fall", mname:"홍길동"},
					method: "post",
					success: function(data) {
						console.log(data);
						var html = "<span>mid: " + data.mid + "</span> <br/>";
						html += "<span>mname: " + data.mname + "</span>";
						$("#resultDiv").html(html);
						
					}
						
					
				});
			}
		</script>
		<button onclick="joinAjax()" class="btn btn-warning">Ajax를
			이용해서 데이터 전달</button>
			<div id="resultDiv">
			</div>
	</p>


</body>
</html>