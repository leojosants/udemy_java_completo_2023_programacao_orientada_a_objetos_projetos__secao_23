/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- imports --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.course.entities.Order;

/*-------------------- interface OrderRepository --------------------*/
public interface OrderRepository extends JpaRepository<Order, Long> {
	//
}
