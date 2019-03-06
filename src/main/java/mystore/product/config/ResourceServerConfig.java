package mystore.product.config;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";
    
	@Autowired(required = false)
  	private ResourceServerTokenServices[] tokenServices;
	
	@Autowired
	private ApplicationContext context;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/product/**").access("hasRole('ADMIN')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
    
    private ResourceServerTokenServices resolveTokenServices() {
    	if (tokenServices == null || tokenServices.length==0) {
    		return null;
    	}
    	if (tokenServices.length == 1) {
    		return tokenServices[0];
    	}
    	if (tokenServices.length == 2 && tokenServices[0] == tokenServices[1]) {
    		return tokenServices[0];
    	}
    	try {
    		TokenServicesConfiguration bean = context.getAutowireCapableBeanFactory().createBean(
    				TokenServicesConfiguration.class);
    		return bean.services;
    	}
    	catch (BeanCreationException e) {
    		throw new IllegalStateException(
    				"Could not wire ResourceServerTokenServices: please create a bean definition and mark it as @Primary.");
    	}
    }

    private static class TokenServicesConfiguration {
    	@Autowired
    	private ResourceServerTokenServices services;
    }

}