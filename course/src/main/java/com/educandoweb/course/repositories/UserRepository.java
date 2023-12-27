/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- dependencies --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;

/*-------------------- modules --------------------*/
import com.educandoweb.course.entities.User;

/*-------------------- interface UserRepository --------------------*/
public interface UserRepository extends JpaRepository<User, Long> {
	//
}
