<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/main.css"/>
<title>Mon compte</title>
</head>
<body>

	<%@ include file="../html/entete.html" %>
	<%@ include file="menuNavigation.jspf" %>

<h1>Mon compte</h1>

<c:if test="${!empty utilisateur}">
	<ul>
		<li>
			<p class="txtLabel">Pseudo : </p><p>${utilisateur.pseudo}</p>
		</li>
		<li>
			<p class="txtLabel">Nom : </p><p>${utilisateur.nom}</p>
		</li>
		<li>
			<p class="txtLabel">Prénom : </p><p>${utilisateur.prenom}</p> 
		</li>
		<li>
			<p class="txtLabel">Email : </p><p>${utilisateur.email}</p>
		</li>
		<li>
			<p class="txtLabel">Téléphone : </p><p>${utilisateur.telephone}</p>
		</li>
		<li>
			<p class="txtLabel">Rue : </p><p>${utilisateur.rue}</p>
		</li>
		<li>
			<p class="txtLabel">Code postal : </p><p>${utilisateur.codePostal}</p>
		</li>
		<li>
			<p class="txtLabel">Ville : </p><p>${utilisateur.ville}</p>
		</li>
	</ul>
</c:if>

<a href="<%=request.getContextPath()%>/ServletModifUtilisateur"><button>Modifier</button></a>
	

</body>
</html>