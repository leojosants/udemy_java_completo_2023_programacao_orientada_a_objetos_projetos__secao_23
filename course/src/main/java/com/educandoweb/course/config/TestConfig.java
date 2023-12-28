/*-------------------- packages --------------------*/
package com.educandoweb.course.config;

/*-------------------- imports --------------------*/
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

/*-------------------- class TestConfig --------------------*/
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	/*-------------------- attributes --------------------*/
	@Autowired
	private UserRepository user_repository;

	@Autowired
	private OrderRepository order_repository;
	
	@Autowired
	private CategoryRepository category_repository;

	/*-------------------- methods --------------------*/
	@Override
	public void run(String... args) throws Exception {
		Category category_1 = instanceateCategory("Electronics");
		Category category_2 = instanceateCategory("Books");
		Category category_3 = instanceateCategory("Computers"); 
		
		this.category_repository.saveAll(Arrays.asList(category_1, category_2, category_3));

		User user_1 = instanceateUser("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user_2 = instanceateUser("Alex Green", "alex@gmail.com", "977777777", "123456");

		Order order_1 = instanceateOrder(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user_1);
		Order order_2 = instanceateOrder(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAINTING_PAYMENT, user_2);
		Order order_3 = instanceateOrder(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAINTING_PAYMENT, user_1); 
		
		this.user_repository.saveAll(Arrays.asList(user_1, user_2));
		this.order_repository.saveAll(Arrays.asList(order_1, order_2, order_3));
	}

	private Category instanceateCategory(String name) {
		return new Category(null, name);
	}

	private Order instanceateOrder(Instant moment, OrderStatus order_status, User user) {
		return new Order(null, moment, order_status, user);
	}

	private User instanceateUser(String name, String email, String phone, String password) {
		return new User(null, name, email, phone, password);
	}
}


