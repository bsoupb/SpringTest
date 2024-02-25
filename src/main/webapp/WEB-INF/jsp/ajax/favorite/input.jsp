<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<h2>즐겨찾기 추가하기</h2>
		
		<label>제목</label>
		<input type="text" class="form-control" id="name">
		<label>주소</label>
		<div class="d-flex">	
			<input type="text" class="form-control col-11" id="url"> 
			<button type="button" class="btn btn-sm btn-info ml-3" id="DuplicateBtn">중복확인</button>
		</div>
		<div class="text-danger small d-none" id="duplicateText">중복된 url 입니다</div>
		<div class="text-info small d-none" id="availableText">저장 가능한 url 입니다</div>
		<div>
			<button type="button" class="btn btn-success btn-block mt-3" id="addBtn">추가</button>
		</div>
		
	</div>
	
	<script
	 src="https://code.jquery.com/jquery-3.7.1.min.js"
	 integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	 crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>	
	
	<script>
		$(document).ready(function(){
			
			$("#DuplicateBtn").on("click", function(){
				
				let url = $("#url").val();
				
				if(url == ""){
					alert("주소를 입력하세요");
					return;
				}
				
				// 주소가 http:// 로 시작하지 않고 https:// 로 시작하지 않으면 
				if(!(url.startsWith("http://") || url.startsWith("https://"))){
					alert("주소를 잘못 입력하셨습니다. 확인 해 주십시오.");
					$("#url").focus();
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorite/duplicate-url"
					, data:{"url":url}
					, success:function(data){
						if(data.isDuplicate){
							$("#duplicateText").removeClass("d-none");
							$("#availableText").addClass("d-none");
						} else{
							$("#duplicateText").addClass("d-none");
							$("#availableText").removeClass("d-none");
						}
					}
					, error:function(){
						alert("에러");
					}
				});
				
			});
			
			$("#addBtn").on("click", function(){
				
				let name = $("#name").val();
				let url = $("#url").val();
				
				if(name == ""){
					alert("제목을 입력하세요");
					return;
				}
				
				if(url == ""){
					alert("주소를 입력하세요");
					return;
				}
				
				

				// 주소가 http:// 로 시작하지 않고 https:// 로 시작하지 않으면 
				if(!(url.startsWith("http://") || url.startsWith("https://"))){
					alert("주소를 잘못 입력하셨습니다. 확인 해 주십시오.");
					$("#url").focus();
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorite/create"
					, data:{"name":name, "url":url}
					, success:function(data){
						if(data.result == "success"){
							// 성공 // {"result":"success"}
							location.href = "/ajax/favorite/list";
						} else {
							alert("저장 실패");
							// 실패 // {"result":"fail"}
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