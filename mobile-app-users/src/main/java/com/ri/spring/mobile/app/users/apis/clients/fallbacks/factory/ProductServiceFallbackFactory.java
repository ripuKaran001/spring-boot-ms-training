package com.ri.spring.mobile.app.users.apis.clients.fallbacks.factory;

import org.springframework.stereotype.Component;

import com.ri.spring.mobile.app.users.apis.clients.ProductServiceClient;
import com.ri.spring.mobile.app.users.apis.clients.fallbacks.ProductServiceFallback;

import feign.hystrix.FallbackFactory;

@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductServiceClient> {

	@Override
	public ProductServiceClient create(Throwable cause) {
		return new ProductServiceFallback(cause);
	}

}
