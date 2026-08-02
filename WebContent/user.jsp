<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<Link rel="stylesheet" type="text/css" href="style.css" />
<title>Connexion</title>
</head>
<body>
	
    <fieldset>
    <legend>Connexion</legend>
    <form action="Sconnecteruser" method="post">
        <p>
            <label for="iduser">Identifiant :</label>
            <input type="text" name="iduser" id="iduser" />
        </p>
        <p>
            <label for="motdepasse">Mot de passe :</label>
            <input type="password" name="motdepasse" id="motdepasse" />
        </p>
        <p id="btn">
            <input type="submit" value="Valider" />
        </p>
    </form>
    </fieldset>
</body>
</html>