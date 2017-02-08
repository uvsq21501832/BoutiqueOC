package uvsq.datascale.boutiqueoc.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uvsq.datascale.boutiqueoc.dao.IBoutiqueDAO;
import uvsq.datascale.boutiqueoc.entities.Article;
import uvsq.datascale.boutiqueoc.entities.CategorieArticle;
import uvsq.datascale.boutiqueoc.entities.Client;
import uvsq.datascale.boutiqueoc.entities.Commande;
import uvsq.datascale.boutiqueoc.entities.Panier;

@Transactional
public class BoutiqueImpl implements IAdminCategorie {
	
	private IBoutiqueDAO dao;
	
	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}

	@Override
	public int ajouterarticle(Article i, int idCategorie) {
		
		return dao.ajouterarticle(i, idCategorie);
	}

	@Override
	public void supprimerArticle(int idArticle) {
		dao.supprimerArticle(idArticle);
		
	}

	@Override
	public void modifierarticle(Article i) {
		dao.modifierarticle(i);
		
	}

	@Override
	public List<CategorieArticle> listCategories() {
		return dao.listCategories();
	}

	@Override
	public CategorieArticle getCategorie(int idCategorie) {
		return dao.getCategorie(idCategorie);
	}

	@Override
	public List<Article> listArticles() {
		return dao.listArticles();
	}

	@Override
	public List<Article> articlesParMotCle(String mc) {
		return dao.articlesParMotCle(mc);
	}

	@Override
	public List<Article> articlesParCategorie(int idCategorie) {
		return dao.articlesParCategorie(idCategorie);
	}

	@Override
	public List<Article> articlesSelectionnes() {
		return dao.articlesSelectionnes();
	}

	@Override
	public Article getArticle(int idArticle) {
		return dao.getArticle(idArticle);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public int ajouterCategorie(CategorieArticle c) {
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategrorie(int idCategorie) {
		dao.supprimerCategrorie(idCategorie);
	}

	@Override
	public void modifierCategorie(CategorieArticle c) {
		dao.modifierCategorie(c);
	}

}
