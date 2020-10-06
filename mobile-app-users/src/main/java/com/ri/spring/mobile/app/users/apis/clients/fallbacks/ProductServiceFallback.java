package com.ri.spring.mobile.app.users.apis.clients.fallbacks;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ri.spring.mobile.app.users.apis.clients.ProductServiceClient;
import com.ri.spring.mobile.app.users.ui.model.ProductResponseModel;

import feign.FeignException;

public class ProductServiceFallback implements ProductServiceClient {

	private final static Logger LOG = LoggerFactory.getLogger(ProductServiceFallback.class);
	private Throwable cause = null;

	public ProductServiceFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<ProductResponseModel> getProducts() {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			LOG.error("404 Status is returned when getProducts is called." + cause.getLocalizedMessage());
		} else {
			LOG.error("Products Service Exception :" + cause.getLocalizedMessage());
		}
		return new ArrayList<>();
	}

}
