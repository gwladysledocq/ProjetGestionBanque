<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employe</title>

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
		<form action="addEmploye" method="post">
		   <table>
		   
		    <tr>
				<td>Nom Employe</td>
				<td><input type="text" name="nom"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Ajouter" /></td>
			</tr>
		   
		   </table>
		</form>
		
</div>
<div>
		<form action="getListEmploye">
			<table>
				<tr>
					<td>Liste des employes</td>
				</tr>
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
			</table>
		</form>
		
		
</div>
			
<div>
		  <form action="getComptesParEmploye">
			<table>
				<tr>
					<th>Liste des comptes créés par employé :</th>
				</tr>
				<tr>
					<td>Nom de l'employe :</td>
					<td><select name="idEmploye">
							<c:forEach items="${employeModel.tabEmploye}" var="e">
								<option value="${e.idEmploye}">${e.nomEmploye}</option>
							</c:forEach>
					</select>
					</td>
					<td><input type="submit" value="Afficher les comptes"></td>
				</tr>				
		  </form>
 
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
</div>
	
</body>
</html>