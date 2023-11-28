<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	textarea {
		font-size: 13px;
		font-weight: bold;
	}
	img {
	  image-rendering: pixelated;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	히든페이지<img width="33" style="" src="resources/roomImg/babyStore.png">
	히든페이지<img width="33" style="" src="resources/roomImg/woodChest.png">
	<div align="center">
		<form>
			<table border="1" >
				<tr>
					<td>종류</td>
					<td>
						<select name = "kind" onchange="inputDataChange(this.form)">
						<c:forEach var="kind" items="${kindList }">
							<option value="${kind.kind_no }">
								<c:choose>
									<c:when test="${kind.kind_no == 3}">장신구</c:when>
									<c:when test="${kind.kind_no == 1}">패시브</c:when>
									<c:when test="${kind.kind_no == 2}">액티브</c:when>
								</c:choose>
							</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="number"></td>
				</tr>
				<tr>
					<td>한글 이름</td>
					<td><input type = "text"></td>
				</tr>
				<tr>
					<td>영어 이름</td>
					<td><input type = "text"></td>
				</tr>
				<tr>
					<td>한글 습득 대사</td>
					<td><input type = "text"></td>
				</tr>
				<tr>
					<td>영어 습득 대사</td>
					<td><input type = "text"></td>
				</tr>
				<tr hidden="">
					<td>등급</td>
					<td><input name = "quality" type="number"></td>
				</tr>
				<tr hidden="">
					<td>쿨타임</td>
					<td><input name = "cooltime" type="number"></td>
				</tr>
				<tr hidden="">
					<td>등장 장소</td>
					<td><input name = "locations" type="number"></td>
				</tr>
				<tr>
					<td>언락 조건</td>
					<td><textarea rows="5" cols="40"></textarea></td>
				</tr>
				<tr>
					<td>효과</td>
					<td><textarea rows="5" cols="40"></textarea></td>
				</tr>
				<tr hidden="">
					<td>황금 장신구<br>효과</td>
					<td><textarea name="goldaccessories" rows="5" cols="40"></textarea></td>
				</tr>
			</table>
			<input type="button" value="저장">
		</form>
	</div>
	<script type="text/javascript">
		inputDataChange(document.querySelector("form"))
		function inputDataChange(t) {
			console.log(t.kind)
			let choice = +t.kind.value;
			const qualityTr = t.quality.parentElement.parentElement;
			const cooltimeTr = t.cooltime.parentElement.parentElement;
			const goldaccessoriesTr = t.goldaccessories.parentElement.parentElement;
			qualityTr.setAttribute("hidden", "");
			cooltimeTr.setAttribute("hidden", "");
			goldaccessoriesTr.setAttribute("hidden", "");
			
			if(choice == 3){
				goldaccessoriesTr.removeAttribute("hidden");
				return
			}
			qualityTr.removeAttribute("hidden");
			//등장 장소도 위에 처럼
			if(choice == 1)return;
			cooltimeTr.removeAttribute("hidden");
		}
	</script>
</body>
</html>