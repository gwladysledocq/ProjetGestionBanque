<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/css/banqueStyle.css"/>" rel="stylesheet">
<link
	href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page banques</title>
<body>
	<!-- Banque.jsp
Package: WebContent/vue
Author: Philippe
Version: 1.0.1
Date: 07/07/16 -->
	<script type="text/javascript">
		function validateAjouterBanque() {

			var selectTypeBanque = document.getElementById("typeBanqueMajer");

			var fieldNomAgenceAjouter = document
					.getElementById("nomAgenceAjouter").value;
			var fieldNomAgenceErrorAjouter = document
					.getElementById("nomAgenceErrorAjouter");
			var fieldAdrAgenceAjouter = document
					.getElementById("adrAgenceAjouter").value;
			var fieldAdrAgenceErrorAjouter = document
					.getElementById("adrAgenceErrorAjouter");
			var fieldCpAgenceAjouter = document
					.getElementById("cpAgenceAjouter").value;
			var fieldCpAgenceErrorAjouter = document
					.getElementById("cpAgenceErrorAjouter");

			if (selectTypeBanque.selectedIndex == 0) {
				alert("veuillez choisir un client a updater");
				return false;
			}

			if (fieldNomAgenceAjouter.length == 0) {
				fieldNomAgenceErrorAjouter.innerHTML = "veuillez rentrer un nom d agence";
				fieldNomAgenceErrorAjouter.style.color = "red";
				return false;
			}
			if (fieldAdrAgenceAjouter.lenght == 0) {
				fieldAdrAgenceErrorAjouter.innerHTML = "veuillez rentrer une adresse";
				fieldAdrAgenceErrorAjouter.style.color = "red";
				return false;
			}
			if (fieldCpAgenceAjouter.lenght == 0) {
				fieldCpAgenceErrorAjouter.innerHTML = "veuillez rentrer un code postal";
				fieldCpAgenceErrorAjouter.style.color = "red";
				return false;
			}
			return true;
		}

		function validateRecupererBanque() {

			var selectChoixBanque = document.getElementById("choixBanque");
			if (selectChoixBanque.selectedIndex == 0) {
				alert("veuillez choisir une banque");
				return false;
			}
			return true;

		}
	</script>
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
				<a href="#"><img src="<c:url value="/css/image/logo.jpeg"/>"
					width=50px></a> <a class="navbar-brand" href="#">Gestion des
					Banques</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav nav-pills navbar-right">
					<li><a href="<c:url value="home"/>">Home</a></li>
					<li><a href="<c:url value="client"/>">Client</a></li>
					<li><a href="<c:url value="indexEmploye"/>">Employé</a></li>
					<li><a href="<c:url value="indexCompte"/>">Compte</a></li>
					<li><a href="<c:url value="groupe"/>">Groupe</a></li>
					<li><a href="<c:url value="operation"/>">Operation</a></li>
					<li class="active"><a href="#">Banque<span class="sr-only">(current)</span></a></li>
				</ul>
			</div>
		</div>
	</nav>


	<section>
		<div>
			<h1>Afficher la liste des banques</h1>
			<form action="afficherBanque">
				<h3>Liste des banques :</h3>
				<table>
					<tr>
						<td><input type="submit" value="Chercher"
							name="afficherBanque"></td>
					</tr>
				</table>
				<table class="table">
					<tr>
						<th>Id</th>
						<th>nomAgence</th>
						<th>Adresse</th>
						<th>CodePostal</th>
					</tr>
					<c:forEach items="${banqueModel.tabBanque}" var="banq">
						<tr>
							<td>${banq.idBanque}</td>
							<td>${banq.nomAgence}</td>
							<td>${banq.adresse}</td>
							<td>${banq.codePostal}</td>
						</tr>
					</c:forEach>

				</table>
			</form>
		</div>

		<div>
			<h1>Ajouter une banque</h1>
			<form action="ajouterBanque" method="post"
				onsubmit="return validateAjouterBanque();">
				<h3>Ajouter une nouvelle agence bancaire</h3>
				<table>
					<tr>
						<td>Nom de l'agence : <input type="text" name="nomAgence"
							id="nomAgenceAjouter"> <span id="nomAgenceErrorAjouter"></span></td>
						<td>Adresse de l'agence : <input type="text" name="adrAgence"
							id="adrAgenceAjouter"> <span id="adrAgenceErrorAjouter"></span></td>
						<td>Code Postal de l'agence : <input type="text"
							name="cpAgence" id="cpAgenceAjouter"> <span
							id="cpAgenceErrorAjouter"></span></td>
						<td>Type de banque<select name="typeBanque"
							id="typeBanqueMajer">
								<option value="">Choisir</option>
								<option value="cic">CIC</option>
								<option value="bnp">BNP</option>
								<option value="lcl">LCL</option>
						</select></td>
						<td><input type="submit" value="Ajouter" name="ajouterBanque"
							onclick="validateAjouterBanque()"></td>
					</tr>

				</table>
			</form>
		</div>

		<div>
			<h1>Afficher les informations d'une banque</h1>
			<form action="afficherInfosBanque" method="post"
				onsubmit="return validateRecupererBanque();">
				<h3>Chercher une agence :</h3>
				<table>
					<tr>
						<td>Nom de l'agence :</td>
						<td><select name="idBanque" id="choixBanque">
								<option value="">Choisir</option>
								<c:forEach items="${banqueModel.tabBanque}" var="banq">
									<option value="${banq.idBanque}">${banq.nomAgence}</option>
								</c:forEach>
						</select></td>
						<td><input type="submit" value="Chercher la banque"
							name="afficherInfosBanque" onclick="validateRecupererBanque()"></td>
					</tr>
				</table>

				<h3>Agence :</h3>
				<table class="table">
					<tr>
						<th>idBanque</th>
						<th>nomAgence</th>
						<th>adresse</th>
						<th>codePostal</th>
					</tr>
					<tr>
						<td>${banqueModel.banque.idBanque}</td>
						<td>${banqueModel.banque.nomAgence}</td>
						<td>${banqueModel.banque.adresse}</td>
						<td>${banqueModel.banque.codePostal}</td>
					</tr>
				</table>

				<h3>Comptes :</h3>
				<table class="table">
					<tr>
						<th>Id</th>
						<th>solde</th>
						<th>dateDeCreation</th>
						<th>decouvert</th>
					</tr>
					<c:forEach items="${banqueModel.tabCompte}" var="c">
						<tr>
							<td>${c.getIdCompte()}</td>
							<td>${c.getSolde()}</td>
							<td>${c.getDateDeCreation()}</td>
							<td>${c.getDecouvert()}</td>
						</tr>
					</c:forEach>
				</table>

				<h3>Employés :</h3>
				<table class="table">
				  <tr>
				        <th>Id</th>
				        <th>nomEmploye</th>
			         </tr>
			        <c:forEach items="${banqueModel.tabEmploye}" var="e">
				         <tr>
					         <td>${e.idEmploye}</td>
					         <td>${e.nomEmploye}</td>
				         </tr>
			       </c:forEach>
				</table>
				
				<h3>Clients :</h3>
				<table class="table">
				 <tr>
						<th>Id</th>
						<th>nomClient</th>
						<th>prenomClient</th>
						<th>adrClient</th>
					</tr>
					<c:forEach items="${banqueModel.tabClient}" var="c">
						<tr>
							<td>${c.idClient}</td>
							<td>${c.nomClient}</td>
							<td>${c.prenomClient}</td>
							<td>${c.adrClient}</td>
						</tr>
					</c:forEach>
				</table>

				<%--			<label>idAgence</label> <input type="text" name="idBanque"> <input
				type="submit" value="Chercher la banque" name="afficherInfosBanque">
		

 		<c:forEach items="${Att.tabBanque}" var="x">

			<c:out value="${x.idBanque}"></c:out>
		</c:forEach>
		<table>
		<tr>
			<th>idBanque</th>
			<th>nomAgence</th>
			<th>adresse</th>
			<th>codePostal</th>
		</tr>
		<tr>
		<c:forEach items="${banqueModel.tabBanqueChoisie}" var="y">
			<td>${y.idBanque}</td>
			<td>${y.nomAgence}</td>
			<td>${y.adresse}</td>
			<td>${y.codePostal}</td>
		</c:forEach>
		</tr>
		</table> --%>
			</form>
		</div>


	</section>

	<script type="text/javascript"
		src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>

</body>
</html>