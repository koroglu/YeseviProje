package view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/application-config.xml")
@Configuration
@EnableAutoConfiguration

public class Application {

	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
