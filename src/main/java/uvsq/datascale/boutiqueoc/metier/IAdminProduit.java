package uvsq.datascale.boutiqueoc.metier;


import uvsq.datascale.boutiqueoc.entities.Article;

public interface IAdminProduit extends Internaute{
	
	public int ajouterarticle(Article i, int idCategorie);
	public void supprimerArticle(int idArticle);
	public void modifierarticle(Article i);
	

}
