package uvsq.datascale.boutiqueoc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/", method = RequestMethod.GET)
public class AdminCategorieControlleur {
	
	@RequestMapping(value = "/adminCat", method = RequestMethod.GET)
	public String index() {
		
		return "categories";
	}
}