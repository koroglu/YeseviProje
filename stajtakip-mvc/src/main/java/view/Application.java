package view;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication
@ImportResource("classpath:spring/application-config.xml")
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "dao", "model", "security", "view" })
public class Application extends SpringBootServletInitializer {

	@Bean public RequestContextListener requestContextListener(){
	    return new RequestContextListener();
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	public void onStartup( ServletContext servletContext ) throws ServletException {
        servletContext.addFilter("requestContextFilter", new RequestContextFilter() ).addMappingForUrlPatterns(null, false, "/*");
        servletContext.addListener( new RequestContextListener() ) ;
        super.onStartup( servletContext );
        
    }

}
