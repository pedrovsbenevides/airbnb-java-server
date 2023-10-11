package com.airbnbserver.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class DocConfig {

    @Bean
    public OpenAPI apiDocs() {
        return new OpenAPI()
                .info(new Info().title("Airbnb Clone Server")
                        .description("API para sistema de locação de acomodações similar ao Airbnb")
                        .version("1.0.0"));
    }
}
