package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.models.Products;
import demo.services.IProductsService;

@Controller
public class controller {

	@Autowired
	private IProductsService productsService;
	
	@GetMapping("")
	public String getDefault() {
		return "redirect:/products/page/1";
	}
	@RequestMapping("/products")
	public String getProducts(Model model) {
		return productsByPage(model,1);
	}
	
	@GetMapping("/products/page/{pageNr}")
	public String productsByPage(Model model, @PathVariable("pageNr") int currentPage) {
		Page<Products> page = productsService.listAll(currentPage);
		
		model.addAttribute("product", page);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("totalElements", page.getTotalElements());
		model.addAttribute("totalPages", page.getTotalPages());
		return "products";
	}
	
	@GetMapping("/badProducts")
	public String getBadProducts(Model model) {

		model.addAttribute("product", productsService.listAll());

		return "bad-products";
	}
}
