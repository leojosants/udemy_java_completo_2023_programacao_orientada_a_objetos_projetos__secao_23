/*-------------------- packages --------------------*/
package com.educandoweb.course.entities.enums;

/*-------------------- enum OrderStatus --------------------*/
public enum OrderStatus {

	/*-------------------- values --------------------*/
	WAINTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	/*-------------------- attributes --------------------*/
	private int code;
	
	/*-------------------- constructors --------------------*/
	private OrderStatus(int code) {
		this.code = code;
	}

	/*-------------------- getters and setters --------------------*/
	public int getCode() {
		return this.code;
	}
	
	/*-------------------- methods --------------------*/
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) return value;
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
