<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
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
		
		<div class="container w-50">
			<h3 class="text-center mt-3">예약 하기</h3>
			<label class="mt-1">이름</label>
			<input type="text" class="form-control mt-1" id="nameInput">
			<label class="mt-1">예약날짜</label>
			<input type="text" class="form-control mt-1" id="date">
			<label class="mt-1">숙박일수</label>
			<input type="text" class="form-control mt-1" id="dayInput">
			<label class="mt-1">숙박인원</label>
			<input type="text" class="form-control mt-1" id="headcountInput">
			<label class="mt-1">전화번호</label>
			<input type="text" class="form-control mt-1" id="phoneNumberInput">
			<button type="button" class="btn btn-warning btn-block mt-3" id="addBtn">예약하기</button>
		</div>
	
		<jsp:include page="footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#addBtn").on("click", function(){
				
				let name = $("#nameInput").val();
				let date = $("#date").val();
				let day = $("#dayInput").val();
				let headcount = $("#headcountInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				if(name == ""){
					alert("이름을 입력해 주세요");
					return;
				}
				
				if(date == ""){
					alert("예약날짜를 입력해 주세요");
					return;
				}
				
				if(day == ""){
					alert("숙박일수를 입력해 주세요");
					return;
				}
				
				if(headcount == ""){
					alert("숙박인원을 입력해 주세요");
					return;
				}
				
				if(phoneNumber == ""){
					alert("전화번호를 입력해 주세요");
					return;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/booking/insert"
					, data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
					, success:function(data){
						if(data.result == "success"){
							location.href = "/ajax/booking/list";
						} else{
							alert("추가 실패");
						}
					}
					, error:function(){
						alert("에러");
					}
				});
			});
			
			
		});
	</script>
	
	<script>
		$("#date").datepicker({
			dateFormat:"yy년 mm월 dd일",
            dayNamesMin:["일", "월", "화", "수", "목", "금", "토"]
		});
	
	</script>
	
</body>
</html>