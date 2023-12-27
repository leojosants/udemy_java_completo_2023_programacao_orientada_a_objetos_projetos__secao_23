/*-------------------- packages --------------------*/
package com.educandoweb.course.resources;

/*-------------------- libraries --------------------*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*-------------------- modules --------------------*/
import com.educandoweb.course.entities.User;

/*-------------------- class UserResource --------------------*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {	
	
	/*-------------------- methods --------------------*/
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = instanceateUser(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(user);
	}

	private User instanceateUser(Long id, String name, String email, String phone, String password) {
		return new User(id, name, email, phone, password);
	}
}