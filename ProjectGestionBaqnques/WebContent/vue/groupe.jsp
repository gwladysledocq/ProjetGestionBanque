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
			<form action="saveGroupe" method="post">
				<table>
					<tr>
						<th>Ajouter un groupe :</th>
					</tr>
					<tr>
						<td class="excepetion">${groupeModel.nomVideException.getMessage()}</td>
					</tr>
					<tr>
						<td>Nom Groupe :</td>
						<td><input type="text" name="nomGroupe"></td>
						<td><input type="submit" name="SaveGroupe"
							value="Sauvegarder"></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<h1>Afficher les employés d'un groupe</h1>
			<form action="getEmployesOfGroupe" method="post">
				<table>
					<tr>
						<th>Afficher les employés d'un groupe :</th>
					</tr>
					<tr>
						<td>Nom du groupe :</td>
						<td><select name="idGroupe">
								<c:forEach items="${groupeModel.tabGroupe}" var="gr">
									<option value="${gr.idGroupe}">${gr.nomGroupe}</option>
								</c:forEach>
						</select></td>
						<td><input type="submit" name="SaveEmploye" value="Afficher"></td>
					</tr>
					<c:if test="${groupeModel.nomGroupe != null}">
						<tr>
							<td>Groupe choisi : ${groupeModel.nomGroupe}</td>
						</tr>
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
					</c:if>
				</table>
			</form>
		</div>
		<div>
			<h1>Ajouter un employé à un groupe</h1>
			<form action="addEmployesToGroupe" method="post">
				<table>
					<tr>
						<th>Ajouter un employé à un groupe :</th>
					</tr>
					<tr>
						<td>Nom du groupe :</td>
						<td><select name="idGroupeAdd">
								<c:forEach items="${groupeModel.tabGroupe}" var="gr">
									<option value="${gr.idGroupe}">${gr.nomGroupe}</option>
								</c:forEach>
						</select></td>
						<td>Nom de l'employé :</td>
						<td><select name="idEmployeAdd">
								<c:forEach items="${groupeModel.tousEmploye}" var="emp">
									<option value="${emp.idEmploye}">${emp.nomEmploye}</option>
								</c:forEach>
						</select></td>
						<td><input type="submit" name="SaveEmployeToGroupe"
							value="Ajouter"></td>
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