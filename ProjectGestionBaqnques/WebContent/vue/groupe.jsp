<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<link href="<c:url value="/css/groupeStyle.css"/>" rel="stylesheet">
<link
	href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Groupe</title>
</head>

<body>

	<script type="text/javascript">
		function nomGroupeValidate() {

			var fieldnomGroupe = document.getElementById("nomGroupeValid").value;
			var fieldnomGroupeError = document
					.getElementById("nomGroupeValidError");

			if (fieldnomGroupe.length == 0) {
				fieldnomGroupeError.innerHTML = "Veuillez saisir un nom de groupe !";
				fieldnomGroupeError.style.color = "red";
				return false;
			}

			return true;
		}

		function nomGroupeValidateEmploye() {

			var selectValidateNomGroupe = document
					.getElementById("validatetNomGroupe");

			var selectValidateNomGroupeError = document
					.getElementById("validatetNomGroupeError");

			if (selectValidateNomGroupe.selectedIndex == 0) {
				selectValidateNomGroupeError.innerHTML = "Veuillez choisir un nom de groupe !";
				selectValidateNomGroupeError.style.color = "red";
				return false;
			}

			return true;
		}

		function addEmployeValidate() {

			var selectValidateGroupe = document
					.getElementById("validateGroupe");
			var selectValidateEmploye = document
					.getElementById("validateEmploye");
			
			var selectValidateError = document.getElementById("validateError");
			
			if(selectValidateGroupe.selectedIndex == 0 || selectValidateEmploye.selectedIndex == 0){
				selectValidateError.innerHTML = "Veuillez choisir un nom de groupe et un nom d'employé !";
				selectValidateError.style.color = "red";
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
					<li class="active"><a href="#">Groupe<span class="sr-only">(current)</span></a></li>
					<li><a href="<c:url value="operation"/>">Operation</a></li>
					<li><a href="<c:url value="banque"/>">Banque</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section>

		<div>
			<h1>Afficher les groupes</h1>
			<form action="getGroupes">
				<h3>Liste des groupes :</h3>
				<p>
					<input type="submit" name="getGroupe" value="Afficher">
				</p>

				<table class="table">
					<c:if test="${groupeModel.affichageGroupes == true}">
						<tr>
							<th>Id</th>
							<th>nomGroupe</th>
						</tr>
						<c:forEach items="${groupeModel.tabGroupe}" var="gr">
							<tr>
								<td>${gr.idGroupe}</td>
								<td>${gr.nomGroupe}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</form>
		</div>

		<div>
			<h1>Enregistrer un groupe</h1>
			<form action="saveGroupe" method="post"
				onsubmit="return nomGroupeValidate();">
				<h3>Ajouter un groupe :</h3>
				<div>
					<span id="nomGroupeValidError" class="alert-link"></span>
				</div>
				<table>
					<tr>
						<td>Entrez le nom du groupe :</td>
						<td><input type="text" name="nomGroupe" id="nomGroupeValid"></td>
						<td><input type="submit" name="SaveGroupe"
							value="Sauvegarder" onclick="nomGroupeValidate()"></td>
					</tr>
				</table>
			</form>
		</div>

		<div>
			<h1>Afficher les employés d'un groupe</h1>
			<form action="getEmployesOfGroupe" method="post"
				onsubmit="return nomGroupeValidateEmploye();">
				<h3>Afficher les employés d'un groupe :</h3>
				<div>
					<span id="validatetNomGroupeError" class="alert-link"></span>
				</div>
				<table>
					<tr>
						<td>Choisissez le nom du groupe :</td>
						<td><select name="idGroupe" id="validatetNomGroupe">
								<option value="">Choisir</option>
								<c:forEach items="${groupeModel.tabGroupe}" var="gr">
									<option value="${gr.idGroupe}">${gr.nomGroupe}</option>
								</c:forEach>
						</select></td>
						<td><input type="submit" name="SaveEmploye" value="Afficher les employés"
							onclick="nomGroupeValidateEmploye()"></td>
					</tr>
				</table>
				<c:if test="${groupeModel.nomGroupe != null}">
					<table>
						<tr>
							<td>Groupe choisi : ${groupeModel.nomGroupe}</td>
						</tr>
					</table>
					<table class="table">
						<tr>
							<th>Id</th>
							<th>nomEmploye</th>
						</tr>
						<c:forEach items="${groupeModel.tabEmploye}" var="emp">
							<tr>
								<td>${emp.idEmploye}</td>
								<td>${emp.nomEmploye}</td>
							</tr>
						</c:forEach>

					</table>
				</c:if>
			</form>
		</div>

		<div>
			<h1>Ajouter un employé à un groupe</h1>
			<form action="addEmployesToGroupe" method="post" onsubmit="return addEmployeValidate();">
				<h3>Ajouter un employé à un groupe :</h3>
				<div>
					<span id="validateError" class="alert-link"></span>
				</div>
				<table>
					<tr>
						<td>Choisir le nom du groupe :</td>
						<td><select name="idGroupeAdd" id="validateGroupe">
								<option value="">Choisir</option>
								<c:forEach items="${groupeModel.tabGroupe}" var="gr">
									<option value="${gr.idGroupe}">${gr.nomGroupe}</option>
								</c:forEach>
						</select></td>
						<td>Choisir le nom de l'employé :</td>
						<td><select name="idEmployeAdd" id="validateEmploye">
								<option value="">Choisir</option>
								<c:forEach items="${groupeModel.tousEmploye}" var="emp">
									<option value="${emp.idEmploye}">${emp.nomEmploye}</option>
								</c:forEach>
						</select></td>
						<td><input type="submit" name="SaveEmployeToGroupe"
							value="Ajouter" onclick="addEmployeValidate()"></td>
					</tr>
				</table>
			</form>
		</div>
	</section>

	<script type="text/javascript"
		src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>

</body>
</html>