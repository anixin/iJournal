package my.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"my.personal"})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		UserService service = new UserService();
//		System.out.println(service.findAll().get(0).toString());
	}

}
