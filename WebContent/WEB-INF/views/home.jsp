<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			html, body {
				height:100%;
				margin: 0px;
				background-color: grey;
			}
			
			#wrapper {
				width:100%;
				height:96%;
				display:flex;
				flex-direction:column;
			}
		
			#header {
				border-bottom:1px solid black;
				margin-bottom:10px;
			}
		
			#content {
				flex-grow:1;
				display:flex;
				min-height:0;
			}
			
			#sideBar {
				width:400px;
				background-color:lightgray;
				padding-right:10px;
				border-right:1px solid black;
				overflow-y: scroll;
			}
			
			#center {
				flex-grow:1;
				padding:10px;
			}
			
			#center iframe {
				margin-top:0px;
				width:100%;
				height:100%;
			}
			
			#footer {
				border-top:1px solid black;
				margin-top:10px;
			}
		</style>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h3>SpringProgramming2</h3>
			</div>
			<div id="content">
				<div id="sideBar">
					<ul>
					
						<li><a href="info" target="iframe">컨트롤러 생성</a></li>
						<li><a href="ch02/content" target="iframe">요청 매핑</a></li>
						<li><a href="ch03/content" target="iframe">요청 파라메타</a></li>
						<li><a href="ch04/content" target="iframe">요청 헤더값과 쿠키값 설정 및 읽기</a></li>
						<li><a href="ch05/content" target="iframe">컨트롤러에서 뷰로 데이터 전달</a></li>
						<li><a href="ch06/content" target="iframe">매개변수 타입과  리턴 타입</a></li>
						<li><a href="ch08/content" target="iframe">파일 업로드</a></li>
						<li><a href="ch09/content" target="iframe">Dependency Injection</a></li>
						<li><a href="ch10/content" target="iframe">Database 연동</a></li>
						
					</ul>
				</div>
				<div id="center">
					<iframe name="iframe" src="http://tomcat.apache.org" frameborder="0"></iframe>
				</div>
			</div>
			<div id="footer">2019. IoT. K.H.B</div>
		</div>
	</body>
</html>