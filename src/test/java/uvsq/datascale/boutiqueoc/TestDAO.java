package uvsq.datascale.boutiqueoc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uvsq.datascale.boutiqueoc.entities.Article;
import uvsq.datascale.boutiqueoc.entities.CategorieArticle;
import uvsq.datascale.boutiqueoc.metier.IAdminCategorie;

public class TestDAO {
	
	ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

	
	@Test
	public void testDAO() {
	try {
	
	IAdminCategorie metier=(IAdminCategorie) context.getBean("metier");
	List<CategorieArticle> cats1=metier.listCategories();
	metier.ajouterCategorie(new CategorieArticle("Ordinateur", "Ordinateurs"));
	metier.ajouterCategorie(new CategorieArticle("Imprimantes", "Imprimantes"));
	metier.ajouterCategorie(new CategorieArticle("Imprimantes", "Imprimantes"));
	metier.ajouterCategorie(new CategorieArticle("Imprimantes", "Imprimantes"));
	List<CategorieArticle> cats2=metier.listCategories();
	assertTrue(cats2.size()==cats1.size()+4);
	} catch (Exception e) { assertTrue(e.getMessage(),false);}}
	
	@Test
	public void testDAO2() {
	try {
	
	IAdminCategorie metier=(IAdminCategorie) context.getBean("metier");
	
	List<Article> art1=metier.listArticles();
	metier.ajouterarticle(new Article("aaa"), 11);
	metier.ajouterarticle(new Article("bbb"), 13);
	
	List<Article> art2=metier.listArticles();
	assertTrue(art2.size()==art1.size()+2);
	} catch (Exception e) { assertTrue(e.getMessage(),false);}
	}


}
