<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page banques</title>
<%-- <link rel="stylesheet" href="<%= request.getContextPath()%>/css/banque.css"> --%>
<body>
	<h1>Ici, c est la page banques</h1>
	<div>
		<a href="client">Page clients</a>
	</div>

	<div>
		<form action="afficherBanque" method="post">
			<table>
				<tr>
					<th>Liste des banques :</th>
					<td><input type="submit" value="Chercher"
						name="afficherBanque"></td>
				</tr>
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
		<form action="ajouterBanque" method="post">
			<table>
				<tr>
					<td>Ajouter une nouvelle agence bancaire</td>
					<td>Nom de l'agence : <input type="text" name="nomAgence"></td>
					<td>Adresse de l'agence : <input type="text" name="adrAgence"></td>
					<td>Code Postal de l'agence : <input type="text"
						name="cpAgence"></td>
					<td>Type de banque<select name="typeBanque">
							<option value="cic">CIC</option>
							<option value="bnp">BNP</option>
							<option value="lcl">LCL</option>
					</select></td>
					<td><input type="submit" value="Ajouter" name="ajouterBanque"></td>
				</tr>

			</table>
		</form>
	</div>

	<div>
		<form action="afficherInfosBanque">
			<%-- <table>
				<tr>
					<td>Chercher une agence</td>
					<td>Nom de l'agence :</td>
					<td><select name="nomAgence">
							<c:forEach items="${banqueModel.tabBanque}" var="banq">
								<option value="${banq.nomAgence}">${banq.nomAgence}</option>
							</c:forEach>
					</select></td>
					<td><input type="submit" value="Chercher la banque"
						name="afficherInfosBanque"></td>
				</tr>
			</table>
			
			<table>
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
				<tr>
				<td>Tableau comptes</td>
				<c:forEach items="${banqueModel.tabCompte}" var="emp1">
					<td>${emp1.solde}</td>
					</c:forEach>
				</tr>
				<tr>
				<td>Tableau employes</td>
				<c:forEach items="${banqueModel.tabEmploye}" var="emp2">
					<td>${emp2.nomEmploye}</td>
					</c:forEach>
				</tr>
				<tr>
				<td>Tableau clients</td>
				<c:forEach items="${banqueModel.tabClient}" var="emp3">
					<td>${emp3.nomClient}</td>
					</c:forEach>
				</tr>
			</table> --%>
			<label>idAgence</label> <input type="text" name="idBanque"> <input
				type="submit" value="Chercher la banque" name="afficherInfosBanque">
		</form>

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
		</table>

	</div>

</body>
</html>