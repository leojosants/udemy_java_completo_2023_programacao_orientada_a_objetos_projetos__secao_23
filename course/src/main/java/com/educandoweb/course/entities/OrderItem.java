/*-------------------- packages --------------------*/
package com.educandoweb.course.entities;

/*-------------------- imports --------------------*/
import java.io.Serializable;
import com.educandoweb.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*-------------------- class OrderItem --------------------*/
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id = instanceateOrderItemPK();

	private Integer quantity;
	private Double price;
	
	/*-------------------- constructors --------------------*/
	public OrderItem() {}
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.setQuantity(quantity);
		this.setPrice(price);
	}
	
	/*-------------------- attributes --------------------*/
	@JsonIgnore
	public Order getOrder() {
		return this.id.getOrder();
	}
	
	public void setOrder(Order order) {
		this.id.setOrder(order);
	}
	
	public Product getProduct() {
		return this.id.getProduct();
	}
	
	public void setProduct(Product product) {
		this.id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	/*-------------------- methods --------------------*/
	public Double getSubTotal() {
		return this.getPrice() * this.getQuantity();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		OrderItem other = (OrderItem) obj;
		
		if (this.id == null) {
			if (other.id != null) return false;
		} 
		else if (!this.id.equals(other.id)) return false;

		return true;
	}
	
	private OrderItemPK instanceateOrderItemPK() {
		return new OrderItemPK();
	}
}