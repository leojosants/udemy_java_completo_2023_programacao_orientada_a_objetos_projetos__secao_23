/*-------------------- packages --------------------*/
package com.educandoweb.course.entities;

/*-------------------- imports --------------------*/
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/*-------------------- class Category --------------------*/
@Entity
@Table(name = "tb_Category")
public class Category implements Serializable {

	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = instanceateHashSet(); // association
	
	/*-------------------- constructors --------------------*/
	public Category() {}
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/*-------------------- getters and setters --------------------*/
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
	/*-------------------- methods --------------------*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		Category other = (Category) obj;
		
		if (this.getId() == null) {
			if (other.getId() != null) return false;
		} 
		else if (!this.getId().equals(other.getId())) return false;
		
		return true;
	}
	
	private Set<Product> instanceateHashSet() {
		return new HashSet<>();
	}
}
