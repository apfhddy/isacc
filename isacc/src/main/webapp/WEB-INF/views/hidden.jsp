<%@page import="locations.LocationsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<LocationsDTO> locatoins = (List<LocationsDTO>)request.getAttribute("locationsList"); %>
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
	  width: 33px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="${pageContext.request.contextPath }/insertItem" method="post">
			<div id = "locations" style="display: none; margin-left: 20%; position: absolute; border: 1px solid; z-index: 1; background-color: white">
				등장장소 설정
				<table border="1">
					<tr>
						<%for(int i = 0 ; i < locatoins.size(); i++){
							%><td><img src="resources/roomImg/<%=locatoins.get(i).getImage()%>"><input name = "locations" type = "checkbox" value="<%=locatoins.get(i).getLocation_no()%>"></td><%
							if((i+1) % 3 == 0){
								%></tr><tr><% 
							}
						}%>  
					</tr>
				</table>
			</div>
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
					<td>이미지*</td>
					<td><input name = "image" type="file"></td>
				</tr>
				<tr>
					<td>아이디*</td>
					<td><input name = "id" type="number"></td>
				</tr>
				<tr>
					<td>한글 이름*</td>
					<td><input name = "kr_name" type = "text"></td>
				</tr>
				<tr>
					<td>영어 이름*</td>
					<td><input name = "en_name" type = "text"></td>
				</tr>
				<tr>
					<td>한글 습득 대사*</td>
					<td><input name = "kr_line" type = "text"></td>
				</tr>
				<tr>
					<td>영어 습득 대사*</td>
					<td><input name = "en_line" type = "text"></td>
				</tr>
				<tr hidden="">
					<td>등급</td>
					<td>
						<select name = "quality">
							<option value = "0">0</option>
							<option value = "1">1</option>
							<option value = "2">2</option>
							<option value = "3">3</option>
							<option value = "4">4</option>
						</select>
					</td>
				</tr>
				<tr hidden="">
					<td>쿨타임*</td>
					<td><input name = "cooltime" type="number"></td>
				</tr>
				<tr>
					<td>언락 조건</td>
					<td><textarea rows="5" cols="40"></textarea></td>
				</tr>
				<tr>
					<td>효과*</td>
					<td><textarea name = "effect" rows="5" cols="40"></textarea></td>
				</tr>
				<tr hidden="">
					<td>황금 장신구<br>효과</td>
					<td><textarea name="goldaccessories" rows="5" cols="40"></textarea></td>
				</tr>
			</table>
			<input type="button" value="저장" onclick="checkSubmit(this.form)">
		</form>
	</div>
	<script type="text/javascript">
		inputDataChange(document.querySelector("form"))
		function inputDataChange(t) {
			let choice = +t.kind.value;
			const qualityTr = t.quality.parentElement.parentElement;
			const cooltimeTr = t.cooltime.parentElement.parentElement;
			const goldaccessoriesTr = t.goldaccessories.parentElement.parentElement;
			const locationsDiv = locations;
			
			qualityTr.setAttribute("hidden", "");
			cooltimeTr.setAttribute("hidden", "");
			locationsDiv.style.display = "none";
			goldaccessoriesTr.setAttribute("hidden", "");
			
			if(choice == 3){
				goldaccessoriesTr.removeAttribute("hidden");
				return
			}
			qualityTr.removeAttribute("hidden");
			locationsDiv.style.display = "";
			//등장 장소도 위에 처럼
			if(choice == 1)return;
			cooltimeTr.removeAttribute("hidden");
		}
		
		function checkSubmit(t) {
			let str = errMessage(t);
			if(str != undefined)alert(str);
		}
		function errMessage(t) {
			const imageCheck = t.image.value == "";
			const idCheck = t.id.value == "" || t.id.value <= 0;
			const kr_nameCheck = t.kr_name.value == "";
			const en_nameCheck = t.en_name.value == "";
			const kr_lineCheck = t.kr_line.value == "";
			const en_lineCheck = t.en_line.value == "";
			const effectCheck = t.effect.value == "";
			
			if(imageCheck)return '이미지를 등록해주세요';
			if(idCheck)return '아이디를 올바르게 입력해주세요';
			if(kr_nameCheck)return '한글이름을 입력해주세요';
			if(en_nameCheck)return '영어이름을 입력해주세요';
			if(kr_lineCheck)return '한글 습득 대사를 입력해주세요';
			if(en_lineCheck)return '영어 습득 대사를 입력해주세요';
			if(effectCheck)return '효과를 입력해주세요';
			t.submit();
		}
	</script>
</body>
</html>