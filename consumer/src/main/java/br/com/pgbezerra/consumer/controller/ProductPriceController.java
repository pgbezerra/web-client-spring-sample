package br.com.pgbezerra.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.pgbezerra.consumer.model.ProductPrice;
import br.com.pgbezerra.consumer.service.ProductPriceService;

@RestController
public class ProductPriceController {
	
	@Autowired
	private ProductPriceService productPriceService;
	
	@GetMapping(value = "/product/{productId}/price")
	public ResponseEntity<ProductPrice> getPrice(@PathVariable(value = "productId") Long productId){
		return ResponseEntity.ok(productPriceService.getProductPrice(productId));
	}

}
