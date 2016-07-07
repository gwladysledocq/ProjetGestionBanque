<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<link href="<c:url value="/css/employeStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employe</title>

</head>
<body>

<script>

function validateAddEmploye(){

	var fieldValidateEmploye = document.getElementById("validateEmploye").value;
	var fieldValidateEmployeError = document.getElementById("validateEmployeError");
	
	if(fieldValidateEmploye.length ==0){
		fieldValidateEmployeError.innerHTML = "Veuillez entrer un nom !";
		fieldValidateEmployeError.style.color = "red";
		return false;
	}
	return true;
}

function getEmploye(){
	
	var selectValidateIdEmploye = document.getElementById("validateIdEmploye");
	var selectValidateIdEmployeError = document.getElementById("validateIdEmployeError");
	
	if(selectValidateIdEmploye.selectedIndex == 0){
		selectValidateIdEmployeError.innerHTML = "Veuillez choisir un nom !";
		selectValidateIdEmployeError.style.color = "red";
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
					<li ><a href="#">Home<span
							class="sr-only">(current)</span></a></li>
					<li><a href="<c:url value="client"/>">Client</a></li>
					<li class="active"><a href="<c:url value="indexEmploye"/>">Employé</a></li>
					<li><a href="<c:url value="indexCompte"/>">Compte</a></li>
					<li><a href="<c:url value="groupe"/>">Groupe</a></li>
					<li><a href="<c:url value="operation"/>">Operation</a></li>
					<li><a href="<c:url value="banque"/>">Banque</a></li>
				</ul>
			</div>
		</div>
	</nav>
<section>	
   <div>
       <h1>Enregistrer un employe</h1>
		<form action="addEmploye" method="post" onsubmit="return validateAddEmploye()">
		<div>
		<span id="validateEmployeError"></span>
		</div>
		   <table class="table">
		   
		    <tr>
				<td>Nom Employe</td>
				<td><input type="text" name="nom" id="validateEmploye"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Ajouter" onclick="validateAddEmploye()"/></td>
			</tr>
		   
		   </table>
		</form>
	</div>
</section>		
<section> 
   <div class="panel panel-default">
       <h1>Afficher les employés</h1>
		<form action="getListEmploye">
		  <div class="panel-heading">Liste des employés :</div>
		    <p>
			   <input type="submit" name="getListEmploye" value="Afficher">
		    </p>
			    <table class="table">
			      <c:if test="${employeModel.affichageEmployes == true}">
				     <tr>
				        <th>Id</th>
				        <th>nomEmploye</th>
			         </tr>
			        <c:forEach items="${employeModel.tabEmploye}" var="e">
				         <tr>
					         <td>${e.idEmploye}</td>
					         <td>${e.nomEmploye}</td>
				         </tr>
			       </c:forEach>
			    </c:if>
			</table>
		</form>
   </div>
</section>  			

<section>
        <div>
          <h1>Afficher les comptes créés par un employé</h1>
		  <form action="getComptesParEmploye" onsubmit="return getEmploye();">
		  <div>
		<span id="validateIdEmployeError"></span>
		</div>
			<table class="table">
				<tr>
					<td>Nom de l'employe :</td>
					<td><select name="idEmploye" id="validateIdEmploye">
							<option>Choisir</option>
							<c:forEach items="${employeModel.tabEmploye}" var="e">
								<option value="${e.idEmploye}">${e.nomEmploye}</option>
							</c:forEach>
					</select>
					</td>
					<td><input type="submit" value="Afficher les comptes" onclick="getEmploye()"></td>
				</tr>
				</table>
				
				<table class="table">				
	            <tr>
					<td>Employe choisi : ${employeModel.nomEmploye}</td>
				</tr>
				<tr>
					<th>Id</th>
					<th>solde</th>
					<th>dateDeCreation</th>
				</tr>
				<c:forEach items="${employeModel.tabCompte}" var="c">
					<tr>
						<td>${c.idCompte}</td>
						<td>${c.solde}</td>
						<td>${c.dateDeCreation}</td>
					</tr>
				</c:forEach>
			</table>
	      </form>
       </div>
</section>

	<script type="text/javascript" src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>
	
</body>
</html>