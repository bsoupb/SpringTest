<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/ajax/css/style.css" type="text/css">

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
 
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        
</head>
<body>
	
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<jsp:include page="nav.jsp" />
		<div>
			<h2 class="text-center mt-3">예약 목록 보기</h2>
			
			<table class="table text-center mt-3">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>진화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="booking" items="${bookingList }" >
						<tr>
							<td>${booking.name }</td>
							<td><fmt:formatDate value="${booking.date }" pattern="yyyy년 M월 d일" /></td>
							<td>${booking.day }</td>
							<td>${booking.headcount }</td>
							<td>${booking.phoneNumber }</td>
							
								<c:choose>
									<c:when test="${booking.state eq '대기중' }">
										<td class="text-info">${booking.state }</td>
									</c:when>
									<c:when test="${booking.state eq '확정'}">
										<td class="text-success">${booking.state }</td>
									</c:when>
									<c:when test="${booking.state eq '취소'}">
										<td class="text-danger">${booking.state }</td>
									</c:when>
									<c:otherwise>
										<td>${booking.state }</td>
									</c:otherwise>
								</c:choose>
							
							<td><button type="button" data-booking-id="${booking.id }" class="btn btn-danger btn-sm delete-Btn">삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<jsp:include page="footer.jsp" />
	</div>

	<script>
		$(document).ready(function(){
			$(".delete-Btn").on("click", function(){
				
				// 이벤트가 발생한 버튼의 data-booking-id 값을 얻어 온다
				
				let bookingId = $(this).data("booking-id");
				
				$.ajax({
					type:"get"
					, url:"/ajax/booking/delete"
					, data:{"id":bookingId}
					, success:function(data){
						if(data.result == "success"){
							location.reload();
						} else{
							alert("삭제 실패");
						}
					}
					, error:function(){
						alert("에러");
					}
				});
			});
		});
	</script>


		
</body>
</html>