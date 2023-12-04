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
		margin-top: 0;
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
		background-color: gray;
		position: fixed;
	}
	#item{
		float:right;
		width: 80%;
		height: 100%;
	}
	font > img{
		width: 27px;
	}
	#popupBackGround{
		width: 100%;
		height: 100%;
		z-index: 998;
		background-color: rgba(0, 0, 0, 0.5);
		position: absolute;
	}
	#itemDetail{
		margin-top: 7%;
		z-index: 999;
		background-color: #515151;
		width: 80%;
		height: 60%;
		border: 4px solid;
		border-radius: 11px;
	}
	 #itemData{
		float: left;
		height: 100%;
		width: 50%;
	}
	 #itemVideo{
		float: left;
		height: 100%;
		width: 50%;
	}
	ul {
		padding-left: 6%;
	}
	#selectItems > div{
		font-size: 14;
		margin-bottom: 3px;
		margin-top: 3px;
		margin-left: 8px;
		margin-right: 8px;
	}
	.selectOne{
		border-radius: 10px;
		cursor: pointer;
		width: 0 auto;
	}
	.selectOne > img {
		width: 50;
	}
	.selectOne:hover {
		background-color: gray;	
	}
	#selectImg{
		width: 50; 
		border: 3px solid; 
		height: 50; 
		border-radius: 10px;
		cursor: pointer;
	}
	#selectImg > img{
		width: 50;
	}
	#selectItems{
		z-index: 9999;
		position: absolute;
		background-color: white;
		border-radius: 6px; 
		width: 160;
	}
	#itemSelect{
		margin-bottom: 1%;
		margin-left: 2.3%;
		margin-top: 1%;
	}
</style>
	<title>Home</title>
	<link rel="shortcut icon" href="#">
</head>
<body>
	<div id = "popupBackGround" style="display: none;" align="center">
		<div id = "itemDetail" align="center">
			<div id = "itemData" style="padding-top: 0.5%;" align="left">
				<div align="center">
					<h2 id = "detailTitle">dd</h2>
				</div>
				<div id = "detailID">
					
				</div>
			</div>
			<div id = "itemVideo">
				<div id = "itemSelect"  align="left">
					<div id = "selectImg" align="center">
						<img>
					</div>
					<div id = "selectItems" align="left" style="display: none">
						<div>기본</div>
						<div class="selectOne">
							<img>
						</div>
						<div>시너지</div>
					</div> 
				</div>
				<div>
					<video style="width:  95%; border-radius: 6px;" id = "video"  src="" controls="controls"></video>
				</div>
			</div>
		</div> 
	</div>
	<div id = "sideConsole" align="center" >
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
					<h4 style="margin-bottom: 1%;">언락 조건</h4>
					<div id = "unlock"></div>
				</div>
				<div>
					<h4 style="margin-bottom: 1%;">효과</h4>
					<div id = "effect"></div>
				</div>
			</div>
		</div>
	</div>
	<div id = "item">
	</div>
<script type="text/javascript">
	//아이템 jsonObject를 받아 메인에 배치하는 포문
	const items = ${itemList}
	items.forEach(i => {
		let img = document.createElement("img");
		img.setAttribute("src", "resources/itemImg/"+i["IMAGE"]);
		img.setAttribute("data-token", i["ID"]);
		item.appendChild(img);
	})
	//옆에 콘솔에 간략설명 띄우기 이벤트
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
				
		quality.children[oneItem["QUALITY"]].style.backgroundColor = "orange";
		
		textUlLi(unlock,oneItem["UNLOCK"]);

		textUlLi(effect,oneItem["EFFECT"] )
		
		if(oneItem["LOCATIONS"] != null){
			oneItem["LOCATIONS"].forEach(l => {
				locations.innerHTML += '<img src = "resources/roomImg/'+l["IMAGE"]+'">'					
			})
		}
	})
	//텍스트들 들여쓰기 적용 시키기
	function textUlLi(parentNode,text) {
		parentNode.innerHTML = "";
		if(text == null){
			parentNode.innerText = " - ";
			return;
		}
		const mainUl = document.createElement("ul");
		const texts = text.split("\r\n");
		let tapFirst = true;
		let newLi = null;
		let newUl = null;
		for(let i = 0; i < texts.length; i++){
			let checkStr = texts[i].trim()
			if(checkStr == "" || checkStr == "\t"){
				let ulAppendCheck = newUl != null && newUl.children.length != 0;
				if(ulAppendCheck){
					mainUl.appendChild(newUl);
				}
				break;
			}
			newLi = document.createElement("li");
			newLi.innerText = texts[i];
			if(texts[i].substr(0,1) == "\t"){
				if(tapFirst){
					tapFirst = false;
					newUl = document.createElement("ul");
				}
				newUl.appendChild(newLi);
				if(!tapFirst && i == texts.length -1)
					mainUl.appendChild(newUl);
			}else{
				if(!tapFirst){
					tapFirst = true;
					mainUl.appendChild(newUl);
				}
				mainUl.appendChild(newLi);
			}
		}
		parentNode.appendChild(mainUl);
	}
	//아이템 디테일 보여주는 이벤트
	item.addEventListener("click", function(e) {
		if(e.target.tagName == "IMG"){
			let index = (+e.target.getAttribute("data-token"))
			let oneItem = items[index-1];
			//popUp 백그라운드 활성화와 side콘솔 내용 가리기
			popupBackGround.style.display = "";
			sideConsole.children[0].style.display = "none"; 
			//itemSelector 이미지
			let targetSrc = "resources/itemImg/"+oneItem["IMAGE"];
			selectItems.children[1].children[0].src = targetSrc;
			selectImg.children[0].src = targetSrc;
			//itemdetail 내용 설정
			detailTitle.innerText = oneItem["EN_NAME"]+"("+oneItem["KR_NAME"]+")";
			// video  동영상 경로와 바로 재생
			video.src = "resources/itemVideo/"+index+".mp4";
		}
	});
	//밖에 클릭시 꺼지는 이벤트
	popupBackGround.addEventListener("click", function(e) {
		if(!itemDetail.contains(e.target) && !selectImg.contains(e.target) && !selectItems.contains(e.target)){
			popupBackGround.style.display = "none";
			video.src = "";
			video.pause(); 
		}
	})
	
	//
	selectImg.addEventListener('click', function(e) {
		function selectRemove(e){
			if(!selectItems.contains(e.target)){
				selectItems.style.display = "none";
				document.removeEventListener("mousedown",selectRemove);
			}
		} 
		document.addEventListener("mousedown",selectRemove);
		selectItems.style.display = "";
	})
	
	
</script>
</body>
</html>
