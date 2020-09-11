/**
 * 
 */
package com.ri.spring.mobile.app.users.ui.model;

import java.time.LocalDateTime;

/**
 * @author ripum
 *
 */
public class Error {

	private LocalDateTime timestamp;
	private int code;
	private String message;

	public Error() {
	}

	public Error(int code, String message, LocalDateTime timestamp) {
		this.code = code;

		this.message = message;
		this.timestamp = timestamp;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
