<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<Link rel="stylesheet" type="text/css" href="style.css" />
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
.menu ul li a::visited {
    color: #f39c12;
    border-bottom: 1px solid black;
}
	b{
	position : absolute;
	top : 10px;
	right : 20px;
	font-size : 25px;
	
	}
	b a{
	color : white;
	}
</style>
<body>
		<b><a href="Sconnecteruser" class="active">Se Deconnecter</a></b>
		<div class="titre">
			<h1>Tribunal de Grande Instance</h1>
			<span>Systeme de Gestion des Affaire JuridiQues</span>
		</div>
	<div class="menu">
        <ul>
            <li><a href="Accueil.jsp" class="active">Accueil</a></li>
            <li><a href="Enregistrermagistrat" class="active">Magistrats</a></li>
            <li><a href="Enregistreraffaire" class="active">Affaires</a></li>
            <li><a href="Enregistrerpartie" class="active">Parties</a></li>
            <li><a href="Enregistrerparticiper" class="active">Participations</a></li>
        </ul>
    </div>
    <script type="text/javascript" src="index.js"></script>
</body>
</html>