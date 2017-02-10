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

import uvsq.datascale.boutiqueoc.entities.Article;
import uvsq.datascale.boutiqueoc.metier.IAdminProduit;

@Controller
@RequestMapping(value="/", method = RequestMethod.GET)
@SessionAttributes("editedProd")

public class AdminArticlesControlleur implements HandlerExceptionResolver{
	@Autowired
	private IAdminProduit metier;
	@RequestMapping(value = "/adminProd", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("produit", new Article());
		model.addAttribute("produits", metier.listArticles());
		return "produits";
	}
	
	@RequestMapping(value = "/saveProd", method = RequestMethod.POST)
	public String saveProd(@Valid Article a, BindingResult bindingResult, 
			Model model, MultipartFile file) throws IOException{

		if(bindingResult.hasErrors()){
			model.addAttribute("produits", metier.listArticles());
			return "produits";
		}

		if(!file.isEmpty()){
			BufferedImage bi = ImageIO.read(file.getInputStream());
			a.setPhoto(file.getBytes());
			a.setNomPhoto(file.getOriginalFilename());
		}
		
		if(a.getIdArticle() != null){
			if(model.asMap().get("editedProd") != null){
				if(file.isEmpty()){
					Article art = (Article) model.asMap().get("editedProd");
					a.setPhoto(art.getPhoto());
				}
			}
			metier.modifierarticle(a);
		} else      

		metier.ajouterarticle(a,11);
		model.addAttribute("produit", new Article());
		model.addAttribute("produits", metier.listArticles());
		return "produits";
		
	}
	
	@RequestMapping(value="/photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idProd) throws IOException{
		Article a = metier.getArticle(idProd);
		return IOUtils.toByteArray(new ByteArrayInputStream(a.getPhoto()));
	}

	@RequestMapping(value="/suppProd")
	public String suppProd(int idProd,Model model){
		metier.supprimerArticle(idProd);
		model.addAttribute("produit", new Article());
		model.addAttribute("produits", metier.listArticles());
		return "produits";
	}
	
	@RequestMapping(value="/editProd")
	public String edit(int idProd,Model model){
		Article a = metier.getArticle(idProd);
		model.addAttribute("editedProd", a); //On place cet attribut dans la session :session attribute 
		model.addAttribute("produit", a);
		model.addAttribute("produits", metier.listArticles());
		return "produits";
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object objet,
			Exception exc) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", exc.getMessage());
		mv.setViewName("produits");
		return mv;
	}

}