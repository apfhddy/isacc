<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<style type="text/css">
	body{
		margin: 0;
		padding: 0;
	}
	h4{
		margin-top: 0
	}
	img {
	  image-rendering: pixelated;
	  width: 70px;
	}
	#item > img{
	  cursor: pointer;
	}
	th{
		border: 1px solid;
		width: 10%; 
	}
	font{
		font-weight: normal; 
		word-break: break-all;
	}
	#sideConsole{
		float:left;
		width: 20%;
		height: 100%;
		background-color: gray
	}
	#item{
		float:right;
		width: 80%;
		height: 100%;
	}
	font > img{
		width: 30px;
	}
</style>
	<title>Home</title>
</head>
<body>
	<div id = "sideConsole" align="center">
		<div style = "display: none;">
			<div>
				<h2 id = "title" style="margin-bottom: 0;"></h2>
			</div>
			<div>
				<img id = "image">
			</div>
			<div align="left" style="margin-left: 2%; margin-right: 2%;">
				<div>
					<h4>ID : <font id = "id"></font></h4>
				</div>
				<div>
					<h4>습득 대사 : <font id = "line"></font></h4>
				</div>
				<div>
					<h4>언락 조건 : <font id = "unlock"></font></h4>
				</div>
				<div>
					<h4>등장 장소 : <font id = "locations"></font></h4>
				</div>
				<div style="overflow: hidden;">
					<h4 style="float: left;">등급 : 　</h4> 
					<table style="border-spacing: 0;">
						<tr id = "quality">
							<th>0</th>
							<th>1</th>
							<th>2</th>
							<th>3</th>
							<th>4</th>
						</tr>
					</table>
				</div>
				<div>
					<h4>효과 : <font id = "effect"></font></h4>
				</div>
			</div>
		</div>
	</div>
	<div id = "item">
	
	</div>
<script type="text/javascript">
	const items = ${itemList}
	items.forEach(i => {
		let img = document.createElement("img");
		img.setAttribute("src", "resources/itemImg/"+i["IMAGE"]);
		img.setAttribute("data-token", i["ID"]);
		
		img.addEventListener("click", function(e) {
			document.location.href='updateForm?key='+items[this.getAttribute("data-token")-1]["ITEM_NO"]
		});
		
		item.appendChild(img);
	})
	document.addEventListener("mousemove", function(e) {
		if(e.target.tagName != 'IMG' || !item.contains(e.target)){
			sideConsole.children[0].style.display = "none";
			return;
		}
		sideConsole.children[0].style.display = "";
		locations.innerHTML = '';
		quality.children[0].style.backgroundColor = "";
		quality.children[1].style.backgroundColor = "";
		quality.children[2].style.backgroundColor = "";
		quality.children[3].style.backgroundColor = "";
		quality.children[4].style.backgroundColor = "";
		
		let oneItem = items[(+e.target.getAttribute("data-token"))-1];
		title.innerHTML = oneItem["EN_NAME"]+"<br>("+oneItem["KR_NAME"]+")";
		
		image.setAttribute("src", "resources/itemImg/"+oneItem["IMAGE"]);
		
		id.innerText = oneItem["ID"];
		
		line.innerText = oneItem["EN_LINE"]+"("+oneItem["KR_LINE"]+")";
		
		unlock.innerHTML = (oneItem["UNLOCK"] == null) ? " - " : oneItem["UNLOCK"];
		
		quality.children[oneItem["QUALITY"]].style.backgroundColor = "orange";

		effect.innerHTML = oneItem["EFFECT"]
		
		if(oneItem["LOCATIONS"] != null){
			oneItem["LOCATIONS"].forEach(l => {
				locations.innerHTML += '<img src = "resources/roomImg/'+l["IMAGE"]+'">'					
			})
		}
	})
	
	
</script>
</body>
</html>
