<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css"/>
<title>Modifier mon profil</title>
</head>
<body>
<%@ include file="../html/entete.html" %>
<%@ include file="menuNavigation.jspf" %>

	<h1>Modifier mon profil</h1>
	
	<form action="<%=request.getContextPath()%>/ServletModifUtilisateur" method="post"> <!-- Mettre dans action le chemin de la page vers laquelle les infos seront envoyées -->
		<ul>
			<li>
				<label class="txtLabel" for="newPseudo">Pseudo :</label>
				<input class="champs" type="text" id="newPseudo" name="newPseudo" value="${utilisateur.pseudo}" onFocus="this.value='';"/>
			</li>
			<li>
				<label class="txtLabel" for="newNnom">Nom :</label>
				<input class="champs" type="text" id="newNnom" name="newNnom" value="${utilisateur.nom}" onFocus="this.value='';""/>
			</li>
			<li>
				<label class="txtLabel" for="newPrenom">Prénom :</label>
				<input class="champs" type="text" id="newPrenom" name="newPrenom" value="${utilisateur.prenom}" onFocus="this.value='';""/>
			</li>
			<li>
				<label class="txtLabel" for="newEmail">Email :</label>
				<input class="champs" type="email" id="newEmail" name="newEmail" value="${utilisateur.email}" onFocus="this.value='';""/>
			</li>
			<li>
				<label class="txtLabel" for="newTelephone">Téléphone :</label>
				<input class="champs" type="text" id="newTelephone" name="newTelephone" value="${utilisateur.telephone}" onFocus="this.value='';""/>
			</li>
			<li>
				<label class="txtLabel" for="newRue">Rue :</label>
				<input class="champs" type="text" id="newRue" name="newRue" value="${utilisateur.rue}" onFocus="this.value='';""/>
			</li>
			<li>
				<label class="txtLabel" for="newCodePostal">Code postal :</label>
				<input class="champs" type="text" id="newCodePostal" name="newCodePostal" value="${utilisateur.codePostal}" onFocus="this.value='';""/>
			</li>
			<li>
				<label class="txtLabel" for="newVille">Ville :</label>
				<input class="champs" type="text" id="newVille" name="newVille" value="${utilisateur.ville}" onFocus="this.value='';""/>
			</li>
			<li>
				<label class="txtLabel" for="motDePasseActuel">Mot de passe actuel :</label>
				<input class="champs" type="password" id="motDePasseActuel" name="motDePasseActuel"/>
			</li>
			<li>
				<label class="txtLabel" for="newMotDePasse">Nouveau mot de passe :</label>
				<input class="champs" type="password" id="newMotDePasse" name="newMotDePasse"/>
			</li>
			<li>
				<label class="txtLabel" for="newConfirmationMotDePasse">Confirmation :</label>
				<input class="champs" type="password" id="newConfirmationMotDePasse" name="newConfirmationMotDePasse"/>
			</li>
		</ul>
		
		<div type="button">
			<button type="submit" value="submit">Enregistrer</button>
		</div>
			
	</form>

	<a href="<%=request.getContextPath()%>/ServletSupprUtilisateur"><button>Suppr compte</button></a>
			



</body>
</html>