package com.library.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {
        @Bean
        public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route("product_service", r -> r.path("/product_service/**")
                                                // .filters(f -> f.stripPrefix(2))
                                                .uri("lb://PRODUCT-SERVICE"))
                                .route("order_service", r -> r.path("/order_service/**")
                                                .filters(f -> f.stripPrefix(2))
                                                .uri("lb://ORDER-SERVICE"))
                                .build();
        }
}
