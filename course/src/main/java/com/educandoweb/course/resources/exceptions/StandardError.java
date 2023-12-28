/*-------------------- packages --------------------*/
package com.educandoweb.course.resources.exceptions;

/*-------------------- imports --------------------*/
import java.io.Serializable;
import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonFormat;

/*-------------------- class StandardError --------------------*/
public class StandardError implements Serializable {

	/*-------------------- attributes --------------------*/
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;

	private Integer status;
	private String error;
	private String message;
	private String path;
	
	/*-------------------- constructors --------------------*/
	public StandardError() {}
	
	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		this.setTimestamp(timestamp);
		this.setStatus(status);
		this.setError(error);
		this.setMessage(message);
		this.setPath(path);
	}

	/*-------------------- getters and setters --------------------*/
	public Instant getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}