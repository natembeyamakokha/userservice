package lo.getarrays.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class UserserviceApplication {


	public static void main(String[] args) {

//		SpringApplication.run(UserserviceApplication.class, args);
		SpringApplication app = new SpringApplication(UserserviceApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8083"));
		app.run(args);

	}

}
