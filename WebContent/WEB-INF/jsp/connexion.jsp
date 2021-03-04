<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
</head>
<body>

	<%@ include file="../html/entete.html" %>
	
	<form action="<%=request.getContextPath()%>/ServletConnection" method="post"> <!-- Mettre dans action le chemin de la page vers laquelle les infos seront envoyées -->
		<ul>
			<li>
				<label for="identifiant">Identifiant :</label>
				<input type="text" id="identifiant" name="identifiant"/> <!-- L'identifiant peut être le mail ou le pseudo -->
			</li>
			<li>
				<label for="motDePasse">Mot de passe :</label>
				<input type="text" id="motDePasse" name="motDePasse"/> <!-- Paramétrer le fait que le mdp apparaisse en * -->
			</li>
		</ul>
			
		<button type="submit">Connexion</button>
		
		<div class="checkbox">
			<label for="souvenirUtilisateur">
				<input type="checkbox" id="souvenirUtilisateur" name="souvenirUtilisateur" value="1"/> <!-- Quelle valeur attribuer ? Si nb récup =1, on enregistre, si non, on enregistre pas ? -->
				Se souvenir de moi
			</label>
		</div>
	
		<a href="motDePasseOublie.jsp">Mot de passe oublié</a> <!-- Vers quoi renvoit ce lien ? -->
		
	</form>

	
	
	<div class="button">
		<button onclick="creationCompteUtilisateur.jsp">Créer un compte</button> <!-- Ajouter le lien vers la page de création du compte utilisateur -->
	</div>


</body>
</html>