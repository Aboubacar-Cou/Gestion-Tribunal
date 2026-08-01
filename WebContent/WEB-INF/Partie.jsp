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
		<legend>Enregistrement Partie</legend>
		<form action="Enregistrerpartie" method="post">
			<p>
				<label for="idpartie">ID_Partie :</label>
				<input type="text" name="idpartie" id="idpartie" />
			</p>
			<p>
				<label for="libpartie">Lib_Partie :</label>
				<input type="text" name="libpartie" id="libpartie" />
			</p>
			<p>
				<label for="adrpartie">ADR_Partie :</label>
				<input type="text" name="adrpartie" id="adrpartie" />
			</p>
			<p>
				<label for="telpartie">Tel_Partie :</label>
				<input type="text" name="telpartie" id="telpartie" />
			</p>
			<p id="btn">
				<input type="submit" value="Enregistrer" />
				<input type="reset" value="Annuler" />
			</p>
		</form>
		</fieldset>
		<br/><hr/><br/>
			<table border="1">
			<caption>Liste des Participant</caption>
			<tr>
				<th>Id_Partie</th>
				<th>LibPartie</th>
				<th>AdrPartie</th>
				<th>TelPartie</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${lpart }" var="part"> 
				<tr> 
					<td>${part.idpartie}</td>
					<td>${part.libpartie}</td>
					<td>${part.adrpartie}</td>
					<td>${part.telpartie}</td>
					<td>
						<a href="Modifpartie?param=${part.idpartie}">Modifier</a>
						<a href="suppPartie?param=${part.idpartie}">Supprimer</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/piedpage.jsp" %>
</body>
</html>