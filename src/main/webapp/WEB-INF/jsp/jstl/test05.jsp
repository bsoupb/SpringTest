<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function library</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
	
	<h1 class="container">회원 정보 리스트</h1>
	
	<div class="container">
		<table class="table">
			<thead class="text-center">
				<tr>
					<th>No</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>국적</th>
					<th>이메일</th>
					<th>자기소개</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${memberList }" varStatus="status">
					<tr>
						<td class="text-center">
							${status.count }
						</td>
						<td class="text-center">
							${member.name }
						</td>
						<td class="text-center">
							<c:choose>
								<c:when test="${fn:startsWith(member.phoneNumber, '010') }">
									${member.phoneNumber }
								</c:when>
								<c:otherwise>
									유효하지 않은 전화번호
								</c:otherwise>	
							</c:choose>
						</td>
						<td class="text-center">
							${fn:replace(member.nationality, "삼국시대", "삼국 - ") }
						</td>
						<td class="text-center">
							<b>${fn:split(member.email, "@")[0] }</b>
							@${fn:split(member.email, "@")[1] }
						</td>
						<td>
							${fn:substring(member.introduce, 0, 15) }
							<c:if test="${fn:length(member.introduce) > 15 }">
							...
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>