<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<link href="<c:url value="/css/homeStyle.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.css"/>" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
				<a href="#"><img src="<c:url value="/css/image/logo.jpeg"/>" width=50px></a> <a
					class="navbar-brand" href="#">Gestion des Banques</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav nav-pills navbar-right">
					<li class="active"><a href="#">Home<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">Client</a></li>
					<li><a href="#">Employé</a></li>
					<li><a href="#">Compte</a></li>
					<li><a href="<c:url value="groupe"/>">Groupe</a></li>
					<li><a href="<c:url value="operation"/>">Operation</a></li>
					<li><a href="#">Banque</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section>

		<p>
			<img class="fond" src="<c:url value="/css/image/fond2.jpg"/>" width=1520px>
		</p>
		<p class="presentation" >Site de gestion des Banques</p>

	</section>

	<script type="text/javascript" src="<c:url value="/css/bootstrap/jquery.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/css/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.js"/>"></script>


</body>
</html>