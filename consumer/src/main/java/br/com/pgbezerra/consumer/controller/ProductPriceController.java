package br.com.pgbezerra.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductPrice>> findAll(){
		return ResponseEntity.ok(productPriceService.findAll());
	}
	
	@PostMapping(value = "/product")
	public ResponseEntity<ProductPrice> insert(@RequestBody ProductPrice productPrice){
		return ResponseEntity.status(HttpStatus.CREATED).body(productPriceService.insert(productPrice));
	}
}
