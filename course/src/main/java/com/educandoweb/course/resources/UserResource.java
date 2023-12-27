/*-------------------- packages --------------------*/
package com.educandoweb.course.resources;

/*-------------------- dependencies --------------------*/
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*-------------------- modules --------------------*/
import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

/*-------------------- class UserResource --------------------*/
@RestController
@RequestMapping(value = "/users")
public class UserResource {	
	
	/*-------------------- attributes --------------------*/
	@Autowired
	private UserService service;
	
	/*-------------------- methods --------------------*/
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> user_list = service.findAll();
		return ResponseEntity.ok().body(user_list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}