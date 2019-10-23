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
		dispatcher2의 home
	</body>
</html>