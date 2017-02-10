<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Accueil</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>
<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/boutiqueoc">BoutiqueOC.com</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/boutiqueoc">Accueil</a></li>

					<li class="dropdown"><a href="adminProd"
						class="dropdown-toggle" data-toggle="dropdown">Produits <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="adminProd">Ajouter un Produit</a></li>
							<li><a href="adminProd">Modifier un Produit</a></li>
							<li><a href="adminProd">Tous les produits</a></li>
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
	<!--fin entete  -->

	<div id="tabProduits" class="cadre">
		<table class="table table-striped table-bordered table-condensed">
			<tr>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			
			<c:set var="count" value="0" />
			
			<c:forEach items="${produits}" var="prod">
				<c:set var="count" value="${count + 1}" />
				<c:if test="${count % 3 == 1}">
						<tr>
					</c:if>
					<td>${prod.nom}${prod.disponibilite} <img
						src="photoProd?idProd=${prod.idArticle}"> ${prod.prix} <span class="glyphicon glyphicon-euro"></span>
					</td>

					<c:if test="${count % 3 == 0}">
						</tr>
						<c:set var="count" value="0" />
					</c:if>

				
			</c:forEach>
		</table>
	</div>


	<!--pied de page  -->

	<footer>
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
