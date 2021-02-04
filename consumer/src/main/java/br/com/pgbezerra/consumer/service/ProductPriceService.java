package br.com.pgbezerra.consumer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.pgbezerra.consumer.model.ProductPrice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductPriceService {
	
	@Autowired
	private WebClient productWebClient;
	@Autowired
	private WebClient priceWebClient;
	
	public ProductPrice getProductPrice(Long productId) {
		Mono<ProductPrice> productMono =  productWebClient
				.get()
				.uri("/products/{productId}", productId)
				.retrieve()
				.bodyToMono(ProductPrice.class);
		
		Mono<ProductPrice> priceMono = priceWebClient
				.get()
				.uri("/prices/{productId}", productId)
				.retrieve()
				.bodyToMono(ProductPrice.class);
		
		return Mono.zip(productMono, priceMono).map(tuple -> {
			tuple.getT1().setPrice(tuple.getT2().getPrice());
			return tuple.getT1();
		}).block();
	}
	
	public List<ProductPrice> findAll() {
		Flux<ProductPrice> productFlux = productWebClient
				.get()
				.uri("/products")
				.retrieve()
				.bodyToFlux(ProductPrice.class);
		
		return productFlux.collect(Collectors.toList()).block();
	}
	
	public ProductPrice insert(ProductPrice productPrice) {
		Mono<ProductPrice> productMono = productWebClient
				.post()
				.uri("/products")
				.body(BodyInserters.fromValue(productPrice))
				.retrieve()
				.bodyToMono(ProductPrice.class);
		
		Mono<ProductPrice> priceMono = priceWebClient
				.post()
				.uri("/prices")
				.body(BodyInserters.fromValue(productPrice))
				.retrieve()
				.bodyToMono(ProductPrice.class);
		
		return Mono.zip(productMono, priceMono).map(tuple -> {
			tuple.getT1().setPrice(tuple.getT2().getPrice());
			return tuple.getT1();
		}).block();
	}

}
