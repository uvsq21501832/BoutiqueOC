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
		CategorieArticle c=getCategorie(idCategorie);
		i.setIdCategorie(c);
		em.persist(i);
		return i.getIdArticle();
	}

	@Override
	public List<Article> listArticles() {
		Query req=em.createQuery("select a from Article a");
		return req.getResultList();
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
		return em.find(Article.class, idArticle);
	}

	@Override
	public void supprimerArticle(int idArticle) {
		Article a=em.find(Article.class, idArticle);
		em.remove(a);
		
	}

	@Override
	public void modifierarticle(Article i) {
		em.merge(i);
		
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return null;
	}
}
