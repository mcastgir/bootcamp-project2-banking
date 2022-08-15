package com.nttdata.bootcamp.banking.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {

    @Value("${project.url.server.api-gateway}")
    private String urlServerApiGateway;

    private static final Logger log = LoggerFactory.getLogger(WebFluxConfig.class);
    @Bean
    public WebClient getWcClient () {
        return WebClient.builder ()
                .baseUrl (urlServerApiGateway)
                .defaultHeader (HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
