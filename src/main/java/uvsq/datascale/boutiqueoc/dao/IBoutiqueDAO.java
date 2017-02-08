package uvsq.datascale.boutiqueoc.dao;
import java.util.List;

import uvsq.datascale.boutiqueoc.entities.*;

public interface IBoutiqueDAO {
	public int ajouterCategorie(CategorieArticle c);
	public List<CategorieArticle> listCategories();
	public CategorieArticle getCategorie(int idCategorie);
	public void supprimerCategrorie(int idCategorie);
	public void modifierCategorie(CategorieArticle c);
	public int ajouterarticle(Article i, int idCategorie);
	public List<Article> listArticles();
	public List<Article> articlesParMotCle(String mc);
	public List<Article> articlesParCategorie(int idCategorie);
	public List<Article> articlesSelectionnes();
	public Article getArticle(int idArticle);
	public void supprimerArticle(int idArticle);
	public void modifierarticle(Article i);
	/*public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);*/
	public Commande enregistrerCommande(Panier p,Client c);
}