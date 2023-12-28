/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- imports --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.course.entities.OrderItem;

/*-------------------- interface UserRepository --------------------*/
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	//
}
