<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compte</title>
<link href="<c:url value="/css/compteStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<script type="text/javascript">

function validateCompteCourant(){
	
	var fieldSolde            = document.getElementById("soldeValid").value;
	var fieldSoldeError       = document.getElementById("soldeValidError");
	
	var fieldDate             = document.getElementById("dateValid").value;
	var fieldDateError        = document.getElementById("dateValidError");
	
	var fieldDecouvert        = document.getElementById("decouvertValid").value;
	var fieldDecouvertError   = document.getElementById("decouvertValidError");
	
	var fieldClient        = document.getElementById("clientValid").value;
	var fieldClientError   = document.getElementById("clientValidError");
	
	var fieldEmploye        = document.getElementById("employeValid").value;
	var fieldEmployeError   = document.getElementById("employeValidError");
	
	var fieldBanque        = document.getElementById("banqueValid").value;
	var fieldBanqueError   = document.getElementById("banqueValidError");
	
	
	if(fieldSolde.length ==0){
		fieldSoldeError.innerHTML ="Veuillez entrer un solde!";
		fieldSoldeError.style.color="red";
		return false;
	}
	
	if(fieldDate.length ==0){
		fieldDateError.innerHTML ="Veuillez entrer une date!";
		fieldDateError.style.color="red";
		return false;
	}	
	
	if(fieldDecouvert.length ==0){
		fieldDecouvertError.innerHTML ="Veuillez entrer un decouvert!";
		fieldDecouvertError.style.color="red";
		return false;
	}	

	if(fieldClient.length ==0){
		fieldClientError.innerHTML ="Veuillez entrer un client!";
		fieldClientError.style.color="red";
		return false;
	}

	if(fieldEmploye.length ==0){
		fieldEmployeError.innerHTML ="Veuillez entrer un employé!";
		fieldEmployeError.style.color="red";
		return false;
	}
	
	if(fieldBanque.length ==0){
		fieldBanqueError.innerHTML ="Veuillez entrer une banque!";
		fieldBanqueError.style.color="red";
		return false;
	}	
	return true;
}

function validateCompteEpargne(){
	
	var fieldSolde2            = document.getElementById("soldeValid2").value;
	var fieldSoldeError2       = document.getElementById("soldeValidError2");
	
	var fieldDate2            = document.getElementById("dateValid2").value;
	var fieldDateError2        = document.getElementById("dateValidError2");
	
	var fieldDecouvert2        = document.getElementById("decouvertValid2").value;
	var fieldDecouvertError2   = document.getElementById("decouvertValidError2");
	
	var fieldTaux2            = document.getElementById("tauxValid2").value;
	var fieldTauxError2        = document.getElementById("tauxValidError2");
	
	var fieldClient2           = document.getElementById("clientValid2").value;
	var fieldClientError2      = document.getElementById("clientValidError2");
	
	var fieldEmploye2          = document.getElementById("employeValid2").value;
	var fieldEmployeError2     = document.getElementById("employeValidError2");
	
	var fieldBanque2           = document.getElementById("banqueValid2").value;
	var fieldBanqueError2      = document.getElementById("banqueValidError2");
	
	
	if(fieldSolde2.length ==0){
		fieldSoldeError2.innerHTML ="Veuillez entrer un solde!";
		fieldSoldeError2.style.color="red";
		return false;
	}
	
	if(fieldDate2.length ==0){
		fieldDateError2.innerHTML ="Veuillez entrer une date!";
		fieldDateError2.style.color="red";
		return false;
	}	
	
	if(fieldDecouvert2.length ==0){
		fieldDecouvertError2.innerHTML ="Veuillez entrer un decouvert!";
		fieldDecouvertError2.style.color="red";
		return false;
	}	
	
	if(fieldTaux2.length ==0){
		fieldTauxError2.innerHTML ="Veuillez entrer un taux d'interet!";
		fieldTauxError2.style.color="red";
		return false;
	}		

	if(fieldClient2.length ==0){
		fieldClientError2.innerHTML ="Veuillez entrer un client!";
		fieldClientError2.style.color="red";
		return false;
	}

	if(fieldEmploye2.length ==0){
		fieldEmployeError2.innerHTML ="Veuillez entrer un employé!";
		fieldEmployeError2.style.color="red";
		return false;
	}
	
	if(fieldBanque2.length ==0){
		fieldBanqueError2.innerHTML ="Veuillez entrer une banque!";
		fieldBanqueError2.style.color="red";
		return false;
	}	
	return true;
}


function validateGetCompte(){
	
	
	var fieldClient3        = document.getElementById("clientValid3").value;
	var fieldClientError3   = document.getElementById("clientValidError3");
	

	if(fieldClient3.length ==0){
		fieldClientError3.innerHTML ="Veuillez entrer un client!";
		fieldClientError3.style.color="red";
		return false;
	}

	
}

function validateDeleteCompte(){
	
	
	var fieldClient4        = document.getElementById("clientValid4").value;
	var fieldClientError4   = document.getElementById("clientValidError4");
	

	if(fieldClient4.length ==0){
		fieldClientError4.innerHTML ="Veuillez entrer un client!";
		fieldClientError4.style.color="red";
		return false;
	}
	
	if(fieldSolde3.length ==0){
		fieldSoldeError3.innerHTML ="Veuillez entrer un solde!";
		fieldSoldeError3.style.color="red";
		return false;
	}
	
	if(fieldDate3.length ==0){
		fieldDateError3.innerHTML ="Veuillez entrer une date!";
		fieldDateError3.style.color="red";
		return false;
	}	
	
	if(fieldDecouvert3.length ==0){
		fieldDecouvertError3.innerHTML ="Veuillez entrer un decouvert!";
		fieldDecouvertError3.style.color="red";
		return false;
	}	
	
}

function validateUpdateCompte(){
	
	
	var fieldClient5           = document.getElementById("clientValid5").value;
	var fieldClientError5      = document.getElementById("clientValidError5");
	
	var fieldSolde3            = document.getElementById("soldeValid3").value;
	var fieldSoldeError2       = document.getElementById("soldeValidError3");
	
	var fieldDate3             = document.getElementById("dateValid3").value;
	var fieldDateError3        = document.getElementById("dateValidError3");
	
	var fieldDecouvert3        = document.getElementById("decouvertValid3").value;
	var fieldDecouvertError3   = document.getElementById("decouvertValidError3");
	

	if(fieldClient5.length ==0){
		fieldClientError5.innerHTML ="Veuillez entrer un client!";
		fieldClientError5.style.color="red";
		return false;
	}

	
}
</script>


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
				<a href="#"><img src="<c:url value="/css/image/logo.jpeg"/>" width=50px></a> <a
					class="navbar-brand" href="#">Gestion des Banques</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav nav-pills navbar-right">
					<li class="active"><a href="#">Home<span
							class="sr-only">(current)</span></a></li>
					<li><a href="<c:url value="client"/>">Client</a></li>
					<li><a href="<c:url value="indexEmploye"/>">Employé</a></li>
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
          <h1>Enregistrer un Compte courant</h1>
		     <form action="addCompteCourant" method="post" onsubmit="return validateCompteCourant()">
		        <table class="table">		   
		           <tr>
				       <td>solde</td>
				       <td><input type="number" name="solde" id="soldeValid"></td>
				       <td>dateDeCreation</td>
				       <td><input type="date" name="date" id="dateValid"></td>
				       <td>decouvert</td>
				       <td><input type="number" name="decouvert" id="decouvertValid"></td>
				       <td>idClient</td>
				       <td><input type="number" name="idClient" id="clientValid"></td>
					   <td>idEmploye</td>
				       <td><input type="number" name="idEmploye" id="employeValid"></td>
				       <td>idBanque</td>
				       <td><input type="number" name="idBanque" id="banqueValid"></td>
			       </tr>
			       <tr>
				       <td><input type="submit" name="addCompteCourant" value="Ajouter un compte courant" onclick="validateCompteCourant()"></td>
			       </tr>		   
		        </table>
		        <span id="soldeValidError"></span>
		        <span id="dateValidError"></span>
		        <span id="decouvertValidError"></span>
		        <span id="clientValidError"></span>
		        <span id="employeValidError"></span>
		        <span id="banqueValidError"></span>
		     </form>		
      </div>
</section>

<section>
    <div>
      <h1>Enregistrer un Compte epargne</h1>
		<form action="addCompteEpargne" method="post" onsubmit="return validateCompteEpargne()">
		   <table class="table">
		      <tr>
				  <td>solde</td>
				  <td><input type="number" name="solde" id="soldeValid2"></td>
				  <td>dateDeCreation</td>
				  <td><input type="date" name="date" id="dateValid2"></td>
				  <td>decouvert</td>
				  <td><input type="number" name="decouvert" id="decouvertValid2"></td>
				  <td>tauxInteret</td>
				  <td><input type="number" name="taux" id="tauxValid2"></td>
				  <td>idClient</td>
				  <td><input type="number" name="idClient" id="clientValid2"></td>
				  <td>idEmploye</td>
				  <td><input type="number" name="idEmploye" id="employeValid2"></td>
				  <td>idBanque</td>
				  <td><input type="number" name="idBanque" id="banqueValid2"></td>
			  </tr>

			  <tr>
				  <td><input type="submit" value="Ajouter un compte epargne" name="addCompteEpargne" onclick="validateCompteEpargne()"></td>
			  </tr>		   
		   </table>
		        <span id="soldeValidError2"></span>
		        <span id="dateValidError2"></span>
		        <span id="decouvertValidError2"></span>
		        <span id="tauxValidError2"></span>
		        <span id="clientValidError2"></span>
		        <span id="employeValidError2"></span>
		        <span id="banqueValidError2"></span>
		</form>		
   </div>
</section>

<section>	
     <div>
		<form action="getCompte" onsubmit="return validateGetCompte()">
			<h1>Afficher un compte</h1>
			    <td>idCompte</td>
				<td><input type="number" name="idCompte2" id="clientValid3"></td>
			    <input type="submit" value="Afficher le compte" onclick="validateGetCompte()">
				    <table class="table">
				       <tr>
				           <th>Id</th>
				           <th>solde</th>
				           <th>dateDeCreation</th>
				           <th>decouvert</th>
			           </tr>
			           <tr>
				           <td>${compteModel.compte2.getIdCompte()}</td>
				           <td>${compteModel.compte2.getSolde()}</td>
				           <td>${compteModel.compte2.getDateDeCreation()}</td>
				           <td>${compteModel.compte2.getDecouvert()}</td>
			          </tr>
			       </table>	
			       <span id="clientValidError3"></span>			
		</form>		    
     </div>
</section>

<section>
      <div>
         <h1>Supprimer un compte</h1>
		     <form action="deleteCompte" onsubmit="return validateDeleteCompte()">
			     <td>idCompte</td>
				     <td><input type="number" name="idCompte" id="clientValid4"></td>
			         <input type="submit" value="Supprimer le compte" onclick="validateDeleteCompte()">
		     </form>
		     <span id="clientValidError4"></span>
	  </div>
</section>

<section>
      <div>
         <h1>Modifier un compte</h1>
		<form action="updateCompte" onsubmit="return validateUpdateCompte()">			
			    <td>idCompte</td>
				<td><input type="number" name="idCompte3" id="clientValid5"></td>			    
				    <table class="table">
				      <tr>
				        <th>Id</th>
				        <th>solde</th>
				        <th>dateDeCreation</th>
				        <th>decouvert</th>
			          </tr>
			          <tr>
				        <td>${compteModel.compte3.getIdCompte()}</td>
				        <td>${compteModel.compte3.getSolde()}</td>
				        <td>${compteModel.compte3.getDateDeCreation()}</td>
				        <td>${compteModel.compte3.getDecouvert()}</td>
			          </tr>
			       </table>
			    <tr>
				<td>solde</td>
				<td><input type="number" name="solde" id="soldeValid3"></td>
				<td>dateDeCreation</td>
				<td><input type="date" name="date" id="dateValid3"></td>
				<td>decouvert</td>
				<td><input type="number" name="decouvert" id="decouvertValid3"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Modifier un compte" name="updateCompte" onclick="validateUpdateCompte()"></td>
			</tr>	
		</form>
		<span id="clientValidError5"></span>
		<span id="soldeValidError2"></span>
		<span id="dateValidError2"></span>
		<span id="decouvertValidError2"></span>		    
     </div>
</section>

    <script type="text/javascript" src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>	
</body>

</html>v