package mystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MystoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(MystoreApplication.class, args);
	}
	
	@RequestMapping("/home")
    public String home() {
        return "home";
    }

}

