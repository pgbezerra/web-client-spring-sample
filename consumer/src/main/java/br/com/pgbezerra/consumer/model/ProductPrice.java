package br.com.pgbezerra.consumer.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {
	
	private Long productId;
	private String name;
	private String description;
	private BigDecimal price;

}
