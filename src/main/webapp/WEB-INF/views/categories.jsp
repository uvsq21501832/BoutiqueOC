<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<title>Admin Cat�gorie</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">

</head>


<div class="errors">${exception}</div>

<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/boutiqueoc">BoutiqueOC.com</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="/boutiqueoc">Accueil</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Produits <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Ajouter un Produit</a></li>
							<li><a href="#">Modifier un Produit</a></li>
							<li><a href="#">Tous les produits</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Cat�gories <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="adminCat">Ajouter une Cat�gorie</a></li>
							<li><a href="adminCat">Modifier une Cat�gorie</a></li>
							<li><a href="adminCat">Toutes les Cat�gories</a></li>
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
							<li><a href="adminCat">Livraisons Effectu�es</a></li>
							<li><a href="adminCat">Livraisons En Attentes</a></li>
							<li><a href="adminCat">Toutes les Livraisons</a></li>
						</ul></li>

					<li><a href="#">Fid�lit�</a></li>
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

	<!--  debut corps -->

	<div id="formCat" class="cadre">
		<f:form  class="form-horizontal" modelAttribute="categorie" action="saveCat" method="post"
			enctype="multipart/form-data">
			<table >
				<tr>
					<td>Cat�gorie</td>
					<td>${categorie.idCategorie}<f:input type="hidden"
							path="idCategorie" /></td>
					<td><f:errors path="idCategorie"></f:errors></td>
				</tr>
				<tr>
					<td>Nom Cat�gorie</td>
					<td><f:input path="nom" /></td>
					<td><f:errors path="nom"></f:errors></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><f:textarea path="description" /></td>
					<td><f:errors path="description"></f:errors></td>
				</tr>
				<tr>
					<td>Photo</td>
					<c:if test="${categorie.idCategorie!=null}">
						<td><img src="photoCat?idCat=${categorie.idCategorie}"></td>
					</c:if>
					<td><input type="file"  class="filestyle" name="file"></td>
				</tr>
				<tr>
					<td><input type="submit"  class="btn btn-info" value="Enregistrer"></td>
				</tr>
			</table>
		</f:form>

	</div>
	<div id="tabCategories" class="cadre">
		<table class="table table-striped table-bordered table-condensed">
			<tr>
				<th>ID</th>
				<th>NOM CAT</th>
				<th>DESCRIPTION</th>
				<th>PHOTO</th>
				<th>SUPPRIMER</th>
				<th>EDITER</th>
			</tr>
			<c:forEach items="${categories}" var="cat">
				<tr>
					<td>${cat.idCategorie}</td>
					<td>${cat.nom}</td>
					<td>${cat.description}</td>
					<td><img src="photoCat?idCat=${cat.idCategorie}"></td>
					<td><a href="suppCat?idCat=${cat.idCategorie}"><span class="glyphicon glyphicon-remove"></span>Supprimer</a></td>
					<td><a href="editCat?idCat=${cat.idCategorie}"><span class="glyphicon glyphicon-pencil"></span>Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- fin corps -->

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
