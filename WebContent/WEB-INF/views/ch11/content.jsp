<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript"
			src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
		<script type="text/javascript"
			src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript"
			src="<%=application.getContextPath()%>/resources/js/paho-mqtt-min.js"></script>

		
		<script type="text/javascript">
		$(function() {
			//MQTT 브로커와 연결하기
			//192.168.2.13 - 이것이 호스트 이름(location.hostname), 좀더 동적으로 사용하기 위해 그대로 기술
			//Number(location.port) : 8080이 오는데, ActiveMQ는 61614가 할당
			client = new Paho.MQTT.Client(location.hostname, 61614, "clientId");
			client.onMessageArrived = onMessageArrived;
			client.connect({onSuccess:onConnect}); // 연결이 완료되었을때(onSuccess) onConnect가 자동으로 실행되게 함
			
			
		});
		
		function onConnect() {
			  client.subscribe("/drone/pub"); // World는 토픽 이름임
			  			  
			}
		
		
		// 메세지를 수신했을 때 자동으로 실행(콜백)되는 함수
		function onMessageArrived(message) {
			$("#divReceive").append(message.payloadString + "<br/>");
			
									
		}				
		
		//= function() {
			
			
		//}; // 함수도 변수에 대입할 수 있음
		
		
		// 브라우져에서 해석하는 순서는 위에서 아래로임
		
		
		function sendMessage() {
			var data = $("#inputData").val();
			
			var message = new Paho.MQTT.Message(data);
			message.destinationName = "/drone/sub";
			client.send(message);
			
		}
		
		</script>
		
		
		
	</head>
	
	<body>
	
		<input id="inputData" type="text"/>
		<button onclick="sendMessage()">보내기</button>
	
		<h4>수신된 메세지</h4>
		
		<div id="divReceive">
			
		</div>
		
		
		
	</body>
</html>