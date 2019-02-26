package mystore.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mystore.*;
import mystore.product.entity.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/dummylist")

public class dummycontroller {
	
	private dummyrepo dummyrepo;
	
	@GetMapping(path="/dummyall")
	public @ResponseBody Iterable<dummyentity> getdummyAllProduct() {
		// This returns a JSON or XML with the users
		return dummyrepo.findAll();
		//return "ALL DATA in Mystore";
	}
	
	
	@RequestMapping(path="/dummyadd", method = RequestMethod.POST)
	public @ResponseBody String addNewDummy (
			@RequestParam String dum1, @RequestParam String dum2) {
		
		System.out.println("Param Values" + dum1 + " name " + dum2);
		dummyentity de = new dummyentity();
		de.setDum1(new Integer(dum1));
		de.setDum2(new Integer(dum2));
		dummyrepo.save(de);
		 return "Data Added" + dum1 + " dum2 " + dum2 ;
	}

	
	@GetMapping(path="/dummyview")
	 public String dummy() {
        return "Greetings from Dummy!";
    }
	
	@RequestMapping("/home")
    public String home() {
        return "home";
    }
	
	@RequestMapping("/addproduct")
    public String addproduct() {
        return "addproduct";
    }
}
