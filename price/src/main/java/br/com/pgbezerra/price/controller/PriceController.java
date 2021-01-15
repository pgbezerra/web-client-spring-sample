package br.com.pgbezerra.price.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pgbezerra.price.model.Price;

@RestController
@RequestMapping(value = "/prices")
public class PriceController {
	
	@GetMapping(value = "/{productId}")
	public ResponseEntity<Price> getPrice(@PathVariable(value = "productId") Long productId){
		Price price = new Price(productId, BigDecimal.valueOf(100d));
		return ResponseEntity.ok(price);
	}

}
