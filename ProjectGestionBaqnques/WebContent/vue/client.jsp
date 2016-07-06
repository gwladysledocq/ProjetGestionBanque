<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>page Clients</title>
<%-- <link rel="stylesheet" href="<%= request.getContextPath()%>/css/client.css"> --%>
</head>
<body>
	<h1>Ici, c est la page clients</h1>
	<div>
		<a href="banque">page banques</a>
	</div>

	<div>
		<form action="afficherClient" method="post">
			<table>
				<tr>
					<th>Liste des clients :</th>
					<td><input type="submit" value="Chercher client"
						name="afficherClient"></td>
				</tr>
				<tr>
					<th>Id</th>
					<th>nomClient</th>
					<th>prenomClient</th>
					<th>adrClient</th>
				</tr>
				<c:forEach items="${clientModel.tabClient}" var="c">
					<tr>
						<td>${c.idClient}</td>
						<td>${c.nomClient}</td>
						<td>${c.prenomClient}</td>
						<td>${c.adrClient}</td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>

	<div>
		<form action="ajouterClient" method="post">
			<table>
				<tr>
					<td>Ajouter un nouveau client</td>
					<td>Nom du client : <input type="text" name="nomClient"></td>
					<td>Prenom du client : <input type="text" name="prenomClient"></td>
					<td>Adresse du client : <input type="text" name="adrClient"></td>

					<td><input type="submit" value="Ajouter" name="ajouterClient"></td>
				</tr>
			</table>
		</form>
	</div>


	<div>
		<form action="supprimerClient" method="post">
			<table>
				<tr>
					<td>Supprimer un client</td>
					<td><select name="nomClient">
							<c:forEach items="${clientModel.tabClient}" var="cl">
								<option value="${cl.nomClient}">${cl.nomClient}</option>
							</c:forEach>
					</select></td>

					<td><input type="submit" value="Supprimer"
						name="supprimerClient"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<form action="majerClient" method="post">
			<table>
				<tr>
					<td>Selectionner un client</td>
					<td><select name="nomClientChoisi">
							<c:forEach items="${clientModel.tabClient}" var="cl">
								<option value="${cl.nomClient}">${cl.nomClient}</option>
							</c:forEach>
					</select></td>
					<td>Changer infos</td>
					<td>Nom du client : <input type="text" name="nomClientUpdate"></td>
					<td>Prenom du client : <input type="text" name="prenomClientUpdate"></td>
					<td>Adresse du client : <input type="text" name="adrClientUpdate"></td>
					<td><input type="submit" value="Update" name="majerClient"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<form action="comptesClient" method="post">
			<table>
				<tr>
					<td>Selectionner un client</td>
					<td><select name="nomClient">
							<c:forEach items="${clientModel.tabClient}" var="clie">
								<option value="${clie.nomClient}">${clie.nomClient}</option>
							</c:forEach>
					</select></td>
				<tr>
					<td>Tableau comptes</td>
					<c:forEach items="${clientModel.tabCompte}" var="com">
						<td>${com.solde}</td>
					</c:forEach>
					<td><input type="submit" value="Comptes" name="comptesClient"></td>
				</tr>

			</table>
		</form>
	</div>

	<div>
		<form action="motcleClient" method="post">
			<table>
				<tr>
					<td>Chercher un client par mot cle</td>
					<td>Nom du client : <input type="text" name="motCle"></td>
				<tr>
					<th>Id</th>
					<th>nomClient</th>
					<th>prenomClient</th>
					<th>adrClient</th>
				</tr>
				<c:forEach items="${clientModel.tabClientTemp}" var="clien">
					<tr>
						<td>${clien.idClient}</td>
						<td>${clien.nomClient}</td>
						<td>${clien.prenomClient}</td>
						<td>${clien.adrClient}</td>
					</tr>
				</c:forEach>
				<tr><td><input type="submit" value="Rechercher" name="motcleClient"></td></tr>
			</table>
		</form>
	</div>
</body>
</html>