<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/ajax/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
            <jsp:include page="header.jsp" />
            <jsp:include page="nav.jsp" />
            <section>
                <article class="banner-content">
                    <img id="img" src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg">
                    <!-- <button type="button" id="nextBtn">다음</button> -->
                </article>
                <article class="main-content d-flex">
                    <div class="reserved-content d-flex justify-content-center align-items-center">
                        <div class="text-left xx-large-font font-color">실시간 <br> 예약하기</div>
                    </div>
                    <div class="container py-2 confirm-content font-color">
                        <div class="pt-2 d-flex align-items-end">
                            <h3>예약 확인</h3>
                            <div class="ml-4">
                                <label>회원 <input type="radio" value="guest" name="member" checked></label>
                                <label>비회원 <input type="radio" value="noGuest" name="member"></label>
                            </div>
                        </div>
                        <div id="guestInput">
                            <div class="d-flex align-items-end mt-3">
                                <label id="idLabel">아이디</label> 
                                <input type="text" id="id" class="form-control col-8">
                            </div>
                            <div class="d-flex align-items-end mt-3">
                                <label id="passwordLabel">비밀번호</label> 
                                <input type="password" id="password" class="form-control col-8">
                            </div>
                        </div>
                        <div id="noGuestInput" class="d-none">    
                            <div class="d-flex align-items-end mt-3">
                                <label id="nameLabel">이름</label> 
                                <input type="text" id="name" class="form-control col-8">
                            </div>
                            <div class="d-flex align-items-end mt-3">
                                <label id="telLabel">전화번호</label> 
                                <input type="text" id="tel" class="form-control col-8">
                            </div>
                        </div>
                        <div class="d-flex justify-content-end">
                            <button type="button" class="btn btn-success mt-2" id="reservedBtn">조회하기</button>
                        </div>
                    </div>
                    <div class="tel-content d-flex justify-content-center align-items-center">
                        <div class="font-color">
                            <h3>예약문의 :</h3>
                            <h1>010-0000-0000</h1>
                       </div>
                    </div>
                </article>
            </section>
 			<jsp:include page="footer.jsp" />
        </div>

        <script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

        <script>
            $(document).ready(function() {
                
                $("input[name='member']").on("change", function() {
                    let member = $(this).val();
                    
                    if(member == "guest") {
                        $("#noGuestInput").addClass("d-none");
                        $("#guestInput").removeClass("d-none");
                    } else {
                        $("#noGuestInput").removeClass("d-none");
                        $("#guestInput").addClass("d-none");
                    }
                });

                $("#reservedBtn").on("click", function() {
                    // 라디오 버튼의 선택된 태그 객체 얻기

                    let member = $("input[name='member']:checked").val();                    

                    let name = $("#name").val();
                    let tel = $("#tel").val();
                    let id = $("#id").val();
                    let password = $("#password").val();
                    let reservedDate = $("#reservedDate").val();

                    if(member == "guest") { // 회원이 선택된 상태
                        if(id == "") {
                            alert("아이디를 입력해 주십시오.");
                            $("#id").focus();
                            return;
                        }

                        if(password == "") {
                            alert("비밀번호를 입력해 주십시오.");
                            $("#password").focus();
                            return;
                        }
                    } else { // 비회원이 선택된 상태
                        if(name == "") {
                            alert("이름을 입력해 주십시오.");
                            $("#name").focus();
                            return;
                        }

                        if(tel == "") {
                            alert("휴대전화번호를 입력해 주십시오.");
                            $("#tel").focus();
                            return;
                        }

                        // if(tel.substring(0, 3) != "010") {
                        //     alert("입력하신 휴대전화번호를 확인해 주십시오.");
                        //     $("#tel").focus();
                        //     return;
                        // }

                        if(!tel.startsWith("010")) {
                            alert("010으로 시작하는 번호만 입력 가능합니다.");
                            return;
                        }
                        
                        if(!())

                   }

                });

                var bannerImg = ["http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg"
                                , "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner2.jpg"
                                , "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner3.jpg"
                                , "http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner4.jpg"
                                ];

                var currentIndex = 0;

                intervalImg = setInterval(function() {
                    currentIndex++;
                    
                    if(currentIndex == bannerImg.length) {
                        currentIndex = 0;
                    }
                    
                    $("#img").attr("src", bannerImg[currentIndex]);
                }, 3000);

                // $("#nextBtn").on("click", function() {
                //     currentIndex++;

                //     if(currentIndex == bannerImg.length) {
                //         currentIndex = 0;
                //     }
                //     $("img").attr("src", bannerImg[currentIndex]);
                // });

                
            });
        </script>

</body>
</html>