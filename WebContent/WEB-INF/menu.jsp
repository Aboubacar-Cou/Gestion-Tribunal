<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<style>
.titre{
	background-color : #2c3e50;
	height : 120px;
	text-align : center;
	margin-top : 10px;
	padding : 5px;
	padding-top : 35px;
	border-bottom :10px solid yellow;
}
.titre h1{
	color: white;
	font-size : 35px;
}
.titre span{
	color : yellow;
	font-size : 20px;
}
.menu {
    background-color: #2c3e50;
    padding: 10px;
    text-align: center;
}

.menu ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

.menu ul li {
    display: inline-block;
    margin: 0 15px;
}

.menu ul li a {
    text-decoration: none;
    color: #ecf0f1;
    font-weight: bold;
    font-size: 16px;
    transition: color 0.3s ease;
}

.menu ul li a:hover {
    color: #f39c12;
}
.menu ul li a:focus {
    color: #f39c12;
}
	
</style>
<body>
		<div class="titre">
			<h1>Tribunal de Grande Instance</h1>
			<span>Systeme de Gestion des Affaire JuridiQues</span>
		</div>
			  <div class="menu">
                <ul>
            <li><a href="Accueil.jsp">Accueil</a></li>
            <li><a href="Enregistrermagistrat">Magistrats</a></li>
            <li><a href="Enregistreraffaire">Affaires</a></li>
            <li><a href="Enregistrerpartie">Parties</a></li>
            <li><a href="Enregistrerparticiper">Participations</a></li>
        </ul>
    </div>
</body>
</html>