<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/css/clientStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page Clients</title>
</head>
<body>
<!-- Client.jsp
Package: WebContent/vue
Author: Philippe
Version: 1.0.1
Date: 07/07/16 -->


<!-- validation champs/selects non vides -->
<script type="text/javascript">

function validateAjouterClient(){
	
	var fieldNomClientAjouter     = document.getElementById("nomValideAjouter").value;
	var fieldNomClientErrorAjouter = document.getElementById("nomValideErrorAjouter");
	var fieldPrenomClientAjouter = document.getElementById("prenomValideAjouter").value;
	var fieldPrenomClientErrorAjouter = document.getElementById("prenomValideErrorAjouter");
	var fieldAdrClientAjouter = document.getElementById("adrValideAjouter").value;
	var fieldAdrClientErrorAjouter = document.getElementById("adrValideErrorAjouter");
	

	if(fieldNomClientAjouter.length == 0){
		fieldNomClientErrorAjouter.innerHTML ="veuillez rentrer un nom";
		fieldNomClientErrorAjouter.style.color="red";
		return false; 
	}
	 if(fieldPrenomClientAjouter.length == 0){
		fieldPrenomClientErrorAjouter.innerHTML ="veuillez rentrer un prenom";
		fieldPrenomClientErrorAjouter.style.color="red";
		return false;
	}
	if(fieldAdrClientAjouter.length == 0){
		fieldAdrClientErrorAjouter.innerHTML ="veuillez rentrer un adresse";
		fieldAdrClientErrorAjouter.style.color="red";
		return false;
	} 
	return true;
}

function validateSupprimerClient(){
	
	var selectClientASupprimer = document.getElementById("clientASupprimer");
	if(selectClientASupprimer.selectedIndex == 0){
		alert("veuillez choisir un client a supprimer");
		return false;
	}

}

function validateMajerClient(){
	
	var selectIdClientAUpdater = document.getElementById("clientAUpdater");
	
	var fieldNomClientMajer     = document.getElementById("nomValideMajer").value;
	var fieldNomClientErrorMajer = document.getElementById("nomValideErrorMajer");
	var fieldPrenomClientMajer = document.getElementById("prenomValideMajer").value;
	var fieldPrenomClientErrorMajer = document.getElementById("prenomValideErrorMajer");
	var fieldAdrClientMajer = document.getElementById("adrValideMajer").value;
	var fieldAdrClientErrorMajer = document.getElementById("adrValideErrorMajer");
	
	if(selectIdClientAUpdater.selectedIndex == 0){
		alert("veuillez choisir un client a updater");
		return false;
	}

	if(fieldNomClientMajer.length == 0){
		fieldNomClientErrorMajer.innerHTML ="veuillez rentrer un nom";
		fieldNomClientErrorMajer.style.color="red";
		return false;
	}
	if(fieldPrenomClientMajer.lenght == 0){
		fieldPrenomClientErrorMajer.innerHTML ="veuillez rentrer un prenom";
		fieldPrenomClientErrorMajer.style.color="red";
		return false;
	}
	if(fieldAdrClientMajer.lenght == 0){
		fieldAdrClientErrorMajer.innerHTML ="veuillez rentrer un adresse";
		fieldAdrClientErrorMajer.style.color="red";
		return false;
	}
	return true;
}

function validateComptesClient(){
	
	var selectClientACompter = document.getElementById("clientACompter");
	if(selectClientACompter.selectedIndex == 0){
		alert("veuillez choisir un client a supprimer");
		return false;
	}
	return true;
}

function validateMotcleClient(){
	
	var fieldNomClientMotCle     = document.getElementById("nomValideMotCle").value;
	var fieldNomClientErrorMotCle = document.getElementById("nomValideErrorMotCle");
	
	if(fieldNomClient.length == 0){
		fieldNomClientErrorMotCle.innerHTML ="veuillez rentrer un nom";
		fieldNomClientErrorMotCle.style.color="red";
		return false;
	}
	return true;
}



</script>

<!-- barre de nagivation -->
<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#"><img src="<c:url value="/css/image/logo.jpeg"/>" width=50px></a> <a
					class="navbar-brand" href="#">Gestion des Banques</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav nav-pills navbar-right">
					<li><a href="<c:url value="home"/>">Home</a></li>
					<li class="active"><a href="#">Client<span
							class="sr-only">(current)</span></a></li>					
					<li><a href="<c:url value="indexEmploye"/>">Employé</a></li>
					<li><a href="<c:url value="indexCompte"/>">Compte</a></li>
					<li><a href="<c:url value="groupe"/>" >Groupe</a></li>
					<li><a href="<c:url value="operation"/>">Operation</a></li>
					<li><a href="<c:url value="banque"/>">Banque</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h1>Ici, c est la page clients</h1>
	
<!-- 	afficher clients -->
	<div>
		<form action="afficherClient"  method="post">
			<table>
				<tr>
					<th>Liste des clients :</th>
					<td><input type="submit" value="Chercher client"
						name="afficherClient"></td>
				</tr>
				<tr>
					<th>Id</th>
					<th>nomClient</th>
					<th>prenomClient</th>
					<th>adrClient</th>
				</tr>
				<c:forEach items="${clientModel.tabClient}" var="c">
					<tr>
						<td>${c.idClient}</td>
						<td>${c.nomClient}</td>
						<td>${c.prenomClient}</td>
						<td>${c.adrClient}</td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>

<!-- ajouter client -->
	<div>
		<form action="ajouterClient" method="post" onsubmit="return validateAjouterClient();">
			<table>
				<tr>
					<td>Ajouter un nouveau client</td>
					<td>Nom du client : <input type="text" name="nomClient" id="nomValideAjouter">
					<span id="nomValideErrorAjouter"></span></td>
					<td>Prenom du client : <input type="text" name="prenomClient"  id="prenomValideAjouter">
					<span id="prenomValideErrorAjouter"></span></td>
					<td>Adresse du client : <input type="text" name="adrClient"  id="adrValideAjouter">
					<span id="adrValideErrorAjouter"></span></td>

					<td><input type="submit" value="Ajouter" name="ajouterClient" onclick="validateAjouterClient()"></td>
				</tr>
			</table>
		</form>
	</div>

<!-- supprimer client -->
	<div>
		<form action="supprimerClient"  method="post" onsubmit="return validateSupprimerClient();">
			<table>
				<tr>
					<td>Supprimer un client</td>
					<td><select name="nomClient" id="clientASupprimer">
							<option value="">Choisir</option>
							<c:forEach items="${clientModel.tabClient}" var="cl">
								<option value="${cl.nomClient}">${cl.nomClient}</option>
							</c:forEach>
					</select></td>

					<td><input type="submit" value="Supprimer"
						name="supprimerClient" onclick="validateSupprimerClient()"></td>
				</tr>
			</table>
		</form>
	</div>

<!-- update client -->
	<div>
		<form action="majerClient"  method="post" onsubmit="return validateMajerClient();">
			<table>
				<tr>
					<td>Selectionner un client</td>
					<td><select name="nomClientChoisi" id="clientAUpdater">
							<option value="">Choisir</option>
							<c:forEach items="${clientModel.tabClient}" var="cl">
								<option value="${cl.nomClient}">${cl.nomClient}</option>
							</c:forEach>
					</select></td>
					<td>Changer infos</td>
					<td>Nom du client : <input type="text" name="nomClientUpdate" id="nomValideMajer">
					<span id="nomValideErrorMajer"></span></td>
					<td>Prenom du client : <input type="text" name="prenomClientUpdate"  id="prenomValideMajer">
					<span id="prenomValideErrorMajer"></span></td>
					<td>Adresse du client : <input type="text" name="adrClientUpdate" id="adrValideMajer">
					<span id="adrValideErrorMajer"></span></td>
					<td><input type="submit" value="Update" name="majerClient" onclick="validateMajerClient()"></td>
				</tr>
			</table>
		</form>
	</div>

<!-- afficher les comptes d un client -->
	<div>
		<form action="comptesClient"  method="post" onsubmit="return validateComptesClient();">
			<table>
				<tr>
					<td>Selectionner un client</td>
					<td><select name="nomClient" id="clientACompter">
							<option value="">Choisir</option>
							<c:forEach items="${clientModel.tabClient}" var="clie">
								<option value="${clie.nomClient}">${clie.nomClient}</option>
							</c:forEach>
					</select></td>
				<tr>
					<td>Tableau comptes</td>
					<c:forEach items="${clientModel.tabCompte}" var="com">
						<td>${com.solde}</td>
					</c:forEach>
					<td><input type="submit" value="Comptes" name="comptesClient" onclick="validateComptesClient()"></td>
				</tr>

			</table>
		</form>
	</div>

<!-- afficher les clients en fonction d un mot cle -->
	<div>
		<form action="motcleClient"  method="post" onsubmit="return validateMotcleClient();">
			<table>
				<tr>
					<td>Chercher un client par mot cle</td>
					<td>Nom du client : <input type="text" name="motCle" id="nomValideMotCle">
					<span id="nomValideErrorMotCle"></span></td>
				<tr>
					<th>Id</th>
					<th>nomClient</th>
					<th>prenomClient</th>
					<th>adrClient</th>
				</tr>
				<c:forEach items="${clientModel.tabClientTemp}" var="clien">
					<tr>
						<td>${clien.idClient}</td>
						<td>${clien.nomClient}</td>
						<td>${clien.prenomClient}</td>
						<td>${clien.adrClient}</td>
					</tr>
				</c:forEach>
				<tr><td><input type="submit" value="Rechercher" name="motcleClient" onclick="validateMotcleClient()"></td></tr>
			</table>
		</form>
	</div>

<!-- habillage du site	 -->
	<section>

		<p>
			<img class="fond" src="<c:url value="/css/image/fond2.jpg"/>" width=1520px>
		</p>
		<p class="presentation" >Site de gestion des Banques</p>

	</section>

	<script type="text/javascript" src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>
	
</body>
</html>