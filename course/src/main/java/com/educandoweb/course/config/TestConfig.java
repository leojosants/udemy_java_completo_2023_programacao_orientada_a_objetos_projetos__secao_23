/*-------------------- packages --------------------*/
package com.educandoweb.course.config;

/*-------------------- libraries --------------------*/
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*-------------------- modules --------------------*/
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

/*-------------------- class TestConfig --------------------*/
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	/*-------------------- attributes --------------------*/
	@Autowired
	private UserRepository user_repository;

	/*-------------------- methods --------------------*/
	@Override
	public void run(String... args) throws Exception {
		User user_1 = instanceateUser("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user_2 = instanceateUser("Alex Green", "alex@gmail.com", "977777777", "123456");
		user_repository.saveAll(Arrays.asList(user_1, user_2));
	}

	private User instanceateUser(String name, String email, String phone, String password) {
		return new User(null, name, email, phone, password);
	}
}


