<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div><a href="/serverweb/member/list.do">부서 목록보기</a></div><!-- 물리적 경로 아님 -->
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/member/insert.do" method="POST" 
				name="myform">
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">아이디</label>
						<div class="col-sm-3">
							<input type="text" id="orgcode" name="id"
								placeholder="아이디" class="form-control"
								 required>
						</div>
					</div>

					
					
					<div class="form-group">
						<!-- 성명-->
						<label class="control-label col-sm-2" for="orgname">비번</label>
						<div class="col-sm-3">
							<input type="text" id="orgname" name="pass"
								placeholder="비번" class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 사번-->
						<label class="control-label col-sm-2" for="id">이름</label>
						<div class="col-sm-3">
							<input type="text" id="id" name="name"
								placeholder="이름" class="form-control" 
								minlength="4" required onkeyup="runAjax()">
							
						</div>
						<span id="checkVal"></span>
					</div>



				


					
					<div class="form-group">
						<!-- 패스워드-->
						<label class="control-label col-sm-2" for="pass">주소</label>
						<div class="col-sm-3">
							<input type="text" id="pass" name="addr"
								placeholder="주소" class="form-control" minlength="4" >

						</div>
					</div>
					<div class="form-group">
						<!-- 주소-->
						<label class="control-label col-sm-2" for="addr">부서코드</label>
						<div class="col-sm-3">
							<input type="text" id="addr" name="deptno" 
							placeholder="부서코드"
								class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 포인트-->
						<label class="control-label col-sm-2" for="point">입사일</label>
						<div class="col-sm-3">
							<input type="text" id="point" name="hiredate" 
							placeholder="입사일"
								class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 등급-->
						<label class="control-label col-sm-2" for="grade">포인트</label>
						<div class="col-sm-3">
							<input type="text" id="grade" name="point" 
							placeholder="포인트"
								class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="가입하기" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>