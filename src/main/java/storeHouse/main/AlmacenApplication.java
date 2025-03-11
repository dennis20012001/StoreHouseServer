package storeHouse.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("storeHouse.Objects") 
@ComponentScan("storeHouse") 
@EnableJpaRepositories("storeHouse.Repositories") 
public class AlmacenApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlmacenApplication.class, args);
	}
}
