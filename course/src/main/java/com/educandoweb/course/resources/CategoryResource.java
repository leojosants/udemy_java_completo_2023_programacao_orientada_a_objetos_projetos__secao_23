/*-------------------- packages --------------------*/
package com.educandoweb.course.resources;

/*-------------------- imports --------------------*/
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

/*-------------------- class CategoryResource --------------------*/
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {	
	
	/*-------------------- attributes --------------------*/
	@Autowired
	private CategoryService service;
	
	/*-------------------- methods --------------------*/
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> user_list = service.findAll();
		return ResponseEntity.ok().body(user_list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}