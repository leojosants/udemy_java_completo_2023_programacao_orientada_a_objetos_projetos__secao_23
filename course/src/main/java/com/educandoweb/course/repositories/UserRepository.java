/*-------------------- packages --------------------*/
package com.educandoweb.course.repositories;

/*-------------------- libraries --------------------*/
import org.springframework.data.jpa.repository.JpaRepository;

/*-------------------- modules --------------------*/
import com.educandoweb.course.entities.User;

/*-------------------- interface UserRepository --------------------*/
public interface UserRepository extends JpaRepository<User, Long> {
	//
}
