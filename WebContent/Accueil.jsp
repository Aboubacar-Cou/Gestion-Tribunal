<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gestion Tribunal</title>
</head>
<style>
	*{
    	box-sizing: border-box;
    	margin: 0;
    	padding: 0;
	}
	body{
    	background-color: #f4f4f4;
		padding-bottom :30px; 
	}
	footer{
	width : 100%;
	height : 50px;
	background-color : white;
	border-radius : 10px;
	position : fixed;
	bottom : 0px;
	text-align : center;
	padding-top : 30px;
}
#para{
	color : black;
	margin-left : 250px;
}
</style>
<body>
	<%@ include file="/WEB-INF/menu.jsp" %>
	<section>
    	<div style="text-align: center; padding: 50px 20px;">
        <h1>Bienvenue sur la Plateforme de Gestion du Tribunal</h1>
        <p id="para">
            Cette application vous permet de gérer efficacement les dossiers judiciaires, 
            les audiences, les affaires et les intervenants du tribunal en toute simplicité.
        </p>
    	</div>
	</section>
	<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>