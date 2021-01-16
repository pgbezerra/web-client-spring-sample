package br.com.pgbezerra.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@Value("${api.product.baseurl}")
	private String productBaseUrl;
	@Value("${api.price.baseurl}")
	private String priceBaseUrl;

	@Bean
	public WebClient productWebClient() {
		return WebClient.builder().baseUrl(productBaseUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	@Bean
	public WebClient priceWebClient() {
		return WebClient.builder().baseUrl(priceBaseUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
}
