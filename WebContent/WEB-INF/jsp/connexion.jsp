<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css"/>
<title>Connexion</title>
</head>
<body>

	<%@ include file="../html/entete.html" %>
	
	<h1>Se connecter</h1>
	
	<form action="<%=request.getContextPath()%>/ServletConnexion" method="post" action="j_security_check"> <!-- Mettre dans action le chemin de la page vers laquelle les infos seront envoyées -->
		<ul>
			<li>
				<label class="txtLabel" for="emailouPseudo">Identifiant :</label>
				<input class="champs" type="text" id="emailouPseudo" name="emailouPseudo"/> <!-- L'identifiant peut être le mail ou le pseudo -->
			</li>
			<li>
				<label class="txtLabel" for="motDePasse">Mot de passe :</label>
				<input class="champs" type="password" id="motDePasse" name="motDePasse"> <!-- Paramétrer le fait que le mdp apparaisse en * -->
			</li>
		</ul>
		<div class="checkbox">
			<label for="souvenirUtilisateur">
				<input type="checkbox" id="souvenirUtilisateur" name="souvenirUtilisateur" value="1"/> <!-- Quelle valeur attribuer ? Si nb récup =1, on enregistre, si non, on enregistre pas ? -->
				Se souvenir de moi
			</label>
		</div>
	
		<a class="mdpOublie" href="<%=request.getContextPath()%>/ServletMotDePasseOublie">Mot de passe oublié</a> <!-- Dois renvoyer vers une servlet qui retrouvera l'utilisateur + envoie un mail -->
		
		<div type="button">
			<button type="submit" value="submit">Connexion</button>
		</div>
		
	</form>

	<a href="<%=request.getContextPath()%>/ServletCreationUtilisateur"><button>Créer un compte</button></a> <!-- Ajouter le lien vers la page de création du compte utilisateur -->
		

</body>
</html>