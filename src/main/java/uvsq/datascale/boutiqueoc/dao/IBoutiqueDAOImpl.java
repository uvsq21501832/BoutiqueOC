package uvsq.datascale.boutiqueoc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uvsq.datascale.boutiqueoc.entities.Article;
import uvsq.datascale.boutiqueoc.entities.CategorieArticle;
import uvsq.datascale.boutiqueoc.entities.Client;
import uvsq.datascale.boutiqueoc.entities.Commande;
import uvsq.datascale.boutiqueoc.entities.Panier;

public class IBoutiqueDAOImpl implements IBoutiqueDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public int ajouterCategorie(CategorieArticle c) {
		em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<CategorieArticle> listCategories() {
		Query req=em.createQuery("select c from CategorieArticle c");
		return req.getResultList();
	}

	@Override
	public CategorieArticle getCategorie(int idCategorie) {
		return em.find(CategorieArticle.class, idCategorie);
	}

	@Override
	public void supprimerCategrorie(int idCategorie) {
		CategorieArticle c=em.find(CategorieArticle.class, idCategorie);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(CategorieArticle c) {
		em.merge(c);
		
	}

	@Override
	public int ajouterarticle(Article i, int idCategorie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Article> listArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> articlesParMotCle(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> articlesParCategorie(int idCategorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> articlesSelectionnes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article getArticle(int idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerArticle(int idArticle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierarticle(Article i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return null;
	}
}
