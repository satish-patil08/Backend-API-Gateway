package com.microservices.apigateway.api_gateway.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CorsGlobalConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        // Create and configure the CORS configuration
        CorsConfiguration corsConfig = new CorsConfiguration();
        // Remove trailing slashes to match the browser's Origin header exactly.
        corsConfig.addAllowedOrigin("http://localhost:3000"); // Localhost Origin
        corsConfig.addAllowedOrigin("http://20.201.119.138");   // Production Origin
        corsConfig.addAllowedHeader("*");
        corsConfig.addAllowedMethod("*");
        corsConfig.setAllowCredentials(false);

        // Create the reactive URL-based configuration source using the reactive PathPatternParser
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", corsConfig);

        // Return the CorsWebFilter, passing the reactive CorsConfigurationSource
        return new CorsWebFilter(source);
    }
}
