/*-------------------- packages --------------------*/
package com.educandoweb.course.services;

/*-------------------- imports --------------------*/
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

/*-------------------- class UserService --------------------*/
@Service
public class UserService {

	/*-------------------- attributes --------------------*/
	@Autowired
	private UserRepository repository;
	
	/*-------------------- methods --------------------*/
	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj	= this.repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return this.repository.save(obj);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}