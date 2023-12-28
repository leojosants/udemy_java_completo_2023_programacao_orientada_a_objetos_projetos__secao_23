/*-------------------- packages --------------------*/
package com.educandoweb.course.entities;

/*-------------------- imports --------------------*/
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*-------------------- class Order --------------------*/
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer order_status;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client; // association
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = instanceateHashSet(); // association
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment; // association

	/*-------------------- constructors --------------------*/
	public Order() {}
	
	public Order(Long id, Instant moment, OrderStatus order_status, User client) {
		this.setId(id);
		this.setMoment(moment);
		this.setOrderStatus(order_status);
		this.setClient(client);
	}

	/*-------------------- getters and setters --------------------*/
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return this.moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(this.order_status);
	}

	public void setOrderStatus(OrderStatus order_status) {
		if (order_status != null) {
			this.order_status = order_status.getCode();
		}
	}

	public User getClient() {
		return this.client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem> getItems() {
		return this.items;
	}
	
	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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

		Order other = (Order) obj;
		
		if (this.getId() == null) {
			if (other.getId() != null) return false;
		} 
		else if (!this.getId().equals(other.getId())) return false;

		return true;
	}
	
	private Set<OrderItem> instanceateHashSet() {
		return new HashSet<>();
	}
}
