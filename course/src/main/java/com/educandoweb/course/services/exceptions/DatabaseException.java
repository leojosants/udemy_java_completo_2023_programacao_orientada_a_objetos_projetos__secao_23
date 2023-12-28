/*-------------------- packages --------------------*/
package com.educandoweb.course.services.exceptions;

/*-------------------- class DatabaseException --------------------*/
public class DatabaseException extends RuntimeException {

	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;
	
	/*-------------------- constructors --------------------*/
	public DatabaseException(String message) {
		super(message);
	}
}
