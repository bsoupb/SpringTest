<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자 득표율</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
	
	<h1 class="container">1. 후보자 득표율</h1>
	
	<div class="container">
		<table class="table text-center">
			<tr>
				<thead>
					<tr>
						<th>기호</th>
						<th>득표수</th>
						<th>득표율</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="candidate" items="${candidates }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td><fmt:formatNumber value="${candidate }" /></td>
							<td><fmt:formatNumber value="${candidate / 1000000 }" type="percent" /></td>
						</tr>						
					</c:forEach>
				</tbody>
			</tr>
		</table>
	</div>
	
	<h1 class="container">2. 카드 명세서</h1>
	
	<div class="container">
		<table class="table text-center">
			<thead>
				<tr>
					<th>사용처</th>
					<th>가격</th>
					<th>사용날짜</th>
					<th>할부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cardBill" items="${cardBillList }">
					<tr>
						<td>${cardBill.store }</td>
						<td><fmt:formatNumber value="${cardBill.pay }" type="currency" /></td>
						<fmt:parseDate value="${cardBill.date }" pattern="yyyy-MM-dd" var="date" />
						<td><fmt:formatDate value="${date }" pattern="yyyy년 M월 d일" /></td>
						<td>${cardBill.installment }</td>
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