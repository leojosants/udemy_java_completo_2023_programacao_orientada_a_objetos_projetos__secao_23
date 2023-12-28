/*-------------------- packages --------------------*/
package com.educandoweb.course.entities.pk;

/*-------------------- imports --------------------*/
import java.io.Serializable;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*-------------------- class OrderItemPK --------------------*/
@Embeddable
public class OrderItemPK implements Serializable {

	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	/*-------------------- getters and setters --------------------*/
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/*-------------------- methods --------------------*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getOrder() == null) ? 0 : this.getOrder().hashCode());
		result = prime * result + ((this.getProduct() == null) ? 0 : this.getProduct().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		OrderItemPK other = (OrderItemPK) obj;
		
		if (this.getOrder() == null) {
			if (other.getOrder()  != null) return false;
		} 
		else if (!this.getOrder().equals(other.getOrder() )) return false;

		if (this.getProduct() == null) {
			if (other.getProduct() != null) return false;
		} 
		else if (!this.getProduct().equals(other.getProduct())) return false;
		
		return true;
	}
}