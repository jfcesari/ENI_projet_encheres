<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css"/>
<title>Mot de passe oublié</title>
</head>
<body>

	<%@ include file="../html/entete.html" %>

	<h1>Mot de passe oublié</h1>
	<p>Veuillez saisir votre email pour réinitialiser votre mot de passe</p>
	
	<form>
		<input class="champsMdp" type="email" id="email" name="email"/>
	</form>
	
	<a href="<%=request.getContextPath()%>/ServletConnexion"><button>Retour</button></a>
	
	<button type="submit">Envoyer</button>
	
</body>
</html>