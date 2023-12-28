/*-------------------- packages --------------------*/
package com.educandoweb.course.services;

/*-------------------- imports --------------------*/
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

/*-------------------- class ProductService --------------------*/
@Service
public class ProductService {

	/*-------------------- attributes --------------------*/
	@Autowired
	private ProductRepository repository;
	
	/*-------------------- methods --------------------*/
	public List<Product> findAll() {
		return this.repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj	= this.repository.findById(id);
		return obj.get();
	}
}