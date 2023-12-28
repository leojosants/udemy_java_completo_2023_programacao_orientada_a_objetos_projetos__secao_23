/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- imports --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;
import com.educandoweb.course.entities.User;

/*-------------------- interface UserRepository --------------------*/
public interface UserRepository extends JpaRepository<User, Long> {
	//
}
