<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<title>nom page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>


<div class = "errors">
${exception}
</div>

<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="acceuil">BoutiqueOC.com</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="acceuil">Accueil</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Produits <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Ajouter un Produit</a></li>
							<li><a href="#">Modifier un Produit</a></li>
							<li><a href="#">Tous les produits</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Catégories <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="adminCat">Ajouter une Catégorie</a></li>
							<li><a href="adminCat">Modifier une Catégorie</a></li>
							<li><a href="adminCat">Toutes les Catégories</a></li>
						</ul></li>


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Gestion Commandes <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="adminCat">Validation</a></li>
							<li><a href="adminCat">Annulation</a></li>
							<li><a href="adminCat">Toutes les Commandes</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Gestion Livraison <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="adminCat">Livraisons Effectuées</a></li>
							<li><a href="adminCat">Livraisons En Attentes</a></li>
							<li><a href="adminCat">Toutes les Livraisons</a></li>
						</ul></li>

					<li><a href="#">Fidélité</a></li>
					<li><a href="#">Contacter</a></li>
				</ul>

				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</nav>

	</header>
<!-- 


Corps de la page



 -->

	<h1>Contenu en cours de developpement</h1>





	<footer class="navbar-fixed-bottom">
		<div class="panel panel-default">
			<p>Posted by: M2 UVSQ Data scale</p>

			<p>
				Contact information: <a href="mailto:poulmanogo@ens.uvsq.fr">
					groupe7-2017@ens.uvsq.fr</a>
			</p>
			<P>The time on the server is ${serverTime}.</P>

		</div>
	</footer>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
