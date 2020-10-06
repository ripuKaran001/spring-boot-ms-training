/**
 * 
 */
package com.ri.spring.mobile.app.users.apis.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * @author ripum
 *
 */
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 404:
			if (methodKey.contains("getProducts")) {
				return new UsersException("Products Not found");
			}
			break;
		case 500:
			break;
		}
		return null;
	}

}
