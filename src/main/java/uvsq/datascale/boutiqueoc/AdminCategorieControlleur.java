package uvsq.datascale.boutiqueoc;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import uvsq.datascale.boutiqueoc.entities.CategorieArticle;
import uvsq.datascale.boutiqueoc.metier.IAdminCategorie;

@Controller
@RequestMapping(value="/", method = RequestMethod.GET)
@SessionAttributes("editedCat")

public class AdminCategorieControlleur implements HandlerExceptionResolver{
	@Autowired
	private IAdminCategorie metier;
	@RequestMapping(value = "/adminCat", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("categorie", new CategorieArticle());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}
	@RequestMapping(value = "/saveCat", method = RequestMethod.POST)
	public String saveCat(@Valid CategorieArticle c, BindingResult bindingResult, 
			Model model, MultipartFile file) throws IOException{

		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			return "categories";
		}

		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		
		if(c.getIdCategorie() != null){
			if(model.asMap().get("editedCat") != null){
				if(file.isEmpty()){
					CategorieArticle cat = (CategorieArticle) model.asMap().get("editedCat");
					c.setPhoto(cat.getPhoto());
				}
			}
			metier.modifierCategorie(c);
		} else      

		metier.ajouterCategorie(c);
		model.addAttribute("categorie", new CategorieArticle());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
		
	}

	@RequestMapping(value="/photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idCat) throws IOException{
		CategorieArticle c = metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value="/suppCat")
	public String suppCat(int idCat,Model model){
		metier.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new CategorieArticle());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}
	
	@RequestMapping(value="/editCat")
	public String edit(int idCat,Model model){
		CategorieArticle c = metier.getCategorie(idCat);
		model.addAttribute("editedCat", c); //On place cet attribut dans la session :session attribute 
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}


	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object objet,
			Exception exc) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", exc.getMessage());
		mv.setViewName("categories");
		return mv;
	}

}