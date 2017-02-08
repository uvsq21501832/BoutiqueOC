package uvsq.datascale.boutiqueoc.metier;

import uvsq.datascale.boutiqueoc.entities.CategorieArticle;
;

public interface IAdminCategorie extends IAdminProduit{
	
	public int ajouterCategorie(CategorieArticle c);
	public void supprimerCategrorie(int idCategorie);
	public void modifierCategorie(CategorieArticle c);
	//public void ajouterUser(User u);
	//public void attribuerRole(Role r,Long userID);

}
