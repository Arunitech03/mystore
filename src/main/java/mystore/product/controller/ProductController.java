package mystore.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mystore.*;
import mystore.product.entity.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/listproduct")
public class ProductController {
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private ProductListRepository productListRepository;
	private dummyrepo dummyrepo;

	@RequestMapping(path="/add", method = RequestMethod.POST) // Map ONLY POST Requests
	public @ResponseBody String addNewProduct (
			@RequestParam String productid, @RequestParam String name, @RequestParam float price, @RequestParam String description) {
		
		System.out.println("Param Values" + productid + " name " + name + "price  " + price + "description " +description);
		
		ProductEntity pe = new ProductEntity();
		pe.setName(name);
		pe.setproductId(new Integer(productid));
		pe.setPrice(price);
		pe.setDescription(description);
		productListRepository.save(pe);
		return "Saved to mystore Table";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<ProductEntity> getAllProduct() {
		// This returns a JSON or XML with the users
		return productListRepository.findAll();
		//return "ALL DATA in Mystore";
	}
	

	@RequestMapping(path="/addproduct2", method = RequestMethod.GET)
	public String addproductview(ProductEntity productentity, Model model) {
		model.addAttribute("productentity", new ProductEntity());
		return "addproduct2";
		
	}
	
	@RequestMapping(path="/addproduct", method = RequestMethod.POST)
	public @ResponseBody String addNewProduct2 (ProductEntity productentity, BindingResult result, Model model) {
		
		productListRepository.save(productentity);
		model.addAttribute("productentity", productListRepository.findAll());
		return "home";
	}
	
	@RequestMapping(path="/showproduct", method = RequestMethod.GET)
	public String showAllProducts (Model model) {
		//productListRepository.save(productentity);
		model.addAttribute("products", productListRepository.findAll());
		return "products";
	}
	
	@RequestMapping(path="/delete/{productid}", method = RequestMethod.GET)
	public String deleteProduct (@PathVariable(name = "productid") String productid) {
		productListRepository.delete(new Integer(productid));
		//model.addAttribute("products", productListRepository.findAll());
		return "redirect:/listproduct/showproduct";
	}
	
	
}
