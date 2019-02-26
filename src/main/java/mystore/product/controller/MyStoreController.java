package mystore.product.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MyStoreController {
	@RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping("/login")
    public String login() {
        return "Login Page";
    }
	
	@RequestMapping("/first")
    public String first() {
        return "first Page";
    }
}
