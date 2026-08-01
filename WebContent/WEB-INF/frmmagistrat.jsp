<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Link rel="stylesheet" type="text/css" href="style.css" />
<title>Gestion Tribunal</title>
</head>
<body>
<%@ include file="/WEB-INF/menu.jsp" %>
	<fieldset>
	<legend>Enregistrement Magistrat</legend>
	<form action="Enregistrermagistrat" method="post">
			<p>
				<label for="idmag">ID_MAG :</label>
				<input type="text" name="idmag" id="idmag" />
			</p>
			<p>
				<label for="nommag">Non_MAG :</label>
				<input type="text" name="nommag" id="nommag" />
			</p>
			<p>
				<label for="prenommag">Prenom_MAG :</label>
				<input type="text" name="prenommag" id="prenommag" />
			</p>
			<p id="btn">
				<input type="submit" value="Ajouter" />
				<input type="reset" value="Annuler" />
			</p>
		</form>
	</fieldset>	
	<br/><hr/><br/>
		<table border="1">
			<caption>Liste des Magistrats</caption>
			<tr>
				<th>IdMAG</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${lmag }" var="mag"> 
				<tr> 
					<td>${mag.idmag}</td>
					<td>${mag.nommag}</td>
					<td>${mag.prenommag}</td>
					<td>
						<a href="modifmagistrat?param=${mag.idmag}">Modifier</a>
						<a href="Suppmagistrat?param=${mag.idmag}">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>