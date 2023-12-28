/*-------------------- packages --------------------*/
package com.educandoweb.course.services;

/*-------------------- imports --------------------*/
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

/*-------------------- class CategoryService --------------------*/
@Service
public class CategoryService {

	/*-------------------- attributes --------------------*/
	@Autowired
	private CategoryRepository repository;
	
	/*-------------------- methods --------------------*/
	public List<Category> findAll() {
		return this.repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj	= this.repository.findById(id);
		return obj.get();
	}
}