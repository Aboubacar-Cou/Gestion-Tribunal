<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<legend>Enregistrement Participer</legend>
		<form action="Enregistrerparticiper" method="post">
			<p>
				<label for="idpartie">ID_ParticiPer :</label>
				<input type="text" name="idpartie" id="idpartie" />
			</p>
			<p>
				<label for="numaf">NUM_AF :</label>
    			<select name="numaf" id="numaf">
        				<option value="#">Choisir un numéro d'affaire</option>
        			<c:forEach items="${laff}" var="a">
            			<option value="${a.numaf}">${a.numaf}</option>
        			</c:forEach>
    			</select>
			</p>
			<p>
				<label for="rolepartie">Role_Partie :</label>
				<input type="text" name="rolepartie" id="rolepartie" />
			</p>
			<p id="btn">
				<input type="submit" value="Ajouter" />
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
						<a href="suppParticiper?param=${part.idpartie}">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>