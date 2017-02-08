package uvsq.datascale.boutiqueoc.metier;

import java.util.List;

import uvsq.datascale.boutiqueoc.entities.Article;
import uvsq.datascale.boutiqueoc.entities.CategorieArticle;
import uvsq.datascale.boutiqueoc.entities.Client;
import uvsq.datascale.boutiqueoc.entities.Commande;
import uvsq.datascale.boutiqueoc.entities.Panier;

public interface Internaute {
	public List<CategorieArticle> listCategories();
	public CategorieArticle getCategorie(int idCategorie);
	public List<Article> listArticles();
	public List<Article> articlesParMotCle(String mc);
	public List<Article> articlesParCategorie(int idCategorie);
	public List<Article> articlesSelectionnes();
	public Article getArticle(int idArticle);
	public Commande enregistrerCommande(Panier p,Client c);

}
