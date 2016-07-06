<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<link href="<c:url value="/css/groupeStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operation</title>

</head>
<body>
<script type="text/javascript">

function validate(){
	
	var fieldMontant      = document.getElementById("mntantValid").value;
	var fieldMontantError = document.getElementById("mntantValidError");
	
	var selectTypeOper      = document.getElementById("valdateTypeOper");
	
	
	if(selectTypeOper.selectedIndex == 0){
		alert("alert");
		return false;
	}
	
	
	if(fieldMontant.length ==0){
		fieldMontantError.innerHTML ="Vuillez renter un montant!";
		fieldMontantError.style.color="red";
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
				<a href="#"><img src="<c:url value="/css/image/logo.jpeg"/>" width=50px></a> <a
					class="navbar-brand" href="#">Gestion des Banques</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav nav-pills navbar-right">
					<li><a href="<c:url value="home"/>">Home</a></li>
					<li><a href="#">Client</a></li>
					<li><a href="#">Employé</a></li>
					<li><a href="#">Compte</a></li>
					<li><a href="<c:url value="groupe"/>">Groupe</a></li>
					<li class="active"><a href="#">Operation<span
							class="sr-only">(current)</span></a></li>
					
					<li><a href="#">Banque</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div>
		<form action="getOperationsOfCompteOfClient" method="post">
			<table>
				<tr>
					<td>Numéro du compte :</td>
					<td><select name="idCompte">
							<c:forEach items="${operationModel.tabCompte}" var="com">
								<option value="${com.idCompte}">${com.idCompte}</option>
							</c:forEach>
					</select></td>
					<td><input type="submit" name="getOperationsOfCompteOfClient"
						value="Choisir"></td>
				</tr>
			</table>
		</form>
		<table>
			<tr>
				<td>Compte choisi : ${operationModel.idCompte }</td>
			</tr>
		</table>
		<table>
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
	</div>

	<div>
		<form action="addOperationUnCompte" onsubmit="return validate();">
			<table>
				<tr>
					<td class="excepetion">${operationModel.getExceptionSoldeInsuffisant().getMessage()}</td>
				</tr>
				<tr>
					<td>Type d'opération :</td>
					<td><select name="type" id="valdateTypeOper">
					       <option value="">Choisir une option</option>
							<option value="retrait">Retrait</option>
							<option value="versement">Versement</option>
					</select></td>
				</tr>
				<tr>
					<td>Numero de compte :</td>
					<td><select name="idCompte">
							<c:forEach items="${operationModel.tabCompte}" var="com">
								<option value="${com.idCompte}">${com.idCompte}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Nom de l'employé :</td>
					<td><select name="idEmploye">
							<c:forEach items="${operationModel.tousEmploye}" var="emp">
								<option value="${emp.idEmploye}">${emp.nomEmploye}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Montant :</td>
					<td><input type="number" name="montant" id="mntantValid"></td>
				</tr>
				
				<tr>
					<td><input type="submit" name="addOperationUnCompte"
						value="Effectuer" onclick="validate()"></td>
				</tr>
			</table>
			<span id="mntantValidError"></span>
		</form>
		<table>
			<tr>
				<th>Numéro du compte</th>
				<th>Solde avant opération</th>
				<th>Solde après opération</th>
				<th>montant de l'opération</th>
			</tr>
			<tr>
				<td>${operationModel.idCompte}</td>
				<td>${operationModel.soldeBefore}</td>
				<td>${operationModel.soldeAfter}</td>
				<td>${operationModel.montant}</td>
			</tr>
		</table>
	</div>
	
	<div>
		<form action="addOperationVirement">
			<table>
				<tr>
					<td class="excepetion">${operationModel.getExceptionSoldeInsuffisant().getMessage()}</td>
				</tr>
				<tr>
					<td>Numero de compte à débiter:</td>
					<td><select name="idCompteDebite">
							<c:forEach items="${operationModel.tabCompte}" var="com">
								<option value="${com.idCompte}">${com.idCompte}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Numero de compte à créditer:</td>
					<td><select name="idCompteCredite">
							<c:forEach items="${operationModel.tabCompte}" var="com">
								<option value="${com.idCompte}">${com.idCompte}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Nom de l'employé :</td>
					<td><select name="idEmploye">
							<c:forEach items="${operationModel.tousEmploye}" var="emp">
								<option value="${emp.idEmploye}">${emp.nomEmploye}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Montant :</td>
					<td><input type="text" name="montant"></td>
				</tr>
				<tr>
					<td><input type="submit" name="addOperationVirement"
						value="Effectuer"></td>
				</tr>
			</table>
		</form>
		<table>
			<tr>
				<th>Numéro du compte crédité</th>
				<th>Solde avant opération</th>
				<th>Solde après opération</th>
				<th>Numéro du compte dédité</th>
				<th>Solde avant opération</th>
				<th>Solde après opération</th>
				<th>montant de l'opération</th>
			</tr>
			<tr>
				<td>${operationModel.idCompteDebite}</td>
				<td>${operationModel.soldeBeforeDebite}</td>
				<td>${operationModel.soldeAfterDebite}</td>
				<td>${operationModel.idCompteCredite}</td>
				<td>${operationModel.soldeBeforeCredite}</td>
				<td>${operationModel.soldeAfterCredite}</td>
				<td>${operationModel.montant}</td>
			</tr>
		</table>
	</div>

<script type="text/javascript" src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>

</body>
</html>