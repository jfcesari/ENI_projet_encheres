<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création de compte</title>
</head>
<body>

<%@ include file="../html/entete.html" %>

	<h1>Mon profil</h1>
	
	<form action="<%=request.getContextPath()%>/ServletConnection" method="post"> <!-- Mettre dans action le chemin de la page vers laquelle les infos seront envoyées -->
		<ul>
			<li>
				<label for="pseudo">Pseudo :</label>
				<input type="text" id="pseudo" name="pseudo"/> <!-- L'identifiant peut être le mail ou le pseudo -->
			</li>
			<li>
				<label for="nom">Nom :</label>
				<input type="text" id="nom" name="nom"/> <!-- Paramétrer le fait que le mdp apparaisse en * -->
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