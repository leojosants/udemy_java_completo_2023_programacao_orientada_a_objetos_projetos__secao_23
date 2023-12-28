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
import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderItemRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository product_repository;
	
	@Autowired
	private OrderItemRepository order_item_repository;

	/*-------------------- methods --------------------*/
	@Override
	public void run(String... args) throws Exception {
		Category category_1 = instanceateCategory("Electronics");
		Category category_2 = instanceateCategory("Books");
		Category category_3 = instanceateCategory("Computers"); 
		
		Product product_1 = instanceateProduct("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product product_2 = instanceateProduct("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product product_3 = instanceateProduct("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product product_4 = instanceateProduct("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product product_5 = instanceateProduct("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		this.category_repository.saveAll(Arrays.asList(category_1, category_2, category_3));
		this.product_repository.saveAll(Arrays.asList(product_1, product_2, product_3, product_4, product_5));

		product_1.getCategories().add(category_2);
		product_2.getCategories().add(category_1);
		product_2.getCategories().add(category_3);
		product_3.getCategories().add(category_3);
		product_4.getCategories().add(category_3);
		product_5.getCategories().add(category_2);
		
		this.product_repository.saveAll(Arrays.asList(product_1, product_2, product_3, product_4, product_5));
		
		User user_1 = instanceateUser("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user_2 = instanceateUser("Alex Green", "alex@gmail.com", "977777777", "123456");

		Order order_1 = instanceateOrder(Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user_1);
		Order order_2 = instanceateOrder(Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAINTING_PAYMENT, user_2);
		Order order_3 = instanceateOrder(Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAINTING_PAYMENT, user_1); 
		
		this.user_repository.saveAll(Arrays.asList(user_1, user_2));
		this.order_repository.saveAll(Arrays.asList(order_1, order_2, order_3));
		
		OrderItem order_item_1 = instanceateOrderItem(order_1, product_1, 2, product_1.getPrice());
		OrderItem order_item_2 = instanceateOrderItem(order_1, product_3, 1, product_4.getPrice());
		OrderItem order_item_3 = instanceateOrderItem(order_2, product_3, 2, product_1.getPrice());
		OrderItem order_item_4 = instanceateOrderItem(order_3, product_5, 2, product_5.getPrice()); 
		
		this.order_item_repository.saveAll(Arrays.asList(order_item_1, order_item_2, order_item_3, order_item_4));
	}

	private Product instanceateProduct(String name, String description, Double price, String img_url) {
		return new Product(null, name, description, price, img_url);
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
	
	private OrderItem instanceateOrderItem(Order order, Product product, Integer quantity, Double price) {
		return new OrderItem(order, product, quantity, price);
	}
}


