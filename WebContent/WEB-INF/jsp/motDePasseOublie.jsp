<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mot de passe oublié</title>
</head>
<body>

	<%@ include file="../html/entete.html" %>

	<h1 style="text-align:center">Mot de passe oublié</h1>
	<h2 style="text-align:center">Veuillez saisir votre email pour réinitialiser votre mot de passe</h2>
	
	<form>
		<input type="email" id="email" name="email"/>
	</form>
	
	<button type="submit">Envoyer</button>
	
</body>
</html>