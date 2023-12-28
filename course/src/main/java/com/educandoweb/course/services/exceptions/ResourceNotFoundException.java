/*-------------------- packages --------------------*/
package com.educandoweb.course.services.exceptions;

/*-------------------- class ResourceNotFoundException --------------------*/
public class ResourceNotFoundException  extends RuntimeException{
	
	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;

	/*-------------------- constructors --------------------*/
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id ..: " + id);
	}
}
