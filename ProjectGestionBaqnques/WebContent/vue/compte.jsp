<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compte</title>

</head>
<style>
div {
	border: 1px solid black;
	margin: 10px;
	padding: 10px;
}

.table td {
	border: 1px solid black;
	margin: 10px;
	padding: 10px;
}

.table th {
	border: 1px solid black;
	margin: 10px;
	padding: 10px;
	background: pink;
}
</style>
<body>
<div>
		<form action="addCompteCourant" method="post">
		   <table>
		   
		    <tr>
				<td>solde</td>
				<td><input type="number" name="solde"></td>
				<td>dateDeCreation</td>
				<td><input type="date" name="date"></td>
				<td>decouvert</td>
				<td><input type="number" name="decouvert"></td>
				<td>idClient</td>
				<td><input type="number" name="idClient"></td>
				<td>idEmploye</td>
				<td><input type="number" name="idEmploye"></td>
				<td>idBanque</td>
				<td><input type="number" name="idBanque"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Ajouter un compte courant" name="addCompteCourant" /></td>
			</tr>
		   
		   </table>
		</form>
		
</div>
<div>
		<form action="addCompteEpargne" method="post">
		   <table>
		   
		    <tr>
				<td>solde</td>
				<td><input type="number" name="solde"></td>
				<td>dateDeCreation</td>
				<td><input type="date" name="date"></td>
				<td>decouvert</td>
				<td><input type="number" name="decouvert"></td>
				<td>tauxInteret</td>
				<td><input type="number" name="taux"></td>
				<td>idClient</td>
				<td><input type="number" name="idClient"></td>
				<td>idEmploye</td>
				<td><input type="number" name="idEmploye"></td>
				<td>idBanque</td>
				<td><input type="number" name="idBanque"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Ajouter un compte epargne" name="addCompteEpargne"/></td>
			</tr>
		   
		   </table>
		</form>
		
</div>
<div>
		<form action="getCompte">
			
			    <td>idCompte</td>
				<td><input type="number" name="idCompte2"></td>
			    <input type="submit" value="Afficher le compte">
				<table>
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
				
		</form>
		    
</div>
<div>
		<form action="deleteCompte">
			<td>idCompte</td>
				<td><input type="number" name="idCompte"></td>
			    <input type="submit" value="Supprimer le compte">
		</form>
	</div>
</body>
<div>
		<form action="updateCompte">
			
			    <td>idCompte</td>
				<td><input type="number" name="idCompte3"></td>
			    
				<table>
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
				<td><input type="number" name="solde"></td>
				<td>dateDeCreation</td>
				<td><input type="date" name="date"></td>
				<td>decouvert</td>
				<td><input type="number" name="decouvert"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Modifier un compte" name="updateCompte"/></td>
			</tr>	
		</form>
		    
</div>
</html>