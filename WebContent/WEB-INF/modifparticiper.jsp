<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h2>Formulaire de Modification</h2>
		<form action="Modifparticiper" method="post">
			<p>
				<label for="idpartie">ID_ParticiPer :</label>
				<input type="text" name="idpartie" id="idpartie" value="${part.idpartie}" readonly/>
			</p>
			<p>
				<label for="numaf">Numaf :</label>
				<input type="text" name="numaf" id="numaf" value="${part.numaf}" readonly/>
			</p>
			<p>
				<label for="rolepartie">Role_Partie :</label>
				<input type="text" name="rolepartie" id="rolepartie" value="${part.rolepartie}"/>
			</p>
			<p id="btn">
				<input type="submit" value="Enregistrer les modifications" />
				<input type="reset" value="Annuler" />
			</p>
		</form>
		</fieldset>
		<br/><hr/><br/>
		<table border="1">
			<caption>Liste des Participant</caption>
			<tr>
				<th>Id_Partie</th>
				<th>Numaf</th>
				<th>Rolepartie</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${lpart}" var="part"> 
				<tr> 
					<td>${part.idpartie}</td>
					<td>${part.numaf}</td>
					<td>${part.rolepartie}</td>
					<td>
						<a href="Modifparticiper?idpartie=${part.idpartie}&numaf=${part.numaf}">Modifier</a>
						<a href="suppParticiper?idpartie=${part.idpartie}&numaf=${part.numaf}">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>