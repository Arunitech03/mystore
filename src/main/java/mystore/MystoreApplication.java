package mystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories(basePackages = {"mystore.product.repository"})
public class MystoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(MystoreApplication.class, args);
	}
	
	@RequestMapping("/home")
    public String home() {
        return "home";
    }

}

