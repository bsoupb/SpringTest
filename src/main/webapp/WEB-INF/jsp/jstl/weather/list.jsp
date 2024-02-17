<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="/jstl/css/style.css" type="text/css">
</head>
<body>
	
	<form method="get" action=""/jstl/weather/list">
	 	<div id="wrap">
			<section class="main d-flex">
				<jsp:include page="nav.jsp" />
				<article class="content">
					<div>
						<h2 class="container pt-3">과거 날씨</h2>
						<table class="table text-center">
							<thead>
								<tr>
									<th>날짜</th>
									<th>날씨</th>
									<th>기온</th>
									<th>강수량</th>
									<th>미세먼지</th>
									<th>풍속</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="weather" items="${weather }">
									<tr>
										<td><fmt:formatDate value="${weather.date }" pattern="yyyy년 M월 d일" /></td>
										<td>
											<c:choose>
												<c:when test="${weather.weather eq '맑음' }" >
													<img src="${weatherImage[0] }">
												</c:when>
												<c:when test="${weather.weather eq '구름조금' }" >
													<img src="${weatherImage[1] }">
												</c:when>
												<c:when test="${weather.weather eq '흐림' }" >
													<img src="${weatherImage[2] }">
												</c:when>
												<c:when test="${weather.weather eq '비' }" >
													<img src="${weatherImage[3] }">
												</c:when>
											</c:choose>
										</td>
										<td>${weather.temperatures }℃</td>
										<td>${weather.precipitation }mm</td>
										<td>${weather.microDust }</td>
										<td>${weather.windSpeed }km/h</td>
									</tr>
								</c:forEach>
							</tbody>
							<tbody>
							</tbody>
						</table>
					</div>
				</article>
			</section>
			<jsp:include page="footer.jsp" />
		</div>
	</form>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>	
</body>
</html>