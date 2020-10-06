/**
 * 
 */
package com.ri.spring.mobile.app.users.apis.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ri.spring.mobile.app.users.apis.clients.fallbacks.factory.ProductServiceFallbackFactory;
import com.ri.spring.mobile.app.users.ui.model.ProductResponseModel;

/**
 * @author ripum
 *
 */
@FeignClient(name="products-ws",fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductServiceClient {
	
	@GetMapping("/products")
	public List<ProductResponseModel> getProducts();
	

}


