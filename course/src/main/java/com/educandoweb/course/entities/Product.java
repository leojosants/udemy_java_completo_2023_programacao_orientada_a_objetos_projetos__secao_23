/*-------------------- packages --------------------*/
package com.educandoweb.course.entities;

/*-------------------- imports --------------------*/
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/*-------------------- class Product --------------------*/
@Entity
@Table(name = "tb_Product")
public class Product implements Serializable {

	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private Double price;
	private String img_url;
	
	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = instanceateHashSet(); // association
	
	/*-------------------- constructors --------------------*/
	public Product() {}
	public Product(Long id, String name, String description, Double price, String img_url) {
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
		this.setImgUrl(img_url);
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getImgUrl() {
		return img_url;
	}

	public void setImgUrl(String img_url) {
		this.img_url = img_url;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	/*-------------------- methods --------------------*/
	private Set<Category> instanceateHashSet() {
		return new HashSet<>();
	}
	
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

		Product other = (Product) obj;
		
		if (this.getId() == null) {
			if (other.getId() != null) return false;
		} 
		else if (!this.getId().equals(other.getId())) return false;

		return true;
	}
}
