<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<Link rel="stylesheet" type="text/css" href="style.css" />
<title>Gestion Tribunal</title>
</head>
<body>
<%@ include file="/WEB-INF/menu.jsp" %>
	<fieldset>
	<h2>Formulaire de Modification</h2>
	<form action="modifmagistrat" method="post">
			<p>
				<label for="idmag">ID_MAG :</label>
				<input type="text" name="idmag" id="idmag" value="${mag.idmag}" readonly/>
			</p>
			<p>
				<label for="nommag">Non_MAG :</label>
				<input type="text" name="nommag" id="nommag" value="${mag.nommag}"/>
			</p>
			<p>
				<label for="prenommag">Prenom_MAG :</label>
				<input type="text" name="prenommag" id="prenommag" value="${mag.prenommag}"/>
			</p>
			<p id="btn">
				<input type="submit" value="Enregistrer les modifications" />
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
			<c:forEach items="${lmag}" var="mag"> 
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