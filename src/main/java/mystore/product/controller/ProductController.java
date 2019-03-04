package mystore.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mystore.ProductRepository;
import mystore.product.model.Product;

@Controller    
@RequestMapping(path="/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String addproduct(Product product, Model model) {
		productRepository.save(product);
		return "redirect:/product/view";
		
	}
	
	@RequestMapping(path="/add", method = RequestMethod.GET)
	public String addproductview(Product product, Model model) {
		model.addAttribute("product", new Product());
		return "editproduct";
		
	}
	
	@RequestMapping(path="/view", method = RequestMethod.GET)
	public String showproduct(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "products";
		
	}
	
	@RequestMapping(path="/edit/{productid}", method = RequestMethod.GET)
	public String editProduct(Model model, @PathVariable(value = "productid") int productid) {
		model.addAttribute("product", productRepository.findById(productid));
		return "editproduct";
		
	}
	
	@RequestMapping(path="/delete/{productid}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(value = "productid") int productid) {
		productRepository.deleteById(productid);
		return "redirect:/product/view";
		
	}
	

}
