/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- dependencies --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;

/*-------------------- modules --------------------*/
import com.educandoweb.course.entities.Order;

/*-------------------- interface UserRepository --------------------*/
public interface OrderRepository extends JpaRepository<Order, Long> {
	//
}
