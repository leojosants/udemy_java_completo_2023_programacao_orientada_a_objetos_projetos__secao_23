/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- imports --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.course.entities.Category;

/*-------------------- interface CategoryRepository --------------------*/
public interface CategoryRepository extends JpaRepository<Category, Long> {
	//
}
