<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="/jstl/css/style.css" type="text/css">
</head>
<body>
	
	<form method="get" action="/jstl/weather/input">
		<div id="wrap">
			<section class="d-flex">
				<jsp:include page="nav.jsp" />
				<article>
					<div class="container">
						
						<h2 class="pt-2">날씨 입력</h2>
						
						<div class="container pt-3">
							<div class="d-flex align-items-center justify-content-between">
								<div class="date d-flex">
									<div>
										<label class="text-center" style="font-size:20px;">날짜</label> &nbsp;&nbsp;&nbsp;
									</div>
									<div>
										<input class="form-control" type="text" name="date">
									</div>
								</div>
								<div class="weather d-flex">
									<div>
										&nbsp;&nbsp;&nbsp;<label class="text-center" style="font-size:20px;">날씨</label> &nbsp;&nbsp;&nbsp;
									</div>
									<div>
										<select class="form-control" style="font-size:20px;" name="weather">
											<option>맑음</option>
											<option>구름조금</option>
											<option>흐림</option>
											<option>비</option>
										</select>
									</div>
								</div>
								<div class="microDust d-flex">
									<div>
										&nbsp;&nbsp;&nbsp;<label class="text-center" style="font-size:20px;" name="microDust">미세먼지</label> &nbsp;&nbsp;&nbsp;
									</div>
									<div>
										<select class="form-control" style="font-size:20px;">
											<option>좋음</option>
											<option>보통</option>
											<option>나쁨</option>
											<option>최악</option>
										</select>
									</div>
								</div>
								
							</div>
							<div class="d-flex align-items-center justify-content-between">
								<div class="temperatures d-flex pt-5">
									<div>
										<label class="text-center" style='font-size:20px !important;'>온도</label> &nbsp;&nbsp;&nbsp;
									</div>
									<div class="input-group mb-4">
									  <input type="text" style="font-size:20px" class="form-control" name="temperatures">
									  <div class="input-group-append">
									    <span class="input-group-text">℃</span>
									  </div>
									</div>
								</div>
								
								<div class="precipitation d-flex pt-5">
									&nbsp;&nbsp;&nbsp;<div>
										<label class="text-center" style="font-size:20px;">강수량</label> &nbsp;&nbsp;&nbsp;
									</div>
									<div class="input-group mb-4">
									  <input type="text" style="font-size:20px" class="form-control" name="precipitation">
									  <div class="input-group-append">
									    <span class="input-group-text">mm</span>
									  </div>
									</div>
								</div>
								<div class="windSpeed d-flex pt-5">
									<div>
										&nbsp;&nbsp;&nbsp;<label class="text-center" style="font-size:20px;">풍속</label> &nbsp;&nbsp;&nbsp;
									</div>
									<div class="input-group mb-4">
									  <input type="text" style="font-size:20px" class="form-control" name="windSpeed">
									  <div class="input-group-append">
									    <span class="input-group-text">km/h</span>
									  </div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</article>
			</section>
			<jsp:include page="footer.jsp" />
		</div>
	</form>
	
</div>
</body>
</html>