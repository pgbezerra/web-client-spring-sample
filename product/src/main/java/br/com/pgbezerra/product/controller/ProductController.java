package br.com.pgbezerra.product.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pgbezerra.product.model.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		Product product1 = new Product(1L, "Bed", "This is not realy bad");
		Product product2 = new Product(2L, "Bed", "This is not realy bad");
		Product product3 = new Product(3L, "Bed", "This is not realy bad");
		Product product4 = new Product(4L, "Bed", "This is not realy bad");
		Product product5 = new Product(5L, "Bed", "This is not realy bad");
		return ResponseEntity.ok(Arrays.asList(product1, product2, product3, product4, product5));
	}
	
	@GetMapping(value = "/{productId}")
	public ResponseEntity<Product> findById(@PathVariable(value = "productId") Long productId) throws InterruptedException{
		Product product = new Product(1L, "Bed", "This is not realy bad");
		Thread.sleep(5000);
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product product) throws InterruptedException{
		Thread.sleep(3000);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

}
