<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
</style>
<body>
	<%@ include file="/WEB-INF/menu.jsp" %>
	<section>
    	<div style="text-align: center; padding: 50px 20px;">
        <h1>Bienvenue sur la Plateforme de Gestion du Tribunal</h1>
        <p>
            Cette application vous permet de gérer efficacement les dossiers judiciaires, 
            les audiences, les affaires et les intervenants du tribunal en toute simplicité.
        </p>
        <p>
            Grâce à cet outil, les greffiers, juges et administrateurs peuvent suivre 
            l'avancement des procédures, consulter l'historique des affaires et organiser 
            le calendrier des audiences de manière centralisée et sécurisée.
        </p>
        <div style="margin-top: 30px;">
            <a href="" style="margin: 0 10px;">Consulter les dossiers</a>
            <a href="" style="margin: 0 10px;">Voir les audiences</a>
        </div>
    	</div>
	</section>
	<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>