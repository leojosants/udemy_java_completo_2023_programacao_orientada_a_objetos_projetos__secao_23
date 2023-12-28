/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- imports --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.course.entities.Product;

/*-------------------- interface ProductRepository --------------------*/
public interface ProductRepository extends JpaRepository<Product, Long> {
	//
}
