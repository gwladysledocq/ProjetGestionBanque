<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<link href="<c:url value="/css/groupeStyle.css"/>" rel="stylesheet">
<link
	href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operation</title>
<!-- com -->
</head>
<body>
	<script type="text/javascript">
	
		function validateGetComptes() {

			var selectGetComptes = document.getElementById("getComptes");

			var selectGetComptesError = document.getElementById("getComptesError");

			if (selectGetComptes.selectedIndex == 0) {
				selectGetComptesError.innerHTML = "Veuillez choisir un compte !";
				selectGetComptesError.style.color = "red";
				return false;
			}
			
			return true;
		}

		function validate() {

			var selectValidateType = document.getElementById("validateType");
			var selectValidateIdCompte = document.getElementById("validateIdCompte");
			var selectValidateIdEmploye = document.getElementById("validateIdEmploye");
			var fieldValidateMontant = document.getElementById("validateMontant");
			
			var selectFormError = document.getElementById("formError");

			if (fieldValidateMontant.length == 0 ||
					selectValidateType.selectedIndex == 0 ||
					selectValidateIdCompte.selectedIndex == 0 ||
					selectValidateIdEmploye.selectedIndex == 0) {
				selectFormError.innerHTML = "Veuillez remplir tous les champs !";
				selectFormError.style.color = "red";
				return false;
			}
			return true;
		}
		
		function validateVirement() {

			var selectValidateIdCompte = document.getElementById("validateIdCompteVirement");
			var selectValidateIdCompte2 = document.getElementById("validateIdCompte2Virement");
			var selectValidateIdEmploye = document.getElementById("validateIdEmployeVirement");
			var fieldValidateMontant = document.getElementById("validateMontantVirement");
			
			var selectFormError = document.getElementById("formErrorVirement");

			if (fieldValidateMontant.length == 0 ||
					selectValidateIdCompte2.selectedIndex == 0 ||
					selectValidateIdCompte.selectedIndex == 0 ||
					selectValidateIdEmploye.selectedIndex == 0) {
				selectFormError.innerHTML = "Veuillez remplir tous les champs !";
				selectFormError.style.color = "red";
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
					<li class="active"><a href="#">Operation<span
							class="sr-only">(current)</span></a></li>

					<li><a href="<c:url value="banque"/>">Banque</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section>
		<div>
			<h1>Afficher les opérations</h1>
			<form action="getOperationsOfCompteOfClient" method="post"
				onsubmit="return validateGetComptes();">
				<h3>Afficher les opérations d'un compte :</h3>
				<div>
					<span id="getComptesError" class="alert-link"></span>
				</div>
				<table>
					<tr>
						<td>Choisissez le numéro du compte :</td>
						<td><select name="idCompte" id="getComptes">
								<option value="">Choisir</option>
								<c:forEach items="${operationModel.tabCompte}" var="com">
									<option value="${com.idCompte}">${com.idCompte}</option>
								</c:forEach>
						</select></td>
						<td><input type="submit" name="getOperationsOfCompteOfClient"
							value="Choisir" onclick="validateGetComptes()"></td>
					</tr>
				</table>
				<c:if test="${operationModel.idCompte != null}">
					<table>
						<tr>
							<td>Compte choisi : ${operationModel.idCompte }</td>
						</tr>
					</table>
					<table class="table">
						<tr>
							<th>Id</th>
							<th>Date</th>
							<th>Employe</th>
						</tr>
						<c:forEach items="${operationModel.tabOperation}" var="op">
							<tr>
								<td>${op.idOperation}</td>
								<td>${op.dateOperation}</td>
								<td>${op.employe.nomEmploye}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</form>
		</div>

		<div>
		<h1>Réaliser une opération</h1>
			<form action="addOperationUnCompte" onsubmit="return validate();">
			<h3>Réaliser un retrait ou un versement</h3>
			<div>
					<span id="formError" class="alert-link"></span>
				</div>
				<table>
					<tr>
						<td class="excepetion">${operationModel.getExceptionSoldeInsuffisant().getMessage()}</td>
					</tr>
					<tr>
						<td>Type d'opération :</td>
						<td><select name="type" id="validateType">
								<option value="">Choisir une option</option>
								<option value="retrait">Retrait</option>
								<option value="versement">Versement</option>
						</select></td>
					</tr>
					<tr>
						<td>Numero de compte :</td>
						<td><select name="idCompte" id="validateIdCompte">
								<option>Choisir</option>
								<c:forEach items="${operationModel.tabCompte}" var="com">
									<option value="${com.idCompte}">${com.idCompte}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Nom de l'employé :</td>
						<td><select name="idEmploye" id="validateIdEmploye">
								<c:forEach items="${operationModel.tousEmploye}" var="emp">
									<option value="${emp.idEmploye}">${emp.nomEmploye}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Montant :</td>
						<td><input type="number" name="montant" id="validateMontant"></td>
					</tr>

					<tr>
						<td><input type="submit" name="addOperationUnCompte"
							value="Effectuer" onclick="validate()"></td>
					</tr>
				</table>
<%-- 			<c:if test="${operationModel.montant != 0}"> --%>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<th>Numéro du compte</th> -->
<!-- 					<th>Solde avant opération</th> -->
<!-- 					<th>Solde après opération</th> -->
<!-- 					<th>montant de l'opération</th> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<%-- 					<td>${operationModel.idCompte}</td> --%>
<%-- 					<td>${operationModel.soldeBefore}</td> --%>
<%-- 					<td>${operationModel.soldeAfter}</td> --%>
<%-- 					<td>${operationModel.montant}</td> --%>
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 			</c:if> --%>
			</form>
		</div>

		<div>
			<form action="addOperationVirement" onsubmit="return validateVirement();">
			<h3>Réaliser un virement</h3>
			<div>
					<span id="formErrorVirement" class="alert-link"></span>
				</div>
				<table>
					<tr>
						<td class="excepetion">${operationModel.getExceptionSoldeInsuffisant().getMessage()}</td>
					</tr>
					<tr>
						<td>Numero de compte à débiter:</td>
						<td><select name="idCompteDebite" id="validateIdCompteVirement">
								<option>Choisir</option>
								<c:forEach items="${operationModel.tabCompte}" var="com">
									<option value="${com.idCompte}">${com.idCompte}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Numero de compte à créditer:</td>
						<td><select name="idCompteCredite" id="validateIdCompte2Virement">
								<option>Choisir</option>
								<c:forEach items="${operationModel.tabCompte}" var="com">
									<option value="${com.idCompte}">${com.idCompte}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Nom de l'employé :</td>
						<td><select name="idEmploye" id="validateIdEmployeVirement">
								<option>Choisir</option>
								<c:forEach items="${operationModel.tousEmploye}" var="emp">
									<option value="${emp.idEmploye}">${emp.nomEmploye}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Montant :</td>
						<td><input type="number" name="montant" id="validateMontantVirement"></td>
					</tr>
					<tr>
						<td><input type="submit" name="addOperationVirement"
							value="Effectuer" onclick="validateVirement()"></td>
					</tr>
				</table>
			</form>
<!-- 			<table> -->
<!-- 				<tr> -->
<!-- 					<th>Numéro du compte crédité</th> -->
<!-- 					<th>Solde avant opération</th> -->
<!-- 					<th>Solde après opération</th> -->
<!-- 					<th>Numéro du compte dédité</th> -->
<!-- 					<th>Solde avant opération</th> -->
<!-- 					<th>Solde après opération</th> -->
<!-- 					<th>montant de l'opération</th> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<%-- 					<td>${operationModel.idCompteDebite}</td> --%>
<%-- 					<td>${operationModel.soldeBeforeDebite}</td> --%>
<%-- 					<td>${operationModel.soldeAfterDebite}</td> --%>
<%-- 					<td>${operationModel.idCompteCredite}</td> --%>
<%-- 					<td>${operationModel.soldeBeforeCredite}</td> --%>
<%-- 					<td>${operationModel.soldeAfterCredite}</td> --%>
<%-- 					<td>${operationModel.montant}</td> --%>
<!-- 				</tr> -->
<!-- 			</table> -->
		</div>
	</section>

	<script type="text/javascript"
		src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>

</body>
</html>