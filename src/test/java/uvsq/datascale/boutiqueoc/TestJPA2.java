package uvsq.datascale.boutiqueoc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA2 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		//Fait juste une lecture du fichier applicationContext.xml
		//si la lecture se passe bien alors configuration correcte, sinon problème de config hibernate
		try {
			ClassPathXmlApplicationContext app=
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			} 
	}

}
