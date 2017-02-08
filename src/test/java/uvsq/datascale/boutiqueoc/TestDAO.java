package uvsq.datascale.boutiqueoc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uvsq.datascale.boutiqueoc.entities.CategorieArticle;
import uvsq.datascale.boutiqueoc.metier.IAdminCategorie;

public class TestDAO {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testDAO() {
	try {
	ClassPathXmlApplicationContext context=
	new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	IAdminCategorie metier=(IAdminCategorie) context.getBean("metier");
	List<CategorieArticle> cats1=metier.listCategories();
	metier.ajouterCategorie(new CategorieArticle("Ordinateur", "Ordinateurs"));
	metier.ajouterCategorie(new CategorieArticle("Imprimantes", "Imprimantes"));
	metier.ajouterCategorie(new CategorieArticle("Imprimantes", "Imprimantes"));
	metier.ajouterCategorie(new CategorieArticle("Imprimantes", "Imprimantes"));
	List<CategorieArticle> cats2=metier.listCategories();
	assertTrue(cats2.size()==cats1.size()+4);
	} catch (Exception e) { assertTrue(e.getMessage(),false);}}
	

}
