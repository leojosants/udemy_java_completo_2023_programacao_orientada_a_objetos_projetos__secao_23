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
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

/*-------------------- class OrderResource --------------------*/
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {	
	
	/*-------------------- attributes --------------------*/
	@Autowired
	private OrderService service;
	
	/*-------------------- methods --------------------*/
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> user_list = service.findAll();
		return ResponseEntity.ok().body(user_list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}