/**
 * 
 */
package com.ri.spring.mobile.app.users.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ri.spring.mobile.app.users.apis.exceptions.UsersException;
import com.ri.spring.mobile.app.users.ui.model.Error;

/**
 * @author ripum
 *
 */
@ControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(value = { UsersException.class })
	public ResponseEntity<Error> usersExceptionHandler(UsersException exception, WebRequest request) {
		
		return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getLocalizedMessage(),
				LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
