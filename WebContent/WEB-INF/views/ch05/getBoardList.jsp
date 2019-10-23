<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mycompany.web.dto.*"%>


<%
	List<Ch05Dto> boardList = (List<Ch05Dto>) request.getAttribute("boardList");
%>


<table class="table table-sm">
	<thead>
		<tr>
			<th scope="col">번호</th>
			<th scope="col">제목</th>
			<th scope="col">글쓴이</th>
			<th scope="col">날짜</th>
			<th scope="col">조회수</th>
		</tr>
</thead>

<tbody>
<%
	for (Ch05Dto board : boardList) {
%>

<tr>
	<th scope="row"><%=board.getBno()%></th>
	<td><%=board.getBtitle()%></td>
	<td><%=board.getWriter()%></td>
	<td><%=board.getDate()%></td>
	<td><%=board.getHitcount()%></td>
</tr>


<%
	}
%>


</tbody>
</table>